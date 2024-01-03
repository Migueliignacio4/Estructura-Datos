package com.example;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class BoletoFinal {

    private Cine cine;
    private Pelicula pelicula;
    private String horario;
    private Sala sala1;
    private int cantidadBoletos;
    private String[] asientosR;

    public BoletoFinal(Cine cine, Pelicula pelicula, String horario, Sala sala1, int cantidadBoletos, String[] asientosR) {
        this.cine = cine;
        this.pelicula = pelicula;
        this.horario = horario;
        this.sala1 = sala1;
        this.asientosR = asientosR;
        this.cantidadBoletos = cantidadBoletos;

    }
        //FALTA CREAR BOTÓN DE "IR A PAGAR" El cual dirá que tu pago fue exitoso y te devuelva a la pantalla de inicio, los asientos deben quedar reservados.
    public void mostrar(){
        Stage stage = new Stage();
        stage.setTitle("Boleto Final");

        VBox layout = new VBox(10);

        HBox tittleBlox = new HBox();
        tittleBlox.setAlignment(Pos.CENTER);

        Label lblTitulo = new Label("Boleto — CINEMAPM");
        tittleBlox.getChildren().add(lblTitulo);
        

        Label lblSala = new Label("Sala: " + sala1.getNumeroSala());
        Label lblHorario = new Label("Horario: " + horario);
        Label lblPelicula = new Label("Película: " + pelicula.getNombre());
        Label lblCantidadBoletos = new Label("Cantidad de Boletos: " + cantidadBoletos);
        Label lblAsientos = new Label("Asientos Escogidos: " + String.join(", ", asientosR));
        Label lblPrecioTotal = new Label("Precio Total: $" + (cantidadBoletos * 3000));


        Button btnVolverInicio = new Button("Volver al inicio");
        btnVolverInicio.setOnAction(e -> {volverAlInicio();
        stage.close();
        });

        layout.getChildren().addAll(tittleBlox, lblSala, lblHorario, lblPelicula, lblCantidadBoletos, lblAsientos, lblPrecioTotal, btnVolverInicio);

        Scene scene = new Scene(layout, 400, 300);
        stage.setScene(scene);
        stage.show();
    }

    private void volverAlInicio() {
        cine.mostrarMainPage();
    }
}
