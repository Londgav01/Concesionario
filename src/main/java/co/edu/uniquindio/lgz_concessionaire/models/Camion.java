package co.edu.uniquindio.lgz_concessionaire.models;

import jakarta.persistence.*;

@Entity
@Table(schema = "vehiculos", name = "camiones")
public class Camion extends Vehiculo{

    private double capacidadCarga;
    private boolean tieneFrenosAire;
    private int numeroEjes;
    private boolean tieneABS;
    private String tipoCamion;
    private boolean tieneAC;

    public Camion(String marca, String placa, String modelo, int cantidadCambios, double velocidadMaxima, String cilindraje,
                  EstadoVehiculo estadoVehiculo, TipoCombustible tipoCombustible, TipoTransmision tipoTrasmision,
                  double capacidadCarga, boolean tieneFrenosAire, int numeroEjes, boolean tieneABS, String tipoCamion,
                  boolean tieneAC) {
        super(marca, placa, modelo, cantidadCambios, velocidadMaxima, cilindraje, estadoVehiculo, tipoCombustible, tipoTrasmision);
        this.capacidadCarga = capacidadCarga;
        this.tieneFrenosAire = tieneFrenosAire;
        this.numeroEjes = numeroEjes;
        this.tieneABS = tieneABS;
        this.tipoCamion = tipoCamion;
        this.tieneAC = tieneAC;
    }

    public Camion() {}

    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    public boolean isTieneFrenosAire() {
        return tieneFrenosAire;
    }

    public void setTieneFrenosAire(boolean tieneFrenosAire) {
        this.tieneFrenosAire = tieneFrenosAire;
    }

    public int getNumeroEjes() {
        return numeroEjes;
    }

    public void setNumeroEjes(int numeroEjes) {
        this.numeroEjes = numeroEjes;
    }

    public boolean isTieneABS() {
        return tieneABS;
    }

    public void setTieneABS(boolean tieneABS) {
        this.tieneABS = tieneABS;
    }

    public String getTipoCamion() {
        return tipoCamion;
    }

    public void setTipoCamion(String tipoCamion) {
        this.tipoCamion = tipoCamion;
    }

    public boolean isTieneAC() {
        return tieneAC;
    }

    public void setTieneAC(boolean tieneAC) {
        this.tieneAC = tieneAC;
    }
}
