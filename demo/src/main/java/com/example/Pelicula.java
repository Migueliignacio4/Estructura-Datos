package com.example;

public class Pelicula {
    
    private String nombre;
    private int duracion;
    private String genero; //clase pelicula, se usa para crear peliculas básicamente. Las peliculas fueron creadas en la clase MainPage


    public Pelicula(String nombre, int duracion, String genero){
        this.nombre = nombre;
        this.duracion = duracion;
        this.genero = genero;

    }

    public String getNombre(){
        return nombre;
    }
}
