package co.edu.uniquindio.lgz_concessionaire.controllers;

import co.edu.uniquindio.lgz_concessionaire.models.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
        mostrarAlertaError(texto);
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
        mostrarAlertaError(texto);
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
        mostrarAlertaError(texto);
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
        mostrarAlertaError(texto);
    }

    @FXML
    void mostrarInfoLindo(ActionEvent event) {
        mostrarAlertaError("No hay stock," +
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
        mostrarAlertaError(texto);
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
        mostrarAlertaError(texto);
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
        mostrarAlertaError(texto);
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
            texto = """
                    Estimado profesor Robinson Arias,
                                        
                    Espero que este mensaje le encuentre bien. Me dirijo a usted con sinceridad y humildad para expresarle mis disculpas por no haber logrado completar el proyecto asignado a tiempo. Reconozco que mi falta de organización y compromiso ha afectado negativamente el resultado final y le pido sinceramente perdón por ello.
                                        
                    Entiendo la importancia de la responsabilidad y la puntualidad en el ámbito académico, y lamento no haber cumplido con estas expectativas. Acepto toda la responsabilidad por mis acciones y entiendo que mi comportamiento ha sido inaceptable.
                                        
                    Me gustaría asegurarle que he reflexionado profundamente sobre esta situación y estoy comprometido a aprender de mis errores. Entiendo la importancia de cumplir con mis obligaciones y asumo la responsabilidad de enfrentar las consecuencias de mis acciones.
                                        
                    Si hay alguna oportunidad para remediar esta situación o para realizar cualquier acción adicional, estaría más que dispuesto a colaborar y asumir cualquier tarea adicional que pueda ayudar a mitigar los efectos negativos de mi falta de compromiso.
                                        
                    Aprecio mucho su dedicación y paciencia como profesor, y lamento profundamente haber defraudado su confianza. Me esforzaré por mejorar en el futuro y asegurarme de que situaciones como esta no vuelvan a ocurrir.
                                        
                    Gracias por su comprensión y por considerar mis disculpas. Valoraría mucho cualquier orientación o consejo que pueda brindarme para aprender de esta experiencia y crecer tanto académica como personalmente.
                    """;
        }
        mostrarAlertaError(texto);

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
    private void mostrarAlertaError(String mensaje) {
        // Crear la alerta de error
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);

        // Mostrar la alerta y esperar a que el usuario la cierre
        alert.showAndWait();
    }
}