package com.tkb.android.dagger;

import android.os.Bundle;

import com.tkb.android.dagger.field_injection.Car;
import com.tkb.android.dagger.field_injection.CarComponent;
import com.tkb.android.dagger.field_injection.DaggerCarComponent;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import es.dmoral.toasty.Toasty;


public class DaggerActivity extends AppCompatActivity {

    @Inject
    Car car;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger);

        //Constructor injection
        /*CarComponent carComponent = DaggerCarComponent.create();
        Toasty.normal(this,carComponent.getCar().driveCar()).show();*/


        //Field Injection

        CarComponent carComponent = DaggerCarComponent.create();
        carComponent.inject(this);
        Toasty.normal(this,car.driveCar()).show();

    }
}
