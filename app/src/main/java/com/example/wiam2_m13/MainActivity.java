package com.example.wiam2_m13;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btHome).setOnClickListener(this::onclick);
        findViewById(R.id.btnLocalInf).setOnClickListener(this::onclick);
        findViewById(R.id.btnfoodDesc).setOnClickListener(this::onclick);
        findViewById(R.id.btnLogin).setOnClickListener(this::onclick);

    }

    private void onclick(View view) {

        switch (view.getId()){
            case R.id.btHome:
                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                break;
            case R.id.btnLocalInf:
                startActivity(new Intent(getApplicationContext(), LocalinfoActivity.class));
                break;
            case R.id.btnfoodDesc:
                startActivity(new Intent(getApplicationContext(), FoodDescriptionActivity.class));
                break;
            case R.id.btnLogin:
                final Dialog dialog = new Dialog(this);
                dialog.setContentView(R.layout.login_dialog);
                //acciones dentro de dialog
                dialog.show();
                break;




        }
    }

}