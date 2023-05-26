package co.edu.uniquindio.lgz_concessionaire.models;

import jakarta.persistence.*;

@Entity
@Table(schema = "personas", name = "proveedor")
public class Proveedor extends Persona{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    public Proveedor(String nombre, String identificacion, String direccion, String num) {
        super(nombre, identificacion, direccion, num);
    }

    public Proveedor() {}
}
