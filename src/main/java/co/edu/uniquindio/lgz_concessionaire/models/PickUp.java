package co.edu.uniquindio.lgz_concessionaire.models;

public class PickUp extends StationWagon {
    private boolean is4x4;
    private Double capacidadCarga;

    PickUp(PickUpBuilder pickUpBuilder) {
        super(pickUpBuilder);
        this.capacidadCarga= pickUpBuilder.capacidadCarga;
        this.is4x4= pickUpBuilder.is4x4;
    }

    // Getters para los atributos

    public boolean is4x4() {
        return is4x4;
    }

    public Double getCapacidadCarga() {
        return capacidadCarga;
    }

    public static class PickUpBuilder extends StationWagonBuilder {

        private boolean is4x4;
        private Double capacidadCarga;

        public PickUpBuilder() {
            PickUp pickUp= new PickUp(this);
        }

        public PickUpBuilder is4x4(boolean is4x4) {
            this.is4x4 = is4x4;
            return this;
        }

        public PickUpBuilder capacidadCarga(Double capacidadCarga) {
            this.capacidadCarga = capacidadCarga;
            return this;
        }

        @Override
        public PickUp build() {
            return new PickUp(this);
        }
    }
}