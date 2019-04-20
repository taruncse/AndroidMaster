package com.tkb.android.dagger.module_and_provider;

import com.tkb.android.dagger.DaggerActivity;

import dagger.Component;
import dagger.Module;

@Component(modules = WheelModules.class)
public interface CarMComponent {
    void inject(DaggerActivity daggerActivity);

    CarM getCar() ;
}
