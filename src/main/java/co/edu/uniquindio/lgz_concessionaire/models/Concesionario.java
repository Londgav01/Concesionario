package co.edu.uniquindio.lgz_concessionaire.models;

import co.edu.uniquindio.lgz_concessionaire.exceptions.EmpleadoException;
import co.edu.uniquindio.lgz_concessionaire.exceptions.UsuarioExcepction;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "concesionario")
public class Concesionario {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @OneToMany
    private List<Empleado> listaEmpleados= new ArrayList<>();
    @OneToMany(mappedBy = "")
    private List<Cliente> listaClientes= new ArrayList<>();
    @OneToMany
    private List<Vehiculo> listaVehiculos= new ArrayList<>();

    public Concesionario(List<Empleado> listaEmpleados, List<Cliente> listaClientes, List<Vehiculo> listaVehiculos) {
        this.listaEmpleados = listaEmpleados;
        this.listaClientes = listaClientes;
        this.listaVehiculos = listaVehiculos;
    }

    public Concesionario() {}

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    ////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////

    public void CrearEmpleado (String nombre, String identificacion, String direccion, String numeroTelefonico, String idEmpleado) throws EmpleadoException{
        Empleado empleado = new Empleado (nombre, identificacion, direccion, numeroTelefonico, idEmpleado);
        if(verificarEmpleado(empleado)){
            throw new EmpleadoException("El empleado ya existe");
        }
        listaEmpleados.add(empleado);
    }

    public Empleado buscarEmpleado (String idEmpleado) throws EmpleadoException{
        for (Empleado empleado : listaEmpleados) {
            if(empleado.getIdEmpleado().equals(idEmpleado)){
                return empleado;
            }
        }
        throw new EmpleadoException("El empleado no se ha encontrado");
    }

    public void actualizarEmpleado (String nombre, String direccion, String numeroTelefonico, String idEmpleado) throws EmpleadoException{
        for (Empleado empleado : listaEmpleados) {
            if(buscarEmpleado(idEmpleado) != null){
                empleado.setDireccion(empleado.getDireccion());
                empleado.setNombre(empleado.getNombre());
                empleado.setNumeroTelefonico(empleado.getNumeroTelefonico());
            }
        }
    }

    public boolean verificarEmpleado(Empleado empleado){
        return listaEmpleados.stream().anyMatch(e -> e.equals(empleado));
    }


    public boolean eliminarEmpleado (String idEmpleado) throws EmpleadoException{
        boolean eliminado = false;
        for (Empleado empleado : listaEmpleados) {
            if(buscarEmpleado(idEmpleado).equals(empleado.getIdEmpleado())){
                listaEmpleados.remove(empleado);
                eliminado = true;
            }
        }
        return eliminado;
    }

    ///////////////////////////////////////////////////////////////

    public void crearCliente(String nombre, String identificacion, String direccion, String numeroTelefonico) throws UsuarioExcepction {
        Cliente cliente = new Cliente (nombre, identificacion, direccion, numeroTelefonico);
        if(verificarCliente(cliente.getIdentificacion())){
            throw new UsuarioExcepction("El cliente ya existe");
        }
    }
    public boolean verificarCliente(String identificacion){
        return listaClientes.stream().anyMatch(c -> c.getIdentificacion().equals(identificacion))
    }

}
