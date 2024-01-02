package com.example;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class BoletoFinal {

    private Cine cine;
    private Pelicula pelicula;
    private String horario;
    private Stage stage;
    private Sala sala1;
    private int cantidadBoletos;

    public BoletoFinal(Cine cine, Pelicula pelicula, String horario, Sala sala1, int cantidadBoletos) {
        this.pelicula = pelicula;
        this.horario = horario;
        this.sala1 = sala1;
        this.cantidadBoletos = cantidadBoletos;

    }
        //FALTA CREAR BOTÓN DE "IR A PAGAR" El cual dirá que tu pago fue exitoso y te devuelva a la pantalla de inicio, los asientos deben quedar reservados.
    public void mostrar(){
        Stage stage = new Stage();
        stage.setTitle("Boleto Final");

        VBox layout = new VBox(10);
        Label lblSala = new Label("Sala: " + sala1.getNumeroSala());
        Label lblHorario = new Label("Horario: " + horario);
        Label lblPelicula = new Label("Película: " + pelicula.getNombre());
        Label lblCantidadBoletos = new Label("Cantidad de Boletos: " + cantidadBoletos);
        Label lblAsientos = new Label("Asientos Escogidos: " + String.join(", "));
        Label lblPrecioTotal = new Label("Precio Total: $" + (cantidadBoletos * 3000));

        layout.getChildren().addAll(lblSala, lblHorario, lblPelicula, lblCantidadBoletos, lblAsientos, lblPrecioTotal);

        Scene scene = new Scene(layout, 400, 300);
        stage.setScene(scene);
        stage.show();
    }

}
