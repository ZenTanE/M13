package com.example.wiam2_m13;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;

public class home extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener{
    private Integer[] rowElementId1 ={R.layout.home_data,R.id.txtVData_nameFood,R.id.imgVHomeData,R.id.txtVData_price};//solo importa la de home data
    private ListView listView1;
    CustomerAdapter customerAdapter1;

    MyRecyclerViewAdapter adapter,adapter1;
    private String[] nameItems1 = {"Hamburguesa", "Pizza", "Paella", "Croquetas", "Migas extremeñas", "Tortilla de patatas","Alcachofas","Callos","Bravas","Chuleta de Buey"};
    private Integer[] idImg = {R.drawable.hamburguesa,R.drawable.pizza,R.drawable.paella,R.drawable.croquetas,R.drawable.migas,R.drawable.tortilla,R.drawable.alcachofas,R.drawable.callos,R.drawable.bravas,R.drawable.chuleta};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
/*
        listView1 = findViewById(R.id.lstV_homeplatos);
        customerAdapter1 = new CustomerAdapter(this,rowElementId1,false);
        listView1.setAdapter(customerAdapter1);
*/
        LinearLayoutManager horizontalLayoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        RecyclerView recyclerView1 = findViewById(R.id.lstV_homeplatos);
        recyclerView1.setLayoutManager(horizontalLayoutManager);
        adapter = new MyRecyclerViewAdapter(this, Arrays.asList(idImg), Arrays.asList(nameItems1));
        adapter.setClickListener(this);
        recyclerView1.setAdapter(adapter);

        RecyclerView recyclerView = findViewById(R.id.rvPlatosLocalInfo);
        horizontalLayoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManager);
        adapter = new MyRecyclerViewAdapter(this, Arrays.asList(idImg), Arrays.asList(nameItems1));
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }
    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on item position " + position, Toast.LENGTH_SHORT).show();
    }

}
