package co.edu.uniquindio.lgz_concessionaire.models;

public class Electrico extends TipoCombustible{
    private double autonomiaCarga;
    private double tiempoCarga;

    public Electrico(double autonomiaCarga, double tiempoCarga) {
        this.autonomiaCarga = autonomiaCarga;
        this.tiempoCarga = tiempoCarga;
    }

    public double getAutonomiaCarga() {
        return autonomiaCarga;
    }

    public void setAutonomiaCarga(double autonomiaCarga) {
        this.autonomiaCarga = autonomiaCarga;
    }

    public double getTiempoCarga() {
        return tiempoCarga;
    }

    public void setTiempoCarga(double tiempoCarga) {
        this.tiempoCarga = tiempoCarga;
    }
}
