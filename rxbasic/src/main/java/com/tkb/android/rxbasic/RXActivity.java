package com.tkb.android.rxbasic;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
//https://www.androidhive.info/RxJava/android-getting-started-with-reactive-programming/
public class RXActivity extends AppCompatActivity {

    Disposable disposable;
    String Tag = RXActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx);

        Observable<String> animalObservable = ObservableProvider.getAnimalsObservable();
        Observer<String> animalObserver = getAnimalObserver();

        /**
         * Schedulers.io() – This is used to perform non CPU-intensive operations
         * like making network calls, reading disc / files, database operations etc.,
         * This maintains pool of threads.
         */

        /**
         * AndroidSchedulers.mainThread() – This provides access to android Main Thread / UI Thread.
         * Usually operations like updating UI, user interactions happens on this thread.
         * We shouldn’t perform any intensive operations on this thread as it makes the
         * app glitchy or ANR dialog can be thrown.
         */
        animalObservable.observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(animalObserver);
    }

    private Observer<String> getAnimalObserver() {
        return new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                disposable = d;
                Log.e(Tag," Subscribed");
            }

            @Override
            public void onNext(String s) {
                Log.e(Tag,"Name: "+s);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(Tag,"Error "+e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.e(Tag,"Finished");
            }
        };
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (disposable != null){
            disposable.dispose();
        }
    }
}
