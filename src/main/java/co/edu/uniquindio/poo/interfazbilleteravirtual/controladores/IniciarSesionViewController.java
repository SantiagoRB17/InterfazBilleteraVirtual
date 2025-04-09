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
    private GridPane gridPaneFormularioIniciarSesion;
    @FXML
    private Button btnIniciarSesion;

    @FXML
    private PasswordField passFieldContrasenaInicioSesion;

    @FXML
    private TextField txtNumeroIdentificacionInicioSesion;

    @FXML
    void iniciarSesion(ActionEvent event) {

    }
    private final BancoApp bancoApp = BancoApp.getInstancia();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

    }
    /**
     * Metodo controlador para el boton volver al inicio
     * @param event
     * @throws Exception
     */
    public void volverAInicio(ActionEvent event) throws Exception {
        bancoApp.navegarVentanas("/InicioView.fxml","Banco-IniciarSesion",false);
    }
}

