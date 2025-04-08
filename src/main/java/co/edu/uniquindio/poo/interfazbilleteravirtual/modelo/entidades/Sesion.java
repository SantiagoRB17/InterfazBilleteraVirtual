package co.edu.uniquindio.poo.interfazbilleteravirtual.modelo.entidades;
import lombok.Getter;
import lombok.Setter;

public class Sesion {
    public static Sesion INSTANCIA;

    @Getter
    @Setter
    private Usuario usuario;

    private Sesion(){

    }
    public static Sesion getInstance(){
        if(INSTANCIA == null){
            INSTANCIA = new Sesion();
        }
        return INSTANCIA;
    }

    public void cerrearSesion(){
        usuario = null;
    }
}
