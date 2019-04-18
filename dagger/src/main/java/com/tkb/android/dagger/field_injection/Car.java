package com.tkb.android.dagger.field_injection;

import javax.inject.Inject;

public class Car {
    public static String TAG = Car.class.getSimpleName();
    @Inject
    Engine engine;
    private final Wheels wheels;

    @Inject
    public Car ( Wheels wheels){
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
