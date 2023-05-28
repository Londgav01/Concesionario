package co.edu.uniquindio.lgz_concessionaire.models;

import jakarta.persistence.*;


public class DetalleTransaccion {

    private Long id;
    private String articulo;
    private Double valorArticulo;
    private Integer cantidad;
    private TipoTransaccion tipoTransaccion;
}
