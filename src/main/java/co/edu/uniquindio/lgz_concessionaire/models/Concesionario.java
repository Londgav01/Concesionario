package co.edu.uniquindio.lgz_concessionaire.models;

import co.edu.uniquindio.lgz_concessionaire.exceptions.EmpleadoException;
import co.edu.uniquindio.lgz_concessionaire.exceptions.TransactionException;
import co.edu.uniquindio.lgz_concessionaire.exceptions.UsuarioExcepction;
import jakarta.persistence.*;
import java.util.stream.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "concesionario")
public class Concesionario implements Serializable {

    /**
     * Datos y atributos utilizados a lo largo de esta clase "concesionario"
     * Incluye listas
     * Incluye instancia Administrador
     */
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

    /**
     * Crea una empleado y lo retorna
     * @param nombre
     * @param identificacion
     * @param direccion
     * @param numeroTelefonico
     * @param contrasenia
     * @return
     * @throws EmpleadoException
     */
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

    /**
     * Busca a un empleado y lo retorna
     * internamente se verifica que el usuario si sea valido a traves de la contraseña
     * @param identificacion
     * @param contrasenia
     * @return
     * @throws EmpleadoException
     */
    public Empleado buscarEmpleado(String identificacion, String contrasenia) throws EmpleadoException{
        for (Empleado empleado : listaEmpleados) {
            if(empleado.getIdentificacion().equals(identificacion) && empleado.getContrasenia().equals(contrasenia)){
                return empleado;
            }
        }
        throw new EmpleadoException("El empleado no se ha encontrado");
    }

    /**
     * Metodo que busca al empleado solo con la identificacion
     * retorna al empleado encontrado
     * @param identificacion
     * @return
     * @throws EmpleadoException
     */
    public Empleado buscarEmpleadoIdentificacion(String identificacion) throws EmpleadoException {
        for (Empleado empleado: listaEmpleados) {
            if(empleado.equals(identificacion)){
                return empleado;
            }
        }
        throw new EmpleadoException("El empleado no se ha encontrado");
    }

    /**
     * Actualiza los atributos de un empleado
     * Se busca por su identifiacion para asi poder actualizarlo
     * @param nombre
     * @param direccion
     * @param numeroTelefonico
     * @param idEmpleado
     * @param contrasenia
     * @throws EmpleadoException
     */
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

    /**
     *
     * @param idEmpleado
     * @return
     */
    public Empleado buscarEmpleadoRoyer (String idEmpleado){
        for (Empleado empleado: listaEmpleados
             ) {
            if(empleado.getId().equals(idEmpleado)){
                return empleado;
            }

        }
        return null;
    }

    /**
     * Otro metodo de actualizar empleado
     * Lo hio royersito para poder implementarlo con su logica
     * @param nombre
     * @param direccion
     * @param numeroTelefonico
     * @param idEmpleado
     * @throws EmpleadoException
     */
    public void actualizarEmpleado2 (String nombre, String direccion, String numeroTelefonico, String idEmpleado) throws EmpleadoException {
        for (Empleado empleado: listaEmpleados) {
            if(buscarEmpleadoRoyer(idEmpleado) != null){
                empleado.setDireccion(direccion);
                empleado.setNombre(nombre);
                empleado.setNumeroTelefonico(numeroTelefonico);

            }
        }

    }

    /**
     * Verifica si un empleado ya existe para no volver a crearlo
     * @param idEmpleado
     * @return
     */
    public boolean verificarEmpleado(String idEmpleado){
        return listaEmpleados.stream().anyMatch(e -> e.equals(idEmpleado));
    }


    /**
     * Elimina a un empleado si es que existe dadp su id
     * @param idEmpleado
     * @return
     * @throws EmpleadoException
     */
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

    /**
     * Crea a un cliente pero no lo retorna
     * @param nombre
     * @param identificacion
     * @param direccion
     * @param numeroTelefonico
     * @throws UsuarioExcepction
     */
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

    /**
     * Verifica si un cliente ya existe
     * @param identificacion
     * @return
     */
    public boolean verificarCliente(String identificacion){
        return listaClientes.stream().anyMatch(c -> c.getIdentificacion().equals(identificacion));
    }

    /**
     * Actualiza a un cliente, solo ciertos atributos
     * @param nombre
     * @param identificacion
     * @param direccion
     * @param numTelefono
     * @throws UsuarioExcepction
     */
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

    /**
     * Busca a un cliente dada su id
     * @param idCliente
     * @return
     * @throws UsuarioExcepction
     */
    public Cliente buscarCliente (String idCliente) throws UsuarioExcepction{
        for (Cliente cliente : listaClientes) {
            if(cliente.getIdentificacion().equals(idCliente)){
                return cliente;
            }
        }


        throw new UsuarioExcepction("El cliente no se ha encontrado");
    }

    /**
     * elimina a un cliente dada su id
     * @param identificacion
     * @return
     * @throws UsuarioExcepction
     */
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

    /**
     * Crea a un proveedor con todos sus atributos
     * @param nombre
     * @param identificacion
     * @param direccion
     * @param num
     * @throws UsuarioExcepction
     */
    public void crearProveedor(String nombre, String identificacion, String direccion, String num) throws UsuarioExcepction {
        Proveedor proveedor = new Proveedor (nombre, identificacion, direccion, num);
        if(verificarProveedor(proveedor.getIdentificacion())){
            throw new UsuarioExcepction("El proveedor ya existe");
        }
        listaProveedores.add(proveedor);
    }

    /**
     * Verifica si un proveedor ya existe para asi no volver a crearlo
     * @param identificacion
     * @return
     */
    public boolean verificarProveedor(String identificacion){
        return listaProveedores.stream().anyMatch(c -> c.getIdentificacion().equals(identificacion));
    }

    /**
     * Se actualizan ciertos atributos del proveedor
     * @param nombre
     * @param identificacion
     * @param direccion
     * @param numTelefono
     * @throws UsuarioExcepction
     */
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

    /**
     * Se busca a un proveedor dada su id
     * @param idProveedor
     * @return
     * @throws UsuarioExcepction
     */
    public Proveedor buscarProveedor (String idProveedor) throws UsuarioExcepction{
        for (Proveedor proveedor : listaProveedores) {
            if(proveedor.getIdentificacion().equals(idProveedor)){
                return proveedor;
            }
        }
        throw new UsuarioExcepction("El proveedor no se ha encontrado");
    }

    /////////////////////////////////////////////////////////////////////////
    //CRUD Transacciones


    /**
     * Encargado de crear Transaccion, asignandole un vehiculo
     * @param empleado
     * @param code
     * @param valorTotal
     * @param cliente
     * @param listaDetalles
     * @throws TransactionException
     */
    public void crearTransacciones(Empleado empleado, String code, Double valorTotal, Cliente cliente,  List<DetalleTransaccion> listaDetalles) throws TransactionException {
        Transaccion transaccion = new Transaccion(empleado, code, valorTotal, cliente, listaDetalles);
        if(verificarTransacciones(transaccion.getCode())){
            throw new TransactionException("La transaccion ya existe");
        }
        listaTransacciones.add(transaccion);
    }


    /**
     * Busca una transaccion dandole un codigo
     * @param code
     * @return
     */
    public Transaccion buscarTransaccion(String code){
        return (Transaccion) listaTransacciones.stream()
                .filter(t -> t.getCode().equals(code)).collect(Collectors.toList());
    }


    /**
     * elimina una transaccion dandole un codigo para buscarla y hacer el proceso de eliminacion
     * @param code
     * @throws TransactionException
     */
    public void eliminarTransaccion(String code) throws TransactionException {
        Transaccion transaccion = buscarTransaccion(code);
        if(transaccion != null){
            listaTransacciones.remove(transaccion);
        }
        throw new TransactionException("La transacción no existe");
    }


    /**
     * verifica si una transaccion ya existe en la base de datos
     * @param code
     * @return
     */
    public boolean verificarTransacciones(String code){
        return listaTransacciones.stream().anyMatch(t -> t.getCode().equals(code));
    }
    ////////////////////////////////////////////////////////////////////////////
    //CRUD vehiculos

    /**
     * busca un vehiculo brindandole la placa
     * retorna el vehiculo encontrado
     * @param placa
     * @return
     */
    public Vehiculo buscarVehiculo (String placa){
        for (Vehiculo vehiculo : listaVehiculos) {
            if(vehiculo.getPlaca().equals(placa)){
                return vehiculo;

            }
        }
        return null;
    }

    /**
     * elimina el vehiculo dado la placa
     * @param placa
     * @return
     */
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


    /**
     * crea un sedan el cual hereda de otras clases, asignando asi los
     * atributos de su clase y de las clases padre
     * @param marca
     * @param placa
     * @param modelo
     * @param cantidadCambios
     * @param velocidadMaxima
     * @param cilindraje
     * @param estadoVehiculo
     * @param tipoCombustible
     * @param tipoTrasmision
     * @param numPuertas
     * @param numPasajeros
     * @param numBolsasAire
     * @param aC
     * @param camaraReversa
     * @param aBS
     * @param velocidadCrucero
     * @param sensoresColision
     * @param sensorTraficoCruzado
     * @param asistenteCarril
     * @return
     */
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


    /**
     * Crea un Deportivo el cual hereda atributos de otras clases
     * @param marca
     * @param placa
     * @param modelo
     * @param cantidadCambios
     * @param velocidadMaxima
     * @param cilindraje
     * @param estadoVehiculo
     * @param tipoCombustible
     * @param tipoTrasmision
     * @param numPuertas
     * @param numPasajeros
     * @param numBolsasAire
     * @param tiempo100Km
     * @param caballosFuerza
     * @return
     */
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


    /**
     * Crea una camioneta y la retorna
     * @param marca
     * @param placa
     * @param modelo
     * @param cantidadCambios
     * @param velocidadMaxima
     * @param cilindraje
     * @param estadoVehiculo
     * @param tipoCombustible
     * @param tipoTrasmision
     * @param numPuertas
     * @param numPasajeros
     * @param numBolsasAire
     * @param aC
     * @param camaraReversa
     * @param aBS
     * @param velocidadCrucero
     * @param sensoresColision
     * @param sensorTraficoCruzado
     * @param asistenteCarril
     * @param is4x4
     * @return
     */
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


    /**
     * Crea un camion y se retorna
     * @param marca
     * @param placa
     * @param modelo
     * @param cantidadCambios
     * @param velocidadMaxima
     * @param cilindraje
     * @param estadoVehiculo
     * @param tipoCombustible
     * @param tipoTrasmision
     * @param capacidadCarga
     * @param tieneFrenosAire
     * @param numeroEjes
     * @param tieneABS
     * @param tipoCamion
     * @param tieneAC
     * @return
     */
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


    /**
     * Crea una moto y la retorna
     * @param marca
     * @param estadoVehiculo
     * @param modelo
     * @param cambios
     * @param velocidadMaxima
     * @param cilindraje
     * @param placa
     * @return
     */
    public Moto crearMoto (String marca, EstadoVehiculo estadoVehiculo, String modelo, int cambios, Double velocidadMaxima,
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

    /**
     * Crea un bus y lo retorna
     * @param marca
     * @param placa
     * @param modelo
     * @param cantidadCambios
     * @param velocidadMaxima
     * @param cilindraje
     * @param estadoVehiculo
     * @param tipoCombustible
     * @param tipoTrasmision
     * @param numPuertas
     * @param numPasajeros
     * @param numBolsasAire
     * @param numEjes
     * @param numSalidas
     * @param tieneAbs
     * @return
     */
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

    /**
     * Crea una pick up y la retorna
     * @param marca
     * @param placa
     * @param modelo
     * @param cantidadCambios
     * @param velocidadMaxima
     * @param cilindraje
     * @param estadoVehiculo
     * @param tipoCombustible
     * @param tipoTrasmision
     * @param numPuertas
     * @param numPasajeros
     * @param numBolsasAire
     * @param aC
     * @param camaraReversa
     * @param aBS
     * @param is4x4
     * @param capacidadCarga
     * @return
     */
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

    /**
     * Crea una van y la retorna
     * @param marca
     * @param placa
     * @param modelo
     * @param cantidadCambios
     * @param velocidadMaxima
     * @param cilindraje
     * @param estadoVehiculo
     * @param tipoCombustible
     * @param tipoTrasmision
     * @param numPuertas
     * @param numPasajeros
     * @param numBolsasAire
     * @param aC
     * @param camaraReversa
     * @param aBS
     * @return
     */
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
