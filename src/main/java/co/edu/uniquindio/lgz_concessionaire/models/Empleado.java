package co.edu.uniquindio.lgz_concessionaire.models;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Entity
@Table(name = "EMPLEADO")
public class Empleado extends Persona implements Serializable {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String idEmpleado;

    public Empleado() {super();}

    /*public Cliente registrarCliente(String nombre, String id, String direccion, String numTelefono){
        Cliente nuevoCliente = new Cliente(nombre, id, direccion, numTelefono);
        return nuevoCliente;
    }*/

    public String getIdEmpleado() {
        return idEmpleado;
    }


    public static class EmpleadoBuilder extends PersonaBuilder{
        Empleado empleado= new Empleado();

        public EmpleadoBuilder idEmpleado(String id) {
            empleado.idEmpleado= id;
            return this;
        }

        public EmpleadoBuilder () {
            Empleado empleado= new Empleado();
        }

        public Empleado build() {
            return empleado;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
