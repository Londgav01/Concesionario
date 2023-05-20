package co.edu.uniquindio.lgz_concessionaire.models;

import jakarta.persistence.*;

@Entity
@Table(schema = "personas", name = "clientes")
public class Cliente extends Persona{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    public Cliente(String nombre, String identificacion, String direccion, String numeroTelefonico) {
        super(nombre, identificacion, direccion, numeroTelefonico);
    }

    public Cliente() {
        super();
    }
}
