package co.edu.uniquindio.lgz_concessionaire.models;

public class Deportivo extends Automovil{
    private Double caballosFuerza;
    private Double tiempo100Km;

    public Deportivo() {super();}
    public Double getCaballosFuerza() {
        return caballosFuerza;
    }

    public Double getTiempo100Km() {
        return tiempo100Km;
    }

    public static class DeportivoBuilder extends AutomovilBuilder {

        private Deportivo deportivo;

        public DeportivoBuilder() {
            deportivo = new Deportivo();
        }

        public DeportivoBuilder caballosFuerza(Double caballosFuerza) {
            deportivo.caballosFuerza = caballosFuerza;
            return this;
        }

        public DeportivoBuilder tiempo100Km(Double tiempo100Km) {
            deportivo.tiempo100Km = tiempo100Km;
            return this;
        }

        public Deportivo build() {
            return deportivo;
        }
    }
}
