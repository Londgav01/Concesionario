package co.edu.uniquindio.lgz_concessionaire.controllers;

import co.edu.uniquindio.lgz_concessionaire.exceptions.EmpleadoException;
import co.edu.uniquindio.lgz_concessionaire.exceptions.UsuarioExcepction;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class RegistrosAdminController implements Initializable {


    /**
     * Atributos y variables utilizadas a lo largo de la interfaz para poder capturar los datos de la interfaz
     */
    @FXML
    private Hyperlink backToPrincipal;

    @FXML
    private Button botonActualizarAdmin;

    @FXML
    private Button botonActualizarCliente;

    @FXML
    private Button botonActualizarEmpleado;

    @FXML
    private Button botonEliminar;

    @FXML
    private Button botonRegistrarAdmin;

    @FXML
    private Button botonRegistrarCliente;

    @FXML
    private Button botonRegistrarEmpleado;

    @FXML
    private TextField direccionNuevoAdmin;

    @FXML
    private TextField direccionNuevoCliente;

    @FXML
    private TextField idEliminar;

    @FXML
    private TextField idNuevoAdmin;

    @FXML
    private TextField idNuevoCliente;

    @FXML
    private TextField nombreNuevoAdmin;

    @FXML
    private TextField nombreNuevoCliente;

    @FXML
    private TextField nuevoDireccionEmpleado;

    @FXML
    private TextField nuevoIdEmpleado;

    @FXML
    private TextField nuevoNombreEmpleado;

    @FXML
    private TextField nuevoTelefonoEmpleado;

    @FXML
    private ChoiceBox<String> opciones;

    @FXML
    private TextField telefonoNuevoAdmin;

    @FXML
    private TextField telefonoNuevoCliente;



    //////////////////////////////////////////////////////

    /**
     * Funcionalidades generales utilizadas para los registros utilizados
     *
     */
    ModelFactoryController mfm = ModelFactoryController.getInstance();

    /**
     * funcion para crear mensajes de alerta, lo podemos usar en diferentes metodos
     * @param titulo
     * @param header
     * @param contenido
     * @param alertType
     */
    public void mostrarMensajeAlerta (String titulo, String header, String contenido, Alert.AlertType alertType){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }


    /**
     * funcion para validar si los campos de texto tienen informacion
     * @param saldoAux
     * @param tasaAux
     * @param numeroCuenta1
     * @param estrato
     * @return
     */
    private boolean datosValidados(String saldoAux, String tasaAux, String numeroCuenta1, String estrato) {
        String notificacion = "";
        if(saldoAux == null || saldoAux.equals("")){
            notificacion+= "El dato es invalido";
        }
        if(tasaAux == null || tasaAux.equals("")){
            notificacion+= "El dato es invalido";
        }
        if(numeroCuenta1 == null || numeroCuenta1.equals("")){
            notificacion+= "El dato es invalido";
        }
        if(estrato == null || estrato.equals("")){
            notificacion+= "El dato es invalido";
        }
        if(notificacion.equals("") || notificacion == null){
            return true;
        }
        return false;
    }


    //////////////////////////////////////////////////////
    @FXML
    void actualizarAdmin(ActionEvent event) {

    }

    /**
     * evento del boton para actualizar al cliente
     * @param event
     * @throws EmpleadoException
     * @throws UsuarioExcepction
     */
    @FXML
    void actualizarCliente(ActionEvent event) throws EmpleadoException, UsuarioExcepction {
         actualizarClienteAction();
    }

    /**
     * esta es la funcionalidad que se da en el boton anterior
     * se encarga de actualizar al cliente
     * se llama al mfm el cual tiene los metodos de actualizar
     * @throws EmpleadoException
     * @throws UsuarioExcepction
     */
    private void actualizarClienteAction() throws EmpleadoException, UsuarioExcepction {
        String nombreCliente = nombreNuevoCliente.getText();
        String idCliente = idNuevoCliente.getText();
        String direccionCliente = direccionNuevoCliente.getText();
        String telefonoCliente = telefonoNuevoCliente.getText();
        if(datosValidados(nombreCliente, direccionCliente, "aaa", telefonoCliente)){
            mfm.actualizarCliente(nombreCliente, idCliente, direccionCliente, telefonoCliente);
        }
    }
    /**
     * evento de actualizar empleado
     * @param event
     * @throws EmpleadoException
     */
    @FXML
    void actualizarEmpleado(ActionEvent event) throws EmpleadoException {
        actualizarEmpleadoAction();
    }

    /**
     * metodo implementado en el boton anterior
     * actualiza a un empleado ingresand osu id
     * @throws EmpleadoException
     */
    private void actualizarEmpleadoAction() throws EmpleadoException {
        String nombreEmpleado = nuevoNombreEmpleado.getText();
        String idEmpleado = nuevoIdEmpleado.getText();
        String direccionEmpleado = nuevoDireccionEmpleado.getText();
        String telefonoEmpleado = nuevoTelefonoEmpleado.getText();
            if(datosValidados(nombreEmpleado, direccionEmpleado, "aaa", telefonoEmpleado)){
                mfm.actualizarEmpleado2(nombreEmpleado, direccionEmpleado,telefonoEmpleado, idEmpleado);
        }
    }


    /**
     * elimina lo que sea, segun su decision en la choice box
     * se hace ingresando por parametro id
     * @param event
     * @throws EmpleadoException
     * @throws UsuarioExcepction
     */
    @FXML
    void eliminar(ActionEvent event) throws EmpleadoException, UsuarioExcepction {
        eliminarAction();

    }

    private void eliminarAction () throws EmpleadoException, UsuarioExcepction {
        if(opciones.getOnAction().equals("empleado")) {
            mfm.eliminarEmpleado(idEliminar.getText());
            mostrarMensajeAlerta("Cliente eliminado ", "Cliente informacion ", "El Cliente se elimino correctamente ", Alert.AlertType.INFORMATION);
        }
        else{
            mfm.eliminarCliente(idEliminar.getText());
        }
    }

    @FXML
    void registrarCliente(ActionEvent event) {
        String nombre = nombreNuevoCliente.getText();
        String idCliente = idNuevoCliente.getText();
        String direccion = direccionNuevoCliente.getText();
        String telefonoCliente = telefonoNuevoCliente.getText();
        try {
            mfm.crearCliente(nombre, idCliente, direccion, telefonoCliente);
        } catch (UsuarioExcepction e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void registrarNuevoAdmin(ActionEvent event) {

    }

    @FXML
    void registrarNuevoEmpleado(ActionEvent event) {
        String nombre = nuevoNombreEmpleado.getText();
        String idEmpleado = nuevoIdEmpleado.getText();
        String direccion = nuevoDireccionEmpleado.getText();
        String telefonoEmpleado = nuevoTelefonoEmpleado.getText();
        int numContrasenia = (int) (Math.random() * 6);
        try {
            mfm.crearEmpleado(nombre, idEmpleado, direccion, telefonoEmpleado, String.valueOf(numContrasenia));
        } catch (EmpleadoException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void volver_a_principal(ActionEvent event) {
        concesionarioController.show();
        this.stage.close();
    }

    private ConcesionarioController concesionarioController;
    private Stage stage;

    public void init(Stage stage, ConcesionarioController concesionarioController) {
        this.concesionarioController = concesionarioController;
        this.stage = stage;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[] options= {"Cliente","Empleado"};
        opciones.setItems(FXCollections.observableArrayList(options));
    }
}