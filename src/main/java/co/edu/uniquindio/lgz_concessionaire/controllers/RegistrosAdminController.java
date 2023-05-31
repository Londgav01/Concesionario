package co.edu.uniquindio.lgz_concessionaire.controllers;

import co.edu.uniquindio.lgz_concessionaire.exceptions.EmpleadoException;
import co.edu.uniquindio.lgz_concessionaire.exceptions.UsuarioExcepction;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.springframework.stereotype.Component;

@Component
public class RegistrosAdminController {

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
    private ChoiceBox<?> opciones;

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

    @FXML
    void actualizarCliente(ActionEvent event) throws EmpleadoException, UsuarioExcepction {
         actualizarClienteAction();
    }
    private void actualizarClienteAction() throws EmpleadoException, UsuarioExcepction {
        String nombreCliente = nombreNuevoCliente.getText();
        String idCliente = idNuevoCliente.getText();
        String direccionCliente = direccionNuevoCliente.getText();
        String telefonoCliente = telefonoNuevoCliente.getText();
        if(datosValidados(nombreCliente, direccionCliente, "aaa", telefonoCliente)){
            mfm.actualizarCliente(nombreCliente, idCliente, direccionCliente, telefonoCliente);
        }
    }

    @FXML
    void actualizarEmpleado(ActionEvent event) throws EmpleadoException {
        actualizarEmpleadoAction();
    }
    private void actualizarEmpleadoAction() throws EmpleadoException {
        String nombreEmpleado = nuevoNombreEmpleado.getText();
        String idEmpleado = nuevoIdEmpleado.getText();
        String direccionEmpleado = nuevoDireccionEmpleado.getText();
        String telefonoEmpleado = nuevoTelefonoEmpleado.getText();
            if(datosValidados(nombreEmpleado, direccionEmpleado, "aaa", telefonoEmpleado)){
                mfm.actualizarEmpleado2(nombreEmpleado, direccionEmpleado,telefonoEmpleado, idEmpleado);
        }
    }


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

    }

}