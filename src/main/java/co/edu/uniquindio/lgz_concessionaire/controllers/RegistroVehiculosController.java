package co.edu.uniquindio.lgz_concessionaire.controllers;

import co.edu.uniquindio.lgz_concessionaire.models.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

@Component
public class RegistroVehiculosController implements Initializable {

    private ModelFactoryController modelFactoryController = ModelFactoryController.getInstance();
    @FXML
    private Button botonRegistrarBus;

    @FXML
    private Button botonRegistrarCamion;

    @FXML
    private Button botonRegistrarCamioneta;

    @FXML
    private Button botonRegistrarDeportivo;

    @FXML
    private Button botonRegistrarMoto;

    @FXML
    private Button botonRegistrarPick;

    @FXML
    private Button botonRegistrarSedan;

    @FXML
    private Button botonRegistrarVan;

    @FXML
    private Button btnVolver;

    @FXML
    private TextField caballosFuerzaDepor;

    @FXML
    private TextField cantidadCambios;

    @FXML
    private TextField cargaCamion;

    @FXML
    private TextField cargaPick;

    @FXML
    private TextField cilindraje;

    @FXML
    private ChoiceBox<String> es4x4Camioneta;

    @FXML
    private ChoiceBox<String> es4x4Pick;

    @FXML
    private ChoiceBox<String> estadoVehiculo;

    @FXML
    private Hyperlink hyperSiguienteAuto;

    @FXML
    private Hyperlink hyperSiguienteSedaneta;

    @FXML
    private Hyperlink hyperSiguienteSw;

    @FXML
    private TextField idProveedor;

    @FXML
    private TextField marca;

    @FXML
    private TextField modelo;

    @FXML
    private TextField numBolsasAireAuto;

    @FXML
    private TextField numEjesBus;

    @FXML
    private TextField numEjesCamion;

    @FXML
    private TextField numPasajerosAuto;

    @FXML
    private TextField numPuertasAuto;

    @FXML
    private TextField placa;

    @FXML
    private TextField precio;

    @FXML
    private Hyperlink primerSiguiente;

    @FXML
    private TextField salidasBus;

    @FXML
    private TextField tiempoDepor;

    @FXML
    private ChoiceBox<String> tieneABSBus;

    @FXML
    private ChoiceBox<String> tieneABSCamion;

    @FXML
    private ChoiceBox<String> tieneABSw;

    @FXML
    private ChoiceBox<String> tieneACCamion;

    @FXML
    private ChoiceBox<String> tieneACSw;

    @FXML
    private ChoiceBox<String> tieneAsistenteCarrilSedaneta;

    @FXML
    private ChoiceBox<String> tieneCamaraSw;

    @FXML
    private ChoiceBox<String> tieneFrenosCamion;

    @FXML
    private ChoiceBox<String> tieneSensorCruzadoSedaneta;

    @FXML
    private ChoiceBox<String> tieneSensoresColisionSedaneta;

    @FXML
    private ChoiceBox<String> tieneVelCruceroSedaneta;

    @FXML
    private ChoiceBox<String> tipoAutos;

    @FXML
    private TextField tipoCamion;

    @FXML
    private ChoiceBox<String> tipoCombustible;

    @FXML
    private ChoiceBox<String> tipoTransimicion;

    @FXML
    private ChoiceBox<String> tipoVehiculo;

    @FXML
    private ChoiceBox<String> tiposSw;

    @FXML
    private Button urlImage;

    @FXML
    private TextField velMaxima;

    @FXML
    private Tab auto;

    @FXML
    private Tab bus;

    @FXML
    private Tab camion;

    @FXML
    private Tab camioneta;

    @FXML
    private Tab deportivo;

    @FXML
    private Tab pickup;

    @FXML
    private Tab sedaneta;

    @FXML
    private Tab station;

    @FXML
    private TabPane tabpane;

    @FXML
    private Tab vehiculo;

    private Vehiculo vehicule;

    private void llenarChoiceBox() {
        List<String> listatipoVehiculo = Arrays.asList("Moto","Camión","Automovil");
        tipoVehiculo.setItems(FXCollections.observableArrayList(listatipoVehiculo));

        List<String>listaTipoTransmision = Arrays.asList("Automática","Manual");
        tipoTransimicion.setItems(FXCollections.observableArrayList(listaTipoTransmision));

        List<String>listaEstado = Arrays.asList("Nuevo","Usado");
        tipoTransimicion.setItems(FXCollections.observableArrayList(listaEstado));

        List<String>listaTipoCombustible = Arrays.asList("Gasolina","Diesel","Híbrido","Eléctrico");
        tipoCombustible.setItems(FXCollections.observableArrayList(listaTipoCombustible));

        List<String>listaTipoAutomovil = Arrays.asList("Deportivo","Station-Wagon", "Bus");
        tipoAutos.setItems(FXCollections.observableArrayList(listaTipoAutomovil));

        List<String>listaTipoStation= Arrays.asList("Pick Up","Van","Sedaneta");
        tiposSw.setItems(FXCollections.observableArrayList(listaTipoStation));

        List<String>listaBooleanos= Arrays.asList("SI","NO");
        tieneACCamion.setItems(FXCollections.observableArrayList(listaBooleanos));
        tieneABSCamion.setItems(FXCollections.observableArrayList(listaBooleanos));
        tieneFrenosCamion.setItems(FXCollections.observableArrayList(listaBooleanos));
        tieneAsistenteCarrilSedaneta.setItems(FXCollections.observableArrayList(listaBooleanos));
        tieneACSw.setItems(FXCollections.observableArrayList(listaBooleanos));
        tieneABSBus.setItems(FXCollections.observableArrayList(listaBooleanos));
        tieneSensorCruzadoSedaneta.setItems(FXCollections.observableArrayList(listaBooleanos));
        tieneVelCruceroSedaneta.setItems(FXCollections.observableArrayList(listaBooleanos));
        tieneSensoresColisionSedaneta.setItems(FXCollections.observableArrayList(listaBooleanos));
        tieneCamaraSw.setItems(FXCollections.observableArrayList(listaBooleanos));
        tieneABSw.setItems(FXCollections.observableArrayList(listaBooleanos));
        es4x4Camioneta.setItems(FXCollections.observableArrayList(listaBooleanos));
        es4x4Pick.setItems(FXCollections.observableArrayList(listaBooleanos));

    }

    @FXML
    void seleccionarImagen(ActionEvent event) {

    }

    @FXML
    void irSiguienteSedaneta(ActionEvent event) {

    }

    @FXML
    void irSiguienteSw(ActionEvent event) {

    }

    @FXML
    void irSiguienteTabDeAuto(ActionEvent event) {

    }

    @FXML
    void pasarPrimerPagina(ActionEvent event) {
        if(tipoVehiculo.getValue()!= null && tipoVehiculo.getValue().equals("Moto")){
            System.out.println("Oprima el boton registrar moto");
        }else{
            if(tipoVehiculo.getValue()!= null && tipoVehiculo.getValue().equals("Camión")){
                cambiarDeTab(camion);
            }else{
                if(tipoVehiculo.getValue()!=null){
                    cambiarDeTab(auto);
                }
            }

        }
    }

    private boolean validarDatosGeneralidades() {
        System.out.println("verificando");
        String marca = this.marca.getText();
        String nuevo = this.estadoVehiculo.getValue();
        String modelo = this.modelo.getText();
        String cantidadCambios = this.cantidadCambios.getText();
        String velocidadMaxima = this.velMaxima.getText();
        String cilindraje = this.cilindraje.getText();
        String placa = this.placa.getText();
        String rutaImagen = this.urlImage.getText();
        String tipoTransmision = this.tipoTransimicion.getValue();
        String tipoCombustible= this.tipoCombustible.getValue();

        String notificacion = "";
        if(marca.equals("")){
            notificacion = "Campo Vacio";
        }
        if(nuevo.equals("")){
            notificacion = "Campo Vacio";
        }
        if(modelo.equals("")){
            notificacion = "Campo Vacio";
        }
        if(cantidadCambios.equals("")){
            notificacion = "Campo Vacio";
        }
        if(velocidadMaxima.equals("")){
            notificacion = "Campo Vacio";
        }
        if(cilindraje.equals("")){
            notificacion = "Campo Vacio";
        }
        if(placa.equals("")){
            notificacion = "Campo Vacio";
        }
        if(rutaImagen.equals("")){
            notificacion = "Campo Vacio";
        }
        if(tipoTransmision.equals("")){
            notificacion = "Campo Vacio";
        }
        if(tipoCombustible.equals("")){
            notificacion = "Campo Vacio";
        }
        if(notificacion.equals("")){
            return true;
        }

        return false;
    }

    public Vehiculo crearVehiculoInterno(){
        Vehiculo vehiculo= null;
        String marca = this.marca.getText();
        String nuevo = this.estadoVehiculo.getValue();
        EstadoVehiculo estado= determiarEstado(nuevo);
        String modelo = this.modelo.getText();
        int cantidadCambios = Integer.parseInt(this.cantidadCambios.getText());
        String velocidadMaxima = this.velMaxima.getText();
        String cilindraje = this.cilindraje.getText();
        String placa = this.placa.getText();
        String rutaImagen = this.urlImage.getText();
        String tipoTransmision = this.tipoTransimicion.getValue();
        String tipoCombustible= this.tipoCombustible.getValue();
        Double precio= Double.parseDouble(this.precio.getText());
        if(validarDatosGeneralidades()){
            vehiculo= modelFactoryController.crearMoto(marca,estado, modelo,cantidadCambios, Double.valueOf(velocidadMaxima), cilindraje, placa);
            JOptionPane.showMessageDialog(null, "vehiculo creado");
        }
        return vehiculo;
    }

    private void cambiarDeTab(Tab tab) {
        tabpane.getSelectionModel().select(tab);
    }

    public EstadoVehiculo determiarEstado(String x){
        if(x.equalsIgnoreCase("Nuevo")){
            return EstadoVehiculo.NUEVO;
        }
        else
            return EstadoVehiculo.USADO;
    }

    @FXML
    void registrarBus(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            Image image = new Image(selectedFile.toURI().toString());

            // Asignar la imagen al atributo del objeto
            Bus bus;
            /*if (bus == null) {

            }*/
            //bus.setImage(image);
        }
    }

    private boolean determinarBooleano(String value) {
        if (value.equals("SI")){
            return true;
        }
        return false;
    }


    @FXML
    void registrarCamion(ActionEvent event) {
        Vehiculo vehiculo1= crearVehiculoInterno();
        TipoTransmision tipoTransmision = determinarTipoTransmision(this.tipoTransimicion.getValue());
        TipoCombustible tipoCombustible= determinarTipoCombustible(this.tipoCombustible.getValue());
        Double precio = Double.valueOf(this.precio.getText());
        boolean frenoABS = determinarBooleano(tieneABSCamion.getValue());
        int numeroEjes = Integer.parseInt(numEjesCamion.getText());
        boolean frenoAire = determinarBooleano(tieneFrenosCamion.getValue());
        boolean frenoAc= determinarBooleano(tieneACCamion.getValue());
        String tipoCamion = this.tipoCamion.getText();
        double capacidadCarga= Double.parseDouble(this.cargaCamion.getText());
        if(validarDatosGeneralidades()&& validarDatosCamion() ){
            modelFactoryController.crearCamion(vehiculo1.getMarca(), vehiculo1.getPlaca(), vehiculo1.getModelo(), vehiculo1.getCantidadCambios(), vehiculo1.getVelocidadMaxima(), vehiculo1.getCilindraje(), vehiculo1.getEstadoVehiculo(), tipoCombustible, tipoTransmision, capacidadCarga, frenoAire, numeroEjes, frenoABS, tipoCamion, frenoAc);
        }

    }

    private TipoTransmision determinarTipoTransmision(String tipoTransmision) {
        if (tipoTransmision.equalsIgnoreCase("Automatica")){
            return TipoTransmision.AUTOMATICA;
        }
        return TipoTransmision.MANUAL;
    }

    private TipoCombustible determinarTipoCombustible(String tipo){
        if(tipo.equalsIgnoreCase("Diesel")){
            return TipoCombustible.DIESEL;
        }else if(tipo.equalsIgnoreCase("Gasolina")){
            return TipoCombustible.GASOLINA;
        }else if(tipo.equalsIgnoreCase("Hibrido")){
            return TipoCombustible.HIBRIDO;
        }else{
            return TipoCombustible.ELECTRICO;
        }
    }

    private boolean validarDatosCamion() {
        String x = "";
        if (tieneFrenosCamion.getValue()==null){
            x = "campo Vacio";
        }
        if(numEjesCamion.getText().equals("") || numEjesCamion.getText()==null){
            x = "campo Vacio";
        }
        if(this.tieneACCamion.getValue()==null){
            x = "campo Vacio";
        }
        if(tipoCamion.getText().equals("")||tipoCamion.getText()==null){
            x = "campo Vacio";
        }
        if (x.equals("")){
            return true;
        }
        return false;
    }

    @FXML
    void registrarCamioneta(ActionEvent event) {

    }

    @FXML
    void registrarDeportivo(ActionEvent event) {

    }

    @FXML
    void registrarMoto(ActionEvent event) {
        crearVehiculoInterno();
    }

    @FXML
    void registrarSedan(ActionEvent event) {

    }

    @FXML
    void registrarVan(ActionEvent event) {

    }

    @FXML
    void registrarṔickUp(ActionEvent event) {

    }

    private void selectImage() {
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            Image image = new Image(selectedFile.toURI().toString());
            //imageView.setImage(image);

            // Asignar la imagen al atributo del objeto
            /*if (myObject == null) {
                (Moto)myObject = new Moto();
            }
            myObject.setImage(image);*/
        }
    }

    @FXML
    void volverEvent(ActionEvent event) {
        concesionarioController.show();
        this.stage.hide();
    }

    private ConcesionarioController concesionarioController;
    private Stage stage;

    public void init(Stage stage, ConcesionarioController concesionarioController) {
        this.concesionarioController = concesionarioController;
        this.stage = stage;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        llenarChoiceBox();
    }
}
