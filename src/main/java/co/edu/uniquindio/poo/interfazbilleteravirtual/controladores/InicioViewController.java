package co.edu.uniquindio.poo.interfazbilleteravirtual.controladores;

import co.edu.uniquindio.poo.interfazbilleteravirtual.app.BancoApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


import java.net.URL;
import java.util.ResourceBundle;

public class InicioViewController implements Initializable {

    @FXML
    private Button btnIniciarSesion;

    @FXML
    private Button btnRegistrarse;

    @FXML
    private ImageView imgImagenInicio;

    private final BancoApp bancoApp = BancoApp.getInstancia();

    Image imagen = new Image(getClass().getResource("/fondoInicio.jpg").toExternalForm());
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        imgImagenInicio.setImage(imagen);
    }

    /**
     * Metodo controlador del boton iniciar sesion
     * @param event
     * @throws Exception
     */
    public void irAIniciarSesion(ActionEvent event) throws Exception {
            bancoApp.navegarVentanas("/IniciarSesionView.fxml","Banco-IniciarSesion",false);
    }

    /**
     * Metodo controlador del boton registrarse
     * @param event
     * @throws Exception
     */
    public void irARegistrarse(ActionEvent event) throws Exception {
        bancoApp.navegarVentanas("/RegistroView.fxml","Banco-Registrarse",false);
    }
}

