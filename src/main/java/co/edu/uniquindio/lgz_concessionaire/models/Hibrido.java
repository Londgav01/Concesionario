package co.edu.uniquindio.lgz_concessionaire.models;

public class Hibrido extends TipoCombustible{
    private boolean esEnchufable;
    private boolean esLigero;

    public Hibrido(boolean esEnchufable, boolean esLigero) {
        this.esEnchufable = esEnchufable;
        this.esLigero = esLigero;
    }

    public boolean isEsEnchufable() {
        return esEnchufable;
    }

    public void setEsEnchufable(boolean esEnchufable) {
        this.esEnchufable = esEnchufable;
    }

    public boolean isEsLigero() {
        return esLigero;
    }

    public void setEsLigero(boolean esLigero) {
        this.esLigero = esLigero;
    }
}
