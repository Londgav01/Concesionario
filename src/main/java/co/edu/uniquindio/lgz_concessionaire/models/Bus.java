package co.edu.uniquindio.lgz_concessionaire.models;

public class Bus extends Automovil{

    private Integer numEjes;
    private Integer numSalidasEmergencia;
    private boolean tieneABS;

    Bus(BusBuilder busBuilder) {
        super();
        this.numEjes= busBuilder.numEjes;
        this.numSalidasEmergencia= busBuilder.numSalidasEmergencia;
        this.tieneABS= busBuilder.tieneABS;

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
        private Integer numEjes;
        private Integer numSalidasEmergencia;
        private boolean tieneABS;

        public BusBuilder numEjes(Integer numEjes) {
            this.numEjes = numEjes;
            return this;
        }

        public BusBuilder numSalidasEmergencia(Integer numSalidasEmergencia) {
            this.numSalidasEmergencia = numSalidasEmergencia;
            return this;
        }

        public BusBuilder tieneABS(boolean tieneABS) {
            this.tieneABS = tieneABS;
            return this;
        }

        public Bus build() {
            return new Bus(this);
        }
    }
}

