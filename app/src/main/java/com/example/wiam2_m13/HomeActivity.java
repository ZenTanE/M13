package com.example.wiam2_m13;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import java.io.Serializable;
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
        miniaturaRectangular = new Miniature2Adapter(this, platoList );
        miniaturaRectangular.setClickListener(this);
        miniaturaRectangular.setRatingChangeListener((plato, newRating) -> plato.rating = newRating);
        recyclerView1.setAdapter(miniaturaRectangular);
        RecyclerView recyclerView = findViewById(R.id.rvPlatosLocalInfo);
        miniaturaCuadrada = new Miniature1Adapter(this, localesList);
        miniaturaCuadrada.setClickListener(this);

        recyclerView.setAdapter(miniaturaCuadrada);
    }

    private void getPlatos() {
        platoList = new ArrayList<>();
        platoList.add(new Plato("Hamburguesa", R.drawable.hamburguesa,0.5F,"plato"));
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

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    @Override
    public void onItemClickmin2(View view, int position) {
        //Toast.makeText(this, "You clicked " + miniaturaRectangular.getItem(position).nombre + " on item position " + position, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, FoodDescriptionActivity.class);
        Plato pl = miniaturaRectangular.getItem(position);
        intent.putExtra("envioObjetoPrueba", (Serializable) pl);
        this.startActivity(intent);
    }

    @Override
    public void onItemClickmin1(View view, int position) {
        Intent intent = new Intent(this, LocalinfoActivity.class);
        Plato localenviado = miniaturaCuadrada.getItem(position);
        intent.putExtra("envioObjetoPruebaLocal", (Serializable) localenviado);
        this.startActivity(intent);
    }
}
