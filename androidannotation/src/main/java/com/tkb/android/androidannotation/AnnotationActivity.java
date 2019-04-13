package com.tkb.android.androidannotation;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

import androidx.appcompat.app.AppCompatActivity;

@EActivity(R.layout.activity_annotation)
public class AnnotationActivity extends AppCompatActivity {

    @AfterViews
    void afterView(){

    }
}
