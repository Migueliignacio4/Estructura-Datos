package com.example;

import java.util.List;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Boletos {

    private Cine cine;
    private Pelicula pelicula;
    private String horario;
    private Stage stage;
    private Sala sala1;

    public Boletos(Cine cine, Pelicula pelicula, String horario, Sala sala1) {
        this.cine = cine;
        this.pelicula = pelicula;
        this.horario = horario;
        this.sala1 = sala1;
    }

    public Stage getStage(){
        return stage;
    }
            //Metodo que muestra la interfáz de los boletos, donde aparecen los labels y botones.
    public void mostrar() {
        Stage stage = new Stage();
        stage.setTitle("Compra de Boletos - " + pelicula.getNombre());

        VBox layout = new VBox(10);

        Label lblInformacion = new Label("Pelicula: " + pelicula.getNombre() + "\nHorario: " + horario + "\nSala: " + sala1.getNumeroSala());

        Label lblCantidadBoletos = new Label("Cantidad de Boletos:");
        TextField txtCantidadBoletos = new TextField();


        Label lblPrecioTotal = new Label("Precio Total: $0.0");

        Button btnCalcularPrecio = new Button("Calcular Precio");
        btnCalcularPrecio.setOnAction(e -> calcularPrecio(txtCantidadBoletos.getText(), lblPrecioTotal));

        Button btnSeleccionAsientos = new Button("Ir a seleccionar asientos");
        btnSeleccionAsientos.setOnAction(e -> {seleccionarAsientos(txtCantidadBoletos.getText());
        stage.close();
        });

        layout.getChildren().addAll(lblInformacion, lblCantidadBoletos, txtCantidadBoletos, lblPrecioTotal, btnCalcularPrecio, btnSeleccionAsientos);

        Scene scene = new Scene(layout, 1000, 500);
        stage.setScene(scene);
        stage.show();
    } 

    //Metodo que sirve para calcular el precio del los boletos, se ejecuta al darle click al botón "Consultar precio"
    private void calcularPrecio(String cantidadBoletos, Label lblPrecioTotal) {
        try {
            int cantidad = Integer.parseInt(cantidadBoletos);

            if (cantidad > 25){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setTitle("Advertencia");
                alert.setContentText("No puedes comprar más de " + 25 + " boletos.");
                alert.showAndWait();
                return;
            }
            double precioUnitario = 3000;
            double precioTotal = cantidad * precioUnitario;


            lblPrecioTotal.setText("Precio Total: $" + precioTotal);

        } catch (NumberFormatException e) {
            
            System.out.println("Por favor, ingresa un número válido para la cantidad de boletos.");
        }
    }       //Metodo que se utiliza para llamar al metodo mostrarAsientos de la clase Cine, el cual está conectado con un metodo de la clase Asientos.
    private void seleccionarAsientos(String cantidadBoletos){
        try{
            int cantidad = Integer.parseInt(cantidadBoletos);

            if (cantidad > 25){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setTitle("Advertencia");
                alert.setContentText("No puedes comprar más de " + 25 + " boletos.");
                alert.showAndWait();
                return;
            }

            cine.mostrarAsientos(pelicula, horario, sala1, cantidad);

            
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Por favor, ingrese un número válido para la cantidad de boletos.");
            alert.showAndWait();
        }
    }




}