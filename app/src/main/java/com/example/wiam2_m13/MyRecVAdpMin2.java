package com.example.wiam2_m13;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MyRecVAdpMin2 extends RecyclerView.Adapter<MyRecVAdpMin2.ViewHolder> {

    private List<Integer> mViewImgPlatos;
    private List<String> mPlatos;
    private LayoutInflater mInflater;
    private MyRecyclerViewAdapter.ItemClickListener mClickListener;

    public MyRecVAdpMin2(Context context, List<Integer> imgPlatos, List<String> strNombrePlato) {
        this.mInflater = LayoutInflater.from(context);
        this.mViewImgPlatos = imgPlatos;
        this.mPlatos = strNombrePlato;
    }

    @NonNull
    @Override
    public MyRecVAdpMin2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.home_data, parent, false);
        return new MyRecVAdpMin2.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int color = mViewImgPlatos.get(position);
        Log.e("pruebas", "onBindViewHolder: "+color );
        holder.myImageView.setImageResource(color);
    }

    @Override
    public int getItemCount() {return mPlatos.size();}

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView myImageView;
        TextView myTextView;

        ViewHolder(View itemView) {
            super(itemView);
            myImageView = itemView.findViewById(R.id.imgVHomeData);
            //myTextView = itemView.findViewById(R.id.txtVData_nameFood);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }
    public String getItem(int id) {
        return mPlatos.get(id);
    }

    // allows clicks events to be caught
    public void setClickListener(MyRecyclerViewAdapter.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
