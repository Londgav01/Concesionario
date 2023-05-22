package co.edu.uniquindio.lgz_concessionaire.models;


 public class Persona {

     private String nombre;
     private String identificacion;
     private String direccion;
     private String numeroTelefonico;

     private Persona() {}

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

