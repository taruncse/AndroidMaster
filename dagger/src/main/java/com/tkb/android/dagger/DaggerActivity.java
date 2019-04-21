package com.tkb.android.dagger;

import android.os.Bundle;


import com.tkb.android.dagger.interface_injection.CarIComponent;
import com.tkb.android.dagger.interface_injection.DaggerCarIComponent;

import androidx.appcompat.app.AppCompatActivity;


public class DaggerActivity extends AppCompatActivity {

    /** To inject the following object in Activity, we need to pass this activity to component class.
     *  Activity passing to the component 'carFComponent.inject(this);'
     */
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
        CarIComponent carIComponent = DaggerCarIComponent.create();
        carIComponent.inject(this);
        carIComponent.getCar().driveCar();

    }
}
