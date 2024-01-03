package com.example;

import javafx.application.Application;
import javafx.stage.Stage;

/*
Integrantes: 
- Marcelo Villaroel
- Miguel Rocha
- Tomas Serrudo
- Matias Rocha
- Cristofer Leiva
*/

public class App extends Application {

    public static void main(String[] args) { //Aquí se ejecuta el programa.
        launch(args);
    }

    

    @Override
    public void start(Stage primaryStage) {
        Cine cine = new Cine(primaryStage);
        cine.mostrarMainPage();
    }
}