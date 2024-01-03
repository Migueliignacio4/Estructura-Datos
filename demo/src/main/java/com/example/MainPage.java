package com.example;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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
        

        GridPane layout = new GridPane();
        layout.setVgap(4);
        layout.setHgap(4);

        Label lblTitulo = new Label("CINEMAPM — CARTELERA");
        lblTitulo.setFont(Font.font("Arial", FontWeight.BOLD, 24));

        Pelicula rapunzel = new Pelicula("Rapunzel", 84);
        Pelicula ualgosLand = new Pelicula("UalgosLand", 120);
        Pelicula shrek = new Pelicula("Shrek", 74);

        //CARGAR IMAGENES
        Image imgShrek = new Image("https://i.imgur.com/r2pHgkJ.png"); 
        Image imgRapunzel = new Image("https://i.imgur.com/sfWYKHP.jpeg");
        Image imgUlagos = new Image("https://i.imgur.com/6WAryyo.jpeg");

        ImageView viewShrek = new ImageView(imgShrek);
        viewShrek.setFitWidth(200);
        viewShrek.setFitHeight(300);
        ImageView viewRapuzel = new ImageView(imgRapunzel);
        viewRapuzel.setFitWidth(200);
        viewRapuzel.setFitHeight(300);
        ImageView viewUlagos = new ImageView(imgUlagos);
        viewUlagos.setFitWidth(200);
        viewUlagos.setFitHeight(300);

        //BOTONES


        Button btnRegistroVentas = new Button("Registro de Ventas");
        btnRegistroVentas.setOnAction(e -> mostrarRegistroVentas());

        Button btnRapunzel = new Button();
        btnRapunzel.setGraphic(viewRapuzel);
        btnRapunzel.setOnAction(e -> {mostrarSalas(rapunzel);
        stage.close();
        });
        
        Button btnUalgosLand = new Button();
        btnUalgosLand.setGraphic(viewUlagos);
        btnUalgosLand.setOnAction(e -> {mostrarSalas(ualgosLand);
        stage.close();
        });

        Button btnShrek = new Button();
        btnShrek.setGraphic(viewShrek);
        btnShrek.setOnAction(e -> {mostrarSalas(shrek);
        stage.close();
        });


        layout.add(lblTitulo, 2, 1);
        layout.add(btnRapunzel, 1 , 2);
        layout.add(btnShrek, 2, 2);
        layout.add(btnUalgosLand, 3, 2);
        layout.add(btnRegistroVentas, 4, 4);

        Scene scene = new Scene(layout, 1300, 800);
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

    public void mostrarRegistroVentas(){
        RegistroVentas registroVentasPage = new RegistroVentas();
        registroVentasPage.mostrar();
    }

}