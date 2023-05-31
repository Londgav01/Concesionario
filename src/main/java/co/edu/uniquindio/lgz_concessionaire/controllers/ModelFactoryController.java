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

	/**
	 * invoca al buscarEmpleado el cual se encuentra en concesionario
	 * @param idEmpleado
	 * @param contrasenia
	 * @return
	 * @throws EmpleadoException
	 */
	public Empleado buscarEmpleado(String idEmpleado, String contrasenia) throws EmpleadoException {
		Empleado empleado = (concesionario.buscarEmpleado(idEmpleado, contrasenia));
		return empleado;
	}

	/**
	 * invoca al metodo buscarEmpleadoIdentificacion que se encuentra en concesionario
	 * Busca igual al empleado pero solo lo hace con identificacion
	 * @param idetificacion
	 * @return
	 * @throws EmpleadoException
	 */
	public Empleado buscarEmpleadoIdentificacion(String idetificacion) throws EmpleadoException {
		Empleado empleado = (concesionario.buscarEmpleadoIdentificacion(idetificacion));
		return empleado;
	}


	/**
	 * Crea al empleado llamando a la funcion desde concesionario
	 * @param nombre
	 * @param identificacion
	 * @param direccion
	 * @param numeroTelefonico
	 * @param idEmpleado
	 * @return
	 * @throws EmpleadoException
	 */

	public Empleado crearEmpleado(String nombre, String identificacion, String direccion, String numeroTelefonico,
								  String idEmpleado) throws EmpleadoException {
		Empleado empleado = (concesionario.crearEmpleado(nombre, identificacion, direccion, numeroTelefonico, idEmpleado));
		return empleado;
	}


	/**
	 * elimina a un empledo llamando a la funcion a traves de concesionario
	 * @param idEmpleado
	 * @return
	 * @throws EmpleadoException
	 */
	public boolean eliminarEmpleado(String idEmpleado) throws EmpleadoException {
		boolean eliminado = concesionario.eliminarEmpleado(idEmpleado);
		return eliminado;
	}


	/**
	 * actualiza al empleado llamando al metodo a traves del concesionario
	 * @param nombre
	 * @param direccion
	 * @param numeroTelefonico
	 * @param idEmpleado
	 * @param contrasenia
	 * @throws EmpleadoException
	 */
	public void actualizarEmpleado(String nombre, String direccion, String numeroTelefonico, String idEmpleado, String contrasenia) throws EmpleadoException {
		concesionario.actualizarEmpleado(nombre, direccion, numeroTelefonico, idEmpleado, contrasenia);
	}


	/**
	 * tambien actualiza al empleado pero sin la contraseña
	 * @param nombre
	 * @param direccion
	 * @param numeroTelefonico
	 * @param idEmpleado
	 * @throws EmpleadoException
	 */
	public void actualizarEmpleado2(String nombre, String direccion, String numeroTelefonico, String idEmpleado) throws EmpleadoException {
		concesionario.actualizarEmpleado2(nombre, direccion, numeroTelefonico, idEmpleado);
	}

	/**
	 * verifica si el empleado ya existe, el metodo es de la clase concesionario pero se llama desde aqui
	 * @param identificacion
	 * @return
	 */

	public boolean verificarEmpleado(String identificacion) {
		return concesionario.verificarEmpleado(identificacion);
	}

	/**
	 * obtiene los empleados quemados
	 * @return
	 */
	public List<Empleado> obtenerEmpleados() {
		return concesionario.getListaEmpleados();
	}

	////////////////////////

	/**
	 * elimina cliente llamando al metodo de la clase concesionario
	 * @param idCliente
	 * @return
	 * @throws UsuarioExcepction
	 */
	public boolean eliminarCliente(String idCliente) throws UsuarioExcepction {
		boolean eliminado = concesionario.eliminarCliente(idCliente);
		return eliminado;
	}

	/**
	 * actualiza cliente a traves de la clase concesionario
	 * @param nombreCliente
	 * @param direccionCliente
	 * @param idCliente
	 * @param telefonoCliente
	 * @throws UsuarioExcepction
	 */
	public void actualizarCliente(String nombreCliente, String direccionCliente, String idCliente, String telefonoCliente) throws UsuarioExcepction {
		concesionario.actualizarCliente(nombreCliente, idCliente, direccionCliente, telefonoCliente);
	}

	/**
	 * Crea cliente a traves de la clase concesionario
	 * @param nombre
	 * @param identificacion
	 * @param direccion
	 * @param numeroTelefonico
	 * @throws UsuarioExcepction
	 */
	public void crearCliente(String nombre, String identificacion, String direccion, String numeroTelefonico) throws UsuarioExcepction {
		concesionario.crearCliente(nombre, identificacion, direccion, numeroTelefonico);
	}

	/**
	 * busca a un cliente con el parametro de identificacion, el metodo es perteneciente a la clase
	 * concesionario y es llamado desde aqui
	 * @param idCliente
	 * @return
	 * @throws UsuarioExcepction
	 */
	public Cliente buscarCliente(String idCliente) throws UsuarioExcepction {
		return concesionario.buscarCliente(idCliente);
	}

	/////////////////////

	/**
	 * crea a un proveedor, se llama al metodo a traves de concesionario
	 * @param nombre
	 * @param identificacion
	 * @param direccion
	 * @param num
	 * @throws UsuarioExcepction
	 */
	public void crearProveedor(String nombre, String identificacion, String direccion, String num) throws UsuarioExcepction {
		concesionario.crearProveedor(nombre, identificacion, direccion, num);
	}

	/**
	 * actualiza a un proveedor usando el metodo que llama a la clase concesionario
	 * @param nombre
	 * @param identificacion
	 * @param direccion
	 * @param numTelefono
	 * @throws UsuarioExcepction
	 */

	public void actualizarProveedor(String nombre, String identificacion, String direccion,
									String numTelefono) throws UsuarioExcepction {
		concesionario.actualizarProveedor(nombre, identificacion, direccion, numTelefono);
	}


	/**
	 * busca a un proveedor a traves de su id
	 * @param idProveedor
	 * @return
	 * @throws UsuarioExcepction
	 */
	public Proveedor buscarProveedor(String idProveedor) throws UsuarioExcepction {
		return concesionario.buscarProveedor(idProveedor);
	}

	/////////////////////////

	/**
	 * crea transaccionesm, usa a concesionario ya que es alli donde se encuentra el metodo
	 * @param empleado
	 * @param code
	 * @param valorTotal
	 * @param cliente
	 * @param listaDetalles
	 * @throws TransactionException
	 */
	public void crearTransacciones(Empleado empleado, String code, Double valorTotal, Cliente cliente, List<DetalleTransaccion> listaDetalles) throws TransactionException {
		concesionario.crearTransacciones(empleado, code, valorTotal, cliente, listaDetalles);
	}


	/**
	 * busca una transaccion ingresandole cl codigo de la transaccion
	 * @param code
	 * @return
	 */
	public Transaccion buscarTransaccion(String code) {
		return concesionario.buscarTransaccion(code);
	}

	/**
	 * elimina una transaccion
	 * @param code
	 * @throws TransactionException
	 */
	public void eliminarTransaccion(String code) throws TransactionException {
		concesionario.eliminarTransaccion(code);
	}

	/**
	 * busca un vehiculo con la placa
	 * @param placa
	 * @return
	 */

	//////////////////////////////////
	public Vehiculo buscarVehiculo(String placa) {
		return concesionario.buscarVehiculo(placa);

	}

	/**
	 * elimina a un vehiculo buscando la placa
	 * @param placa
	 * @return
	 */
	public boolean eliminarVehiculo(String placa) {
		return concesionario.eliminarVehiculo(placa);
	}


	/**
	 * crea un sedan con todos sus atributos, el metodo se encuentra en concesionario
	 * @param marca
	 * @param placa
	 * @param modelo
	 * @param cantidadCambios
	 * @param velocidadMaxima
	 * @param cilindraje
	 * @param estadoVehiculo
	 * @param tipoCombustible
	 * @param tipoTrasmision
	 * @param numPuertas
	 * @param numPasajeros
	 * @param numBolsasAire
	 * @param aC
	 * @param camaraReversa
	 * @param aBS
	 * @param velocidadCrucero
	 * @param sensoresColision
	 * @param sensorTraficoCruzado
	 * @param asistenteCarril
	 * @return
	 */
	public Sedan crearSedan(String marca, String placa, String modelo, int cantidadCambios, double velocidadMaxima,
							String cilindraje, EstadoVehiculo estadoVehiculo, TipoCombustible tipoCombustible,
							TipoTransmision tipoTrasmision, int numPuertas, int numPasajeros, int numBolsasAire, boolean aC,
							boolean camaraReversa, boolean aBS, boolean velocidadCrucero, boolean sensoresColision,
							boolean sensorTraficoCruzado, boolean asistenteCarril) {
		return concesionario.crearSedan(marca, placa, modelo, cantidadCambios, velocidadMaxima, cilindraje, estadoVehiculo, tipoCombustible, tipoTrasmision, numPuertas, numPasajeros, numBolsasAire, aC, camaraReversa, aBS, velocidadCrucero, sensoresColision, sensorTraficoCruzado, asistenteCarril);
	}

	/**
	 * crea un deportivo con todos sus atributos, el metodo original se encuentra en concesionario
	 * @param marca
	 * @param placa
	 * @param modelo
	 * @param cantidadCambios
	 * @param velocidadMaxima
	 * @param cilindraje
	 * @param estadoVehiculo
	 * @param tipoCombustible
	 * @param tipoTrasmision
	 * @param numPuertas
	 * @param numPasajeros
	 * @param numBolsasAire
	 * @param tiempo100Km
	 * @param caballosFuerza
	 * @return
	 */
	public Deportivo crearDeportivo(String marca, String placa, String modelo, int cantidadCambios, double velocidadMaxima,
									String cilindraje, EstadoVehiculo estadoVehiculo, TipoCombustible tipoCombustible,
									TipoTransmision tipoTrasmision, int numPuertas, int numPasajeros, int numBolsasAire, Double tiempo100Km, Double caballosFuerza) {
		return concesionario.crearDeportivo(marca, placa, modelo, cantidadCambios, velocidadMaxima, cilindraje, estadoVehiculo, tipoCombustible, tipoTrasmision, numPuertas, numPasajeros, numBolsasAire, tiempo100Km, caballosFuerza);
	}


	/**
	 * Crea una camioneta con todos sus atributos
	 * @param marca
	 * @param placa
	 * @param modelo
	 * @param cantidadCambios
	 * @param velocidadMaxima
	 * @param cilindraje
	 * @param estadoVehiculo
	 * @param tipoCombustible
	 * @param tipoTrasmision
	 * @param numPuertas
	 * @param numPasajeros
	 * @param numBolsasAire
	 * @param aC
	 * @param camaraReversa
	 * @param aBS
	 * @param velocidadCrucero
	 * @param sensoresColision
	 * @param sensorTraficoCruzado
	 * @param asistenteCarril
	 * @param is4x4
	 * @return
	 */
	public Camioneta crearCamioneta(String marca, String placa, String modelo, int cantidadCambios, double velocidadMaxima,
									String cilindraje, EstadoVehiculo estadoVehiculo, TipoCombustible tipoCombustible,
									TipoTransmision tipoTrasmision, int numPuertas, int numPasajeros, int numBolsasAire, boolean aC,
									boolean camaraReversa, boolean aBS, boolean velocidadCrucero, boolean sensoresColision,
									boolean sensorTraficoCruzado, boolean asistenteCarril, boolean is4x4) {
		return concesionario.crearCamioneta(marca, placa, modelo, cantidadCambios, velocidadMaxima, cilindraje, estadoVehiculo, tipoCombustible, tipoTrasmision, numPuertas, numPasajeros, numBolsasAire, aC, camaraReversa, aBS, velocidadCrucero, sensoresColision, sensorTraficoCruzado, asistenteCarril, is4x4);
	}

	/**
	 * crea un camion con todos sus atributos
	 * @param marca
	 * @param placa
	 * @param modelo
	 * @param cantidadCambios
	 * @param velocidadMaxima
	 * @param cilindraje
	 * @param estadoVehiculo
	 * @param tipoCombustible
	 * @param tipoTrasmision
	 * @param capacidadCarga
	 * @param tieneFrenosAire
	 * @param numeroEjes
	 * @param tieneABS
	 * @param tipoCamion
	 * @param tieneAC
	 * @return
	 */

	public Camion crearCamion(String marca, String placa, String modelo, int cantidadCambios, double velocidadMaxima,
							  String cilindraje, EstadoVehiculo estadoVehiculo, TipoCombustible tipoCombustible,
							  TipoTransmision tipoTrasmision, double capacidadCarga, boolean tieneFrenosAire, int numeroEjes, boolean tieneABS, String tipoCamion, boolean tieneAC) {
		return concesionario.crearCamion(marca, placa, modelo, cantidadCambios, velocidadMaxima, cilindraje, estadoVehiculo, tipoCombustible, tipoTrasmision, capacidadCarga, tieneFrenosAire, numeroEjes, tieneABS, tipoCamion, tieneAC);
	}


	/**
	 * crea una moto con todos sus atributos
	 * @param marca
	 * @param estadoVehiculo
	 * @param modelo
	 * @param cambios
	 * @param velocidadMaxima
	 * @param cilindraje
	 * @param placa
	 * @return
	 */
	public Moto crearMoto(String marca, EstadoVehiculo estadoVehiculo, String modelo, int cambios, Double velocidadMaxima,
						  String cilindraje, String placa) {
		return concesionario.crearMoto(marca, estadoVehiculo, modelo, cambios, velocidadMaxima, cilindraje, placa);
	}

	/**
	 * crea un bus con todos sus atributos
	 * @param marca
	 * @param placa
	 * @param modelo
	 * @param cantidadCambios
	 * @param velocidadMaxima
	 * @param cilindraje
	 * @param estadoVehiculo
	 * @param tipoCombustible
	 * @param tipoTrasmision
	 * @param numPuertas
	 * @param numPasajeros
	 * @param numBolsasAire
	 * @param numEjes
	 * @param numSalidas
	 * @param tieneAbs
	 * @return
	 */
	public Bus crearBus(String marca, String placa, String modelo, int cantidadCambios, double velocidadMaxima,
						String cilindraje, EstadoVehiculo estadoVehiculo, TipoCombustible tipoCombustible,
						TipoTransmision tipoTrasmision, int numPuertas, int numPasajeros, int numBolsasAire, int numEjes, int numSalidas, boolean tieneAbs) {
		return concesionario.crearBus(marca, placa, modelo, cantidadCambios, velocidadMaxima, cilindraje, estadoVehiculo, tipoCombustible, tipoTrasmision, numPuertas, numPasajeros, numBolsasAire, numEjes, numSalidas, tieneAbs);
	}

	/**
	 * crea una pick up con todos sus atributos
	 * @param marca
	 * @param placa
	 * @param modelo
	 * @param cantidadCambios
	 * @param velocidadMaxima
	 * @param cilindraje
	 * @param estadoVehiculo
	 * @param tipoCombustible
	 * @param tipoTrasmision
	 * @param numPuertas
	 * @param numPasajeros
	 * @param numBolsasAire
	 * @param aC
	 * @param camaraReversa
	 * @param aBS
	 * @param is4x4
	 * @param capacidadCarga
	 * @return
	 */
	public PickUp crearPick(String marca, String placa, String modelo, int cantidadCambios, double velocidadMaxima,
							String cilindraje, EstadoVehiculo estadoVehiculo, TipoCombustible tipoCombustible,
							TipoTransmision tipoTrasmision, int numPuertas, int numPasajeros, int numBolsasAire, boolean aC,
							boolean camaraReversa, boolean aBS, boolean is4x4, double capacidadCarga) {
		return concesionario.crearPick(marca, placa, modelo, cantidadCambios, velocidadMaxima, cilindraje, estadoVehiculo, tipoCombustible, tipoTrasmision, numPuertas, numPasajeros, numBolsasAire, aC, camaraReversa, aBS, is4x4, capacidadCarga);
	}

	/**
	 * crea una van con todos sus atributos
	 * @param marca
	 * @param placa
	 * @param modelo
	 * @param cantidadCambios
	 * @param velocidadMaxima
	 * @param cilindraje
	 * @param estadoVehiculo
	 * @param tipoCombustible
	 * @param tipoTrasmision
	 * @param numPuertas
	 * @param numPasajeros
	 * @param numBolsasAire
	 * @param aC
	 * @param camaraReversa
	 * @param aBS
	 * @return
	 */
	public Van crearVan(String marca, String placa, String modelo, int cantidadCambios, double velocidadMaxima,
						String cilindraje, EstadoVehiculo estadoVehiculo, TipoCombustible tipoCombustible,
						TipoTransmision tipoTrasmision, int numPuertas, int numPasajeros, int numBolsasAire, boolean aC,
						boolean camaraReversa, boolean aBS) {
		return concesionario.crearVan(marca, placa, modelo, cantidadCambios, velocidadMaxima, cilindraje, estadoVehiculo, tipoCombustible, tipoTrasmision, numPuertas, numPasajeros, numBolsasAire, aC, camaraReversa, aBS);
	}
}

