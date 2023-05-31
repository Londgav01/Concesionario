package co.edu.uniquindio.lgz_concessionaire.controllers;

import co.edu.uniquindio.lgz_concessionaire.models.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javax.swing.*;

public class VehiculosController {

    ModelFactoryController modelFactoryController = ModelFactoryController.getInstance();

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
        String texto = "";
        for (Vehiculo vehiculos: modelFactoryController.getConcesionario().getListaVehiculos()) {
            if(vehiculos instanceof Bus){
                texto+=vehiculos.toString();
            }
        }
        if(texto == ""){
            texto = "No hay vehículos disponibles";
        }
        JOptionPane.showMessageDialog(null, texto);
    }

    @FXML
    void mostrarInfoCamion(ActionEvent event) {
        String texto = "";
        for (Vehiculo vehiculos: modelFactoryController.getConcesionario().getListaVehiculos()) {
            if(vehiculos instanceof Camion){
                texto+=vehiculos.toString();
            }
        }
        if(texto == ""){
            texto = "No hay vehículos disponibles";
        }
        JOptionPane.showMessageDialog(null, texto);
    }

    @FXML
    void mostrarInfoCamioneta(ActionEvent event) {
        String texto = "";
        for (Vehiculo vehiculos: modelFactoryController.getConcesionario().getListaVehiculos()) {
            if(vehiculos instanceof Camioneta){
                texto+=vehiculos.toString();
            }
        }
        if(texto == ""){
            texto = "No hay vehículos disponibles";
        }
        JOptionPane.showMessageDialog(null, texto);
    }

    @FXML
    void mostrarInfoDeportivo(ActionEvent event) {
        String texto = "";
        for (Vehiculo vehiculos: modelFactoryController.getConcesionario().getListaVehiculos()) {
            if(vehiculos instanceof Deportivo){
                texto+=vehiculos.toString();
            }
        }
        if(texto == ""){
            texto = "No hay vehículos disponibles";
        }
        JOptionPane.showMessageDialog(null, texto);
    }

    @FXML
    void mostrarInfoLindo(ActionEvent event) {
        JOptionPane.showMessageDialog(null, "No hay stock," +
                "vulva la semana siguiente");
    }

    @FXML
    void mostrarInfoMoto(ActionEvent event) {
        String texto = "";
        for (Vehiculo vehiculos: modelFactoryController.getConcesionario().getListaVehiculos()) {
            if(vehiculos instanceof Moto){
                texto+=vehiculos.toString();
            }
        }
        if(texto == ""){
            texto = "No hay vehículos disponibles";
        }
        JOptionPane.showMessageDialog(null, texto);
    }

    @FXML
    void mostrarInfoPickUp(ActionEvent event) {
        String texto = "";
        for (Vehiculo vehiculos: modelFactoryController.getConcesionario().getListaVehiculos()) {
            if(vehiculos instanceof PickUp){
                texto+=vehiculos.toString();
            }
        }
        if(texto == ""){
            texto = "No hay vehículos disponibles";
        }
        JOptionPane.showMessageDialog(null, texto);
    }

    @FXML
    void mostrarInfoSedan(ActionEvent event) {
        String texto = "";
        for (Vehiculo vehiculos: modelFactoryController.getConcesionario().getListaVehiculos()) {
            if(vehiculos instanceof Sedan){
                texto+=vehiculos.toString();
            }
        }
        if(texto == ""){
            texto = "No hay vehículos disponibles";
        }
        JOptionPane.showMessageDialog(null, texto);
    }

    @FXML
    void mostrarInfoVan(ActionEvent event) {
        String texto = "";
        for (Vehiculo vehiculos: modelFactoryController.getConcesionario().getListaVehiculos()) {
            if(vehiculos instanceof Van){
                texto+=vehiculos.toString();
            }
        }
        if(texto == ""){
            texto = "No hay vehículos disponibles";
        }
        JOptionPane.showMessageDialog(null, texto);
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