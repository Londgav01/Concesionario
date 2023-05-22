package co.edu.uniquindio.lgz_concessionaire.models;

public class Sedaneta extends StationWagon{

    private boolean tieneVelocidadCrucero;
    private boolean tieneSensoresColision;
    private boolean tieneSensorTraficoCruzado;
    private boolean tieneAsistenteCarril;

    public Sedaneta() {
        super();
    }

    public boolean isTieneVelocidadCrucero() {
        return tieneVelocidadCrucero;
    }

    public boolean isTieneSensoresColision() {
        return tieneSensoresColision;
    }

    public boolean isTieneSensorTraficoCruzado() {
        return tieneSensorTraficoCruzado;
    }

    public boolean isTieneAsistenteCarril() {
        return tieneAsistenteCarril;
    }

    public static class SedanetaBuilder extends StationWagonBuilder {
        Sedaneta sedaneta= new Sedaneta();

        public SedanetaBuilder() {Sedaneta sedaneta= new Sedaneta();}

        public SedanetaBuilder tieneVelocidadCrucero(boolean tieneVelocidadCrucero) {
            sedaneta.tieneVelocidadCrucero = tieneVelocidadCrucero;
            return this;
        }

        public SedanetaBuilder tieneSensoresColision(boolean tieneSensoresColision) {
            sedaneta.tieneSensoresColision = tieneSensoresColision;
            return this;
        }

        public SedanetaBuilder tieneSensorTraficoCruzado(boolean tieneSensorTraficoCruzado) {
            sedaneta.tieneSensorTraficoCruzado = tieneSensorTraficoCruzado;
            return this;
        }

        public SedanetaBuilder tieneAsistenteCarril(boolean tieneAsistenteCarril) {
            sedaneta.tieneAsistenteCarril = tieneAsistenteCarril;
            return this;
        }

        @Override
        public Sedaneta build() {
            return sedaneta;
        }
    }
}
