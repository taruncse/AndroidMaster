package com.tkb.dialogs;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.afollestad.materialdialogs.MaterialDialog;

import androidx.appcompat.app.AppCompatActivity;

public class MaterialDialogActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnStandar, btnChoice,btnCustom,btnInfo,btnInput,btnProgress ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_dialog);
        initialization ();

        btnStandar.setOnClickListener(this);
    }

    private void initialization() {
        btnChoice = findViewById(R.id.btnChoice);
        btnStandar = findViewById(R.id.btnStandar);
        btnCustom = findViewById(R.id.btnCustom);
        btnInfo = findViewById(R.id.btnInfo);
        btnInput = findViewById(R.id.btnInput);
        btnProgress = findViewById(R.id.btnProgress);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btnStandar){

        }else if (v.getId() == R.id.btnChoice){

        }else if (v.getId() == R.id.btnCustom){

        }else if (v.getId() == R.id.btnInfo){

        }else if (v.getId() == R.id.btnInput){

        }else if (v.getId() == R.id.btnProgress){

        }else {

        }
    }
}
