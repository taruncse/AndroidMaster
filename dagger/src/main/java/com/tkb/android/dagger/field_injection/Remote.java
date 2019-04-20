package com.tkb.android.dagger.field_injection;

import android.util.Log;

import javax.inject.Inject;

public class Remote {
    private static String TAG = Remote.class.getSimpleName();

    @Inject
    public Remote(){

    }
    public void setListener(CarF car){
        Log.d(TAG,"Remote is connected");
    }
}
