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

import javax.swing.*;

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

    /**
     * metodo utilizado en el boton eliminar
     * Depende del choice box se eliminara cliente o empleado
     * @throws EmpleadoException
     * @throws UsuarioExcepction
     */
    private void eliminarAction () throws EmpleadoException, UsuarioExcepction {
        if(opciones.getOnAction().equals("empleado")) {
            mfm.eliminarEmpleado(idEliminar.getText());
            mostrarMensajeAlerta("Cliente eliminado ", "Cliente informacion ", "El Cliente se elimino correctamente ", Alert.AlertType.INFORMATION);
        }
        else{
            mfm.eliminarCliente(idEliminar.getText());
        }
    }

    /**
     * registra a cliente capturando los datos de la interfaz
     * @param event
     */

    private void mostrarAlertaConfirmacion(String mensaje) {
        // Crear la alerta de error
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmacion");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);

        // Mostrar la alerta y esperar a que el usuario la cierre
        alert.showAndWait();
    }

    @FXML
    void registrarCliente(ActionEvent event) {
        String nombre = nombreNuevoCliente.getText();
        String idCliente = idNuevoCliente.getText();
        String direccion = direccionNuevoCliente.getText();
        String telefonoCliente = telefonoNuevoCliente.getText();
        if(validarDatos(nombre,idCliente,direccion,telefonoCliente)) {
            try {
                mfm.crearCliente(nombre, idCliente, direccion, telefonoCliente);
            } catch (UsuarioExcepction e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     *
     * @param event
     */
    @FXML
    void registrarNuevoAdmin(ActionEvent event) {

    }

    /**
     * registra a un empleado llamando a metodos del mfm
     * @param event
     */
    @FXML
    void registrarNuevoEmpleado(ActionEvent event) {
        String nombre = nuevoNombreEmpleado.getText();
        String idEmpleado = nuevoIdEmpleado.getText();
        String direccion = nuevoDireccionEmpleado.getText();
        String telefonoEmpleado = nuevoTelefonoEmpleado.getText();
        int numContrasenia = (int) (Math.random() * 6);
        if(validarDatos(nombre, idEmpleado, direccion, telefonoEmpleado)) {
            try {
                mfm.crearEmpleado(nombre, idEmpleado, direccion, telefonoEmpleado, String.valueOf(numContrasenia));
            } catch (EmpleadoException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * valida los datos pasa saber si los textField estan en blanco o no
     *
     * @param nombre
     * @param idEmpleado
     * @param direccion
     * @param telefono
     * @return
     */
    public boolean validarDatos(String nombre, String idEmpleado, String direccion, String telefono){
        if(nombre=="" || idEmpleado=="" || direccion=="" || telefono==""){
            mostrarAlertaConfirmacion("Llene todos los campos");
            return false;
        }
        mostrarAlertaConfirmacion("Persona creada");
        return true;
    }

    /**
     * Vuelve a la ventana principal "concesionario"
     * @param event
     */
    @FXML
    void volver_a_principal(ActionEvent event) {
        concesionarioController.show();
        this.stage.close();
    }

    private ConcesionarioController concesionarioController;
    private Stage stage;

    /**
     *
     * @param stage
     * @param concesionarioController
     */
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