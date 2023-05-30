package co.edu.uniquindio.lgz_concessionaire.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Proveedor")
public class Proveedor extends Persona{
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "concesionario_id")
    private Concesionario concesionario;

    public Concesionario getConcesionario() {
        return concesionario;
    }

    public void setConcesionario(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    public Proveedor(String nombre, String identificacion, String direccion, String num) {
        super(nombre, identificacion, direccion, num);
    }

    public Proveedor() {}
}
