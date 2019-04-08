package com.tkb.android.androidannotation;

import androidx.appcompat.app.AppCompatActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.sharedpreferences.Pref;

@EActivity(R.layout.activity_pref)
public class PrefActivity extends AppCompatActivity {

    @Pref
    PrefManager_ myPrefs;

    @AfterViews
    protected void afterView() {

    }
}
