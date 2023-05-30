package co.edu.uniquindio.lgz_concessionaire.models;

import jakarta.persistence.*;

@Entity
@Table(name = "DETALLES TRANSACCION")
public class DetalleTransaccion {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String articulo;
    private Double valorArticulo;
    private Integer cantidad;
    private TipoTransaccion tipoTransaccion;

    @ManyToOne
    @JoinColumn(name = "transaccion_id")
    private Transaccion transaccion;

    public Transaccion getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
    }

    public DetalleTransaccion(String articulo, Double valorArticulo, Integer cantidad, TipoTransaccion tipoTransaccion) {
        this.articulo = articulo;
        this.valorArticulo = valorArticulo;
        this.cantidad = cantidad;
        this.tipoTransaccion = tipoTransaccion;
    }

    public DetalleTransaccion() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public Double getValorArticulo() {
        return valorArticulo;
    }

    public void setValorArticulo(Double valorArticulo) {
        this.valorArticulo = valorArticulo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public TipoTransaccion getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }
}
