package co.edu.uniquindio.lgz_concessionaire.controllers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class TransaccionesControlle implements Initializable {

    @FXML
    private Button botonAbrirVentanaRegistros;

    @FXML
    private Button botonRegistrarDevolucion;
    @FXML
    private Button volver;

    @FXML
    private Button botonRegistrarVenta;

    @FXML
    private Button botonRegistroAlquiler;

    @FXML
    private Button botonRegitrarCompra;

    @FXML
    private TextField idClienteAlquiler;

    @FXML
    private TextField idClienteDevolucion;

    @FXML
    private TextField idClienteVenta;

    @FXML
    private TextField idEmpleadoAlquiler;

    @FXML
    private TextField idEmpleadoCompra;

    @FXML
    private TextField idEmpleadoVenta;

    @FXML
    private TextField idProveedor;

    @FXML
    private TextField placaAlquiler;

    @FXML
    private TextField placaCompra;

    @FXML
    private TextField placaDevolucion;

    @FXML
    private TextField placaVenta;

    @FXML
    private ChoiceBox<String> tipoVehiculoAlquiler;

    @FXML
    private ChoiceBox<String> tipoVehiculoVenta;

    @FXML
    private TextField totalCompra;

    @FXML
    private TextField totalPagarAlquiler;

    @FXML
    private Label totalVenta;

    @FXML
    void abrirVentanaRegistrosVehiculos(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vehiculos.fxml"));
            Parent root = loader.load();
            VehiculosController vehiculosController = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            vehiculosController.init2(stage, this);
            stage.show();
            this.stage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void registrarAlquiler(ActionEvent event) {

    }

    @FXML
    void registrarCompra(ActionEvent event) {

    }

    @FXML
    void registrarVenta(ActionEvent event) {

    }


    @FXML
    void volverEvent(ActionEvent event) {
        concesionarioController.show();
        this.stage.close();
    }
    private ConcesionarioController concesionarioController;
    private Stage stage;

    public void init(Stage stage, ConcesionarioController concesionarioController) {
        this.concesionarioController = concesionarioController;
        this.stage = stage;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String listaVentas[] = {"Moto","Camion", "Bus", "Camioneta", "Sedan", "PickUp",
                    "Deportivo", "Van"};
        tipoVehiculoVenta.setItems(FXCollections.observableList(Arrays.asList(listaVentas)));
    }
}
