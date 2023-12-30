package com.example;

import java.util.Set;

import javafx.stage.Stage;

public class Cine { //Main Clase, un panel de control. Aquí se crearon metodos para inicializar funciones y/o metodos de las distintas clases.
    
    private Stage primeryStage;

    public Cine(Stage primeryStage){
        this.primeryStage = primeryStage;
    }


    public void mostrarMainPage(){
        MainPage pantallaPrincipal = new MainPage(this);
        pantallaPrincipal.mostrar();
    }

    public void mostrarHorarios(Pelicula pelicula){
        Horarios pantallaHorarios = new Horarios(this, pelicula);
        pantallaHorarios.mostrar();
    }

    public void mostrarBoletos(Pelicula pelicula, String horario) {
        Boletos pantallaBoletos = new Boletos(this, pelicula, horario);
        pantallaBoletos.mostrar();
    }

    public void mostrarAsientos(String horario, int cantidadBoletos) {
        Asientos pantallaSeleccionAsientos = new Asientos(this, horario, cantidadBoletos);
        pantallaSeleccionAsientos.mostrar();
    }


    public Stage getPrimaryStage() {
        return primeryStage;
    }
}

