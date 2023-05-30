package co.edu.uniquindio.lgz_concessionaire.controllers;

import co.edu.uniquindio.lgz_concessionaire.LgzConcessionaireApplication;
import co.edu.uniquindio.lgz_concessionaire.exceptions.EmpleadoException;
import co.edu.uniquindio.lgz_concessionaire.models.Administrador;
import co.edu.uniquindio.lgz_concessionaire.models.Empleado;
import co.edu.uniquindio.lgz_concessionaire.repository.ClienteRepository;
import co.edu.uniquindio.lgz_concessionaire.repository.ConcesionarioRepository;
import co.edu.uniquindio.lgz_concessionaire.repository.EmpleadoRepository;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

@Component
public class LoginController implements Initializable {

    private Stage stage2= new Stage();
    private RecuperacionController recuperacionController;

    ModelFactoryController mfm= ModelFactoryController.getInstance();
    @Autowired
    private EmpleadoRepository empleadoRepository;
    private ConcesionarioRepository concesionarioRepository;

    Empleado empleado = (Empleado) new Empleado.EmpleadoBuilder()
            .withNombre("robinson")
            .withDireccion("cra 12")
            .withNumeroTelefonico("1234")
            .withId("456")
            .build();


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
    private Stage stage;

    @FXML
    void login(ActionEvent event) throws EmpleadoException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Concesionario.fxml"));
            Parent root = loader.load();
            ConcesionarioController concesionarioController = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            concesionarioController.init(stage, this);
            stage.show();
            this.stage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    void abrirVentanaConcesionario(){
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
            empleadoRepository.save(empleado);


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
            loader.setLocation(LgzConcessionaireApplication.class.getResource("/Registros2.fxml"));
            AnchorPane rootLayout = (AnchorPane)loader.load();
            Scene scene = new Scene(rootLayout);

            this.stage2.setTitle("Registro");
            this.stage2.setScene(scene);
            registrar.getScene().getWindow().hide();
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
