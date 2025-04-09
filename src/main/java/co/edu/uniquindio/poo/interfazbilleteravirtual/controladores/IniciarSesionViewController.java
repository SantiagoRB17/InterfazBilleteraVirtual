package co.edu.uniquindio.poo.interfazbilleteravirtual.controladores;

import co.edu.uniquindio.poo.interfazbilleteravirtual.app.BancoApp;
import co.edu.uniquindio.poo.interfazbilleteravirtual.modelo.entidades.Banco;
import co.edu.uniquindio.poo.interfazbilleteravirtual.modelo.entidades.Sesion;
import co.edu.uniquindio.poo.interfazbilleteravirtual.modelo.entidades.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class IniciarSesionViewController{
    @FXML
    private GridPane gridPaneFormularioIniciarSesion;
    @FXML
    private Button btnIniciarSesion;

    @FXML
    private PasswordField passFieldContrasenaInicioSesion;

    @FXML
    private TextField txtNumeroIdentificacionInicioSesion;

    private final BancoApp bancoApp = BancoApp.getInstancia();
    private final Banco banco= Banco.getInstancia();

    /**
     * Meotodo controlador para el boton de inciar sesion
     * @param event
     * @throws Exception
     */
    public void iniciarSesion(ActionEvent event) throws Exception {
        Usuario usuario=banco.buscarUsuario(txtNumeroIdentificacionInicioSesion.getText(),passFieldContrasenaInicioSesion.getText());
        if(usuario==null){
            bancoApp.crearAlerta("Usuario o Contraseña Incorrectos", Alert.AlertType.ERROR);
        }else{
            Sesion sesion = Sesion.getInstance();
            sesion.setUsuario(usuario);
            bancoApp.crearAlerta("Bienvenido " + usuario.getNombre(), Alert.AlertType.INFORMATION);
            bancoApp.navegarVentanas("/panelClienteView.fxml","Banco-Panel Principal",true);
        }

    }

    /**
     * Metodo controlador para el boton volver al inicio
     * @param event
     * @throws Exception
     */
    public void volverAInicio(ActionEvent event) throws Exception {
        bancoApp.navegarVentanas("/InicioView.fxml","Banco",false);
    }
}

