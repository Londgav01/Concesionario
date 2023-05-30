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

    private String contrasenia;

    @ManyToOne
    @JoinColumn(name = "concesionario_id")
    private Concesionario concesionario;

    public Concesionario getConcesionario() {
        return concesionario;
    }

    public void setConcesionario(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    public Empleado() {super();}

    public Cliente registrarCliente(String nombre, String id, String direccion, String numTelefono, String contrasenia){
        return (Cliente) new PersonaBuilder()
                .withNombre(nombre)
                .withId(id)
                .withDireccion(direccion)
                .withNumeroTelefonico(numTelefono)
                .build();
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public static class EmpleadoBuilder extends PersonaBuilder{
        Empleado empleado= new Empleado();

        public EmpleadoBuilder contraEmpleado(String contrasenia) {
            empleado.contrasenia= contrasenia;
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
