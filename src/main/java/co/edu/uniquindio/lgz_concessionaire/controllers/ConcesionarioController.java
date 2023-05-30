package co.edu.uniquindio.lgz_concessionaire.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.animation.*;
import javafx.util.*;

public class ConcesionarioController implements Initializable {

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
    private ImageView imageViewVehiculos;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        List<Image> images = new ArrayList<>();
        images.add(new Image("/images/Ducati panigale moto.jpg"));
        images.add(new Image("/images/Carro deportivo.png"));
        images.add(new Image("/images/Toyota_Camry_(ASV50R)_SX_sedan.jpg"));

        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(6), event -> {
            int currentIndex = images.indexOf(imageViewVehiculos.getImage());
            int nextIndex = (currentIndex + 1) % images.size();
            imageViewVehiculos.setImage(images.get(nextIndex));
        });
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }

}