package com.tkb.android.dagger.interface_injection;

import android.util.Log;

import javax.inject.Inject;

public class RemoteI {
    private static String TAG = RemoteI.class.getSimpleName();

    @Inject
    public RemoteI(){

    }
    public void setListener(CarI car){
        Log.d(TAG,"Remote is connected");
    }
}
