package com.example;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
//Esta parte ustilizamos chatgpt para poder leer el archivo ventas.txt y mostrarlo por pantalla
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RegistroVentas {

    private TextField txtCantidadBoletos;
    private List<Venta> ventas = new ArrayList<>();

    public void mostrar() {
        Stage stage = new Stage();
        stage.setTitle("Registro de Ventas");

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);

        Label lblTitulo = new Label("Registro de Ventas");
        lblTitulo.setStyle("-fx-font-size: 20; -fx-font-weight: bold;");

        txtCantidadBoletos = new TextField();
        txtCantidadBoletos.setPromptText("Ingrese la cantidad de boletos");

        Button btnVerResumen = new Button("Ver Resumen de Ventas");
        btnVerResumen.setOnAction(e -> mostrarResumenVentas());

        Button btnSeleccionarArchivo = new Button("Seleccionar archivo de ventas");
        btnSeleccionarArchivo.setOnAction(e -> abrirArchivoVentas());

        layout.getChildren().addAll(lblTitulo, btnSeleccionarArchivo);

        Scene scene = new Scene(layout, 400, 250);
        stage.setScene(scene);
        stage.show();
    }

    private void mostrarResumenVentas() {
        try {
            int cantidadBoletos = Integer.parseInt(txtCantidadBoletos.getText());
            double totalVentas = Boletos.calcularPrecioTotal(cantidadBoletos);
            int cantidadVentas = obtenerCantidadVentas();
            mostrarAlerta("Resumen de Ventas", "Total de Ventas: $" + totalVentas + "\nCantidad de Ventas: " + cantidadVentas);
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "Por favor, ingrese un número válido para la cantidad de boletos.");
        }
    }

    private int obtenerCantidadVentas() {
        leerVentasDesdeArchivo((File) ventas); 
        return ventas.size();
    }

    private void abrirArchivoVentas() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar archivo de ventas");
        File archivoSeleccionado = fileChooser.showOpenDialog(null);

        if (archivoSeleccionado != null) {
            leerVentasDesdeArchivo(archivoSeleccionado);
            mostrarVentasEnPantalla();
        }
    }

    private void leerVentasDesdeArchivo(File archivo) {
        ventas.clear(); 
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {

                System.out.println(linea);
                ventas.add(new Venta(linea));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void mostrarVentasEnPantalla() {
        Stage stage = new Stage();
        stage.setTitle("Ventas desde archivo");

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);

        Label lblTitulo = new Label("Ventas desde archivo");
        lblTitulo.setStyle("-fx-font-size: 20; -fx-font-weight: bold;");

        for (Venta venta : ventas) {
            Label lblVenta = new Label("Venta: " + venta.getInformacion());
            layout.getChildren().add(lblVenta);
        }

        Scene scene = new Scene(layout, 400, 250);
        stage.setScene(scene);
        stage.show();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private static class Venta {
        private String informacion;

        public Venta(String informacion) {
            this.informacion = informacion;
        }

        public String getInformacion() {
            return informacion;
        }
    }
}
