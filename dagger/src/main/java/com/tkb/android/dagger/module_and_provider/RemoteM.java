package com.tkb.android.dagger.module_and_provider;

import android.util.Log;

import javax.inject.Inject;

public class RemoteM {
    private static String TAG = RemoteM.class.getSimpleName();

    @Inject
    public RemoteM(){

    }
    public void setListener(CarM car){
        Log.d(TAG,"Remote is connected");
    }
}
