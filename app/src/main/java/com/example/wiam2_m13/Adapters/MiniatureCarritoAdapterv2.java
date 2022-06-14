package com.example.wiam2_m13.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wiam2_m13.R;
import com.example.wiam2_m13.objetos.Plato;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MiniatureCarritoAdapterv2 extends RecyclerView.Adapter<MiniatureCarritoAdapterv2.MyAdapter> {

   List<Plato> lst_platos;
   int size;

   public MiniatureCarritoAdapterv2(List<Plato> lst_comentarios, int size) {
      this.lst_platos = lst_comentarios;
      this.size = size;
   }

   @NonNull
   @Override
   public MiniatureCarritoAdapterv2.MyAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

      View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
      return new MyAdapter(rootView);

   }

   @Override
   public void onBindViewHolder(@NonNull MiniatureCarritoAdapterv2.MyAdapter holder, int position) {
      Plato plato = lst_platos.get(position);
      holder.imgPerfil.setImageResource(plato.imageUrl);
      holder.username.setText(plato.nombre);
      holder.cantidad.setText("X 1");
      holder.precio.setText(plato.price);

   }

   @Override
   public int getItemCount() {
      return size;
   }

   public class MyAdapter extends RecyclerView.ViewHolder {
      ImageView imgPerfil;
      TextView username,cantidad, precio;
      public MyAdapter(@NonNull View itemView) {

         super(itemView);

         imgPerfil = itemView.findViewById(R.id.listitemImageView1);
         username = itemView.findViewById(R.id.listitemTextView1);
         cantidad = itemView.findViewById(R.id.listitemTextView2);
         precio = itemView.findViewById(R.id.listitemTextView3);
      }
   }
}
