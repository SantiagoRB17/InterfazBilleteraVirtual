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

public class RegistroViewController implements Initializable {

    @FXML
    private GridPane gridPane_formularioRegistro;
    @FXML
    private PasswordField passField_contrasena;
    @FXML
    private Button btn_registrarse;

    @FXML
    private TextField txt_correoElectronico;

    @FXML
    private TextField txt_nombre;

    @FXML
    private TextField txt_numeroIdentificacion;

    @FXML
    private TextField txt_residencia;

    @FXML
    void registrarCuenta(ActionEvent event) {

    }
    private final BancoApp bancoApp = BancoApp.getInstancia();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

    }
    public void volverAInicio(ActionEvent event) throws Exception {
        bancoApp.abrirInicio();
    }
}

