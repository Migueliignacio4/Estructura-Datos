package com.example;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Horarios {

    private Pelicula pelicula;
    private Cine cine;
    

    public Horarios(Cine cine, Pelicula pelicula) {
        this.cine = cine;
        this.pelicula = pelicula;
    }

    public void mostrar() {
        Stage stage = new Stage();
        stage.setTitle("Horarios - " + pelicula.getNombre());

        VBox layout = new VBox(10);

        // Agregar botones para los horarios disponibles
        Button btnHorario1 = new Button("Horario 1       12:35");
        btnHorario1.setOnAction(e -> {cine.mostrarBoletos(pelicula, "12:35");
        stage.close();});

        Button btnHorario2 = new Button("Horario 2       13:45");
        btnHorario2.setOnAction(e -> {cine.mostrarBoletos(pelicula, "13:45");
        stage.close();
        });

        Button btnHorario3 = new Button("Horario 3       15:00");
        btnHorario3.setOnAction(e -> {cine.mostrarBoletos(pelicula, "15:00");
        stage.close();
        });

        layout.getChildren().addAll(btnHorario1, btnHorario2, btnHorario3);
        Scene scene = new Scene(layout, 300, 200);
        stage.setScene(scene);
        stage.show();
    }
}