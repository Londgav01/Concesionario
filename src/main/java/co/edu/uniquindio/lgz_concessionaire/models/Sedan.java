package co.edu.uniquindio.lgz_concessionaire.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(schema = "vehiculos", name = "sedan")
public class Sedan extends Sedaneta{

    public Sedan(String marca, String placa, String modelo, int cantidadCambios, double velocidadMaxima, String cilindraje,
                 EstadoVehiculo estadoVehiculo, TipoCombustible tipoCombustible, TipoTransmision tipoTrasmision,
                 Integer numPuertas, Integer numPasajeros, Integer numBolsasAire, boolean tieneAC, boolean tieneCamaraReversa,
                 boolean tieneABS, boolean tieneVelocidadCrucero, boolean tieneSensoresColision, boolean isTieneSensorTraficoCruzado, boolean isTieneAsistenteCarril) {
        super(marca, placa, modelo, cantidadCambios, velocidadMaxima, cilindraje, estadoVehiculo, tipoCombustible,
                tipoTrasmision, numPuertas, numPasajeros, numBolsasAire, tieneAC, tieneCamaraReversa, tieneABS,
                tieneVelocidadCrucero, tieneSensoresColision, isTieneSensorTraficoCruzado, isTieneAsistenteCarril);
    }

    public Sedan() {super();}
}
