package co.edu.uniquindio.lgz_concessionaire.models;

import jakarta.persistence.*;
import javafx.scene.image.*;
import java.io.Serializable;


@Entity
@Table(name = "VEHICULOS")
public class Vehiculo implements Serializable {

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
    //private Image imagenCargar;
    Double precio;

    @ManyToOne
    @JoinColumn(name = "concesionario_id")
    private Concesionario concesionario;

    public Concesionario getConcesionario() {
        return concesionario;
    }

    public void setConcesionario(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    public Vehiculo(VehiculoBuilder builder){
        this.id= builder.id;
        this.tipoCombustible= builder.tipoCombustible;
        this.estadoVehiculo= builder.estadoVehiculo;
        this.marca= builder.marca;
        this.placa= builder.placa;
        this.modelo= builder.modelo;
        this.cantidadCambios= builder.cantidadCambios;
        this.velocidadMaxima= builder.velocidadMaxima;
        this.cilindraje= builder.cilindraje;
        this.tipoTrasmision= builder.tipoTransmision;
    }

    public Vehiculo(String marca, String placa, String modelo, int cantidadCambios, double velocidadMaxima, String cilindraje, EstadoVehiculo estadoVehiculo, TipoCombustible tipoCombustible, TipoTransmision tipoTrasmision, Image imagenCargar, Double precio) {
        this.marca = marca;
        this.placa = placa;
        this.modelo = modelo;
        this.cantidadCambios = cantidadCambios;
        this.velocidadMaxima = velocidadMaxima;
        this.cilindraje = cilindraje;
        this.estadoVehiculo = estadoVehiculo;
        this.tipoCombustible = tipoCombustible;
        this.tipoTrasmision = tipoTrasmision;
        //this.imagenCargar = imagenCargar;
        this.precio = precio;
    }

    public Vehiculo() {}

    public String getMarca() {
        return marca;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public int getCantidadCambios() {
        return cantidadCambios;
    }

    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public String getCilindraje() {
        return cilindraje;
    }

    /*public Image getImagenCargar() {
        return imagenCargar;
    }

    public void setImagenCargar(Image imagenCargar) {
        this.imagenCargar = imagenCargar;
    }*/

    public EstadoVehiculo getEstadoVehiculo(){return estadoVehiculo; }

    // Clase Builder estática dentro de la clase Vehículo
    public static class VehiculoBuilder {
        private Long id;
        private String marca;
        private String placa;
        private String modelo;
        private int cantidadCambios;
        private double velocidadMaxima;
        private String cilindraje;
        private EstadoVehiculo estadoVehiculo;
        private TipoCombustible tipoCombustible;
        private TipoTransmision tipoTransmision;

        public VehiculoBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public VehiculoBuilder setMarca(String marca) {
            this.marca = marca;
            return this;
        }

        public VehiculoBuilder setPlaca(String placa) {
            this.placa = placa;
            return this;
        }

        public VehiculoBuilder setModelo(String modelo) {
            this.modelo = modelo;
            return this;
        }

        public VehiculoBuilder setCantidadCambios(int cantidadCambios) {
            this.cantidadCambios = cantidadCambios;
            return this;
        }

        public VehiculoBuilder setVelocidadMaxima(double velocidadMaxima) {
            this.velocidadMaxima = velocidadMaxima;
            return this;
        }

        public VehiculoBuilder setCilindraje(String cilindraje) {
            this.cilindraje = cilindraje;
            return this;
        }

        public VehiculoBuilder setEstadoVehiculo(EstadoVehiculo estadoVehiculo) {
            this.estadoVehiculo = estadoVehiculo;
            return this;
        }

        public VehiculoBuilder setTipoCombustible(TipoCombustible tipoCombustible) {
            this.tipoCombustible = tipoCombustible;
            return this;
        }

        public VehiculoBuilder setTipoTransmision(TipoTransmision tipoTransmision) {
            this.tipoTransmision = tipoTransmision;
            return this;
        }

        public Vehiculo build() {
            return new Vehiculo(this);
        }
    }
}
