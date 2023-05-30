package co.edu.uniquindio.lgz_concessionaire.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ConcesionarioController {

    @FXML
    private Button buttomBack;

    @FXML
    private Hyperlink empleados;

    @FXML
    private Pane imagenes;

    @FXML
    private Hyperlink registros;

    @FXML
    private Hyperlink transacciones;

    @FXML
    private Hyperlink vehiculos;

    @FXML
    void volverALogin(ActionEvent event) {

    }

    private Stage stage;

    @FXML
    void abrirVehiculos(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/concesionario/views/TransaccionesViews.fxml"));
            Parent root = loader.load();
            VehiculosController vehiculosController = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            vehiculosController.init(stage, this);
            stage.show();
            this.stage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    void abrirTransacciones(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Transacciones.fxml"));
            Parent root = loader.load();
            TransaccionesControlle transaccionesControlle = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            transaccionesControlle.init(stage, this);
            stage.show();
            this.stage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void show() {
        this.stage.show();
    }
    private LoginController loginController;



    public void init(Stage stage, LoginController loginController) {
        this.loginController = loginController;
        this.stage = stage;

    }

}