package co.edu.uniquindio.lgz_concessionaire.models;

import jakarta.persistence.*;

@Entity
@Table(schema = "vehiculos", name = "camionetas")
public class Camioneta extends Sedaneta{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private boolean is4x4;

    public Camioneta(String marca, String placa, String modelo, int cantidadCambios, double velocidadMaxima, String cilindraje,
                     EstadoVehiculo estadoVehiculo, TipoCombustible tipoCombustible, TipoTransmision tipoTrasmision, Integer numPuertas,
                     Integer numPasajeros, Integer numBolsasAire, boolean tieneAC, boolean tieneCamaraReversa, boolean tieneABS,
                     boolean tieneVelocidadCrucero, boolean tieneSensoresColision, boolean isTieneSensorTraficoCruzado,
                     boolean isTieneAsistenteCarril, boolean is4x4) {
        super(marca, placa, modelo, cantidadCambios, velocidadMaxima, cilindraje, estadoVehiculo, tipoCombustible, tipoTrasmision, numPuertas,
                numPasajeros, numBolsasAire, tieneAC, tieneCamaraReversa, tieneABS, tieneVelocidadCrucero, tieneSensoresColision,
                isTieneSensorTraficoCruzado, isTieneAsistenteCarril);
        this.is4x4 = is4x4;
    }



    public boolean isIs4x4() {
        return is4x4;
    }

    public void setIs4x4(boolean is4x4) {
        this.is4x4 = is4x4;
    }
}
