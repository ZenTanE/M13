package com.example.wiam2_m13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btHome).setOnClickListener(this::onclick);
        findViewById(R.id.btnLocalInf).setOnClickListener(this::onclick);
        findViewById(R.id.btnfoodDesc).setOnClickListener(this::onclick);
//
    }

    private void onclick(View view) {

        switch (view.getId()){
            case R.id.btHome:
                    startActivity(new Intent(getApplicationContext(),home.class));
                break;
            case R.id.btnLocalInf:
                startActivity(new Intent(getApplicationContext(),Localinfo.class));
                break;
            case R.id.btnfoodDesc:
                startActivity(new Intent(getApplicationContext(),foodDesc.class));
                break;



        }
    }

}