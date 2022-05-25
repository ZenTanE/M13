package com.example.wiam2_m13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class FoodDescriptionActivity extends AppCompatActivity {

    TextView txtV_namePlatos;
    RatingBar ratingBar;
    Plato platoRecivido;
    LinearLayout li;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_desc);

        txtV_namePlatos = findViewById(R.id.textV_NombrePlato);
        ratingBar = findViewById(R.id.ratingDESC);
        //li=(LinearLayout)findViewById(R.id.layoutid);
        getData();
        setData();
    }

    private void setData() {
        if(platoRecivido !=null) {
            txtV_namePlatos.setText(platoRecivido.nombre);
            ratingBar.setRating(platoRecivido.rating);
        }else{
        }
    }

    private void getData() {
        if (getIntent().hasExtra("envioObjetoPrueba")) {
            platoRecivido = (Plato) getIntent().getSerializableExtra("envioObjetoPrueba");
        } else {
            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
        }
    }
}