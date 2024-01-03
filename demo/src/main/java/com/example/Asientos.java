package com.example;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.*;
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

        // Modifica el nombre del archivo para hacerlo único para cada película
        this.asientosReservados = new HashSet<>();
        this.asientosReservadosCount = 0;
        cargarAsientosReservados(pelicula.getNombre(), horario);
    }

    private String construirNombreArchivo(String nombrePelicula, String horario) {
        return "asientos_reservados_" + nombrePelicula + "_" + horario + ".txt";
    }

    private void cargarAsientosReservados(String nombrePelicula, String horario) {
        String nombreArchivo = construirNombreArchivo(nombrePelicula, horario);

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                asientosReservados.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void guardarAsientosReservados(String nombrePelicula, String horario) {
        String nombreArchivo = construirNombreArchivo(nombrePelicula, horario);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (String asiento : asientosReservados) {
                bw.write(asiento);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void reservarAsiento(String asiento, Button btnAsiento, Stage stage) {
        if (asientosReservadosCount < cantidadBoletos) {
            if (!asientosReservados.contains(asiento)) {
                asientosReservados.add(asiento);
                asientosReservadosCount++;

                System.out.println("Asiento reservado: " + asiento);
                System.out.println("Asientos reservados: " + Arrays.toString(asientosReservados.toArray()));

                btnAsiento.setStyle("-fx-background-color: GREEN;");
 

                guardarAsientosReservados(pelicula.getNombre(), horario);
            } else {
                btnAsiento.setStyle("-fx-background-color: RED;");
                System.out.println("El asiento " + asiento + " ya está reservado.");
                mostrarAlerta("Asiento Reservado", "Este asiento ya está reservado");
                
                 
            }
        } else {
            mostrarAlerta("Ya has seleccionado tus asientos",
                    "Tus asientos ya han sido seleccionados, no puedes seleccionar más debido a que no compraste más boletos.");
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
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
        btnIrAComprar.setOnAction(e -> {
            irAComprar(pelicula, horario, sala1, cantidadBoletos, getAsientosReservadosArray());
            stage.close();
        });
        gridPane.add(btnIrAComprar, 0, 6);

        Scene scene = new Scene(gridPane, 400, 400);
        stage.setScene(scene);
        stage.show();
    }

    private String[] getAsientosReservadosArray() {
        return asientosReservados.toArray(new String[0]);
    }

    public void irAComprar(Pelicula pelicula, String horario, Sala sala1, int cantidadBoletos, String[] asientosR) {
        cine.mostrarBoletoFinal(pelicula, horario, sala1, cantidadBoletos, asientosR);
    }
}
