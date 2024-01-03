package com.example;


import javafx.stage.Stage;

public class Cine { //Main Clase, un panel de control. Aquí se crearon metodos para inicializar funciones y/o metodos de las distintas clases.
    
    private Stage primeryStage;
    

    public Cine(Stage primeryStage){
        this.primeryStage = primeryStage;
        
    }

    //Metodo para mostrar la MainPage, ósea como la cartelera.
    public void mostrarMainPage(){
        MainPage pantallaPrincipal = new MainPage(this);
        pantallaPrincipal.mostrar();
    }

    //Metodo que se utiliza para mostrar la pantalla o el interfáz de los Horarios
    public void mostrarHorarios(Pelicula pelicula, Sala sala1){
        Horarios pantallaHorarios = new Horarios(this, pelicula, sala1);
        pantallaHorarios.mostrar();
    }

    //Metodo que se utiliza para mostrar la interfáz de boletos.
    public void mostrarBoletos(Pelicula pelicula, String horario, Sala sala1) {
        Boletos pantallaBoletos = new Boletos(this, pelicula, horario, sala1);
        pantallaBoletos.mostrar();
    }

    //Metodo que se utiliza para mostrar la interfáz de Asientos, ósea los botones de cada asiento.
    public void mostrarAsientos(Pelicula pelicula, String horario, Sala sala1, int cantidadBoletos) {
        Asientos pantallaSeleccionAsientos = new Asientos(this, pelicula, horario, sala1, cantidadBoletos);
        pantallaSeleccionAsientos.mostrar();
    }

    //Muestra el boleto final, con toda la información de la pelicula, horario, sala1, cantidad de boletos comprados y el nombre de los asientos.
    public void mostrarBoletoFinal(Pelicula pelicula, String horario, Sala sala1, int cantidadBoletos, String[] asientosR){
        BoletoFinal pantallaBoletoFinal = new BoletoFinal(this, pelicula, horario, sala1, cantidadBoletos, asientosR);
        pantallaBoletoFinal.mostrar();
    }


    public Stage getPrimaryStage() {
        return primeryStage;
    }


    
}