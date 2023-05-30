package co.edu.uniquindio.lgz_concessionaire.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Administrador extends Empleado implements Serializable {

    private String idAdministrador;

    public Administrador(String idAdministrador) {
        super();
        this.idAdministrador = idAdministrador;
    }

    public Administrador() {}


    public String getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(String idAdministrador) {
        this.idAdministrador = idAdministrador;
    }
}
