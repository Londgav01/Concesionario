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

    /**
     *
     El código proporcionado es una clase de controlador de JavaFX que
     contiene anotaciones @FXML y métodos para manejar eventos y la inicialización de la interfaz de usuario
     */


    /**
     * Este campo representa un botón llamado
     * buttomBack que se puede acceder a través de un archivo de interfaz de usuario FXML.
     */
    @FXML
    private Button buttomBack;


    /**
     * Este campo representa un hipervínculo llamado
     * empleados que se puede acceder a través de un archivo de interfaz de usuario FXML.
     */
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

    /**
     * Metodo encargado de dirigir a otra pagina la cual es la interfaz de vehiculo
     * este metodo se vera en diferentes ventanas para asegurar la navegabilidad correcta entre ventanas
     * No se Puede hacer static debido a los parametros
     * @param event
     */
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


    /**
     * Metodo encargado de dirigir a la ventana de transacciones
     *  este metodo se vera en diferentes ventanas para asegurar la navegabilidad correcta entre ventanas
     *  No se Puede hacer static debido a los parametros
     * @param event
     */
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


    @FXML
    void abrirRegistroVehiculos(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/RegistroVehiculos.fxml"));
            Parent root = loader.load();
            RegistroVehiculosController registroVehiculosController = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            registroVehiculosController.init(stage, this);
            stage.show();
            this.stage.hide();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void abrirRegistroPersonas(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Registro.fxml"));
            Parent root = loader.load();
            RegistrosAdminController registrosAdminController = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            registrosAdminController.init(stage, this);
            stage.show();
            this.stage.hide();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Este metodo es llamado desde los controladores que lo necesiten el cual se encargara de
     * mostrar esta ventana al momento de darle click en el boton correspondiente
     */
    public void show() {
        this.stage.show();
    }

    /**
     * Parametro para poder completar el metodo init
     * Este metodo es llamado desde los controladores que lo necesiten el cual se encargara de
     * mostrar esta ventana al momento de darle click en el boton correspondiente
     */
    private LoginController loginController;



    public void init(Stage stage, LoginController loginController) {
        this.loginController = loginController;
        this.stage = stage;

    }


    /**
     * Metodo encargado de inicializar datos en la interfaz, haciendo asi que en todo momento se tengan los datos
     * ingresados en la interfaz, evitando altercados con la carga de imagenes o datos
     * @param url
     * @param resourceBundle
     */
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