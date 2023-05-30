package co.edu.uniquindio.lgz_concessionaire.controllers;

import co.edu.uniquindio.lgz_concessionaire.LgzConcessionaireApplication;
import co.edu.uniquindio.lgz_concessionaire.exceptions.EmpleadoException;
import co.edu.uniquindio.lgz_concessionaire.models.Mail;
import co.edu.uniquindio.lgz_concessionaire.models.*;
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
import org.springframework.ui.Model;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class RecuperacionController implements Initializable {

    private String codigo = "";
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
    void cambiarContrasena(ActionEvent event) throws EmpleadoException {
        if(code.getText().equals(codigo)) {//aquí va la condicion de si el codifo introducido es el mismo enviado
            if(verificarContrasenia()){
                Empleado empleadoActualizar = ModelFactoryController.getInstance()
                                                .buscarEmpleadoIdentificacion(id.getText());
                String nombre = empleadoActualizar.getNombre();
                String direccion = empleadoActualizar.getDireccion();
                String numeroTelefonico = empleadoActualizar.getNumeroTelefonico();
                String identificacion = empleadoActualizar.getIdentificacion();
                String contrasenia = newPassword.getText();
                ModelFactoryController.getInstance()
                        .actualizarEmpleado(nombre, direccion, numeroTelefonico, identificacion, contrasenia);
                LgzConcessionaireApplication.getPrimaryStage().show();
                buttomBack.getScene().getWindow().hide();
            }
        }

    }

    @FXML
    void enviarMail(ActionEvent event) throws Exception {
        codigo = mandarCodigoMail();
    }

    public String mandarCodigoMail() throws Exception {
        if (ModelFactoryController.getInstance().verificarEmpleado(id.getText())) {
            String introCuerpo = "<h2>Estimado Usuario,</h2>"
                    + "<p>Hemos recibido una solicitud de recuperaci&oacuten de contrase&ntildea para su cuenta en LGZ Concessionaire. "
                    + "Para asegurarnos de que sea usted quien realiza esta solicitud, hemos generado un c&oacutedigo de verificaci&oacuten &uacutenico.</p>"
                    + "<p>Por favor, utilice el siguiente c&oacutedigo de verificaci&oacuten para restablecer su contrase&ntildea:</p>"
                    + "<p><strong>C&oacutedigo de verificaci&oacuten:</strong> ";

            String finalCuerpo = "<p>Le recomendamos que copie y pegue el c&oacutedigo de verificaci&oacuten en el formulario de recuperaci&oacuten de contrase&ntildea "
                    + "para evitar errores de escritura.</p>"
                    + "<p>Si usted no solicit&oacute esta recuperaci&oacuten de contrase&ntildea, puede ignorar este correo electr&oacutenico. No se realizar&aacuten cambios en su cuenta.</p>"
                    + "<p>Por motivos de seguridad, le sugerimos que una vez que haya restablecido su contrase&ntildea, la modifique por una nueva y segura.</p>";
            return Mail.mail("recuperarContraseña", introCuerpo, finalCuerpo, mail.getText());
        }
        throw new Exception("Idetificacion incorrecta, ingresela nuevamenete ");
    }

    /*

     */
    public boolean verificarContrasenia(){
        if(newPassword.getText().equals(newPassword2.getText())){
            return true;
        }
        return false;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
