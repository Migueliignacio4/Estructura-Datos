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
        btnRapunzel.setOnAction(e -> {mostrarSalas(rapunzel);
        stage.close();
        });
        
        Button btnUalgosLand = new Button(ualgosLand.getNombre());
        btnUalgosLand.setOnAction(e -> {mostrarSalas(ualgosLand);
        stage.close();
        });

        Button btnShrek = new Button(shrek.getNombre());
        btnShrek.setOnAction(e -> {mostrarSalas(shrek);
        stage.close();
        });
        
        layout.getChildren().addAll(btnRapunzel, btnUalgosLand, btnShrek);

        Scene scene = new Scene(layout, 300, 200);
        stage.setScene(scene);
        stage.show();
    } 


    public void mostrarSalas(Pelicula pelicula) {
        // Salas
        Stage salaStage = new Stage();
        Sala sala1 = new Sala("1");
    
        Button btnSala1 = new Button("Sala " + sala1.getNumeroSala());
        btnSala1.setOnAction(e -> {mostrarHorariosVentana(pelicula, sala1);
        salaStage.close();
        });
    
        VBox salaLayout = new VBox(10);
        salaLayout.getChildren().add(btnSala1);
    
        Scene salaScene = new Scene(salaLayout, 200, 100);
        salaStage.setScene(salaScene);
        salaStage.setTitle("Información de la Sala");
        salaStage.show();
    }

    public void mostrarHorariosVentana(Pelicula pelicula, Sala sala1) {

        cine.mostrarHorarios(pelicula, sala1);
    }

}