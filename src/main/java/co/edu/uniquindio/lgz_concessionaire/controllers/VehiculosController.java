package co.edu.uniquindio.lgz_concessionaire.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class VehiculosController {

    @FXML
    private Button bus;

    @FXML
    private Button camion;

    @FXML
    private Button btnVolver;

    @FXML
    private Button camioneta;

    @FXML
    private Button deportivo;

    @FXML
    private Button lindo;

    @FXML
    private Button moto;

    @FXML
    private Button pickup;

    @FXML
    private Button sedan;

    @FXML
    private Button van;

    @FXML
    void mostrarInfoBus(ActionEvent event) {

    }

    @FXML
    void mostrarInfoCamion(ActionEvent event) {

    }

    @FXML
    void mostrarInfoCamioneta(ActionEvent event) {

    }

    @FXML
    void mostrarInfoDeportivo(ActionEvent event) {

    }

    @FXML
    void mostrarInfoLindo(ActionEvent event) {

    }

    @FXML
    void mostrarInfoMoto(ActionEvent event) {

    }

    @FXML
    void mostrarInfoPickUp(ActionEvent event) {

    }

    @FXML
    void mostrarInfoSedan(ActionEvent event) {

    }

    @FXML
    void mostrarInfoVan(ActionEvent event) {

    }

    @FXML
    void volverEvent(ActionEvent event) {
        concesionarioController.show();
        this.stage.hide();
    }

    private ConcesionarioController concesionarioController;
    private Stage stage;

    public void init(Stage stage, ConcesionarioController concesionarioController) {
        this.concesionarioController = concesionarioController;
        this.stage = stage;
    }

    private TransaccionesControlle transaccionesController;
    public void init2(Stage stage, TransaccionesControlle transaccionesController) {
        this.transaccionesController = transaccionesController;
        this.stage = stage;
    }

}