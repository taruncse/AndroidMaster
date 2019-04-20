package com.tkb.android.dagger.module_and_provider;

import javax.inject.Inject;

public class WheelsM {

    private Rims rims;
    private Tires tires;
    public WheelsM(Rims rims, Tires tires){
        this.rims = rims;
        this.tires = tires;
    }
}
