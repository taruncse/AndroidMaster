package com.tkb.android.androidannotation;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import es.dmoral.toasty.Toasty;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.sharedpreferences.Pref;

@EActivity(R.layout.activity_pref)
public class PrefActivity extends AppCompatActivity {

    @Pref
    PrefManager_ myPrefs;

    @ViewById(R.id.txtShowName)
    TextView txtShowName;

    @ViewById(R.id.edtTextName)
    EditText edtTextName;

    @ViewById(R.id.btnSave)
    Button btnSave;

    @Click
    void btnSave(){
        if (edtTextName.getText().toString().isEmpty()){
            Toasty.error(this, "Please enter your name", Toast.LENGTH_SHORT, true).show();

        }else {
            myPrefs.name().put(edtTextName.getText().toString());
            txtShowName.setText(myPrefs.name().get()+"");
        }
    }
    @AfterViews
    protected void afterView() {
        txtShowName.setText(myPrefs.name().get()+"");
    }
}
