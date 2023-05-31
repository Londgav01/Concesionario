package co.edu.uniquindio.lgz_concessionaire.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Administrador extends Empleado implements Serializable {

    private String idAdministrador;

    public Administrador() {
        super();
    }

    public String getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(String idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public static class AdministradorBuilder extends EmpleadoBuilder {
        private String idAdministrador;

        public AdministradorBuilder idAdministrador(String idAdministrador) {
            this.idAdministrador = idAdministrador;
            return this;
        }

        public Administrador build() {
            Administrador administrador = new Administrador();
            administrador.setIdAdministrador(idAdministrador);
            return administrador;
        }
    }
}
