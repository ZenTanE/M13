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
import java.util.List;

public class Localinfo extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {
    //le pasamos una cadena de los elemtos con los que trabajara de data.xml
    private Integer[] rowElementId ={R.layout.data,R.id.txtVData_nameFood,R.id.imgVData_minFood,R.id.txtVData_price};
    private GridView gridView;
    CustomerAdapter customerAdapter;
    List<Plato> platoList;
    MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localinfo);

        getPlatos();
/*
        gridView = findViewById(R.id.gridV_PlatosLocalInfo);
        customerAdapter = new CustomerAdapter(this,rowElementId,true);
        gridView.setAdapter(customerAdapter);
        */

        RecyclerView recyclerView = findViewById(R.id.gridV_PlatosLocalInfo);
        //LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        adapter = new MyRecyclerViewAdapter(this,platoList);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);


    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on item position " + position, Toast.LENGTH_SHORT).show();
    }

    private void getPlatos() {
        platoList = new ArrayList<>();
        platoList.add(new Plato("Hamburgues", R.drawable.hamburguesa));
        platoList.add(new Plato("Pizza", R.drawable.pizza));
        platoList.add(new Plato("Paella", R.drawable.paella));
        platoList.add(new Plato("Croquetas", R.drawable.croquetas));
        platoList.add(new Plato("Migas extremeñas", R.drawable.migas));
        platoList.add(new Plato("Alcachofas", R.drawable.alcachofas));
        platoList.add(new Plato("Callos", R.drawable.callos));
        platoList.add(new Plato("Tortilla de patatas", R.drawable.tortilla));
        platoList.add(new Plato("Bravas", R.drawable.bravas));
        platoList.add(new Plato("Chuleta de Buey", R.drawable.chuleta));

    }
}