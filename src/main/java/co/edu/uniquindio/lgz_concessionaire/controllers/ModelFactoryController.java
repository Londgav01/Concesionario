package co.edu.uniquindio.lgz_concessionaire.controllers;

import java.util.List;

import co.edu.uniquindio.lgz_concessionaire.exceptions.EmpleadoException;
import co.edu.uniquindio.lgz_concessionaire.exceptions.TransactionException;
import co.edu.uniquindio.lgz_concessionaire.exceptions.UsuarioExcepction;
import co.edu.uniquindio.lgz_concessionaire.models.*;


public class ModelFactoryController {


	public Concesionario concesionario = null;

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
									String numTelefono)throws UsuarioExcepction{
		concesionario.actualizarProveedor(nombre, identificacion, direccion, numTelefono);
	}

	public Proveedor buscarProveedor (String idProveedor) throws UsuarioExcepction{
		return concesionario.buscarProveedor(idProveedor);
	}

	/////////////////////////
	public void crearTransacciones(Empleado empleado, String code, Double valorTotal, Cliente cliente,  List<DetalleTransaccion> listaDetalles) throws TransactionException {
		concesionario.crearTransacciones(empleado, code, valorTotal, cliente, listaDetalles);
	}

	public Transaccion buscarTransaccion(String code){
		return concesionario.buscarTransaccion(code);
	}

	public void eliminarTransaccion(String code) throws TransactionException {
		concesionario.eliminarTransaccion(code);
	}

	//////////////////////////////////
	public Vehiculo buscarVehiculo (String placa){
		return concesionario.buscarVehiculo(placa);

	}
}

