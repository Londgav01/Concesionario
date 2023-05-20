package co.edu.uniquindio.lgz_concessionaire.models;

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
}
