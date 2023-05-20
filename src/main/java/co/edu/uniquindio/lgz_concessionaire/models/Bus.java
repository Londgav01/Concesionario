package co.edu.uniquindio.lgz_concessionaire.models;

public class Bus extends Automovil{

    private Integer numEjes;
    private Integer numSalidasEmergencia;
    private boolean tieneABS;

    public Bus(String marca, String placa, String modelo, int cantidadCambios, double velocidadMaxima,
               String cilindraje, EstadoVehiculo estadoVehiculo, TipoCombustible tipoCombustible, TipoTransmision tipoTrasmision,
               Integer numPuertas, Integer numPasajeros, Integer numBolsasAire, Integer numEjes, Integer numSalidasEmergencia,
               boolean tieneABS) {
        super(marca, placa, modelo, cantidadCambios, velocidadMaxima, cilindraje, estadoVehiculo,
                tipoCombustible, tipoTrasmision, numPuertas, numPasajeros, numBolsasAire);
        this.numEjes = numEjes;
        this.numSalidasEmergencia = numSalidasEmergencia;
        this.tieneABS = tieneABS;
    }

    public Bus() {super();}

    public Integer getNumEjes() {
        return numEjes;
    }

    public void setNumEjes(Integer numEjes) {
        this.numEjes = numEjes;
    }

    public Integer getNumSalidasEmergencia() {
        return numSalidasEmergencia;
    }

    public void setNumSalidasEmergencia(Integer numSalidasEmergencia) {
        this.numSalidasEmergencia = numSalidasEmergencia;
    }

    public boolean isTieneABS() {
        return tieneABS;
    }

    public void setTieneABS(boolean tieneABS) {
        this.tieneABS = tieneABS;
    }
}

