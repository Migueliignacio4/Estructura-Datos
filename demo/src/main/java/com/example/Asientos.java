package com.example;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Asientos {

    private String horario;
    private int cantidadBoletos;
    private Set<String> asientosReservados;
    private int asientosReservadosCount;
    private List<String> asientosR;

    public Asientos(Cine cine, String horario, int cantidadBoletos) {
        this.horario = horario;
        this.cantidadBoletos = cantidadBoletos;
        this.asientosReservados = new HashSet<>();
        this.asientosReservadosCount = 0;
        this.asientosR = new ArrayList<>();
    }

    public void mostrar() {
        Stage stage = new Stage();
        stage.setTitle("Selección de Asientos - " + horario);

        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        // Agregar botones para los asientos disponibles
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                Button btnAsiento = new Button("A" + i + "-" + j);
                btnAsiento.setOnAction(e -> reservarAsiento(btnAsiento.getText(), stage));
                gridPane.add(btnAsiento, j, i);
            }
        }

        Scene scene = new Scene(gridPane, 400, 400);
        stage.setScene(scene);
        stage.show();
    }

    public Set<String> getAsientosReservados(){
        return asientosReservados;
    }

    private void reservarAsiento(String asiento, Stage stage) {
        if (asientosReservadosCount < cantidadBoletos) { //Aquí se verifica si han reservado todos los asientos permitidos. (Corresponden a la cantidad de boletos que seleccionó el cliente.)
            if (!asientosReservados.contains(asiento)) { //Aquí se verifica si el asiento está ocupado/reservado.
                // Lógica para reservar el asiento
                asientosReservados.add(asiento);
                asientosReservadosCount++;

                System.out.println("Asiento reservado: " + asiento);

                // Esto sirve para cerrar la ventana una vez se hayan escogido todos los asientos.
                if (asientosReservadosCount == cantidadBoletos) {
                    stage.close();
                }
            } else {
                System.out.println("El asiento " + asiento + " ya está reservado.");
            }
        } else {
            System.out.println("Ya has reservado la cantidad máxima de asientos permitidos.");
        }
    }

    public List<String> getAsientosReservadosList() {
        return new ArrayList<>(asientosReservados);
    }


}
 /*    private void reservarAsiento(String asiento) {
        // Lógica para reservar el asiento
        System.out.println("Asiento reservado: " + asiento);

        // Cerrar la ventana actual
        Stage actualStage = (Stage) cine.getPrimaryStage();
        actualStage.close();
    }
}*/
