package co.edu.uniquindio.lgz_concessionaire.models;

public class Automovil extends Vehiculo {

    private Integer numPuertas;
    private Integer numPasajeros;
    private Integer numBolsasAire;

    public Automovil(AutomovilBuilder automovilBuilder) {
        super();
        this.numPuertas= automovilBuilder.numPuertas;
        this.numBolsasAire= automovilBuilder.numBolsasAire;
        this.numPasajeros= automovilBuilder.numPasajeros;
    }

    public Automovil() {
        super();
    }

    public Integer getNumPuertas() {
        return numPuertas;
    }

    public Integer getNumPasajeros() {
        return numPasajeros;
    }

    public Integer getNumBolsasAire() {
        return numBolsasAire;
    }

    // Clase interna AutomovilBuilder
    public static class AutomovilBuilder extends VehiculoBuilder {

        private Integer numPuertas;
        private Integer numPasajeros;
        private Integer numBolsasAire;

        public AutomovilBuilder numPuertas(Integer numPuertas) {
            this.numPuertas = numPuertas;
            return this;
        }

        public AutomovilBuilder numPasajeros(Integer numPasajeros) {
            this.numPasajeros = numPasajeros;
            return this;
        }

        public AutomovilBuilder numBolsasAire(Integer numBolsasAire) {
            this.numBolsasAire = numBolsasAire;
            return this;
        }

        public Automovil build() {
            return new Automovil();
        }
    }
}
