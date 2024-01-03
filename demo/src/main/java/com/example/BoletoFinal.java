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

    public void mostrar() {
        Stage stage = new Stage();
        stage.setTitle("Boleto Final");

        VBox layout = new VBox(10);

        HBox titleBox = new HBox();
        titleBox.setAlignment(Pos.CENTER);

        Label lblTitulo = new Label("Boleto — CINEMAPM");
        titleBox.getChildren().add(lblTitulo);

        Label lblSala = new Label("Sala: " + sala1.getNumeroSala());
        Label lblHorario = new Label("Horario: " + horario);
        Label lblPelicula = new Label("Película: " + pelicula.getNombre());
        Label lblCantidadBoletos = new Label("Cantidad de Boletos: " + cantidadBoletos);
        Label lblAsientos = new Label("Asientos Reservados en la sala: " + String.join(", ", asientosR));
        Label lblPrecioTotal = new Label("Precio Total: $" + (cantidadBoletos * 3000));

        Button btnVolverInicio = new Button("Volver al inicio");
        btnVolverInicio.setOnAction(e -> {
            volverAlInicio();
            stage.close();
        });

        Button btnIrAPagar = new Button("Ir a pagar");
        btnIrAPagar.setOnAction(e -> {
            pagarExitoso();
            stage.close();
        });

        layout.getChildren().addAll(titleBox, lblSala, lblHorario, lblPelicula, lblCantidadBoletos, lblAsientos, lblPrecioTotal, btnIrAPagar, btnVolverInicio);

        Scene scene = new Scene(layout, 400, 300);
        stage.setScene(scene);
        stage.show();
    }

    private void volverAlInicio() {
        cine.mostrarMainPage();
    }

    private void pagarExitoso() {
        mostrarAlerta("Pago Exitoso", "Tu pago fue exitoso.");

    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Stage alertStage = new Stage();
        alertStage.setTitle(titulo);

        VBox alertLayout = new VBox(10);
        alertLayout.setAlignment(Pos.CENTER);

        Label lblMensaje = new Label(mensaje);
        Button btnAceptar = new Button("Aceptar");
        btnAceptar.setOnAction(e -> alertStage.close());

        alertLayout.getChildren().addAll(lblMensaje, btnAceptar);

        Scene alertScene = new Scene(alertLayout, 250, 150);
        alertStage.setScene(alertScene);
        alertStage.showAndWait();
    }
}
