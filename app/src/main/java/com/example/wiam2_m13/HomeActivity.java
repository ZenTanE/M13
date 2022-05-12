package com.example.wiam2_m13;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements Miniature1Adapter.ItemClickListener {
    Miniature2Adapter miniaturaRectangular;
    Miniature1Adapter miniaturaCuadrada;
    List<Plato> platoList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getPlatos();

        RecyclerView recyclerView1 = findViewById(R.id.lstV_homeplatos);
        miniaturaRectangular = new Miniature2Adapter(this, platoList);
        miniaturaRectangular.setClickListener(this);
        miniaturaRectangular.setRatingChangeListener((plato, newRating) -> plato.rating = newRating);
        recyclerView1.setAdapter(miniaturaRectangular);

        RecyclerView recyclerView = findViewById(R.id.rvPlatosLocalInfo);
        miniaturaCuadrada = new Miniature1Adapter(this, platoList);
        miniaturaCuadrada.setClickListener(this);

        recyclerView.setAdapter(miniaturaCuadrada);
    }

    private void getPlatos() {
        platoList = new ArrayList<>();
        platoList.add(new Plato("Hamburgues", R.drawable.hamburguesa,1,"plato"));
        platoList.add(new Plato("Pizza", R.drawable.pizza,1,"plato"));
        platoList.add(new Plato("Paella", R.drawable.paella,1,"plato"));
        platoList.add(new Plato("Croquetas", R.drawable.croquetas,1,"plato"));
        platoList.add(new Plato("Migas extremeñas", R.drawable.migas,1,"plato"));
        platoList.add(new Plato("Alcachofas", R.drawable.alcachofas,1,"plato"));
        platoList.add(new Plato("Callos", R.drawable.callos,1,"plato"));
        platoList.add(new Plato("Tortilla de patatas", R.drawable.tortilla,1,"plato"));
        platoList.add(new Plato("Bravas", R.drawable.bravas,1,"plato"));
        platoList.add(new Plato("Chuleta de Buey", R.drawable.chuleta,1,"plato"));

    }

    @Override
    public void onItemClick(View view, int position) {
        //Toast.makeText(this, "You clicked " + miniaturaCuadrada.getItem(position).nombre + " on item position " + position, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, FoodDescriptionActivity.class);
        intent.putExtra("name", miniaturaCuadrada.getItem(position).nombre);
        intent.putExtra("urlImage", miniaturaCuadrada.getItem(position).imageUrl);
        this.startActivity(intent);
    }

}
