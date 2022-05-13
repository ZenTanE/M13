package com.example.wiam2_m13;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements Miniature1Adapter.ItemClickListener, Miniature2Adapter.ItemClickListener {
    Miniature2Adapter miniaturaRectangular;
    Miniature1Adapter miniaturaCuadrada;
    List<Plato> platoList,localesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getPlatos();
        getLocales();

        RecyclerView recyclerView1 = findViewById(R.id.lstV_homeplatos);
        miniaturaRectangular = new Miniature2Adapter(this, localesList);
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
        platoList.add(new Plato("Hamburgues", R.drawable.hamburguesa,0.5F,"plato"));
        platoList.add(new Plato("Pizza", R.drawable.pizza,0.5F,"plato"));
        platoList.add(new Plato("Paella", R.drawable.paella,0.5F,"plato"));
        platoList.add(new Plato("Croquetas", R.drawable.croquetas,0.5F,"plato"));
        platoList.add(new Plato("Migas extremeñas", R.drawable.migas,0.0F,"plato"));
        platoList.add(new Plato("Alcachofas", R.drawable.alcachofas,0.0F,"plato"));
        platoList.add(new Plato("Callos", R.drawable.callos,0.0F,"plato"));
        platoList.add(new Plato("Tortilla de patatas", R.drawable.tortilla,0.0F,"plato"));
        platoList.add(new Plato("Bravas", R.drawable.bravas,0.0F,"plato"));
        platoList.add(new Plato("Chuleta de Buey", R.drawable.chuleta,0.0F,"plato"));

    }
    private void getLocales() {
        localesList = new ArrayList<>();
        localesList.add(new Plato("los manolos", R.drawable.bar1,0.5F,"plato"));
        localesList.add(new Plato("Los peques", R.drawable.bar2,0.5F,"plato"));
        localesList.add(new Plato("segovia", R.drawable.bar1,0.5F,"plato"));
        localesList.add(new Plato("5 Puertas", R.drawable.bar1,0.5F,"plato"));
        localesList.add(new Plato("el escondite", R.drawable.bar1,0.0F,"plato"));
        localesList.add(new Plato("la choza", R.drawable.bar1,0.0F,"plato"));
        localesList.add(new Plato("MOE'S", R.drawable.bar1,0.0F,"plato"));
        localesList.add(new Plato("CHIRINGUITO", R.drawable.bar1,0.0F,"plato"));
        localesList.add(new Plato("ja me maten", R.drawable.bar1,0.0F,"plato"));
        localesList.add(new Plato("pal currante", R.drawable.bar1,0.0F,"plato"));

    }
/*
    @Override
    public void onItemClick(View view, int position) {
        //Toast.makeText(this, "You clicked " + miniaturaCuadrada.getItem(position).nombre + " on item position " + position, Toast.LENGTH_SHORT).show();
        Intent intent;
        intent = new Intent(this, FoodDescriptionActivity.class);
        intent.putExtra("name", miniaturaRectangular.getItem(position).nombre);
        intent.putExtra("urlImage", miniaturaRectangular.getItem(position).imageUrl);
        intent.putExtra("rating", Float.valueOf(miniaturaRectangular.getItem(position).rating));
        Log.d("ratingDebug1", "onItemClick:putExtra "+Float.valueOf(miniaturaRectangular.getItem(position).rating));
        this.startActivity(intent);
    }*/

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    @Override
    public void onItemClickmin2(View view, int position) {
        Toast.makeText(this, "You clicked " + miniaturaRectangular.getItem(position).nombre + " on item position " + position, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onItemClickmin1(View view, int position) {
        Toast.makeText(this, "You clicked " + miniaturaCuadrada.getItem(position).nombre + " on item position " + position, Toast.LENGTH_SHORT).show();

    }
}
