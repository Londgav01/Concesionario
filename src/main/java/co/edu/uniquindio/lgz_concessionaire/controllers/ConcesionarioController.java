package co.edu.uniquindio.lgz_concessionaire.controllers;

import co.edu.uniquindio.lgz_concessionaire.LgzConcessionaireApplication;
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
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.animation.*;
import javafx.util.*;

public class ConcesionarioController implements Initializable {

    @FXML
    private Button buttomBack;

    @FXML
    private Hyperlink empleados;

    @FXML
    private ImageView imageViewVehiculos;

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
        LgzConcessionaireApplication.getPrimaryStage().show();
        buttomBack.getScene().getWindow().hide();
    }

    private Stage stage;

    @FXML
    void abrirVehiculos(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vehiculos.fxml"));
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
            this.stage.hide();
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
        images.add(new Image("images/FORD-RANGER-BLACK.jpg"));
        images.add(new Image("images/SITP transmilenio.jpeg"));

        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(3), event -> {
            int currentIndex = images.indexOf(imageViewVehiculos.getImage());
            int nextIndex = (currentIndex + 1) % images.size();
            imageViewVehiculos.setImage(images.get(nextIndex));
        });
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();

    }

}