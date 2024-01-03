package com.example;
    
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class RegistroVentas {

    private List<Venta> ventas = new ArrayList<>();

    public void mostrar() {
        Stage stage = new Stage();
        stage.setTitle("Registro de Ventas");

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);

        Label lblTitulo = new Label("Registro de Ventas");
        lblTitulo.setStyle("-fx-font-size: 20; -fx-font-weight: bold;");

        Button btnVerResumen = new Button("Ver Resumen de Ventas");
        btnVerResumen.setOnAction(e -> verResumenVentas());

        layout.getChildren().addAll(lblTitulo, btnVerResumen);

        Scene scene = new Scene(layout, 300, 200);
        stage.setScene(scene);
        stage.show();
    }


    private void verResumenVentas() {
        double totalVentas = ventas.stream().mapToDouble(Venta::getMonto).sum();
        System.out.println("Resumen de Ventas:");
        System.out.println("Total de Ventas: $" + totalVentas);
        System.out.println("Cantidad de Ventas: " + ventas.size());
    }

    private static class Venta {
        private double monto;

        public double getMonto() {
            return monto;
        }
    }
}
