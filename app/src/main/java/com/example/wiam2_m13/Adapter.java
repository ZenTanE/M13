package com.example.wiam2_m13;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class Adapter extends RecyclerView.Adapter<Adapter.MyAdapter> {
   @NonNull
   @Override
   public Adapter.MyAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      return null;
   }

   @Override
   public void onBindViewHolder(@NonNull Adapter.MyAdapter holder, int position) {

   }

   @Override
   public int getItemCount() {
      return 0;
   }

   public class MyAdapter extends RecyclerView.ViewHolder {
      public MyAdapter(@NonNull View itemView) {
         super(itemView);
      }
   }
}
