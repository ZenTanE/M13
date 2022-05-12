package com.example.wiam2_m13;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

   private List<Integer> mViewImgPlatos;
   private List<String> mPlatos;
   private LayoutInflater mInflater;
   private ItemClickListener mClickListener;
   MyRecyclerViewAdapter(Context context, List<Integer> imgPlatos, List<String> strNombrePlato) {
      this.mInflater = LayoutInflater.from(context);
      this.mViewImgPlatos = imgPlatos;
      this.mPlatos = strNombrePlato;
   }

   // inflates the row layout from xml when needed
   @Override
   @NonNull
   public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view = mInflater.inflate(R.layout.data, parent, false);
      return new ViewHolder(view);
   }

   // binds the data to the view and textview in each row
   @Override
   public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
      int color = mViewImgPlatos.get(position);
      String animal = mPlatos.get(position);
      holder.myView.setBackgroundColor(color);
      holder.myTextView.setText(animal);
   }

   // total number of rows
   @Override
   public int getItemCount() {
      return mPlatos.size();
   }

   // stores and recycles views as they are scrolled off screen
   public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
      View myView;
      TextView myTextView;

      ViewHolder(View itemView) {
         super(itemView);
         myView = itemView.findViewById(R.id.imgVData_minFood);
         myTextView = itemView.findViewById(R.id.txtVData_nameFood);
         itemView.setOnClickListener(this);
      }

      @Override
      public void onClick(View view) {
         if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
      }
   }

   // convenience method for getting data at click position
   public String getItem(int id) {
      return mPlatos.get(id);
   }

   // allows clicks events to be caught
   public void setClickListener(ItemClickListener itemClickListener) {
      this.mClickListener = itemClickListener;
   }

   // parent activity will implement this method to respond to click events
   public interface ItemClickListener {
      void onItemClick(View view, int position);
   }
}
