package com.example;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainPage {

    private Cine cine;

    public MainPage(Cine cine) {
        this.cine = cine;
    }
            //Su nombre lo dice, Página Principal, en una página real de cine seria como una cartelera básicamente. Cada pelicula creada es un botón y al darle click comprarás un boleto para esa película.
    public void mostrar() {
        Stage stage = new Stage();
        stage.setTitle("Pantalla Principal");

        VBox layout = new VBox(10);
        Pelicula rapunzel = new Pelicula("Rapunzel", 84, "Fantasía");
        Pelicula ualgosLand = new Pelicula("UalgosLand", 120, "Acción");
        Pelicula shrek = new Pelicula("Shrek", 74, "Fantasía");

        Button btnRapunzel = new Button(rapunzel.getNombre());
        btnRapunzel.setOnAction(e -> {cine.mostrarHorarios(rapunzel);
        stage.close();
        });
        
        Button btnUalgosLand = new Button(ualgosLand.getNombre());
        btnUalgosLand.setOnAction(e -> {cine.mostrarHorarios(ualgosLand);
        stage.close();
        });

        Button btnShrek = new Button(shrek.getNombre());
        btnShrek.setOnAction(e -> {cine.mostrarHorarios(shrek);
        stage.close();
        });
        
        layout.getChildren().addAll(btnRapunzel, btnUalgosLand, btnShrek);

        Scene scene = new Scene(layout, 300, 200);
        stage.setScene(scene);
        stage.show();
    } 
}