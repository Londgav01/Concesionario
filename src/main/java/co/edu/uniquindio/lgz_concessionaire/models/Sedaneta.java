package co.edu.uniquindio.lgz_concessionaire.models;

public class Sedaneta extends StationWagon{

    private boolean tieneVelocidadCrucero;
    private boolean tieneSensoresColision;
    private boolean tieneSensorTraficoCruzado;
    private boolean tieneAsistenteCarril;

    public Sedaneta(SedanetaBuilder sedanetaBuilder) {
        super(sedanetaBuilder);
        this.tieneAsistenteCarril= sedanetaBuilder.tieneAsistenteCarril;
        this.tieneVelocidadCrucero= sedanetaBuilder.tieneVelocidadCrucero;
        this.tieneSensoresColision= sedanetaBuilder.tieneSensoresColision;
        this.tieneSensorTraficoCruzado= sedanetaBuilder.tieneSensorTraficoCruzado;
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

        private boolean tieneVelocidadCrucero;
        private boolean tieneSensoresColision;
        private boolean tieneSensorTraficoCruzado;
        private boolean tieneAsistenteCarril;

        public SedanetaBuilder() {Sedaneta sedaneta= new Sedaneta(this);}

        public SedanetaBuilder tieneVelocidadCrucero(boolean tieneVelocidadCrucero) {
            this.tieneVelocidadCrucero = tieneVelocidadCrucero;
            return this;
        }

        public SedanetaBuilder tieneSensoresColision(boolean tieneSensoresColision) {
            this.tieneSensoresColision = tieneSensoresColision;
            return this;
        }

        public SedanetaBuilder tieneSensorTraficoCruzado(boolean tieneSensorTraficoCruzado) {
            this.tieneSensorTraficoCruzado = tieneSensorTraficoCruzado;
            return this;
        }

        public SedanetaBuilder tieneAsistenteCarril(boolean tieneAsistenteCarril) {
            this.tieneAsistenteCarril = tieneAsistenteCarril;
            return this;
        }

        @Override
        public Sedaneta build() {
            return new Sedaneta(this);
        }
    }
}
