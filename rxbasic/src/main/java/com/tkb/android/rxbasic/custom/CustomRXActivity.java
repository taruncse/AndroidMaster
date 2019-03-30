package com.tkb.android.rxbasic.custom;

import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

import android.os.Bundle;
import android.util.Log;

import com.tkb.android.rxbasic.ObservableProvider;
import com.tkb.android.rxbasic.R;
//Source : https://www.androidhive.info/RxJava/tutorials/
public class CustomRXActivity extends AppCompatActivity {
    String Tag = CustomRXActivity.class.getSimpleName();

    CompositeDisposable disposable = new CompositeDisposable();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_rx);
        

        disposable.add(ObservableProvider.getNoteObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<Note, Note>() {

                    @Override
                    public Note apply(Note note) {
                        note.setNote(note.getNote().toUpperCase());
                        return note;
                    }
                })
                .subscribeWith(getNoteObserver()));
    }

    DisposableObserver<Note> getNoteObserver(){
        return new DisposableObserver<Note>() {
            @Override
            public void onNext(Note note) {
                Log.e(Tag,note.getNote());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
    }
}
