package co.edu.uniquindio.lgz_concessionaire.models;

import co.edu.uniquindio.lgz_concessionaire.exceptions.EmpleadoException;
import co.edu.uniquindio.lgz_concessionaire.exceptions.UsuarioExcepction;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "concesionario")
public class Concesionario implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "concesionario", orphanRemoval = true)
    private List<Cliente> listaClientes = new ArrayList<>();

    @OneToMany(mappedBy = "concesionario", orphanRemoval = true)
    private List<Proveedor> listaProveedores = new ArrayList<>();

    @OneToMany(mappedBy = "concesionario", orphanRemoval = true)
    private List<Vehiculo> listaVehiculos = new ArrayList<>();

    @OneToMany(mappedBy = "concesionario", orphanRemoval = true)
    private List<Empleado> listaEmpleados = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "administrador_id")
    private Administrador administrador;

    @OneToMany(mappedBy = "concesionario", orphanRemoval = true)
    private List<Transaccion> listaTransacciones = new ArrayList<>();

    /**
     *  Constructor y methods getter and setter
     */
    public Concesionario() {}

    public Concesionario(String name) {
        this.name = name;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public List<Proveedor> getListaProveedores() {
        return listaProveedores;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    public void seListaProveedores(List<Proveedor> listaProveedores) {
        this.listaProveedores = listaProveedores;
    }

    public void setListaProveedores(List<Proveedor> listaProveedores) {
        this.listaProveedores = listaProveedores;
    }

    public List<Transaccion> getListaTransacciones() {
        return listaTransacciones;
    }

    public void setListaTransacciones(List<Transaccion> listaTransacciones) {
        this.listaTransacciones = listaTransacciones;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    ////////////////////////////////////////////////////////////////////////
    //Metodo CRUD empleado

    public Empleado crearEmpleado(String nombre, String identificacion, String direccion, String numeroTelefonico, String contrasenia) throws EmpleadoException{
        Empleado empleado = (Empleado) new Empleado.EmpleadoBuilder()
                .contraEmpleado(contrasenia)
                .withNombre(nombre)
                .withId(identificacion)
                .withDireccion(direccion)
                .withNumeroTelefonico(numeroTelefonico)
                .build();
        if(verificarEmpleado(empleado.getIdentificacion())){
            throw new EmpleadoException("El empleado ya existe");
        }
        listaEmpleados.add(empleado);
        return empleado;
    }

    public Empleado buscarEmpleado(String identificacion, String contrasenia) throws EmpleadoException{
        for (Empleado empleado : listaEmpleados) {
            if(empleado.getIdentificacion().equals(identificacion) && empleado.getContrasenia().equals(contrasenia)){
                return empleado;
            }
        }
        throw new EmpleadoException("El empleado no se ha encontrado");
    }

    public Empleado buscarEmpleadoIdentificacion(String identificacion) throws EmpleadoException {
        for (Empleado empleado: listaEmpleados) {
            if(empleado.equals(identificacion)){
                return empleado;
            }
        }
        throw new EmpleadoException("El empleado no se ha encontrado");
    }

    public void actualizarEmpleado (String nombre, String direccion, String numeroTelefonico, String idEmpleado, String contrasenia) throws EmpleadoException{
        if(buscarEmpleadoIdentificacion(idEmpleado) != null) {
            for (Empleado empleado : listaEmpleados) {
                if (empleado.equals(idEmpleado)){
                    empleado.setDireccion(direccion);
                    empleado.setNombre(nombre);
                    empleado.setNumeroTelefonico(numeroTelefonico);
                    empleado.setContrasenia(contrasenia);
                    break;
                }
            }
        }
    }

    public Empleado buscarEmpleadoRoyer (String idEmpleado){
        for (Empleado empleado: listaEmpleados
             ) {
            if(empleado.getId().equals(idEmpleado)){
                return empleado;
            }

        }
        return null;
    }

    public void actualizarEmpleado2 (String nombre, String direccion, String numeroTelefonico, String idEmpleado) throws EmpleadoException {
        for (Empleado empleado: listaEmpleados) {
            if(buscarEmpleadoRoyer(idEmpleado) != null){
                empleado.setDireccion(direccion);
                empleado.setNombre(nombre);
                empleado.setNumeroTelefonico(numeroTelefonico);

            }
        }

    }

    public boolean verificarEmpleado(String idEmpleado){
        return listaEmpleados.stream().anyMatch(e -> e.equals(idEmpleado));
    }


    public boolean eliminarEmpleado (String idEmpleado) throws EmpleadoException{
        for (Empleado empleado : listaEmpleados) {
            if(empleado.getIdentificacion().equals(idEmpleado) ){
                listaEmpleados.remove(empleado);
                return true;
            }
        }
        return false;
    }

    /////////////////////////////////////////////////Métodos CRUD Cliente//////////////////////////////////////////////////////////

    public void crearCliente(String nombre, String identificacion, String direccion, String numeroTelefonico) throws UsuarioExcepction {
        Persona cliente= new Persona.PersonaBuilder()
                .withNombre(nombre)
                .withDireccion(direccion)
                .withNumeroTelefonico(numeroTelefonico)
                .withId(identificacion)
                .build();
        if(verificarCliente(cliente.getIdentificacion())){
            throw new UsuarioExcepction("El cliente ya existe");
        }
        listaClientes.add((Cliente) cliente);
    }

    public boolean verificarCliente(String identificacion){
        return listaClientes.stream().anyMatch(c -> c.getIdentificacion().equals(identificacion));
    }

    public void actualizarCliente(String nombre, String identificacion, String direccion,
                                  String numTelefono)throws UsuarioExcepction{
        if(identificacion!=null){
            for (Cliente cliente: listaClientes) {
                if(cliente.getIdentificacion().equals(identificacion)){
                    Persona.PersonaBuilder builder = new Persona.PersonaBuilder(cliente);
                    builder.withNombre(nombre)
                            .withDireccion(direccion)
                            .withNumeroTelefonico(numTelefono)
                            .build();
                }
            }
        }
        throw  new UsuarioExcepction("El cliente no existe, digite la identificación de nuevo");
    }

    public Cliente buscarCliente (String idCliente) throws UsuarioExcepction{
        for (Cliente cliente : listaClientes) {
            if(cliente.getIdentificacion().equals(idCliente)){
                return cliente;
            }
        }


        throw new UsuarioExcepction("El cliente no se ha encontrado");
    }

    public boolean eliminarCliente (String identificacion) throws UsuarioExcepction {
        for (Cliente cliente: listaClientes) {
            if(buscarCliente(identificacion).equals(cliente.getIdentificacion())){
                listaClientes.remove(cliente);
                return true;
            }
        }
        return false;
    }

    //////////////////////////////////////////////////////////////////
    //Metodos CRUD proveedor

    public void crearProveedor(String nombre, String identificacion, String direccion, String num) throws UsuarioExcepction {
        Proveedor proveedor = new Proveedor (nombre, identificacion, direccion, num);
        if(verificarProveedor(proveedor.getIdentificacion())){
            throw new UsuarioExcepction("El proveedor ya existe");
        }
        listaProveedores.add(proveedor);
    }
    public boolean verificarProveedor(String identificacion){
        return listaProveedores.stream().anyMatch(c -> c.getIdentificacion().equals(identificacion));
    }

    public void actualizarProveedor(String nombre, String identificacion, String direccion,
                                  String numTelefono)throws UsuarioExcepction{
        if(identificacion!=null){
            for (Proveedor proveedor: listaProveedores) {
                if(proveedor.getIdentificacion().equals(identificacion)){
                    Persona.PersonaBuilder builder = new Persona.PersonaBuilder(proveedor);
                    builder.withNombre(nombre)
                            .withDireccion(direccion)
                            .withNumeroTelefonico(numTelefono)
                            .build();
                }
            }
        }
        throw  new UsuarioExcepction("El cliente no existe, digite la identificación de nuevo");
    }

    public Proveedor buscarProveedor (String idProveedor) throws UsuarioExcepction{
        for (Proveedor proveedor : listaProveedores) {
            if(proveedor.getIdentificacion().equals(idProveedor)){
                return proveedor;
            }
        }
        throw new UsuarioExcepction("El proveedor no se ha encontrado");
    }

    ////////////////////////////////////////////////////////////////////////////
    //CRUD vehiculos
    public boolean eliminarVehiculo (String placa){
        boolean eliminado = false;
        for (Vehiculo vehiculo: listaVehiculos) {
            if(buscarVehiculo(placa).equals(vehiculo.getPlaca())){
                listaVehiculos.remove(vehiculo);
                eliminado = true;
            }
        }
        return eliminado;
    }

    public Sedan crearSedan (String marca, String placa, String modelo, int cantidadCambios, double velocidadMaxima,
                             String cilindraje, EstadoVehiculo estadoVehiculo, TipoCombustible tipoCombustible,
                             TipoTransmision tipoTrasmision, int numPuertas, int numPasajeros, int numBolsasAire, boolean aC,
                             boolean camaraReversa, boolean aBS, boolean velocidadCrucero, boolean sensoresColision,
                             boolean sensorTraficoCruzado, boolean asistenteCarril){
        Sedan sedan = (Sedan) new Sedaneta.SedanetaBuilder()
                .setMarca(marca)
                .setPlaca(placa)
                .setModelo(modelo)
                .setCantidadCambios(cantidadCambios)
                .setVelocidadMaxima(velocidadMaxima)
                .setCilindraje(cilindraje)
                .setEstadoVehiculo(estadoVehiculo).setTipoCombustible(tipoCombustible)
                .setTipoTransmision(tipoTrasmision)
                .build();
        return sedan;
    }



    public Deportivo crearDeportivo(String marca, String placa, String modelo, int cantidadCambios, double velocidadMaxima,
                                    String cilindraje, EstadoVehiculo estadoVehiculo, TipoCombustible tipoCombustible,
                                    TipoTransmision tipoTrasmision, int numPuertas, int numPasajeros, int numBolsasAire, Double tiempo100Km, Double caballosFuerza){
        Deportivo deportivo = (Deportivo) new Deportivo.DeportivoBuilder()
                .caballosFuerza(caballosFuerza)
                .tiempo100Km(tiempo100Km)
                .numBolsasAire(numBolsasAire)
                .numPuertas(numPuertas)
                .numPasajeros(numPasajeros)
                .setMarca(marca)
                .setPlaca(placa)
                .setModelo(modelo)
                .setCantidadCambios(cantidadCambios)
                .setVelocidadMaxima(velocidadMaxima)
                .setCilindraje(cilindraje)
                .setEstadoVehiculo(estadoVehiculo)
                .setTipoCombustible(tipoCombustible)
                .setTipoTransmision(tipoTrasmision)
                .build();

        return deportivo;
    }



    public Camioneta crearCamioneta (String marca, String placa, String modelo, int cantidadCambios, double velocidadMaxima,
                                     String cilindraje, EstadoVehiculo estadoVehiculo, TipoCombustible tipoCombustible,
                                     TipoTransmision tipoTrasmision, int numPuertas, int numPasajeros, int numBolsasAire, boolean aC,
                                     boolean camaraReversa, boolean aBS, boolean velocidadCrucero, boolean sensoresColision,
                                     boolean sensorTraficoCruzado, boolean asistenteCarril, boolean is4x4){
        Camioneta camioneta = (Camioneta) new Camioneta.CamionetaBuilder()
                .is4x4(is4x4)
                .tieneAsistenteCarril(asistenteCarril)
                .tieneSensorTraficoCruzado(sensorTraficoCruzado)
                .tieneSensoresColision(sensoresColision)
                .tieneVelocidadCrucero(velocidadCrucero)
                .tieneABS(aBS)
                .tieneCamaraReversa(camaraReversa)
                .numBolsasAire(numBolsasAire)
                .numPasajeros(numPasajeros)
                .numPuertas(numPuertas)
                .setMarca(marca)
                .setPlaca(placa)
                .setModelo(modelo)
                .setCantidadCambios(cantidadCambios)
                .setVelocidadMaxima(velocidadMaxima)
                .setCilindraje(cilindraje)
                .setEstadoVehiculo(estadoVehiculo)
                .setTipoCombustible(tipoCombustible)
                .setTipoTransmision(tipoTrasmision)
                .build();

        return camioneta;
    }


    public Camion crearCamion (String marca, String placa, String modelo, int cantidadCambios, double velocidadMaxima,
                               String cilindraje, EstadoVehiculo estadoVehiculo, TipoCombustible tipoCombustible,
                               TipoTransmision tipoTrasmision, double capacidadCarga, boolean tieneFrenosAire, int numeroEjes, boolean tieneABS, String tipoCamion, boolean tieneAC){
        Camion camion = (Camion) new Camion.CamionBuilder()
                .numeroEjes(numeroEjes)
                .capacidadCarga(capacidadCarga)
                .tieneFrenosAire(tieneFrenosAire)
                .setTipoTransmision(tipoTrasmision)
                .setMarca(marca)
                .setPlaca(placa)
                .setModelo(modelo)
                .setCantidadCambios(cantidadCambios)
                .setVelocidadMaxima(velocidadMaxima)
                .setCilindraje(cilindraje)
                .setEstadoVehiculo(estadoVehiculo)
                .setTipoCombustible(tipoCombustible)
                .setTipoTransmision(tipoTrasmision)
                .build();
        return camion;
    }




    public Moto crearMoto (String marca, EstadoVehiculo estadoVehiculo, String modelo, int cambios, float velocidadMaxima,
                           String cilindraje, String placa){
        Moto moto = (Moto) new Moto.MotoBuilder()
                .setMarca(marca)
                .setPlaca(placa)
                .setEstadoVehiculo(estadoVehiculo)
                .setModelo(modelo)
                .setCantidadCambios(cambios)
                .setVelocidadMaxima(velocidadMaxima)
                .setCilindraje(cilindraje)
                .build();
        return moto;

    }

    public Bus crearBus (String marca, String placa, String modelo, int cantidadCambios, double velocidadMaxima,
                         String cilindraje, EstadoVehiculo estadoVehiculo, TipoCombustible tipoCombustible,
                         TipoTransmision tipoTrasmision, int numPuertas, int numPasajeros, int numBolsasAire, int numEjes, int numSalidas, boolean tieneAbs){
        Bus bus = (Bus) new Bus.BusBuilder()
                .numEjes(numEjes)
                .numSalidasEmergencia(numSalidas)
                .tieneABS(tieneAbs)
                .numPuertas(numPuertas)
                .numPasajeros(numPasajeros)
                .numBolsasAire(numBolsasAire)
                .setCantidadCambios(cantidadCambios)
                .setVelocidadMaxima(velocidadMaxima)
                .setCilindraje(cilindraje)
                .setEstadoVehiculo(estadoVehiculo)
                .setTipoCombustible(tipoCombustible)
                .setTipoTransmision(tipoTrasmision)
                .setMarca(marca)
                .setPlaca(placa)
                .setModelo(modelo)
                .build();


        return  bus;
    }

    public PickUp crearPick (String marca, String placa, String modelo, int cantidadCambios, double velocidadMaxima,
                             String cilindraje, EstadoVehiculo estadoVehiculo, TipoCombustible tipoCombustible,
                             TipoTransmision tipoTrasmision, int numPuertas, int numPasajeros, int numBolsasAire, boolean aC,
                             boolean camaraReversa, boolean aBS, boolean is4x4, double capacidadCarga){
        PickUp pick = (PickUp) new PickUp.PickUpBuilder()
                .is4x4(is4x4)
                .capacidadCarga(capacidadCarga)
                .tieneAC(aC)
                .tieneABS(aBS)
                .tieneCamaraReversa(camaraReversa)
                .numBolsasAire(numBolsasAire)
                .numPasajeros(numPasajeros)
                .numPuertas(numPuertas)
                .setMarca(marca)
                .setPlaca(placa)
                .setModelo(modelo)
                .setCantidadCambios(cantidadCambios)
                .setVelocidadMaxima(velocidadMaxima)
                .setCilindraje(cilindraje)
                .setEstadoVehiculo(estadoVehiculo)
                .setTipoTransmision(tipoTrasmision)
                .setTipoCombustible(tipoCombustible)
                .build();
        return pick;
    }

    public Van crearVan (String marca, String placa, String modelo, int cantidadCambios, double velocidadMaxima,
                         String cilindraje, EstadoVehiculo estadoVehiculo, TipoCombustible tipoCombustible,
                         TipoTransmision tipoTrasmision, int numPuertas, int numPasajeros, int numBolsasAire, boolean aC,
                         boolean camaraReversa, boolean aBS){
        Van van = (Van) new StationWagon.StationWagonBuilder()
                .tieneAC(aC)
                .tieneABS(aBS)
                .tieneCamaraReversa(camaraReversa)
                .numBolsasAire(numBolsasAire)
                .numPasajeros(numPasajeros)
                .numPuertas(numPuertas)
                .setMarca(marca)
                .setPlaca(placa)
                .setModelo(modelo)
                .setCantidadCambios(cantidadCambios)
                .setVelocidadMaxima(velocidadMaxima)
                .setCilindraje(cilindraje)
                .setEstadoVehiculo(estadoVehiculo)
                .setTipoTransmision(tipoTrasmision)
                .setTipoCombustible(tipoCombustible)
                .build();
        return van;
    }



}
