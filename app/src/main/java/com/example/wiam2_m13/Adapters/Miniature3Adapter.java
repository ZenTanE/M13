package com.example.wiam2_m13.Adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wiam2_m13.HomeActivity;
import com.example.wiam2_m13.R;
import com.example.wiam2_m13.objetos.Plato;

import java.util.List;

public class Miniature3Adapter extends RecyclerView.Adapter<Miniature3Adapter.ViewHolder> {

    private List<Plato> listaPlatos;
    private LayoutInflater mInflater;
    private Miniature3Adapter.ItemClickListener mClickListener;

    public Miniature3Adapter(HomeActivity context, List<Plato> platoList) {
        this.mInflater = LayoutInflater.from(context);
        Log.d("localList", "Miniature3Adapter: "+platoList.size());
        this.listaPlatos = platoList;
    }

    @NonNull
    @Override
    public Miniature3Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.viewholder_home_data2, parent, false);
        return new Miniature3Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Plato plato = listaPlatos.get(position);
        holder.myImageView.setImageResource(plato.imageUrl);

    }

    @Override
    public int getItemCount() {return listaPlatos.size();}

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView myImageView;

        ViewHolder(View itemView) {
            super(itemView);
            myImageView = itemView.findViewById(R.id.square_thumbnail_image);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            if (mClickListener != null) mClickListener.onItemClickmin3(view, getAdapterPosition());
        }
    }
    public Plato getItem(int id) {
        return listaPlatos.get(id);
    }

    // allows clicks events to be caught
    public void setClickListener(Miniature3Adapter.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClickmin3(View view, int position);
    }

}
