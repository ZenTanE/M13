package com.example.wiam2_m13.objetos;

public class Coment {
   public String username;
   public String date;
   public String cuerpoDelComentario;
   public int imgUrl;

   public Coment(String username, String date, String cuerpoDelComentario, int imgUrl) {
      this.username = username;
      this.date = date;
      this.cuerpoDelComentario = cuerpoDelComentario;
      this.imgUrl = imgUrl;
   }
}
