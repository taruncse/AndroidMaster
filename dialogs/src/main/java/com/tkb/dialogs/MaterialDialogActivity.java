package com.tkb.dialogs;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.yarolegovich.lovelydialog.LovelyInfoDialog;
import com.yarolegovich.lovelydialog.LovelyTextInputDialog;

import androidx.appcompat.app.AppCompatActivity;

public class MaterialDialogActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnStandar, btnChoice,btnCustom,btnInfo,btnInput,btnProgress ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_dialog);
        initialization ();

        btnStandar.setOnClickListener(this);
        btnInfo.setOnClickListener(this);
        btnInput.setOnClickListener(this);
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
            new LovelyInfoDialog(this)
                    .setTopColorRes(R.color.mtrl_dark_on_primary_emphasis_high_type)
                    .setIcon(R.drawable.ic_info_outline_white_24dp)
                    //This will add Don't show again checkbox to the dialog. You can pass any ID as argument
                    .setNotShowAgainOptionEnabled(0)
                    .setNotShowAgainOptionChecked(true)
                    .setTitle(R.string.info)
                    .setMessage(R.string.app_name)
                    .show();
        }else if (v.getId() == R.id.btnInput){
            new LovelyTextInputDialog(this, R.style.TintTheme)
                    .setTopColorRes(android.R.color.holo_orange_dark)
                    .setTitle(R.string.text_input)
                    .setMessage(R.string.toast_message)
                    .setIcon(R.drawable.ic_info_outline_white_24dp)
                    .setInputFilter(R.string.dont_show_again, text -> text.matches("\\w+"))
                    .setConfirmButton(android.R.string.ok, text -> Toast.makeText(MaterialDialogActivity.this, text, Toast.LENGTH_SHORT).show())
                    .show();
        }else if (v.getId() == R.id.btnProgress){

        }else {

        }
    }
}
