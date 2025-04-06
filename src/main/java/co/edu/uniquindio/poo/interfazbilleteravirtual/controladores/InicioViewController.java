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
    private Button btn_iniciarSesion;

    @FXML
    private Button btn_registrarse;

    @FXML
    private ImageView img_imagenInicio;

    private final BancoApp bancoApp = BancoApp.getInstancia();
    public InicioViewController() {
    }
    Image imagen = new Image(getClass().getResource("/fondoInicio.jpg").toExternalForm());
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        img_imagenInicio.setImage(imagen);
    }

    public void irAIniciarSesion(ActionEvent event) throws Exception {
            bancoApp.abrirIniciarSesion();
    }
    public void irARegistrarse(ActionEvent event) throws Exception {
        bancoApp.abrirRegistro();
    }
}

