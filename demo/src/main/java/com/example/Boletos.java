package com.example;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Boletos {

    private Cine cine;
    private Pelicula pelicula;
    private String horario;
    private Sala sala1;

    public Boletos(Cine cine, Pelicula pelicula, String horario, Sala sala1) {
        this.cine = cine;
        this.pelicula = pelicula;
        this.horario = horario;
        this.sala1 = sala1;
    }

    // Método que muestra la interfaz de los boletos, donde aparecen los labels y botones.
    public void mostrar() {
        Stage stage = new Stage();
        stage.setTitle("Compra de Boletos - " + pelicula.getNombre());

        VBox layout = new VBox(10);

        Label lblInformacion = new Label("Pelicula: " + pelicula.getNombre() + "\nHorario: " + horario + "\nSala: " + sala1.getNumeroSala());

        Label lblCantidadBoletos = new Label("Cantidad de Boletos:");
        TextField txtCantidadBoletos = new TextField();

        Label lblPrecioTotal = new Label("Precio Total: $0.0");

        Button btnCalcularPrecio = new Button("Calcular Precio");
        btnCalcularPrecio.setOnAction(e -> {
            calcularPrecio(txtCantidadBoletos.getText(), lblPrecioTotal);
        });

        Button btnSeleccionAsientos = new Button("Ir a seleccionar asientos");
        btnSeleccionAsientos.setOnAction(e -> {
            seleccionarAsientos(txtCantidadBoletos.getText());
            stage.close();
        });

        layout.getChildren().addAll(lblInformacion, lblCantidadBoletos, txtCantidadBoletos, lblPrecioTotal, btnCalcularPrecio, btnSeleccionAsientos);

        Scene scene = new Scene(layout, 1000, 500);
        stage.setScene(scene);
        stage.show();
    }

    // Método que sirve para calcular el precio de los boletos, se ejecuta al darle click al botón "Consultar precio"
    private void calcularPrecio(String cantidadBoletos, Label lblPrecioTotal) {
        try {
            int cantidad = Integer.parseInt(cantidadBoletos);

            if (cantidad > 25) {
                mostrarAlerta("Advertencia", "No puedes comprar más de " + 25 + " boletos.");
                return;
            }

            double precioTotal = calcularPrecioTotal(cantidad);
            lblPrecioTotal.setText("Precio Total: $" + precioTotal);

            // Ejecuta el metodo para crear un .txt de ventas
            guardarVentaEnArchivo(cantidad, precioTotal);

        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "Por favor, ingrese un número válido para la cantidad de boletos.");
        }
    }

    // Metodo para calcular el precio total
    public static double calcularPrecioTotal(int cantidadBoletos) {
        double precioUnitario = 3000;
        return cantidadBoletos * precioUnitario;
    }

    // Metodo que utilizamos para poder llamar al metodo mostrarAsientos de la clase cine
    private void seleccionarAsientos(String cantidadBoletos) {
        try { 
            int cantidad = Integer.parseInt(cantidadBoletos);

            if (cantidad > 25) {
                mostrarAlerta("Advertencia", "No puedes comprar más de " + 25 + " boletos.");
                return;
            }

            cine.mostrarAsientos(pelicula, horario, sala1, cantidad);

        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "Por favor, ingrese un número válido para la cantidad de boletos.");
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    // Metodo para guardar las ventas en un .txt y asi poder mostrarlo en registrosVentas.
    private void guardarVentaEnArchivo(int cantidadBoletos, double precioTotal) {
        String nombreArchivo = "ventas.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            bw.write("Pelicula: " + pelicula.getNombre() + ", Horario: " + horario + ", Sala: " + sala1.getNumeroSala() +
                    ", Cantidad de Boletos: " + cantidadBoletos + ", Precio Total: $" + precioTotal);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
