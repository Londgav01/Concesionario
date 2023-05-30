package co.edu.uniquindio.lgz_concessionaire.controllers;

import java.util.List;

import co.edu.uniquindio.lgz_concessionaire.exceptions.EmpleadoException;
import co.edu.uniquindio.lgz_concessionaire.models.Concesionario;
import co.edu.uniquindio.lgz_concessionaire.models.Empleado;
import org.springframework.stereotype.Component;

@Component
public class ModelFactoryController {
	Concesionario concesionario = null;

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

	public Empleado buscarEmpleado (String idEmpleado, String contrasenia) throws EmpleadoException {
		Empleado empleado = (concesionario.buscarEmpleado(idEmpleado, contrasenia));
		return empleado;
	}

	public Empleado crearEmpleado (String nombre, String identificacion, String direccion, String numeroTelefonico,
								   String idEmpleado) throws EmpleadoException {
		Empleado empleado = (concesionario.crearEmpleado(nombre, identificacion, direccion, numeroTelefonico ,idEmpleado));
		return empleado;
	}

	public boolean eliminarEmpleado(String idEmpleado) throws EmpleadoException {
		boolean eliminado = concesionario.eliminarEmpleado(idEmpleado);
		return eliminado;
	}

	public void actualizarEmpleado(String nombre, String direccion, String numeroTelefonico, String idEmpleado) throws EmpleadoException {
		concesionario.actualizarEmpleado(nombre,direccion, direccion, idEmpleado);
	}

	public List<Empleado> obtenerEmpleados() {
		return concesionario.getListaEmpleados();
	}

}
