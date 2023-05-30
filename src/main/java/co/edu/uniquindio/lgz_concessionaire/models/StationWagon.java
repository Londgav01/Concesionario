package co.edu.uniquindio.lgz_concessionaire.models;

public class StationWagon extends Automovil{

    private boolean tieneAC;
    private boolean tieneCamaraReversa;
    private boolean tieneABS;

    public StationWagon(StationWagonBuilder stationWagonBuilder) {
        super(stationWagonBuilder);
        this.tieneAC= stationWagonBuilder.tieneAC;
        this.tieneCamaraReversa= stationWagonBuilder.tieneCamaraReversa;
        this.tieneABS= stationWagonBuilder.tieneABS;
    }

    public boolean isTieneAC() {
        return tieneAC;
    }

    public boolean isTieneCamaraReversa() {
        return tieneCamaraReversa;
    }

    public boolean isTieneABS() {
        return tieneABS;
    }

    public static class StationWagonBuilder extends AutomovilBuilder {
        private boolean tieneAC;
        private boolean tieneCamaraReversa;
        private boolean tieneABS;

        public StationWagonBuilder tieneAC(boolean tieneAC) {
            this.tieneAC = tieneAC;
            return this;
        }

        public StationWagonBuilder tieneCamaraReversa(boolean tieneCamaraReversa) {
            this.tieneCamaraReversa = tieneCamaraReversa;
            return this;
        }

        public StationWagonBuilder tieneABS(boolean tieneABS) {
            this.tieneABS = tieneABS;
            return this;
        }

        public StationWagon build() {
            return new StationWagon(this);
        }
    }
}
