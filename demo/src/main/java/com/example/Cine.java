package com.example;


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


    public void mostrarHorarios(Pelicula pelicula, Sala sala1){
        Horarios pantallaHorarios = new Horarios(this, pelicula, sala1);
        pantallaHorarios.mostrar();
    }

    public void mostrarBoletos(Pelicula pelicula, String horario, Sala sala1) {
        Boletos pantallaBoletos = new Boletos(this, pelicula, horario, sala1);
        pantallaBoletos.mostrar();
    }

    public void mostrarAsientos(Pelicula pelicula, String horario, Sala sala1, int cantidadBoletos) {
        Asientos pantallaSeleccionAsientos = new Asientos(this, pelicula, horario, sala1, cantidadBoletos);
        pantallaSeleccionAsientos.mostrar();
    }

    public void mostrarBoletoFinal(Pelicula pelicula, String horario, Sala sala1, int cantidadBoletos, String[] asientosR){
        BoletoFinal pantallaBoletoFinal = new BoletoFinal(this, pelicula, horario, sala1, cantidadBoletos, asientosR);
        pantallaBoletoFinal.mostrar();
    }


    public Stage getPrimaryStage() {
        return primeryStage;
    }


    
}

