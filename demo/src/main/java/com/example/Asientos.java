package com.example;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Asientos {

    private String horario;
    private Pelicula pelicula;
    private Sala sala1;
    private int cantidadBoletos;
    private Set<String> asientosReservados;
    private int asientosReservadosCount;
    private Cine cine;

    public Asientos(Cine cine, Pelicula pelicula, String horario, Sala sala1, int cantidadBoletos) {
        this.horario = horario;
        this.pelicula = pelicula;
        this.sala1 = sala1;
        this.cantidadBoletos = cantidadBoletos;
        this.cine = cine;
        this.asientosReservados = new HashSet<>();
        this.asientosReservadosCount = 0;
    }

    public void mostrar() {
        Stage stage = new Stage();
        stage.setTitle("Selección de Asientos - " + horario);
        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        // Agrega botones para los asientos 
        for (int i = 1; i <= 5; i++) {
            char[] alfa = {'A', 'B', 'C', 'D', 'E'};
            for (int j = 1; j <= 5; j++) {
                Button btnAsiento = new Button(alfa[i - 1] + "" + i + "-" + j);

                btnAsiento.setOnAction(e -> reservarAsiento(btnAsiento.getText(), btnAsiento, stage));
                gridPane.add(btnAsiento, j, i);
            }
        }

        Button btnIrAComprar = new Button("Ir a pagar");
        btnIrAComprar.setOnAction(e -> {irAComprar(pelicula, horario, sala1, cantidadBoletos, getAsientosReservadosArray());
        stage.close();
        });
        gridPane.add(btnIrAComprar, 0, 6);

        Scene scene = new Scene(gridPane, 400, 400);
        stage.setScene(scene);
        stage.show();
    }


    private void reservarAsiento(String asiento, Button btnAsiento, Stage stage) {
        if (asientosReservadosCount < cantidadBoletos) { //Aquí se verifica si han reservado todos los asientos permitidos. (Corresponden a la cantidad de boletos que seleccionó el cliente.)
            if (!asientosReservados.contains(asiento)) { //Aquí se verifica si el asiento está ocupado/reservado.
                asientosReservados.add(asiento);
                asientosReservadosCount++;

                String[] asientosR = new String[asientosReservados.size()];
                asientosR = asientosReservados.toArray(asientosR);

                System.out.println("Asiento reservado: " + asiento);
                System.out.println("Asientos reservados: " + Arrays.toString(asientosR));


                btnAsiento.setStyle("-fx-background-color: RED;");
            } else {

                System.out.println("El asiento " + asiento + " ya está reservado.");
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("Ya has seleccionado tus asientos");
            alert.setContentText("Tus asientos ya han sido seleccionados, no puedes seleccionar más debido a que no compraste más boletos.");
            alert.showAndWait();
            
        }

    }

    private String[] getAsientosReservadosArray() {
        return asientosReservados.toArray(new String[0]);
    }


    public void irAComprar(Pelicula pelicula, String horario, Sala sala1, int cantidadBoletos, String[] asientosR) {
        cine.mostrarBoletoFinal(pelicula, horario, sala1, cantidadBoletos, asientosR);
    }

}

