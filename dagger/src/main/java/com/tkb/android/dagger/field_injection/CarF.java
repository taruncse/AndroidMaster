package com.tkb.android.dagger.field_injection;

import javax.inject.Inject;

public class CarF {
    public static String TAG = CarF.class.getSimpleName();
    @Inject
    EngineF engine;
    private final WheelsF wheels;

    @Inject
    public CarF ( WheelsF wheels){
        this.wheels = wheels;
    }

    public String driveCar(){
        return "Driving...";
    }

    ///Method injection
    // Constructor injection first inject constructor , then field and thirdly Methods.. That's why
    // enableRemote method doesn't need any call
    @Inject
    public void enableRemote(Remote remote){
        remote.setListener(this);
    }

}
