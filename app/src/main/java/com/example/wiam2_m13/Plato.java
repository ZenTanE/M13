package com.example.wiam2_m13;

public class Plato {
    String nombre;
    Float rating;
    int imageUrl;
    float price;
    String description;
    String opiniones;
    String type;

    public Plato(String nombre, int imageUrl,Float rating,String type) {
        this.nombre = nombre;
        this.imageUrl = imageUrl;
        this.rating = rating;
        this.type = type;
    }
}
