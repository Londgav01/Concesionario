package co.edu.uniquindio.lgz_concessionaire.controllers;

import co.edu.uniquindio.lgz_concessionaire.LgzConcessionaireApplication;
import co.edu.uniquindio.lgz_concessionaire.exceptions.EmpleadoException;
import co.edu.uniquindio.lgz_concessionaire.models.Persona;
import co.edu.uniquindio.lgz_concessionaire.repository.*;
import co.edu.uniquindio.lgz_concessionaire.service.AdministradorService;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

@Component
public class LoginController implements Initializable {

    /**
     * Datos utilizados a traves de la clase
     * Incluye: instancias, datos de interfaz
     */
    private Stage stage2= new Stage();
    private RecuperacionController recuperacionController;

    ModelFactoryController mfm= ModelFactoryController.getInstance();
    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private AdministradorRepository administradorRepository;

    @Autowired
    private AdministradorService administradorService;

    @Autowired
    private PersonasRepository personasRepository;


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

    /**
     * se encarga de abrir el concesionario, la cual es la ventana principal en donde se podran abrir las demas
     * @param event
     * @throws EmpleadoException
     */
    @FXML
    void login(ActionEvent event) throws EmpleadoException {
        String identificacion = userLogin.getText();
        String contrasenia = contraLogin.getText();
        Persona persona= obtener2();
        System.out.println(persona.getIdentificacion());
        if(verificarDatos(identificacion, contrasenia)) {
            if (identificacion.equals("Robinson") && contrasenia.equals("010101")) {
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
        }
    }

    public List<Persona> obtenerAdmin(){
        return personasRepository.findAll();
    }

    public Persona obtener2(){
        Optional<Persona> persona= personasRepository.findById(1L);
        return persona.orElse(null);
    }


    /**
     * Abre la ventana de recuperacion junto con la funcion siguiente
     */
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

    /**
     * Metodo encargado de abrir la ventana para la recuperacion de la conrtaseña
     * @param event
     */
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
            //empleadoRepository.save(empleado);


        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    /**
     * Metodo encargado de abrir la ventana de registros
     * @param event
     */
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

    public void setAdministradorService(AdministradorService administradorService) {
        this.administradorService = administradorService;
    }

    /**
     *
     * Metodo encargado de inicializar datos en la interfaz, haciendo asi que en todo momento se tengan los datos
     * ingresados en la interfaz, evitando altercados con la carga de imagenes o datos
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public boolean verificarDatos(String identificacion, String contrasenia){
        if(identificacion == "" || contrasenia == ""){
            mostrarAlertaError("Error: llene los campos vacios");
            return false;
        }
        return true;
    }
    private void mostrarAlertaError(String mensaje) {
        // Crear la alerta de error
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);

        // Mostrar la alerta y esperar a que el usuario la cierre
        alert.showAndWait();
    }

}
