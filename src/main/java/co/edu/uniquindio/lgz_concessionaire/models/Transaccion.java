package co.edu.uniquindio.lgz_concessionaire.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TRANSACCIONES")
public class Transaccion implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String code;
    private Double valorTotal;
    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Empleado empleado;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "transaccion", orphanRemoval = true)
    private List<DetalleTransaccion> listaDetalleTransaccion = new ArrayList<>();

    public Transaccion(Empleado empleado, String code, Double valorTotal, Cliente cliente,  List<DetalleTransaccion> listaDetalles) {
        this.empleado = empleado;
        this.code = code;
        this.valorTotal = valorTotal;
        this.cliente = cliente;
        this.listaDetalleTransaccion = listaDetalles;
    }

    public Transaccion() {}

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<DetalleTransaccion> getListaDetalleTransaccion() {
        return listaDetalleTransaccion;
    }

    public void setListaDetalleTransaccion(List<DetalleTransaccion> listaDetalleTransaccion) {
        this.listaDetalleTransaccion = listaDetalleTransaccion;
    }

}
