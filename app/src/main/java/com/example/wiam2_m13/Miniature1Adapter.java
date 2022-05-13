package com.example.wiam2_m13;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class Miniature1Adapter extends RecyclerView.Adapter<Miniature1Adapter.ViewHolder> {

   private List<Plato> listaPlatos;
   private List<String> mPlatos;
   private LayoutInflater mInflater;
   private ItemClickListener mClickListener;
   
   Miniature1Adapter(Context context, List<Plato> platoList) {
      this.mInflater = LayoutInflater.from(context);
      this.listaPlatos = platoList;
   }

   // inflates the row layout from xml when needed
   @Override
   @NonNull
   public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view = mInflater.inflate(R.layout.viewholder_item_data, parent, false);
      return new ViewHolder(view);
   }

   // binds the data to the view and textview in each row
   @Override
   public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
      Plato plato = listaPlatos.get(position);
      holder.myImageView.setImageResource(plato.imageUrl);
      holder.myTextView.setText(plato.nombre);
   }

   // total number of rows
   @Override
   public int getItemCount() {
      return listaPlatos.size();
   }

   // stores and recycles views as they are scrolled off screen
   public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
      ImageView myImageView;
      TextView myTextView;

      ViewHolder(View itemView) {
         super(itemView);
         myImageView = itemView.findViewById(R.id.imgVData_minFood);
         myTextView = itemView.findViewById(R.id.txtVData_nameFood);
         itemView.setOnClickListener(this);
      }

      @Override
      public void onClick(View view) {
         if (mClickListener != null) mClickListener.onItemClickmin1(view, getAdapterPosition());
      }
   }

   // convenience method for getting data at click position
   public Plato getItem(int id) {
      return listaPlatos.get(id);
   }

   // allows clicks events to be caught
   public void setClickListener(ItemClickListener itemClickListener) {
      this.mClickListener = itemClickListener;
   }

   // parent activity will implement this method to respond to click events
   public interface ItemClickListener {
      void onItemClickmin1(View view, int position);
   }
}
