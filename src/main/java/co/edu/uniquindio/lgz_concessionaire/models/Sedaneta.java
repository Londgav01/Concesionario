package co.edu.uniquindio.lgz_concessionaire.models;

public class Sedaneta extends StationWagon{

    private boolean tieneVelocidadCrucero;
    private boolean tieneSensoresColision;
    private boolean tieneSensorTraficoCruzado;
    private boolean tieneAsistenteCarril;

    public Sedaneta(String marca, String placa, String modelo, int cantidadCambios, double velocidadMaxima, String cilindraje,
                    EstadoVehiculo estadoVehiculo, TipoCombustible tipoCombustible, TipoTransmision tipoTrasmision,
                    Integer numPuertas, Integer numPasajeros, Integer numBolsasAire, boolean tieneAC, boolean tieneCamaraReversa, boolean tieneABS, boolean tieneVelocidadCrucero, boolean tieneSensoresColision, boolean tieneSensorTraficoCruzado, boolean tieneAsistenteCarril) {
        super(marca, placa, modelo, cantidadCambios, velocidadMaxima, cilindraje, estadoVehiculo, tipoCombustible,
                tipoTrasmision, numPuertas, numPasajeros, numBolsasAire, tieneAC, tieneCamaraReversa, tieneABS);
        this.tieneVelocidadCrucero = tieneVelocidadCrucero;
        this.tieneSensoresColision = tieneSensoresColision;
        this.tieneSensorTraficoCruzado = tieneSensorTraficoCruzado;
        this.tieneAsistenteCarril = tieneAsistenteCarril;
    }

    public Sedaneta() {
        super();
    }

    public boolean isTieneVelocidadCrucero() {
        return tieneVelocidadCrucero;
    }

    public void setTieneVelocidadCrucero(boolean tieneVelocidadCrucero) {
        this.tieneVelocidadCrucero = tieneVelocidadCrucero;
    }

    public boolean isTieneSensoresColision() {
        return tieneSensoresColision;
    }

    public void setTieneSensoresColision(boolean tieneSensoresColision) {
        this.tieneSensoresColision = tieneSensoresColision;
    }

    public boolean isTieneSensorTraficoCruzado() {
        return tieneSensorTraficoCruzado;
    }

    public void setTieneSensorTraficoCruzado(boolean tieneSensorTraficoCruzado) {
        this.tieneSensorTraficoCruzado = tieneSensorTraficoCruzado;
    }

    public boolean isTieneAsistenteCarril() {
        return tieneAsistenteCarril;
    }

    public void setTieneAsistenteCarril(boolean tieneAsistenteCarril) {
        this.tieneAsistenteCarril = tieneAsistenteCarril;
    }
}
