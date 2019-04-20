package com.tkb.android.dagger.module_and_provider;

import javax.inject.Inject;

public class CarM {
    public static String TAG = CarM.class.getSimpleName();
    @Inject
    EngineM engine;
    private final WheelsM wheels;

    @Inject
    public CarM ( WheelsM wheels){
        this.wheels = wheels;
    }

    public String driveCar(){
        return "Driving...";
    }

    ///Method injection
    // Constructor injection first inject constructor , then field and thirdly Methods.. That's why
    // enableRemote method doesn't need any call
    @Inject
    public void enableRemote(RemoteM remote){
        remote.setListener(this);
    }

}
