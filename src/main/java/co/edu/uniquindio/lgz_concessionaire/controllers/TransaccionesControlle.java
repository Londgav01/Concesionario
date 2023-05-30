package co.edu.uniquindio.lgz_concessionaire.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TransaccionesControlle {

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
    private ChoiceBox<?> tipoVehiculoAlquiler;

    @FXML
    private ChoiceBox<?> tipoVehiculoVenta;

    @FXML
    private TextField totalCompra;

    @FXML
    private TextField totalPagarAlquiler;

    @FXML
    private Label totalVenta;

    @FXML
    void abrirVentanaRegistrosVehiculos(ActionEvent event) {

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
}
