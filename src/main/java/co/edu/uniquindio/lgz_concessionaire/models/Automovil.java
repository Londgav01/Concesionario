package co.edu.uniquindio.lgz_concessionaire.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Automovil extends Vehiculo {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Integer numPuertas;
    private Integer numPasajeros;
    private Integer numBolsasAire;

    public Automovil(String marca, String placa, String modelo, int cantidadCambios, double velocidadMaxima, String cilindraje,
                     EstadoVehiculo estadoVehiculo, TipoCombustible tipoCombustible, TipoTransmision tipoTrasmision, Integer numPuertas,
                     Integer numPasajeros, Integer numBolsasAire) {
        super(marca, placa, modelo, cantidadCambios, velocidadMaxima, cilindraje, estadoVehiculo, tipoCombustible, tipoTrasmision);
        this.numPuertas = numPuertas;
        this.numPasajeros = numPasajeros;
        this.numBolsasAire = numBolsasAire;
    }

    public Automovil() {

    }

    public Integer getNumPuertas() {
        return numPuertas;
    }

    public void setNumPuertas(Integer numPuertas) {
        this.numPuertas = numPuertas;
    }

    public Integer getNumPasajeros() {
        return numPasajeros;
    }

    public void setNumPasajeros(Integer numPasajeros) {
        this.numPasajeros = numPasajeros;
    }

    public Integer getNumBolsasAire() {
        return numBolsasAire;
    }

    public void setNumBolsasAire(Integer numBolsasAire) {
        this.numBolsasAire = numBolsasAire;
    }
}
