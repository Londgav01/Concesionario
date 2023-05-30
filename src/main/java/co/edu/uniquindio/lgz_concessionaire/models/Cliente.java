package co.edu.uniquindio.lgz_concessionaire.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "CLIENTE")
public class Cliente extends Persona implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
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
}
