package co.edu.uniquindio.lgz_concessionaire.models;

import jakarta.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
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
