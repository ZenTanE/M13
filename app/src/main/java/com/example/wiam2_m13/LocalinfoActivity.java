package com.example.wiam2_m13;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class LocalinfoActivity extends AppCompatActivity implements Miniature1Adapter.ItemClickListener {
    //le pasamos una cadena de los elemtos con los que trabajara de data.xml
    List<Plato> platoList;
    Miniature1Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localinfo);
        getPlatos();
        RecyclerView recyclerView = findViewById(R.id.gridV_PlatosLocalInfo);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        adapter = new Miniature1Adapter(this,platoList);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onItemClickmin1(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position).nombre + " on item position " + position, Toast.LENGTH_SHORT).show();
    }

    private void getPlatos() {
        platoList = new ArrayList<>();
        platoList.add(new Plato("Hamburgues", R.drawable.hamburguesa,0.5F,"plato"));
        platoList.add(new Plato("Pizza", R.drawable.pizza,0.5F,"plato"));
        platoList.add(new Plato("Paella", R.drawable.paella,0.5F,"plato"));
        platoList.add(new Plato("Croquetas", R.drawable.croquetas,0.5F,"plato"));
        platoList.add(new Plato("Migas extremeñas", R.drawable.migas,0.5F,"plato"));
        platoList.add(new Plato("Alcachofas", R.drawable.alcachofas,0.5F,"plato"));
        platoList.add(new Plato("Callos", R.drawable.callos,0.5F,"plato"));
        platoList.add(new Plato("Tortilla de patatas", R.drawable.tortilla,0.5F,"plato"));
        platoList.add(new Plato("Bravas", R.drawable.bravas,0.5F,"plato"));
        platoList.add(new Plato("Chuleta de Buey", R.drawable.chuleta,0.5F,"plato"));

    }
}