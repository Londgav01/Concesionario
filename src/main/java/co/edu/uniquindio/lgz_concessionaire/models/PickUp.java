package co.edu.uniquindio.lgz_concessionaire.models;

import jakarta.persistence.*;

@Entity
@Table(schema = "vehiculos", name = "pickUps")
public class PickUp extends StationWagon{


    private boolean is4x4;
    private Double capacidadCarga;

    public PickUp(String marca, String placa, String modelo, int cantidadCambios, double velocidadMaxima, String cilindraje,
                  EstadoVehiculo estadoVehiculo, TipoCombustible tipoCombustible, TipoTransmision tipoTrasmision,
                  Integer numPuertas, Integer numPasajeros, Integer numBolsasAire, boolean tieneAC, boolean tieneCamaraReversa,
                  boolean tieneABS, boolean is4x4, Double capacidadCarga) {
        super(marca, placa, modelo, cantidadCambios, velocidadMaxima, cilindraje, estadoVehiculo, tipoCombustible,
                tipoTrasmision, numPuertas, numPasajeros, numBolsasAire, tieneAC, tieneCamaraReversa, tieneABS);
        this.is4x4 = is4x4;
        this.capacidadCarga = capacidadCarga;
    }

    public PickUp() {super();}

    public boolean isIs4x4() {
        return is4x4;
    }

    public void setIs4x4(boolean is4x4) {
        this.is4x4 = is4x4;
    }

    public Double getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(Double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }
}
