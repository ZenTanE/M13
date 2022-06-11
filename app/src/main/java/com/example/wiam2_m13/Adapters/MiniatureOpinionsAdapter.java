package com.example.wiam2_m13.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wiam2_m13.R;
import com.example.wiam2_m13.objetos.Coment;

import java.util.List;

public class MiniatureOpinionsAdapter extends RecyclerView.Adapter<MiniatureOpinionsAdapter.MyAdapter> {

   Context c;
   List<Coment> lst_comentarios;
   int size;

   public MiniatureOpinionsAdapter(Context c, List<Coment> lst_comentarios, int size) {
      this.c = c;
      this.lst_comentarios = lst_comentarios;
      this.size = size;
   }

   @NonNull
   @Override
   public MiniatureOpinionsAdapter.MyAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

      View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_comentario,parent,false);
      return new MyAdapter(rootView);

   }

   @Override
   public void onBindViewHolder(@NonNull MiniatureOpinionsAdapter.MyAdapter holder, int position) {
      Coment coment = lst_comentarios.get(position);
      holder.imgPerfil.setImageResource(coment.imgUrl);
      holder.username.setText(coment.username);
      holder.date.setText(coment.date);
      holder.cosMissatge.setText(coment.cuerpoDelComentario);

   }

   @Override
   public int getItemCount() {
      return size;
   }

   public class MyAdapter extends RecyclerView.ViewHolder {
      de.hdodenhof.circleimageview.CircleImageView imgPerfil;
      TextView username,date,cosMissatge;
      public MyAdapter(@NonNull View itemView) {

         super(itemView);

         imgPerfil = itemView.findViewById(R.id.profile_image_comentarios);
         username = itemView.findViewById(R.id.txt_usernameComentario);
         date = itemView.findViewById(R.id.txt_hora);
         cosMissatge = itemView.findViewById(R.id.txt_textoComentario);

      }
   }
}
