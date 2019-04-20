package com.tkb.android.dagger.module_and_provider;


import dagger.Module;
import dagger.Provides;

/**
 * If we use any library class to instantiated any object , then we use @module and @provider annotation
 * to use that. Android @Component(modules = WheelModules.class) have to add in the component interface
 */
@Module
public class WheelModules {

    @Provides
    public Rims provideRims(){
        return new Rims();
    }

    @Provides
    public Tires provideTires(){
        Tires tires = new Tires();
        tires.inflate();
        return tires;
    }

    @Provides
    public WheelsM provieWheels(Rims rims, Tires tires){
        return new WheelsM(rims,tires);
    }
}
