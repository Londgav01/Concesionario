package co.edu.uniquindio.lgz_concessionaire.models;


public class Van extends StationWagon{
    public Van(String marca, String placa, String modelo, int cantidadCambios, double velocidadMaxima,
               String cilindraje, EstadoVehiculo estadoVehiculo, TipoCombustible tipoCombustible, TipoTransmision tipoTrasmision,
               Integer numPuertas, Integer numPasajeros, Integer numBolsasAire, boolean tieneAC, boolean tieneCamaraReversa,
               boolean tieneABS) {
        super(marca, placa, modelo, cantidadCambios, velocidadMaxima, cilindraje, estadoVehiculo, tipoCombustible,
                tipoTrasmision, numPuertas, numPasajeros, numBolsasAire, tieneAC, tieneCamaraReversa, tieneABS);
    }

    public Van() {}
}
