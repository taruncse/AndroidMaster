package com.tkb.android.dagger.interface_injection;

import android.util.Log;

import javax.inject.Inject;

public class DieselEngine implements EngineI {

    static String TAG = DieselEngine.class.getSimpleName();

    @Inject
    public DieselEngine (){

    }
    @Override
    public void startEngine() {
        Log.i(TAG, "Diesel Engine started");
    }
}
