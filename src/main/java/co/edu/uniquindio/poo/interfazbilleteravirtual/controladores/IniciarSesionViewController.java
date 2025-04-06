package co.edu.uniquindio.poo.interfazbilleteravirtual.controladores;

import co.edu.uniquindio.poo.interfazbilleteravirtual.app.BancoApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class IniciarSesionViewController implements Initializable {
    @FXML
    private GridPane gridPane_formularioIniciarSesion;
    @FXML
    private Button btn_iniciarSesion;

    @FXML
    private PasswordField passField_contrasenaInicioSesion;

    @FXML
    private TextField txt_numeroIdentificacionInicioSesion;

    @FXML
    void iniciarSesion(ActionEvent event) {

    }
    private final BancoApp bancoApp = BancoApp.getInstancia();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

    }
    public void volverAInicio(ActionEvent event) throws Exception {
        bancoApp.abrirInicio();
    }
}

