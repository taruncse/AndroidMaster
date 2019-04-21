package com.tkb.android.dagger.interface_injection;

import com.tkb.android.dagger.constraction_injection.Engine;
import com.tkb.android.dagger.module_and_provider.WheelsM;

import javax.inject.Inject;

public class CarI {
    public static String TAG = CarI.class.getSimpleName();

    EngineI engine;
    private final WheelsM wheels;

    @Inject
    public CarI (WheelsM wheels, EngineI engine){
        this.wheels = wheels;
        this.engine = engine ;
    }

    public String driveCar(){
        engine.startEngine();
        return "Driving...";

    }

    ///Method injection
    // Constructor injection first inject constructor , then field and thirdly Methods.. That's why
    // enableRemote method doesn't need any call
    @Inject
    public void enableRemote(RemoteI remote){
        remote.setListener(this);
    }

}
