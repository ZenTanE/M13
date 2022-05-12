package com.example.wiam2_m13;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {
    private Integer[] rowElementId1 = {R.layout.viewholder_home_data, R.id.txtVData_nameFood, R.id.imgVHomeData, R.id.txtVData_price};//solo importa la de home data
    private ListView listView1;
    CustomerAdapter customerAdapter1;
    MiniatureAdapter adapter1;
    MyRecyclerViewAdapter adapter;
    List<Plato> platoList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getPlatos();

        RecyclerView recyclerView1 = findViewById(R.id.lstV_homeplatos);
        adapter1 = new MiniatureAdapter(this, platoList);
        adapter1.setClickListener(this);
        adapter1.setRatingChangeListener((plato, newRating) -> plato.rating = newRating);
        recyclerView1.setAdapter(adapter1);

        RecyclerView recyclerView = findViewById(R.id.rvPlatosLocalInfo);
        adapter = new MyRecyclerViewAdapter(this, platoList);
        adapter.setClickListener(this);

        recyclerView.setAdapter(adapter);
    }

    private void getPlatos() {
        platoList = new ArrayList<>();
        platoList.add(new Plato("Hamburgues", R.drawable.hamburguesa));
        platoList.add(new Plato("Pizza", R.drawable.pizza));
        platoList.add(new Plato("Paella", R.drawable.paella));
        platoList.add(new Plato("Croquetas", R.drawable.croquetas));
        platoList.add(new Plato("Migas extremeñas", R.drawable.migas));
        platoList.add(new Plato("Alcachofas", R.drawable.alcachofas));
        platoList.add(new Plato("Callos", R.drawable.callos));
        platoList.add(new Plato("Tortilla de patatas", R.drawable.tortilla));
        platoList.add(new Plato("Bravas", R.drawable.bravas));
        platoList.add(new Plato("Chuleta de Buey", R.drawable.chuleta));

    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on item position " + position, Toast.LENGTH_SHORT).show();
    }

}
