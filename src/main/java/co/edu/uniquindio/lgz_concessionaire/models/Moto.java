package co.edu.uniquindio.lgz_concessionaire.models;

import jakarta.persistence.*;

@Entity
@Table(schema = "vehiculos",name = "motos")
public class Moto extends Vehiculo{

    public Moto(String marca, String placa, String modelo, int cantidadCambios, double velocidadMaxima, String cilindraje,
                EstadoVehiculo estadoVehiculo, TipoCombustible tipoCombustible, TipoTransmision tipoTrasmision) {
        super(marca, placa, modelo, cantidadCambios, velocidadMaxima, cilindraje, estadoVehiculo, tipoCombustible, tipoTrasmision);
    }

    public Moto() {}
}
