package co.edu.uniquindio.lgz_concessionaire.models;

public class Automovil extends Vehiculo {

    private Integer numPuertas;
    private Integer numPasajeros;
    private Integer numBolsasAire;

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
        private Automovil automovil;

        public AutomovilBuilder() {
            automovil = new Automovil();
        }

        public AutomovilBuilder numPuertas(Integer numPuertas) {
            automovil.numPuertas = numPuertas;
            return this;
        }

        public AutomovilBuilder numPasajeros(Integer numPasajeros) {
            automovil.numPasajeros = numPasajeros;
            return this;
        }

        public AutomovilBuilder numBolsasAire(Integer numBolsasAire) {
            automovil.numBolsasAire = numBolsasAire;
            return this;
        }

        public Automovil build() {
            return automovil;
        }
    }
}
