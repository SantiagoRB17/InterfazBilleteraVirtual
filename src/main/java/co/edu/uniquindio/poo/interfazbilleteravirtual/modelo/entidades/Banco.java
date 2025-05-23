package co.edu.uniquindio.poo.interfazbilleteravirtual.modelo.entidades;

import co.edu.uniquindio.poo.interfazbilleteravirtual.config.Constantes;
import co.edu.uniquindio.poo.interfazbilleteravirtual.modelo.enums.Categoria;
import co.edu.uniquindio.poo.interfazbilleteravirtual.modelo.vo.PorcentajeGastosIngresos;
import co.edu.uniquindio.poo.interfazbilleteravirtual.modelo.vo.SaldoTransaccionesBilletera;
import co.edu.uniquindio.poo.interfazbilleteravirtual.validaciones.ValidacionCorreo;
import javafx.scene.image.Image;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Clase que representa un banco con usuarios y billeteras
 * @version 1.0
 * @author caflorezvi
 */
public class Banco {

    private List<Usuario> usuarios;
    private List<Billetera> billeteras;
    public static Banco INSTANCIA;

    public static Banco getInstancia(){
        if(INSTANCIA == null){
            INSTANCIA = new Banco();
        }
        return INSTANCIA;
    }

    private Banco(){
        this.usuarios = new ArrayList<>();
        this.billeteras = new ArrayList<>();
    }

    /**
     * Permite registrar un usuario en el banco y crear su billetera
     * @param id identificación del usuario
     * @param nombre nombre del usuario
     * @param direccion dirección del usuario
     * @param email email del usuario
     * @param password contraseña del usuario
     * @throws Exception si el id, nombre, dirección, email o password son nulos o vacíos o si el usuario ya existe
     */
    public void registrarUsuario(String id, String nombre, String direccion, String email, String password) throws Exception{

        if(id == null || id.isEmpty()){
            throw new Exception("El id es obligatorio");
        }

        if(nombre == null || nombre.isEmpty()){
            throw new Exception("El nombre es obligatorio");
        }

        if(direccion == null || direccion.isEmpty()){
            throw new Exception("La dirección es obligatoria");
        }

        if(email == null || email.isEmpty() || !ValidacionCorreo.validarExpresionRegular(email)){
            throw new Exception("No es una direccion de correo valida");
        }

        if(password == null || password.isEmpty()){
            throw new Exception("La contraseña es obligatoria");
        }

        if(buscarUsuario(id,password) != null){
            throw new Exception("El usuario ya existe");
        }

        Usuario usuario = Usuario.builder()
                .id(id)
                .nombre(nombre)
                .direccion(direccion)
                .email(email)
                .password(password)
                .build();
        // Se agrega el usuario a la lista de usuarios
        usuarios.add(usuario);
        // Se registra la billetera del usuario
        registrarBilletera(usuario);
    }

    /**
     * Permite registrar una billetera para un usuario
     * @param usuario usuario al que se le va a registrar la billetera
     */
    public void registrarBilletera(Usuario usuario){
        String numero = crearNumeroBilletera();
        Billetera billetera = new Billetera(numero, 0, usuario);
        billeteras.add(billetera);
    }

    /**
     * Crea un número de billetera único
     * @return número de billetera
     */
    private String crearNumeroBilletera(){
        String numero = generarNumeroAleatorio();
        while(buscarBilletera(numero) != null){
            numero = generarNumeroAleatorio();
        }
        return numero;
    }

    /**
     * Permite generar un número aleatorio de 10 dígitos para la billetera
     * @return número aleatorio
     */
    private String generarNumeroAleatorio(){
        String numero = "";
        for(int i = 0; i < 10; i++){
            numero += ""+((int) (Math.random() * 10));
        }
        return numero;
    }

    /**
     * Permite buscar una billetera por su número
     * @param numero número de la billetera
     * @return billetera encontrada o null si no existe
     */
    public Billetera buscarBilletera(String numero){
        return billeteras.stream()
                .filter(billetera -> billetera.getNumero().equals(numero))
                .findFirst()
                .orElse(null);
    }

    /**
     * Permite consultar el saldo y las transacciones de una billetera de un usuario
     * @param numeroIdentificacion identificación del usuario
     * @param password contraseña del usuario
     * @return Saldo y transacciones de la billetera
     * @throws Exception si el usuario no existe o la contraseña es incorrecta
     */
    public SaldoTransaccionesBilletera consultarSaldoYTransacciones(String numeroIdentificacion, String password)throws Exception{
        Usuario usuario = buscarUsuario(numeroIdentificacion,password);

        if(usuario == null){
            throw new Exception("El usuario no existe");
        }

        if(!usuario.getPassword().equals(password)){
            throw new Exception("Contraseña incorrecta");
        }

        Billetera billetera = buscarBilleteraUsuario(usuario.getId());

        return new SaldoTransaccionesBilletera(
                billetera.consultarSaldo(),
                billetera.obtenerTransacciones()
        );
    }

    /**
     * Permite buscar la billetera de un usuario
     * @param idUsuario identificación del usuario
     * @return billetera del usuario o null si no existe
     */
    public Billetera buscarBilleteraUsuario(String idUsuario){
        return billeteras.stream()
                .filter(billetera -> billetera.getUsuario().getId().equals(idUsuario))
                .findFirst()
                .orElse(null);
    }

    /**
     * Metodo que busca a un usuario segun su id y contraseña
     * @param id id del usuario
     * @param password contraseña del usuario
     * @return usuario encontrado o null en caso contrario
     */
    public Usuario buscarUsuario(String id, String password){
        return usuarios.stream()
                .filter(usuario -> usuario.getId().equals(id) && usuario.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }

    /**
     * Permite realizar una recarga a una billetera
     * @param numeroBiletera número de la billetera
     * @param monto monto a recargar
     * @throws Exception si la billetera no existe
     */
    public void recargarBilletera(String numeroBiletera, float monto) throws Exception{
        Billetera billetera = buscarBilletera(numeroBiletera);
        if(billetera == null){
            throw new Exception("La billetera no existe");
        }

        Transaccion transaccion = new Transaccion(
                UUID.randomUUID().toString(),
                monto,null,
                LocalDateTime.now(),
                Categoria.RECARGA,
                billetera,
                billetera,
                0
        );

        billetera.depositar(monto, transaccion);
    }

    public void realizarTransferencia(String numeroBilleteraOrigen, String numeroBilleteraDestino, float monto, Categoria categoria) throws Exception{
        Billetera billeteraOrigen = buscarBilletera(numeroBilleteraOrigen);
        Billetera billeteraDestino = buscarBilletera(numeroBilleteraDestino);

        if(billeteraOrigen == null || billeteraDestino == null){
            throw new Exception("La billetera no existe");
        }

        if(!billeteraOrigen.tieneSaldo(monto)){
            throw new Exception("Saldo insuficiente");
        }

        Transaccion transaccion = new Transaccion(
                UUID.randomUUID().toString(),
                monto,null,
                LocalDateTime.now(),
                categoria,
                billeteraOrigen,
                billeteraDestino,
                Constantes.COMISION
        );

        billeteraOrigen.retirar(monto, transaccion);
        billeteraDestino.depositar(monto, transaccion);

    }

    public List<Transaccion> obtenerTransacciones(String numeroBilletera){
        Billetera billetera = buscarBilletera(numeroBilletera);
        if(billetera != null){
            return billetera.obtenerTransacciones();
        }
        return new ArrayList<>();
    }

    public List<Transaccion> obtenerTransaccionesPeriodo(String numeroBilletera, LocalDateTime inicio, LocalDateTime fin){
        Billetera billetera = buscarBilletera(numeroBilletera);
        if(billetera != null){
            return billetera.obtenerTransaccionesPeriodo(inicio, fin);
        }
        return new ArrayList<>();
    }

    public PorcentajeGastosIngresos obtenerPorcentajeGastosIngresos(String numeroBilletera, int mes, int anio) throws Exception{
        Billetera billetera = buscarBilletera(numeroBilletera);
        if(billetera == null){
            throw new Exception("La billetera no existe");
        }
        return billetera.obtenerPorcentajeGastosIngresos(mes, anio);
    }

    /**
     * Metodo que permite editar los datos del usuario
     * @param id id del usuario a buscar
     * @param nombre nuevo nombre del usuario
     * @param direccion nueva direccion del usuario
     * @param email nuevo email del usuario
     * @param password nueva contraseña del usuario
     * @throws Exception excepcion en caso de que no se rellene uno de los campos o no sea valido el email
     */
    public void editarUsuario(String id,String nombre, String direccion,String  email, String password ) throws Exception {
        Usuario usuario = buscarUsuario(id,password);

        if(usuario == null) {
            throw new Exception("No existe el usuario con el ID especificado");
        }

        // Validaciones
        if(nombre.isEmpty()  || email.isEmpty() || password.isEmpty()) {
            throw new Exception("Todos los campos son obligatorios");
        }

        if(!ValidacionCorreo.validarExpresionRegular(email)) {
            throw new Exception("Email inválido");
        }
        // Actualizar el Usuario
        usuario.setNombre(nombre);
        usuario.setDireccion(direccion);
        usuario.setEmail(email);
        usuario.setPassword(password);
    }
    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void setBilleteras(List<Billetera> billeteras) {
        this.billeteras = billeteras;
    }
}
