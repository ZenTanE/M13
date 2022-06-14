package com.example.wiam2_m13;

import android.os.Bundle;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wiam2_m13.Adapters.MiniatureCarritoAdapterv2;
import com.example.wiam2_m13.objetos.Plato;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.List;

public class BottomSheetFragment extends BottomSheetDialogFragment {
    String nombre,precio;
    int cantidad,imgUrl;
    List<Plato> lista_platos = new ArrayList<Plato>();
    private MiniatureCarritoAdapterv2 miniarutaCarritoAdapter;
    RecyclerView recyclerViewCarrito;
    private TextView precioTotal;
    public BottomSheetFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            imgUrl = getArguments().getInt("imagen");
            nombre = getArguments().getString("nombre");
            precio = getArguments().getString("precio");
            cantidad = getArguments().getInt("cantidad");
            Plato pl = new Plato(nombre,imgUrl,0.0F,"plato",precio);
            lista_platos.add(pl);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bottom_sheet, container, false);
        recyclerViewCarrito = view.findViewById(R.id.listaCarrito);
        miniarutaCarritoAdapter = new MiniatureCarritoAdapterv2(lista_platos,lista_platos.size());
        recyclerViewCarrito.setAdapter(miniarutaCarritoAdapter);

        precioTotal = view.findViewById(R.id.textView4);
        precioTotal.setText(precio);
        return view;
    }

}
