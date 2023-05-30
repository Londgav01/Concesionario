package co.edu.uniquindio.lgz_concessionaire.controllers;

import co.edu.uniquindio.lgz_concessionaire.LgzConcessionaireApplication;
import co.edu.uniquindio.lgz_concessionaire.exceptions.EmpleadoException;
import co.edu.uniquindio.lgz_concessionaire.models.Administrador;
import co.edu.uniquindio.lgz_concessionaire.models.Empleado;
import co.edu.uniquindio.lgz_concessionaire.repository.ClienteRepository;
import co.edu.uniquindio.lgz_concessionaire.repository.ConcesionarioRepository;
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
    private ConcesionarioRepository concesionarioRepository;


    Administrador admin= (Administrador) new Empleado.EmpleadoBuilder()
            .contraEmpleado("RobinsonMiAmor1")
            .withNombre("Robinson")
            .withNumeroTelefonico("09876")
            .withId("12345")
            .withDireccion("cra 12")
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

    @FXML
    void login(ActionEvent event) throws EmpleadoException {
        String identificacion = userLogin.getText();
        String contrasenia = contraLogin.getText();
        if(ModelFactoryController.getInstance().buscarEmpleado(identificacion, contrasenia) != null){

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
