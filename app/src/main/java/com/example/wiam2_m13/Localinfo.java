package com.example.wiam2_m13;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class Localinfo extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {
    //le pasamos una cadena de los elemtos con los que trabajara de data.xml
    private Integer[] rowElementId ={R.layout.data,R.id.txtVData_nameFood,R.id.imgVData_minFood,R.id.txtVData_price};
    private GridView gridView;
    CustomerAdapter customerAdapter;

    MyRecyclerViewAdapter adapter;
    private String[] nameItems1 = {"Hamburguesa", "Pizza", "Paella", "Croquetas", "Migas extremeñas", "Tortilla de patatas","Alcachofas","Callos","Bravas","Chuleta de Buey"};
    private Integer[] idImg = {R.drawable.hamburguesa,R.drawable.pizza,R.drawable.paella,R.drawable.croquetas,R.drawable.migas,R.drawable.tortilla,R.drawable.alcachofas,R.drawable.callos,R.drawable.bravas,R.drawable.chuleta};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localinfo);


/*
        gridView = findViewById(R.id.gridV_PlatosLocalInfo);
        customerAdapter = new CustomerAdapter(this,rowElementId,true);
        gridView.setAdapter(customerAdapter);
        */

        RecyclerView recyclerView = findViewById(R.id.gridV_PlatosLocalInfo);
        //LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        adapter = new MyRecyclerViewAdapter(this, Arrays.asList(idImg), Arrays.asList(nameItems1));
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);


    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on item position " + position, Toast.LENGTH_SHORT).show();
    }
}