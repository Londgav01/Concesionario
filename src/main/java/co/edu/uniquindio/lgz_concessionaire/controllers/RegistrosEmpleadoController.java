package co.edu.uniquindio.lgz_concessionaire.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Component;

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

    }

    @FXML
    void registrarNuevoCliente(ActionEvent event) {

    }

    @FXML
    void volver_a_principal(ActionEvent event) {

    }

}

