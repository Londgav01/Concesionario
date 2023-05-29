package co.edu.uniquindio.lgz_concessionaire.controllers;

import co.edu.uniquindio.lgz_concessionaire.LgzConcessionaireApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class RecuperacionController implements Initializable {

    private LoginController loginController=new LoginController();

    @FXML
    private Button botonCambiar;

    @FXML
    private Button botonEnviarMail;

    @FXML
    private Button buttomBack;

    @FXML
    private AnchorPane cambiarContrasenaTab;

    @FXML
    private TextField code;

    @FXML
    private Tab correo;

    @FXML
    private TextField mail;

    @FXML
    private AnchorPane mailTab;

    @FXML
    private Label msjEnvio;

    @FXML
    private TextField newPassword;

    @FXML
    private TextField newPassword2;

    @FXML
    private TextField id;

    @FXML
    private Tab registro;
    
    Stage stage= new Stage();


    @FXML
    void backToLogin(ActionEvent event){
        LgzConcessionaireApplication.getPrimaryStage().show();
        buttomBack.getScene().getWindow().hide();
    }

    @FXML
    void cambiarContrasena(ActionEvent event) {
        //if() aquí va la condicion de si el codifo introducido es el mismo enviado


    }

    @FXML
    void enviarMail(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
