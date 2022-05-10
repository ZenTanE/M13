package com.example.wiam2_m13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class home extends AppCompatActivity {
    private Integer[] rowElementId ={R.layout.home_data,R.id.txtVData_nameFood,R.id.imgVHomeData,R.id.txtVData_price};//solo importa la de home data
    private ListView listView1;
    CustomerAdapter customerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listView1 = findViewById(R.id.lstV_homeplatos);
        customerAdapter = new CustomerAdapter(this,rowElementId,false);
        listView1.setAdapter(customerAdapter);

    }
}