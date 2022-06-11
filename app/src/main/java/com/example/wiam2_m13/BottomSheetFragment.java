package com.example.wiam2_m13;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.wiam2_m13.Adapters.MiniarutaCarritoAdapter;
import com.example.wiam2_m13.objetos.Coment;
import com.example.wiam2_m13.objetos.Plato;
import com.example.wiam2_m13.placeholder.PlaceholderContent;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.List;

public class BottomSheetFragment extends BottomSheetDialogFragment {
    String nombre,precio;
    int cantidad,imgUrl;
    Adapter myAdapter;
    List<Plato> lista_platos = new ArrayList<Plato>();
    private MiniarutaCarritoAdapter miniarutaCarritoAdapter;

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
            lista_platos .add(pl);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bottom_sheet, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.List);
        miniarutaCarritoAdapter = new MiniarutaCarritoAdapter(this.getContext(),lista_platos);
        recyclerView.setAdapter(miniarutaCarritoAdapter);
        return view;
    }

}
