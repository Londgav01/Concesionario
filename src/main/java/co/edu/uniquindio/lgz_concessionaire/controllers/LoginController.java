package co.edu.uniquindio.lgz_concessionaire.controllers;

import javafx.fxml.Initializable;
import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class LoginController implements Initializable {

    @FXML
    private Button botonLogin;

    @FXML
    private PasswordField contraLogin;

    @FXML
    private Hyperlink olividoContrasena;

    @FXML
    private Hyperlink registrar;

    @FXML
    private TextField userLogin;

    @FXML
    void login(ActionEvent event) {

    }

    @FXML
    void recuperarContrasena(ActionEvent event) {

    }

    @FXML
    void registrar(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
