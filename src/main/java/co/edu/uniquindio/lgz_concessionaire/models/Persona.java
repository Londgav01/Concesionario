package co.edu.uniquindio.lgz_concessionaire.models;


 public class Persona {

     private String nombre;
     private String identificacion;
     private String direccion;
     private String numeroTelefonico;

     private Persona() {}

     public Persona(String nombre, String identificacion, String direccion, String num){
         this.nombre = nombre;
         this.identificacion = identificacion;
         this.direccion = direccion;
         this.numeroTelefonico = num;
     }

     public String getNombre() {
         return nombre;
     }

     public String getIdentificacion() {
         return identificacion;
     }

     public String getDireccion() {
         return direccion;
     }

     public String getNumeroTelefonico() {
         return numeroTelefonico;
     }

     public void setNombre(String nombre) {
         this.nombre = nombre;
     }

     public void setIdentificacion(String identificacion) {
         this.identificacion = identificacion;
     }

     public void setDireccion(String direccion) {
         this.direccion = direccion;
     }

     public void setNumeroTelefonico(String numeroTelefonico) {
         this.numeroTelefonico = numeroTelefonico;
     }

     // Clase builder
     public static class PersonaBuilder{
         Persona persona = new Persona();
         public PersonaBuilder() {Persona persona = new Persona();}
         public PersonaBuilder(Cliente cliente) {
             persona.nombre = cliente.getNombre();
             persona.identificacion = cliente.getIdentificacion();
             persona.direccion = cliente.getDireccion();
             persona.numeroTelefonico = cliente.getNumeroTelefonico();
         }

         public PersonaBuilder withNombre(String nombre) {
             persona.nombre=nombre;
             return this;
         }

         public PersonaBuilder withId(String identificacion){
             persona.identificacion=identificacion;
             return this;
         }

         public PersonaBuilder withDireccion(String direccion) {
             persona.direccion=direccion;
             return this;
         }

         public PersonaBuilder withNumeroTelefonico(String numeroTelefono) {
             persona.numeroTelefonico=numeroTelefono;
             return this;
         }

         public Persona build() {
             return persona;
         }
     }
}

