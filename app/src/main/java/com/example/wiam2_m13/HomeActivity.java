package com.example.wiam2_m13;

import static com.example.wiam2_m13.placeholder.PlaceholderContent.ITEMS;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.wiam2_m13.Adapters.Miniature2Adapter;
import com.example.wiam2_m13.Adapters.Miniature3Adapter;
import com.example.wiam2_m13.objetos.Coment;
import com.example.wiam2_m13.objetos.Plato;
import com.example.wiam2_m13.placeholder.PlaceholderContent;
import com.google.android.gms.common.SignInButton;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements Miniature3Adapter.ItemClickListener, Miniature2Adapter.ItemClickListener {
    Miniature2Adapter miniaturaRectangular;
    Miniature3Adapter miniaturaCuadrada;
    ImageView profile_ImageView;
    List<Plato> platoList,localesList;
    List<PlaceholderContent.PlaceholderItem> localesList1;
    private SignInButton googleSignInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //
        getPlatos();
        getLocales();


        RecyclerView recyclerView1 = findViewById(R.id.lstV_homeplatos);
        miniaturaRectangular = new Miniature2Adapter(this, platoList );
        miniaturaRectangular.setClickListener(this);
        miniaturaRectangular.setRatingChangeListener((plato, newRating) -> plato.rating = newRating);
        recyclerView1.setAdapter(miniaturaRectangular);
        RecyclerView recyclerView = findViewById(R.id.rvPlatosLocalInfo);


        miniaturaCuadrada = new Miniature3Adapter(this, localesList);
        miniaturaCuadrada.setClickListener(this);

        recyclerView.setAdapter(miniaturaCuadrada);

        profile_ImageView = findViewById(R.id.home_Profile_ImageView);
        profile_ImageView.setOnClickListener(this::imgLoginClick);
    }

    private void imgLoginClick(View view) {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.login_dialog);
        //acciones dentro de dialog
        googleSignInButton = dialog.findViewById(R.id.googleSignInButton);
        googleSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //accederConGoogle();

                Log.d("Itemsobj", "onClick: items"+ ITEMS);
                PlaceholderContent.PlaceholderItem item = ITEMS.get(2);
                for(int i =0;i<ITEMS.size();i++){
                    Log.d("Itemsobj", "onClick: "+ITEMS.get(i).nombre+" fecha: "+ITEMS.get(i).date);
                }

            }
        });
        dialog.show();
    }

    private void getPlatos() {
        platoList = new ArrayList<>();
        platoList.add(new Plato("Hamburguesa", R.drawable.hamburguesa,0.5F,"plato","3,5€"));
        platoList.add(new Plato("Pizza", R.drawable.pizza,0.5F,"plato","3,5€"));
        platoList.add(new Plato("Paella", R.drawable.paella,0.5F,"plato","3,5€"));
        platoList.add(new Plato("Croquetas", R.drawable.croquetas,0.5F,"plato","3,5€"));
        platoList.add(new Plato("Migas extremeñas", R.drawable.migas,0.0F,"plato","3,5€"));
        platoList.add(new Plato("Alcachofas", R.drawable.alcachofas,0.0F,"plato","3,5€"));
        platoList.add(new Plato("Callos", R.drawable.callos,0.0F,"plato","3,5€"));
        platoList.add(new Plato("Tortilla de patatas", R.drawable.tortilla,0.0F,"plato","3,5€"));
        platoList.add(new Plato("Bravas", R.drawable.bravas,0.0F,"plato","3,5€"));
        platoList.add(new Plato("Chuleta de Buey", R.drawable.chuleta,0.0F,"plato","3,5€"));

    }
    private void getLocales() {
        localesList = new ArrayList<>();
        localesList.add(new Plato("los manolos", R.drawable.bar1,0.5F,"plato","3,5€"));
        localesList.add(new Plato("Los peques", R.drawable.bravas,0.5F,"plato","3,5€"));
        localesList.add(new Plato("segovia", R.drawable.bar1,0.5F,"plato","3,5€"));
        localesList.add(new Plato("5 Puertas", R.drawable.bar1,0.5F,"plato","3,5€"));
        localesList.add(new Plato("el escondite", R.drawable.bar1,0.0F,"plato","3,5€"));
        localesList.add(new Plato("la choza", R.drawable.bar1,0.0F,"plato","3,5€"));
        localesList.add(new Plato("MOE'S", R.drawable.bar1,0.0F,"plato","3,5€"));
        localesList.add(new Plato("CHIRINGUITO", R.drawable.bar1,0.0F,"plato","3,5€"));
        localesList.add(new Plato("ja me maten", R.drawable.bar1,0.0F,"plato","3,5€"));
        localesList.add(new Plato("pal currante", R.drawable.bar1,0.0F,"plato","3,5€"));

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
    public void onItemClickmin3(View view, int position) {
        Intent intent = new Intent(this, LocalinfoActivity.class);
        Plato localenviado = miniaturaCuadrada.getItem(position);
        intent.putExtra("envioObjetoPruebaLocal", (Serializable) localenviado);
        this.startActivity(intent);
    }
}
