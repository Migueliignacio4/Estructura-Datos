package com.example;

public class Pelicula {
    
    private String nombre;
    private int duracion;


    public Pelicula(String nombre, int duracion){
        this.nombre = nombre;
        this.duracion = duracion;

    }

    public String getNombre(){
        return nombre;
    }
}
