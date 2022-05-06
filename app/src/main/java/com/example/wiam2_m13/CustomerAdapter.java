package com.example.wiam2_m13;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Console;

public class CustomerAdapter extends BaseAdapter{

    Context context;
    Integer[] lst_id;
    //esto se cambiara
    private String[] nameItems = {"Hamburguesa", "Pizza", "Paella", "Croquetas", "Migas extremeñas", "Tortilla de patatas","Alcachofas","Callos","Bravas","Chuleta de Buey"};
    private Integer[] idImg = {R.drawable.hamburguesa,R.drawable.pizza,R.drawable.paella,R.drawable.croquetas,R.drawable.migas,R.drawable.tortilla,R.drawable.alcachofas,R.drawable.callos,R.drawable.bravas,R.drawable.chuleta};

    public CustomerAdapter(Context context,Integer[] lst_idContentData) {
        //le pasamos por aqui los elementos de la vista con los que trabajaremos
        this.context = context;
        this.lst_id = lst_idContentData;
    }

    @Override
    public int getCount() {
        //aqui devolvemos los elementos que queremos cargar
        return idImg.length;

    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(lst_id[0], null);
        //view = getLayoutInflater().inflate(R.layout.data, null);
        TextView nameItem = (TextView) view.findViewById(lst_id[1]);
        ImageView imageItem = (ImageView) view.findViewById(lst_id[2]);
        TextView priceItem = (TextView) view.findViewById(lst_id[3]);

        nameItem.setText(nameItems[i]);
        imageItem.setImageResource(idImg[i]);
        priceItem.setText("precio: 12€");

        return view;
    }
}
