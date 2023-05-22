package co.edu.uniquindio.lgz_concessionaire.models;

public class PickUp extends StationWagon {
    private boolean is4x4;
    private Double capacidadCarga;

    private PickUp() {
        super();
    }

    // Getters para los atributos

    public boolean is4x4() {
        return is4x4;
    }

    public Double getCapacidadCarga() {
        return capacidadCarga;
    }

    public static class PickUpBuilder extends StationWagonBuilder {

        PickUp pickUp= new PickUp();

        public PickUpBuilder() {
            PickUp pickUp= new PickUp();
        }

        public PickUpBuilder is4x4(boolean is4x4) {
            pickUp.is4x4 = is4x4;
            return this;
        }

        public PickUpBuilder capacidadCarga(Double capacidadCarga) {
            pickUp.capacidadCarga = capacidadCarga;
            return this;
        }

        @Override
        public PickUp build() {
            return pickUp;
        }
    }
}