package com.tkb.android.dagger.constraction_injection;

import javax.inject.Inject;

public class Car {
    public static String TAG = Car.class.getSimpleName();
    private final Engine engine;
    private final Wheels wheels;

    @Inject
    public Car (Engine engine, Wheels wheels){
        this.engine = engine;
        this.wheels = wheels;
    }

    public String driveCar(){
        return "Driving...";
    }
}
