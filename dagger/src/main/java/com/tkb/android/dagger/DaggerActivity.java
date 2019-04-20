package com.tkb.android.dagger;

import android.os.Bundle;


import com.tkb.android.dagger.module_and_provider.CarMComponent;
import com.tkb.android.dagger.module_and_provider.DaggerCarMComponent;

import androidx.appcompat.app.AppCompatActivity;


public class DaggerActivity extends AppCompatActivity {

   /* @Inject
    CarF car;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger);

        //Constructor injection
        /*CarComponent carComponent = DaggerCarComponent.create();
        Toasty.normal(this,carComponent.getCar().driveCar()).show();*/


        //Field Injection

       /* CarFComponent carComponent = DaggerCarFComponent.create();
        carComponent.inject(this);
        car.driveCar();
        Toasty.normal(this,car.driveCar()).show();*/


       //Module and provider
        CarMComponent carFComponent = DaggerCarMComponent.create();
        carFComponent.inject(this);
        carFComponent.getCar().driveCar();

    }
}
