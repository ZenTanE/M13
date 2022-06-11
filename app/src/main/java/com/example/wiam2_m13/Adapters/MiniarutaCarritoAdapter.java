package com.example.wiam2_m13.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wiam2_m13.BottomSheetFragment;
import com.example.wiam2_m13.R;
import com.example.wiam2_m13.objetos.Plato;

import java.util.List;

public class MiniarutaCarritoAdapter extends RecyclerView.Adapter<MiniarutaCarritoAdapter.ViewHolder> {

    private List<Plato> listaPlatos;
    private LayoutInflater mInflater;

    public MiniarutaCarritoAdapter(Context context, List<Plato> platoList) {
        this.mInflater = LayoutInflater.from(context);
        this.listaPlatos = platoList;
    }

    @NonNull
    @Override
    public MiniarutaCarritoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.viewholder_item_data, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MiniarutaCarritoAdapter.ViewHolder holder, int position) {

        Plato plato = listaPlatos.get(position);
        holder.imagen.setImageResource(plato.imageUrl);
        holder.name.setText(plato.nombre);
        holder.precio.setText(plato.price);
        holder.cantidad.setText("X 1");
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imagen;
        TextView name,precio,cantidad;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.listitemImageView1);
            name = itemView.findViewById(R.id.listitemTextView1);
            cantidad = itemView.findViewById(R.id.listitemTextView2);
            precio = itemView.findViewById(R.id.listitemTextView3);

        }
    }
}
