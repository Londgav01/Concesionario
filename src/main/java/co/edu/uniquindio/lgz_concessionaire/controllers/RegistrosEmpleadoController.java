package co.edu.uniquindio.lgz_concessionaire.controllers;

import co.edu.uniquindio.lgz_concessionaire.LgzConcessionaireApplication;
import co.edu.uniquindio.lgz_concessionaire.exceptions.UsuarioExcepction;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class RegistrosEmpleadoController {

    @FXML
    private Hyperlink backToPrincipal;

    @FXML
    private Button botonActualizarCliente1;

    @FXML
    private Button botonRegistrarCliente;

    @FXML
    private TextField nuevoDireccionCliente;

    @FXML
    private TextField nuevoIdCliente;

    @FXML
    private TextField nuevoNombreCliente;

    @FXML
    private TextField nuevoTelefonoCliente;

    @FXML
    void registrarActualizarCliente(ActionEvent event) {
        String nombreCliente = nuevoNombreCliente.getText();
        String idCliente = nuevoIdCliente.getText();
        String direccionCliente = nuevoDireccionCliente.getText();
        String telefonoCliente = nuevoTelefonoCliente.getText();
        if(validarDatos()) {
            try {
                ModelFactoryController.getInstance().crearCliente(nombreCliente, idCliente, direccionCliente, telefonoCliente);
            } catch (UsuarioExcepction e) {
                throw new RuntimeException(e);
            }
        }
    }

    @FXML
    void registrarNuevoCliente(ActionEvent event) {
        String nombreCliente = nuevoNombreCliente.getText();
        String idCliente = nuevoIdCliente.getText();
        String direccionCliente = nuevoDireccionCliente.getText();
        String telefonoCliente = nuevoTelefonoCliente.getText();
        if(validarDatos()) {
            try {
                ModelFactoryController.getInstance().actualizarCliente(nombreCliente, idCliente, direccionCliente, telefonoCliente);
            } catch (UsuarioExcepction e) {
                throw new RuntimeException(e);
            }
        }
    }

    @FXML
    void volver_a_principal(ActionEvent event) {
        LgzConcessionaireApplication.getPrimaryStage().show();
        backToPrincipal.getScene().getWindow().hide();
    }

    public boolean validarDatos(){
        if(nuevoNombreCliente.getText() == "" || nuevoIdCliente.getText() == "" ||
                nuevoDireccionCliente.getText() == "" || nuevoTelefonoCliente.getText() == ""){
            JOptionPane.showMessageDialog(null, "Error, campos vacios");
            return false;
        }
        return true;
    }
    /*
    private MenuPrincipalController menuPrincipalController;
    private Stage stage;

    public void init(Stage stage, MenuPrincipalController menuPrincipalController) {
        this.menuPrincipalController = menuPrincipalController;
        this.stage = stage;
    }*/

}

