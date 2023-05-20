package co.edu.uniquindio.lgz_concessionaire.models;

public class Administrador extends Empleado {

    private String idAdministrador;

    public Administrador(String nombre, String identificacion, String direccion, String numeroTelefonico, String idEmpleado, String idAdministrador) {
        super(nombre, identificacion, direccion, numeroTelefonico, idEmpleado);
        this.idAdministrador = idAdministrador;
    }

    public String getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(String idAdministrador) {
        this.idAdministrador = idAdministrador;
    }
}
