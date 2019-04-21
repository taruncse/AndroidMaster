package com.tkb.android.dagger.interface_injection;

import android.util.Log;

import javax.inject.Inject;

import dagger.Component;

public class PetrolEngine implements EngineI {

    static String TAG = PetrolEngine.class.getSimpleName();
    @Inject
    public PetrolEngine (){

    }
    @Override
    public void startEngine() {
        Log.i(TAG, "Petrol Engine started");
    }
}
