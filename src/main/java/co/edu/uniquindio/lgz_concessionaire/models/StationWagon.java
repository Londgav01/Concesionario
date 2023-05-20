package co.edu.uniquindio.lgz_concessionaire.models;

import jakarta.persistence.Entity;

@Entity
public class StationWagon extends Automovil{

    private boolean tieneAC;
    private boolean tieneCamaraReversa;
    private boolean tieneABS;

    public StationWagon(String marca, String placa, String modelo, int cantidadCambios, double velocidadMaxima,
                        String cilindraje, EstadoVehiculo estadoVehiculo, TipoCombustible tipoCombustible,
                        TipoTransmision tipoTrasmision, Integer numPuertas, Integer numPasajeros, Integer numBolsasAire,
                        boolean tieneAC, boolean tieneCamaraReversa, boolean tieneABS) {
        super(marca, placa, modelo, cantidadCambios, velocidadMaxima, cilindraje, estadoVehiculo, tipoCombustible,
                tipoTrasmision, numPuertas, numPasajeros, numBolsasAire);
        this.tieneAC = tieneAC;
        this.tieneCamaraReversa = tieneCamaraReversa;
        this.tieneABS = tieneABS;
    }

    public StationWagon() {}

    public boolean isTieneAC() {
        return tieneAC;
    }

    public void setTieneAC(boolean tieneAC) {
        this.tieneAC = tieneAC;
    }

    public boolean isTieneCamaraReversa() {
        return tieneCamaraReversa;
    }

    public void setTieneCamaraReversa(boolean tieneCamaraReversa) {
        this.tieneCamaraReversa = tieneCamaraReversa;
    }

    public boolean isTieneABS() {
        return tieneABS;
    }

    public void setTieneABS(boolean tieneABS) {
        this.tieneABS = tieneABS;
    }
}
