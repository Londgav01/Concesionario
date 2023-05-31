package co.edu.uniquindio.lgz_concessionaire.controllers;

import java.util.List;

import co.edu.uniquindio.lgz_concessionaire.LgzConcessionaireApplication;
import co.edu.uniquindio.lgz_concessionaire.exceptions.EmpleadoException;
import co.edu.uniquindio.lgz_concessionaire.exceptions.TransactionException;
import co.edu.uniquindio.lgz_concessionaire.exceptions.UsuarioExcepction;
import co.edu.uniquindio.lgz_concessionaire.models.*;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Window;

import static co.edu.uniquindio.lgz_concessionaire.LgzConcessionaireApplication.primaryStage;


public class ModelFactoryController {


	public Concesionario concesionario = null;

	public void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
		Alert alert = new Alert(tipo);
		alert.setTitle(titulo);
		alert.setHeaderText(null);
		alert.setContentText(mensaje);
		alert.initModality(Modality.APPLICATION_MODAL);
		Window primaryStage = null;
		alert.initOwner(primaryStage); // Reemplaza primaryStage con tu Stage principal

		alert.showAndWait();
	}

	//------------------------------  Singleton ------------------------------------------------
	// Clase estatica oculta. Tan solo se instanciara el singleton una vez
	private static class SingletonHolder {
		// El constructor de Singleton puede ser llamado desde aquí al ser protected
		private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
	}

	// Método para obtener la instancia de nuestra clase
	public static ModelFactoryController getInstance() {
		return SingletonHolder.eINSTANCE;
	}

	public ModelFactoryController() {
		System.out.println("invocación clase singleton");
		inicializarDatos();
	}

	private void inicializarDatos() {
		concesionario = new Concesionario("LGZ Concessionaire");
	}

	public Concesionario getConcesionario() {
		return concesionario;
	}

	public void setConcesionario(Concesionario concesionario) {
		this.concesionario = concesionario;
	}

	public Empleado buscarEmpleado(String idEmpleado, String contrasenia) throws EmpleadoException {
		Empleado empleado = (concesionario.buscarEmpleado(idEmpleado, contrasenia));
		return empleado;
	}

	public Empleado buscarEmpleadoIdentificacion(String idetificacion) throws EmpleadoException {
		Empleado empleado = (concesionario.buscarEmpleadoIdentificacion(idetificacion));
		return empleado;
	}

	public Empleado crearEmpleado(String nombre, String identificacion, String direccion, String numeroTelefonico,
								  String idEmpleado) throws EmpleadoException {
		Empleado empleado = (concesionario.crearEmpleado(nombre, identificacion, direccion, numeroTelefonico, idEmpleado));
		return empleado;
	}

	public boolean eliminarEmpleado(String idEmpleado) throws EmpleadoException {
		boolean eliminado = concesionario.eliminarEmpleado(idEmpleado);
		return eliminado;
	}

	public void actualizarEmpleado(String nombre, String direccion, String numeroTelefonico, String idEmpleado, String contrasenia) throws EmpleadoException {
		concesionario.actualizarEmpleado(nombre, direccion, numeroTelefonico, idEmpleado, contrasenia);
	}


	public void actualizarEmpleado2(String nombre, String direccion, String numeroTelefonico, String idEmpleado) throws EmpleadoException {
		concesionario.actualizarEmpleado2(nombre, direccion, numeroTelefonico, idEmpleado);
	}

	public boolean verificarEmpleado(String identificacion) {
		return concesionario.verificarEmpleado(identificacion);
	}

	public List<Empleado> obtenerEmpleados() {
		return concesionario.getListaEmpleados();
	}

	////////////////////////
	public boolean eliminarCliente(String idCliente) throws UsuarioExcepction {
		boolean eliminado = concesionario.eliminarCliente(idCliente);
		return eliminado;
	}

	public void actualizarCliente(String nombreCliente, String direccionCliente, String idCliente, String telefonoCliente) throws UsuarioExcepction {
		concesionario.actualizarCliente(nombreCliente, idCliente, direccionCliente, telefonoCliente);
	}

	public void crearCliente(String nombre, String identificacion, String direccion, String numeroTelefonico) throws UsuarioExcepction {
		concesionario.crearCliente(nombre, identificacion, direccion, numeroTelefonico);
	}

	public Cliente buscarCliente(String idCliente) throws UsuarioExcepction {
		return concesionario.buscarCliente(idCliente);
	}

	/////////////////////
	public void crearProveedor(String nombre, String identificacion, String direccion, String num) throws UsuarioExcepction {
		concesionario.crearProveedor(nombre, identificacion, direccion, num);
	}

	public void actualizarProveedor(String nombre, String identificacion, String direccion,
									String numTelefono) throws UsuarioExcepction {
		concesionario.actualizarProveedor(nombre, identificacion, direccion, numTelefono);
	}

	public Proveedor buscarProveedor(String idProveedor) throws UsuarioExcepction {
		return concesionario.buscarProveedor(idProveedor);
	}

	/////////////////////////
	public void crearTransacciones(Empleado empleado, String code, Double valorTotal, Cliente cliente, List<DetalleTransaccion> listaDetalles) throws TransactionException {
		concesionario.crearTransacciones(empleado, code, valorTotal, cliente, listaDetalles);
	}

	public Transaccion buscarTransaccion(String code) {
		return concesionario.buscarTransaccion(code);
	}

	public void eliminarTransaccion(String code) throws TransactionException {
		concesionario.eliminarTransaccion(code);
	}

	//////////////////////////////////
	public Vehiculo buscarVehiculo(String placa) {
		return concesionario.buscarVehiculo(placa);

	}

	public boolean eliminarVehiculo(String placa) {
		return concesionario.eliminarVehiculo(placa);
	}

	public Sedan crearSedan(String marca, String placa, String modelo, int cantidadCambios, double velocidadMaxima,
							String cilindraje, EstadoVehiculo estadoVehiculo, TipoCombustible tipoCombustible,
							TipoTransmision tipoTrasmision, int numPuertas, int numPasajeros, int numBolsasAire, boolean aC,
							boolean camaraReversa, boolean aBS, boolean velocidadCrucero, boolean sensoresColision,
							boolean sensorTraficoCruzado, boolean asistenteCarril) {
		return concesionario.crearSedan(marca, placa, modelo, cantidadCambios, velocidadMaxima, cilindraje, estadoVehiculo, tipoCombustible, tipoTrasmision, numPuertas, numPasajeros, numBolsasAire, aC, camaraReversa, aBS, velocidadCrucero, sensoresColision, sensorTraficoCruzado, asistenteCarril);
	}

	public Deportivo crearDeportivo(String marca, String placa, String modelo, int cantidadCambios, double velocidadMaxima,
									String cilindraje, EstadoVehiculo estadoVehiculo, TipoCombustible tipoCombustible,
									TipoTransmision tipoTrasmision, int numPuertas, int numPasajeros, int numBolsasAire, Double tiempo100Km, Double caballosFuerza) {
		return concesionario.crearDeportivo(marca, placa, modelo, cantidadCambios, velocidadMaxima, cilindraje, estadoVehiculo, tipoCombustible, tipoTrasmision, numPuertas, numPasajeros, numBolsasAire, tiempo100Km, caballosFuerza);
	}

	public Camioneta crearCamioneta(String marca, String placa, String modelo, int cantidadCambios, double velocidadMaxima,
									String cilindraje, EstadoVehiculo estadoVehiculo, TipoCombustible tipoCombustible,
									TipoTransmision tipoTrasmision, int numPuertas, int numPasajeros, int numBolsasAire, boolean aC,
									boolean camaraReversa, boolean aBS, boolean velocidadCrucero, boolean sensoresColision,
									boolean sensorTraficoCruzado, boolean asistenteCarril, boolean is4x4) {
		return concesionario.crearCamioneta(marca, placa, modelo, cantidadCambios, velocidadMaxima, cilindraje, estadoVehiculo, tipoCombustible, tipoTrasmision, numPuertas, numPasajeros, numBolsasAire, aC, camaraReversa, aBS, velocidadCrucero, sensoresColision, sensorTraficoCruzado, asistenteCarril, is4x4);
	}

	public Camion crearCamion(String marca, String placa, String modelo, int cantidadCambios, double velocidadMaxima,
							  String cilindraje, EstadoVehiculo estadoVehiculo, TipoCombustible tipoCombustible,
							  TipoTransmision tipoTrasmision, double capacidadCarga, boolean tieneFrenosAire, int numeroEjes, boolean tieneABS, String tipoCamion, boolean tieneAC) {
		return concesionario.crearCamion(marca, placa, modelo, cantidadCambios, velocidadMaxima, cilindraje, estadoVehiculo, tipoCombustible, tipoTrasmision, capacidadCarga, tieneFrenosAire, numeroEjes, tieneABS, tipoCamion, tieneAC);
	}

	public Moto crearMoto(String marca, EstadoVehiculo estadoVehiculo, String modelo, int cambios, Double velocidadMaxima,
						  String cilindraje, String placa) {
		return concesionario.crearMoto(marca, estadoVehiculo, modelo, cambios, velocidadMaxima, cilindraje, placa);
	}

	public Bus crearBus(String marca, String placa, String modelo, int cantidadCambios, double velocidadMaxima,
						String cilindraje, EstadoVehiculo estadoVehiculo, TipoCombustible tipoCombustible,
						TipoTransmision tipoTrasmision, int numPuertas, int numPasajeros, int numBolsasAire, int numEjes, int numSalidas, boolean tieneAbs) {
		return concesionario.crearBus(marca, placa, modelo, cantidadCambios, velocidadMaxima, cilindraje, estadoVehiculo, tipoCombustible, tipoTrasmision, numPuertas, numPasajeros, numBolsasAire, numEjes, numSalidas, tieneAbs);
	}

	public PickUp crearPick(String marca, String placa, String modelo, int cantidadCambios, double velocidadMaxima,
							String cilindraje, EstadoVehiculo estadoVehiculo, TipoCombustible tipoCombustible,
							TipoTransmision tipoTrasmision, int numPuertas, int numPasajeros, int numBolsasAire, boolean aC,
							boolean camaraReversa, boolean aBS, boolean is4x4, double capacidadCarga) {
		return concesionario.crearPick(marca, placa, modelo, cantidadCambios, velocidadMaxima, cilindraje, estadoVehiculo, tipoCombustible, tipoTrasmision, numPuertas, numPasajeros, numBolsasAire, aC, camaraReversa, aBS, is4x4, capacidadCarga);
	}

	public Van crearVan(String marca, String placa, String modelo, int cantidadCambios, double velocidadMaxima,
						String cilindraje, EstadoVehiculo estadoVehiculo, TipoCombustible tipoCombustible,
						TipoTransmision tipoTrasmision, int numPuertas, int numPasajeros, int numBolsasAire, boolean aC,
						boolean camaraReversa, boolean aBS) {
		return concesionario.crearVan(marca, placa, modelo, cantidadCambios, velocidadMaxima, cilindraje, estadoVehiculo, tipoCombustible, tipoTrasmision, numPuertas, numPasajeros, numBolsasAire, aC, camaraReversa, aBS);
	}
}

