package co.edu.uniquindio.lgz_concessionaire.models;

public class Camion extends Vehiculo{

    private double capacidadCarga;
    private boolean tieneFrenosAire;
    private int numeroEjes;
    private boolean tieneABS;
    private String tipoCamion;
    private boolean tieneAC;

    Camion(CamionBuilder camionBuilder) {
        super();
        this.capacidadCarga= camionBuilder.capacidadCarga;
        this.tipoCamion= camionBuilder.tipoCamion;
        this.tieneABS= camionBuilder.tieneABS;
        this.numeroEjes= camionBuilder.numeroEjes;
        this.tieneFrenosAire= camionBuilder.tieneFrenosAire;
        this.tieneAC= camionBuilder.tieneAC;
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

        private double capacidadCarga;
        private boolean tieneFrenosAire;
        private int numeroEjes;
        private boolean tieneABS;
        private String tipoCamion;
        private boolean tieneAC;

        public CamionBuilder capacidadCarga(double capacidadCarga) {
            this.capacidadCarga = capacidadCarga;
            return this;
        }

        public CamionBuilder tieneFrenosAire(boolean tieneFrenosAire) {
            this.tieneFrenosAire = tieneFrenosAire;
            return this;
        }

        public CamionBuilder numeroEjes(int numeroEjes) {
            this.numeroEjes = numeroEjes;
            return this;
        }

        public CamionBuilder tieneABS(boolean tieneABS) {
            this.tieneABS = tieneABS;
            return this;
        }

        public CamionBuilder tipoCamion(String tipoCamion) {
            this.tipoCamion = tipoCamion;
            return this;
        }

        public CamionBuilder tieneAC(boolean tieneAC) {
            this.tieneAC = tieneAC;
            return this;
        }

        @Override
        public Camion build() {
            return new Camion(this);
        }
    }
}
