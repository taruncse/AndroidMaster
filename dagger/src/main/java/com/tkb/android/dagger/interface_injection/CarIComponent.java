package com.tkb.android.dagger.interface_injection;

import com.tkb.android.dagger.DaggerActivity;
import com.tkb.android.dagger.module_and_provider.WheelModules;

import dagger.Component;

@Component(modules = {WheelModules.class, DieselEngineModule.class})
public interface CarIComponent {
    void inject(DaggerActivity daggerActivity);

    CarI getCar() ;
}
