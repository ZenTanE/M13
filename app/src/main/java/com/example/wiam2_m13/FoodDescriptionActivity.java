package com.example.wiam2_m13;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class FoodDescriptionActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<Plato> carrito;
    RecyclerView opiniones;
    List<Coment> listaComentarios = new ArrayList<>();
    Adapter adapter;
    TextView txtV_namePlatos;
    RatingBar ratingBar;
    Plato platoRecivido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_desc);
        carrito = new ArrayList<Plato>();
        txtV_namePlatos = findViewById(R.id.textV_NombrePlato);
        ratingBar = findViewById(R.id.ratingDESC);
        opiniones = findViewById(R.id.rvOpiniones);
        opiniones.setLayoutManager(new LinearLayoutManager(this));

        getDataComent();
        getData();
        setData();
        //añadir a carrito
        findViewById(R.id.button3).setOnClickListener(this);
    }

    private void setData() {
        if(platoRecivido !=null) {
            txtV_namePlatos.setText(platoRecivido.nombre);
            ratingBar.setRating(platoRecivido.rating);
        }else{

        }
    }
    private void getDataComent() {
        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
        String formattedDate = df.format(c);
        listaComentarios.add(new Coment("Fulano",formattedDate,"",R.drawable.callos));
    }
    private void getData() {
        if (getIntent().hasExtra("envioObjetoPrueba")) {
            platoRecivido = (Plato) getIntent().getSerializableExtra("envioObjetoPrueba");
        } else {
            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.button3){
            carrito.add(platoRecivido);
            Toast.makeText(this, "se a agregado correctamente.", Toast.LENGTH_SHORT).show();
        }
        Log.d("CARRITO", "onClick: carrito.size "+carrito.size());
        for (Plato plato:carrito) {
            Log.d("CARRITO", "foreach:carrito "+plato.nombre);
        }
    }
}