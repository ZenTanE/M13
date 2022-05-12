package com.example.wiam2_m13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class FoodDescriptionActivity extends AppCompatActivity {

    String nombrePlato;
    Integer urlImage;
    TextView txtV_namePlatos;
    LinearLayout li;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_desc);

        txtV_namePlatos = findViewById(R.id.textV_NombrePlato);
        //li=(LinearLayout)findViewById(R.id.layoutid);

        getData();
        setData();
    }

    private void setData() {
        txtV_namePlatos.setText(nombrePlato);
        ///li.setBackgroundResource(urlImage);
    }

    private void getData() {
        if (getIntent().hasExtra("name") && getIntent().hasExtra("urlImage")) {
            nombrePlato = getIntent().getStringExtra("name");
            urlImage =Integer.getInteger(getIntent().getStringExtra("urlImage"));
        } else {
            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
        }
    }
}