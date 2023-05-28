package co.edu.uniquindio.lgz_concessionaire.models;

import jakarta.persistence.*;


public class Proveedor extends Persona{

    private Long id;
    public Proveedor(String nombre, String identificacion, String direccion, String num) {
        super(nombre, identificacion, direccion, num);
    }

    public Proveedor() {}
}
