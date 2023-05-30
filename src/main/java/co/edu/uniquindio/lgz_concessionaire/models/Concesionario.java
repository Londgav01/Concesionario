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

    private String name;

    @OneToMany(mappedBy = "concesionario", orphanRemoval = true)
    private List<Cliente> listaClientes = new ArrayList<>();

    @OneToMany(mappedBy = "concesionario", orphanRemoval = true)
    private List<Proveedor> listaProveedores = new ArrayList<>();

    @OneToMany(mappedBy = "concesionario", orphanRemoval = true)
    private List<Vehiculo> listaVehiculos = new ArrayList<>();

    @OneToMany(mappedBy = "concesionario", orphanRemoval = true)
    private List<Empleado> listaEmpleados = new ArrayList<>();


    /**
     *  Constructor y methods getter and setter
     */
    public Concesionario() {}

    public Concesionario(String name) {
        this.name = name;
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public List<Proveedor> getListaProveedores() {
        return listaProveedores;
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

    public void seListaProveedores(List<Proveedor> listaProveedores) {
        this.listaProveedores = listaProveedores;
    }

    public void setListaProveedores(List<Proveedor> listaProveedores) {
        this.listaProveedores = listaProveedores;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    ////////////////////////////////////////////////////////////////////////
    //Metodo CRUD empleado

    public Empleado crearEmpleado(String nombre, String identificacion, String direccion, String numeroTelefonico, String contrasenia) throws EmpleadoException{
        Empleado empleado = (Empleado) new Empleado.EmpleadoBuilder()
                .idEmpleado(contrasenia)
                .withNombre(nombre)
                .withId(identificacion)
                .withDireccion(direccion)
                .withNumeroTelefonico(numeroTelefonico)
                .build();
        if(verificarEmpleado(empleado)){
            throw new EmpleadoException("El empleado ya existe");
        }
        listaEmpleados.add(empleado);
        return empleado;
    }

    public Empleado buscarEmpleado(String identificacion) throws EmpleadoException{
        for (Empleado empleado : listaEmpleados) {
            if(empleado.getIdentificacion().equals(identificacion)){
                return empleado;
            }
        }
        throw new EmpleadoException("El empleado no se ha encontrado");
    }

    public void actualizarEmpleado (String nombre, String direccion, String numeroTelefonico, String idEmpleado) throws EmpleadoException{
        if(buscarEmpleado(idEmpleado) != null) {
            for (Empleado empleado : listaEmpleados) {
                if (empleado.getId().equals(idEmpleado)){
                    empleado.setDireccion(direccion);
                    empleado.setNombre(nombre);
                    empleado.setNumeroTelefonico(numeroTelefonico);
                    break;
                }
            }
        }
    }

    public boolean verificarEmpleado(Empleado empleado){
        return listaEmpleados.stream().anyMatch(e -> e.equals(empleado));
    }


    public boolean eliminarEmpleado (String idEmpleado) throws EmpleadoException{
        for (Empleado empleado : listaEmpleados) {
            if(buscarEmpleado(idEmpleado).equals(empleado.getIdentificacion())){
                listaEmpleados.remove(empleado);
                return true;
            }
        }
        return false;
    }

    /////////////////////////////////////////////////Métodos CRUD Cliente//////////////////////////////////////////////////////////

    public void crearCliente(String nombre, String identificacion, String direccion, String numeroTelefonico) throws UsuarioExcepction {
        Persona cliente= new Persona.PersonaBuilder()
                .withNombre(nombre)
                .withDireccion(direccion)
                .withNumeroTelefonico(numeroTelefonico)
                .withId(identificacion)
                .build();
        if(verificarCliente(cliente.getIdentificacion())){
            throw new UsuarioExcepction("El cliente ya existe");
        }
        listaClientes.add((Cliente) cliente);
    }

    public boolean verificarCliente(String identificacion){
        return listaClientes.stream().anyMatch(c -> c.getIdentificacion().equals(identificacion));
    }

    public void actualizarCliente(String nombre, String identificacion, String direccion,
                                  String numTelefono)throws UsuarioExcepction{
        if(identificacion!=null){
            for (Cliente cliente: listaClientes) {
                if(cliente.getIdentificacion().equals(identificacion)){
                    Persona.PersonaBuilder builder = new Persona.PersonaBuilder(cliente);
                    builder.withNombre(nombre)
                            .withDireccion(direccion)
                            .withNumeroTelefonico(numTelefono)
                            .build();
                }
            }
        }
        throw  new UsuarioExcepction("El cliente no existe, digite la identificación de nuevo");
    }

    public Cliente buscarCliente (String idCliente) throws UsuarioExcepction{
        for (Cliente cliente : listaClientes) {
            if(cliente.getIdentificacion().equals(idCliente)){
                return cliente;
            }
        }


        throw new UsuarioExcepction("El cliente no se ha encontrado");
    }

    public boolean eliminarCliente (String identificacion) throws UsuarioExcepction {
        for (Cliente cliente: listaClientes) {
            if(buscarCliente(identificacion).equals(cliente.getIdentificacion())){
                listaClientes.remove(cliente);
                return true;
            }
        }
        return false;
    }

    //////////////////////////////////////////////////////////////////
    //Metodos CRUD proveedor

    public void crearProveedor(String nombre, String identificacion, String direccion, String num) throws UsuarioExcepction {
        Proveedor proveedor = new Proveedor (nombre, identificacion, direccion, num);
        if(verificarProveedor(proveedor.getIdentificacion())){
            throw new UsuarioExcepction("El proveedor ya existe");
        }
        listaProveedores.add(proveedor);
    }
    public boolean verificarProveedor(String identificacion){
        return listaProveedores.stream().anyMatch(c -> c.getIdentificacion().equals(identificacion));
    }

    public void actualizarProveedor(String nombre, String identificacion, String direccion,
                                  String numTelefono)throws UsuarioExcepction{
        if(identificacion!=null){
            for (Proveedor proveedor: listaProveedores) {
                if(proveedor.getIdentificacion().equals(identificacion)){
                    Persona.PersonaBuilder builder = new Persona.PersonaBuilder(proveedor);
                    builder.withNombre(nombre)
                            .withDireccion(direccion)
                            .withNumeroTelefonico(numTelefono)
                            .build();
                }
            }
        }
        throw  new UsuarioExcepction("El cliente no existe, digite la identificación de nuevo");
    }

    public Proveedor buscarProveedor (String idProveedor) throws UsuarioExcepction{
        for (Proveedor proveedor : listaProveedores) {
            if(proveedor.getIdentificacion().equals(idProveedor)){
                return proveedor;
            }
        }
        throw new UsuarioExcepction("El proveedor no se ha encontrado");
    }
}
