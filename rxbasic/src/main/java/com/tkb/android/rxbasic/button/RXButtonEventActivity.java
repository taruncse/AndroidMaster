package com.tkb.android.rxbasic.button;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.jakewharton.rxbinding2.view.RxView;
import com.tkb.android.rxbasic.R;
//https://code.tutsplus.com/tutorials/rxjava-for-android-apps-introducing-rxbinding-and-rxlifecycle--cms-28565
public class RXButtonEventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxbutton_event);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button button = findViewById(R.id.btnOkay);

        RxView.clicks(button)
                .subscribe(aVoid -> Toast.makeText(RXButtonEventActivity.this,"Clicked",Toast.LENGTH_LONG).show());


    }

}
