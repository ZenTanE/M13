package com.example.wiam2_m13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class FoodDescriptionActivity extends AppCompatActivity {

    String nombrePlato;
    Integer urlImage;
    Float rating;
    TextView txtV_namePlatos;
    RatingBar ratingBar;
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
        txtV_namePlatos.setText(nombrePlato);
        ratingBar.setRating(rating);

        ///li.setBackgroundResource(urlImage);
    }

    private void getData() {
        if (getIntent().hasExtra("name") && getIntent().hasExtra("urlImage")) {
            nombrePlato = getIntent().getStringExtra("name");
            urlImage =Integer.getInteger(getIntent().getStringExtra("urlImage"));
            rating = getIntent().getFloatExtra("rating",0.0F);
            Log.d("ratingDebug2", "setData: "+getIntent().getFloatExtra("rating",0.0F));
        } else {
            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
        }
    }
}