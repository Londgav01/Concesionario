package co.edu.uniquindio.lgz_concessionaire.models;

public class Bus extends Automovil{

    private Integer numEjes;
    private Integer numSalidasEmergencia;
    private boolean tieneABS;


    private Bus() {
        super();
    }
    public Integer getNumEjes() {
        return numEjes;
    }

    public Integer getNumSalidasEmergencia() {
        return numSalidasEmergencia;
    }

    public boolean isTieneABS() {
        return tieneABS;
    }

    public static class BusBuilder extends AutomovilBuilder {
        private Bus bus;

        public BusBuilder() {
            bus = new Bus();
        }

        public BusBuilder numEjes(Integer numEjes) {
            bus.numEjes = numEjes;
            return this;
        }

        public BusBuilder numSalidasEmergencia(Integer numSalidasEmergencia) {
            bus.numSalidasEmergencia = numSalidasEmergencia;
            return this;
        }

        public BusBuilder tieneABS(boolean tieneABS) {
            bus.tieneABS = tieneABS;
            return this;
        }

        public Bus build() {
            return bus;
        }
    }
}

