package com.example;

import javafx.geometry.Pos;
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
        
        //Use GridPane para posicionar y centrar las peliculas y titulo.
        GridPane layout = new GridPane();
        layout.setVgap(10);
        layout.setHgap(10);

        Label lblTitulo = new Label("     |CINEMAPM|");
        lblTitulo.setFont(Font.font("Arial", FontWeight.BOLD, 24)); //Esto es para cambiar la font, size y ponerle Bold osea negritas al titulo.

        //CREACIÓN DE PELÍCULAS
        Pelicula rapunzel = new Pelicula("Rapunzel", 84);
        Pelicula ulagosLand = new Pelicula("UalgosLand", 120);
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

        //Botón de registro de venta
        Button btnRegistroVentas = new Button("Registro de Ventas");
        btnRegistroVentas.setOnAction(e -> mostrarRegistroVentas());
        layout.setAlignment(Pos.CENTER);

        //BOTONES DE PELÍCULAS
        Button btnRapunzel = new Button();
        btnRapunzel.setGraphic(viewRapuzel);
        btnRapunzel.setOnAction(e -> {mostrarSalas(rapunzel); //te lleva al metodo que te muestra las salas.
        stage.close();
        });
        
        Button btnUalgosLand = new Button();
        btnUalgosLand.setGraphic(viewUlagos);
        btnUalgosLand.setOnAction(e -> {mostrarSalas(ulagosLand);
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
        layout.add(btnRegistroVentas, 2, 5);

        Scene scene = new Scene(layout, 700, 700);
        stage.setScene(scene);
        stage.show();
    } 


    public void mostrarSalas(Pelicula pelicula) { //Metodo que te abre el interfáz donde están las salas, se crea un boton para cada sala.
        // Salas //Como se dijo que se creara 1 única sala, solo creé 1.
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

    public void mostrarHorariosVentana(Pelicula pelicula, Sala sala1) { //Metodo que te muestra lso horarios, la cual se pide arriva en el metodo mostrarSalas.

        cine.mostrarHorarios(pelicula, sala1);
    }
//Esto es por si clickeas el botón de ir al registro de ventas
    public void mostrarRegistroVentas(){ //Esto es por si clickeas el botón de ir al registro de ventas.
        RegistroVentas registroVentasPage = new RegistroVentas();
        registroVentasPage.mostrar();
    }

}