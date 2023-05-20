package co.edu.uniquindio.lgz_concessionaire.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(schema = "vehiculos", name = "deportivos")
public class Deportivo extends Automovil{
    private Double caballosFuerza;
    private Double tiempo100Km;

    public Deportivo(String marca, String placa, String modelo, int cantidadCambios, double velocidadMaxima, String cilindraje,
                     EstadoVehiculo estadoVehiculo, TipoCombustible tipoCombustible, TipoTransmision tipoTrasmision,
                     Integer numPuertas, Integer numPasajeros, Integer numBolsasAire, Double caballosFuerza, Double tiempo100Km) {
        super(marca, placa, modelo, cantidadCambios, velocidadMaxima, cilindraje, estadoVehiculo, tipoCombustible,
                tipoTrasmision, numPuertas, numPasajeros, numBolsasAire);
        this.caballosFuerza = caballosFuerza;
        this.tiempo100Km = tiempo100Km;
    }

    public Deportivo() {}

    public Double getCaballosFuerza() {
        return caballosFuerza;
    }

    public void setCaballosFuerza(Double caballosFuerza) {
        this.caballosFuerza = caballosFuerza;
    }

    public Double getTiempo100Km() {
        return tiempo100Km;
    }

    public void setTiempo100Km(Double tiempo100Km) {
        this.tiempo100Km = tiempo100Km;
    }
}
