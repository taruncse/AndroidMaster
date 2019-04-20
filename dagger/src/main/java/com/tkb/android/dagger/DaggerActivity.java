package com.tkb.android.dagger;

import android.os.Bundle;


import com.tkb.android.dagger.field_injection.CarF;
import com.tkb.android.dagger.field_injection.CarFComponent;
import com.tkb.android.dagger.field_injection.DaggerCarFComponent;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import es.dmoral.toasty.Toasty;


public class DaggerActivity extends AppCompatActivity {

    @Inject
    CarF car;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger);

        //Constructor injection
        /*CarComponent carComponent = DaggerCarComponent.create();
        Toasty.normal(this,carComponent.getCar().driveCar()).show();*/


        //Field Injection

        CarFComponent carComponent = DaggerCarFComponent.create();
        carComponent.inject(this);
        car.driveCar();
        Toasty.normal(this,car.driveCar()).show();

    }
}
