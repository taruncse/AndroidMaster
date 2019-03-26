package com.tkb.android.biometricauthentication;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;

import com.mattprecious.swirl.SwirlView;
import com.squareup.whorlwind.ReadResult;
import com.squareup.whorlwind.Whorlwind;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import okio.ByteString;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class BiometricAuthenticationActivity extends Activity {
  private final PublishSubject<String> readSubject = PublishSubject.create();
  private final SampleStorage storage = new SampleStorage();
  @BindView(R.id.swirl) SwirlView swirlView;
  @BindView(R.id.message) TextSwitcher messageView;
  @BindView(R.id.write) View writeView;
  @BindView(R.id.value) EditText valueView;
  @BindView(R.id.button2) Button button2;

  private Whorlwind whorlwind;
  private CompositeDisposable disposables;
  private String keyToStore = "tkb";
  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.biometic_auth_layout);
    ButterKnife.bind(this);

    whorlwind = Whorlwind.create(this, storage, "sample");

    // Set up the TextSwitcher.
    messageView.setFactory(() -> {
      TextView textView = new TextView(this);
      textView.setGravity(Gravity.CENTER);

      LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
      params.gravity = Gravity.CENTER;
      textView.setLayoutParams(params);

      return textView;
    });
  }

  @Override protected void onResume() {
    super.onResume();
    disposables = new CompositeDisposable();

    if (!whorlwind.canStoreSecurely()) {
      messageView.setText("Cannot store securely. If you have a fingerprint reader, make sure " //
          + "you have a fingerprint enrolled.");
      valueView.setEnabled(false);
      writeView.setEnabled(false);
      return;
    }

    messageView.setText(null);

    // Write a new value to secure storage.
    /*disposables.add(RxView.clicks(writeView).map(click -> true) //
        .map(ignored -> //
            Pair.create(keyToStore, valueView.getText().toString())) //
        .doOnNext(ignored -> {
          swirlView.setState(SwirlView.State.OFF);
          messageView.setText(null);
          valueView.setText(null);
          hideKeyboard();
        }) //
        .observeOn(Schedulers.io()) //
        .flatMapCompletable(data -> whorlwind.write(data.first, ByteString.encodeUtf8(data.second)))
        .subscribe());*/

    // Read a value from secure storage for a provided key.
    ConnectableObservable<ReadResult> readResult = readSubject //
        .switchMap(key -> whorlwind.read(key) //
            .subscribeOn(Schedulers.io())) //
        .publish();

    // Toast the decrypted value. See above for an explanation of the skip(1).
    disposables.add(readResult //
        .skip(1) //
        .filter(result -> result.readState == ReadResult.ReadState.READY) //
        .map(result -> result.value.utf8()) //
        .observeOn(AndroidSchedulers.mainThread()) //
        .subscribe(value -> Toast.makeText(this, value, Toast.LENGTH_SHORT).show()));

    // Update the fingerprint icon.
    disposables.add(readResult //
        .map(result -> {
          switch (result.readState) {
            case NEEDS_AUTH:
              return SwirlView.State.ON;
            case UNRECOVERABLE_ERROR:
            case AUTHORIZATION_ERROR:
            case RECOVERABLE_ERROR:
              return SwirlView.State.ERROR;
            case READY:
              return SwirlView.State.OFF;
            default:
              throw new IllegalArgumentException("Unknown state: " + result.readState);
          }
        }) //
        .observeOn(AndroidSchedulers.mainThread()) //
        .subscribe(swirlView::setState));

    // Show error messages. The read result will usually contain help/error messages from Android
    // that should be shown. If you wish to customize these messages, you can check the code in the
    // result.
    disposables.add(readResult //
        .map(result -> {
          if (result.message != null) {
            return result.message;
          }

          // Fall back to default messages.
          switch (result.readState) {
            case NEEDS_AUTH:
              return "Please verify your fingerprint";
            case AUTHORIZATION_ERROR:
              return "Not recognized";
            case RECOVERABLE_ERROR:
              return "Please try again";
            case UNRECOVERABLE_ERROR:
              return "Something went wrong";
            case READY:
              return "";
            default:
              throw new IllegalArgumentException("Unknown state: " + result.readState);
          }
        }) //
        .observeOn(AndroidSchedulers.mainThread()) //
        .subscribe(messageView::setText));

    // Automatically clear the error icon after 1.3 seconds if the error is recoverable.
    disposables.add(readResult //
        .switchMap(result -> Observable.just(result.readState)
            .filter(state -> state == ReadResult.ReadState.AUTHORIZATION_ERROR
                || state == ReadResult.ReadState.RECOVERABLE_ERROR)
            .delay(1300, MILLISECONDS)) //
        .map(ignored -> SwirlView.State.ON) //
        .subscribeOn(Schedulers.io()) //
        .observeOn(AndroidSchedulers.mainThread()) //
        .subscribe(swirlView::setState));

    disposables.add(readResult.connect());
  }

  @Override protected void onPause() {
    super.onPause();
    disposables.dispose();
  }

  private void hideKeyboard() {
    ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)) //
        .hideSoftInputFromWindow(swirlView.getWindowToken(), 0);
  }

  @OnClick(R.id.button2)
  void clicked(){
    viewData();
  }

  void viewData() {
    try {
      Consumer<String> readConsumer2 = readSubject::onNext;
      readConsumer2.accept(keyToStore);
    } catch (Exception e) {
      Log.e("ItemView", "Error passing read value to Consumer");
    }
  }
  @OnClick(R.id.write)
  void writeValue(){
    if (whorlwind.canStoreSecurely()) {
      Observable.just(valueView.getText().toString())
              .doOnNext(ignored -> {
                swirlView.setState(SwirlView.State.OFF);
                messageView.setText(null);
                valueView.setText(null);
                hideKeyboard();
              }).observeOn(Schedulers.io())
              .flatMapCompletable(value -> whorlwind.write(keyToStore, ByteString.encodeUtf8(value)))
              .subscribe();
    }
  }
}
