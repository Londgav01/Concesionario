package co.edu.uniquindio.lgz_concessionaire.models;

public class Camioneta extends Sedaneta{

    private boolean is4x4;

    public Camioneta() {super();}

    public boolean isIs4x4() {
        return is4x4;
    }

    public static class CamionetaBuilder extends SedanetaBuilder {

        Camioneta camioneta = new Camioneta();

        public CamionetaBuilder is4x4(boolean is4x4) {
            camioneta.is4x4 = is4x4;
            return this;
        }

        public CamionetaBuilder () {
            Camioneta camioneta = new Camioneta();
        }

        public Camioneta build() {
            return camioneta;
        }
    }
}
