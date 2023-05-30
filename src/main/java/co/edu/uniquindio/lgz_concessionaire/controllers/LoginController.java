package co.edu.uniquindio.lgz_concessionaire.controllers;

import co.edu.uniquindio.lgz_concessionaire.LgzConcessionaireApplication;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
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

    private Stage stage2= new Stage();
    private RecuperacionController recuperacionController;

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

    public LoginController() {
    }

    @FXML
    void login(ActionEvent event) {
        String identificacion = userLogin.getText();
        String contrasenia = contraLogin.getText();
        if(ModelFactoryController.getInstance().buscarEmpleado(identificacion, contrasenia) != null){

        }
    }

    @FXML
    void abrirVentanaRecuperarContrasena(ActionEvent event) {
        LgzConcessionaireApplication.getPrimaryStage().close();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(LgzConcessionaireApplication.class.getResource("/VentanaRecuperacion.fxml"));
            AnchorPane rootLayout = (AnchorPane)loader.load();
            Scene scene = new Scene(rootLayout);

            this.stage2.setTitle("Recuperación de Contraseñas");
            this.stage2.setScene(scene);
            olividoContrasena.getScene().getWindow().hide();
            this.stage2.show();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    void registrar(ActionEvent event) {
        LgzConcessionaireApplication.getPrimaryStage().close();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(LgzConcessionaireApplication.class.getResource("/Registro.fxml"));
            AnchorPane rootLayout = (AnchorPane)loader.load();
            Scene scene = new Scene(rootLayout);

            this.stage2.setTitle("Registro");
            this.stage2.setScene(scene);
            olividoContrasena.getScene().getWindow().hide();
            this.stage2.show();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
