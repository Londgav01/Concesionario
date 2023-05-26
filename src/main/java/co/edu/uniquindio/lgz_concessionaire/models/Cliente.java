package co.edu.uniquindio.lgz_concessionaire.models;

import jakarta.persistence.*;

@Entity
@Table(schema = "personas", name = "clientes")
public class Cliente extends Persona{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

}
