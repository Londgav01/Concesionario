package co.edu.uniquindio.lgz_concessionaire.models;

import jakarta.persistence.*;

@Entity
@Table(name ="detallesTransaccion" )
public class DetalleTransaccion {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String articulo;
    private Double valorArticulo;
    private Integer cantidad;
    private TipoTransaccion tipoTransaccion;
}
