package com.example.wiam2_m13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CursorAdapter;
import android.widget.GridLayout;
import android.widget.GridView;

public class Localinfo extends AppCompatActivity {
    private Integer[] rowElementId ={R.layout.data,R.id.txtVData_nameFood,R.id.imgVData_minFood,R.id.txtVData_price};
    private GridView gridView;
    CustomerAdapter customerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localinfo);

        gridView = findViewById(R.id.gridV_PlatosLocalInfo);
        customerAdapter = new CustomerAdapter(this,rowElementId);
        gridView.setAdapter(customerAdapter);


    }
}