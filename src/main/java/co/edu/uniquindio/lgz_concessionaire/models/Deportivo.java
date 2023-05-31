package co.edu.uniquindio.lgz_concessionaire.models;

public class Deportivo extends Automovil{
    private Double caballosFuerza;
    private Double tiempo100Km;

    public Deportivo(DeportivoBuilder deportivoBuilder) {
        super();
        this.tiempo100Km= deportivoBuilder.tiempo100Km;
        this.caballosFuerza= deportivoBuilder.caballosFuerza;
    }
    public Double getCaballosFuerza() {
        return caballosFuerza;
    }

    public Double getTiempo100Km() {
        return tiempo100Km;
    }

    public static class DeportivoBuilder extends AutomovilBuilder {

        private Double caballosFuerza;
        private Double tiempo100Km;


        public DeportivoBuilder caballosFuerza(Double caballosFuerza) {
            this.caballosFuerza = caballosFuerza;
            return this;
        }

        public DeportivoBuilder tiempo100Km(Double tiempo100Km) {
            this.tiempo100Km = tiempo100Km;
            return this;
        }

        public Deportivo build() {
            return new Deportivo(this);
        }
    }
}
