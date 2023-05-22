package co.edu.uniquindio.lgz_concessionaire.models;

public class StationWagon extends Automovil{

    private boolean tieneAC;
    private boolean tieneCamaraReversa;
    private boolean tieneABS;

    public StationWagon() {super();}

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
        private StationWagon stationWagon;

        public StationWagonBuilder() {
            stationWagon = new StationWagon();
        }

        public StationWagonBuilder tieneAC(boolean tieneAC) {
            stationWagon.tieneAC = tieneAC;
            return this;
        }

        public StationWagonBuilder tieneCamaraReversa(boolean tieneCamaraReversa) {
            stationWagon.tieneCamaraReversa = tieneCamaraReversa;
            return this;
        }

        public StationWagonBuilder tieneABS(boolean tieneABS) {
            stationWagon.tieneABS = tieneABS;
            return this;
        }

        public StationWagon build() {
            return stationWagon;
        }
    }
}
