package co.edu.uniquindio.lgz_concessionaire.models;

public class Moto extends Vehiculo{

    public Moto() {
        super(precio);
    }
    public static class MotoBuilder extends VehiculoBuilder {
        Moto moto= new Moto();
        @Override
        public Moto build() {
            return moto;
        }
    }
}
