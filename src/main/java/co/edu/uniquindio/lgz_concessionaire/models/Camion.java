package co.edu.uniquindio.lgz_concessionaire.models;

public class Camion extends Vehiculo{

    private double capacidadCarga;
    private boolean tieneFrenosAire;
    private int numeroEjes;
    private boolean tieneABS;
    private String tipoCamion;
    private boolean tieneAC;

    private Camion() {
        super();
    }


    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public boolean isTieneFrenosAire() {
        return tieneFrenosAire;
    }

    public int getNumeroEjes() {
        return numeroEjes;
    }

    public boolean isTieneABS() {
        return tieneABS;
    }

    public String getTipoCamion() {
        return tipoCamion;
    }

    public boolean isTieneAC() {
        return tieneAC;
    }

    public static class CamionBuilder extends Vehiculo.VehiculoBuilder {

        Camion camion = new Camion();

        public CamionBuilder capacidadCarga(double capacidadCarga) {
            camion.capacidadCarga = capacidadCarga;
            return this;
        }

        public CamionBuilder tieneFrenosAire(boolean tieneFrenosAire) {
            camion.tieneFrenosAire = tieneFrenosAire;
            return this;
        }

        public CamionBuilder numeroEjes(int numeroEjes) {
            camion.numeroEjes = numeroEjes;
            return this;
        }

        public CamionBuilder tieneABS(boolean tieneABS) {
            camion.tieneABS = tieneABS;
            return this;
        }

        public CamionBuilder tipoCamion(String tipoCamion) {
            camion.tipoCamion = tipoCamion;
            return this;
        }

        public CamionBuilder tieneAC(boolean tieneAC) {
            camion.tieneAC = tieneAC;
            return this;
        }

        @Override
        public Camion build() {
            return camion;
        }
    }
}
