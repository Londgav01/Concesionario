package co.edu.uniquindio.lgz_concessionaire.models;

import jakarta.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(schema = "vehiculos", name = "Vehiculos")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String marca;
    private String placa ;
    private String modelo;
    private int cantidadCambios;
    private double velocidadMaxima;
    private String cilindraje;
    private EstadoVehiculo estadoVehiculo;
    private TipoCombustible tipoCombustible;
    private TipoTransmision tipoTrasmision;

    public Vehiculo(){}

    public Vehiculo(String marca, String placa, String modelo, int cantidadCambios, double velocidadMaxima, String cilindraje, EstadoVehiculo estadoVehiculo, TipoCombustible tipoCombustible, TipoTransmision tipoTrasmision) {
        this.marca = marca;
        this.placa = placa;
        this.modelo = modelo;
        this.cantidadCambios = cantidadCambios;
        this.velocidadMaxima = velocidadMaxima;
        this.cilindraje = cilindraje;
        this.estadoVehiculo = estadoVehiculo;
        this.tipoCombustible = tipoCombustible;
        this.tipoTrasmision = tipoTrasmision;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCantidadCambios() {
        return cantidadCambios;
    }

    public void setCantidadCambios(int cantidadCambios) {
        this.cantidadCambios = cantidadCambios;
    }

    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(double velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    public String getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(String cilindraje) {
        this.cilindraje = cilindraje;
    }

    public EstadoVehiculo getEstadoVehiculo(){return estadoVehiculo; }

    public void setEstadoVehiculo(EstadoVehiculo estadoVehiculo) {
        this.estadoVehiculo = estadoVehiculo;
    }
}
