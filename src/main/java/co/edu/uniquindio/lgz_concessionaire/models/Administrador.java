package co.edu.uniquindio.lgz_concessionaire.models;

public class Administrador extends Empleado {

    private String idAdministrador;

    public Administrador(String idAdministrador) {
        super();
        this.idAdministrador = idAdministrador;
    }

    public String getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(String idAdministrador) {
        this.idAdministrador = idAdministrador;
    }
}
