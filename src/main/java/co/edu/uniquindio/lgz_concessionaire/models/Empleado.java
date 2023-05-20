package co.edu.uniquindio.lgz_concessionaire.models;

import jakarta.persistence.*;

@Entity
@Table(schema = "personas",name = "empleados")
public class Empleado extends Persona{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String idEmpleado;

    public Empleado(String nombre, String identificacion, String direccion, String numeroTelefonico, String idEmpleado) {
        super(nombre, identificacion, direccion, numeroTelefonico);
        this.idEmpleado = idEmpleado;
    }

    public Empleado() {super();}

    public Cliente registrarCliente(String nombre, String id, String direccion, String numTelefono){
        Cliente nuevoCliente = new Cliente(nombre, id, direccion, numTelefono);
        return nuevoCliente;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
}
