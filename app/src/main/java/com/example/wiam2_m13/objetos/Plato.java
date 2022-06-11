package com.example.wiam2_m13.objetos;

import android.os.Parcelable;

import java.io.Serializable;

public class Plato implements Serializable {
    public String nombre;
    public Float rating;
    public int imageUrl;
    public String price;
    public String description;
    public String opiniones;
    public String type;

    public Plato(String nombre, int imageUrl,Float rating,String type,String price) {
        this.nombre = nombre;
        this.imageUrl = imageUrl;
        this.rating = rating;
        this.type = type;
        this.price = price;
    }
}
