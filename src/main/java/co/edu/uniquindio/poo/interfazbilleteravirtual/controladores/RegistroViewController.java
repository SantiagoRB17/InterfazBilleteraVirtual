package co.edu.uniquindio.poo.interfazbilleteravirtual.controladores;

import co.edu.uniquindio.poo.interfazbilleteravirtual.app.BancoApp;
import co.edu.uniquindio.poo.interfazbilleteravirtual.modelo.entidades.Banco;
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

public class RegistroViewController{

    @FXML
    private GridPane gridPaneFormularioRegistro;
    @FXML
    private PasswordField passFieldContrasena;
    @FXML
    private Button btnRegistrarse;

    @FXML
    private TextField txtCorreoElectronico;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtNumeroIdentificacion;

    @FXML
    private TextField txtResidencia;

    private final BancoApp bancoApp = BancoApp.getInstancia();
    private final Banco banco= Banco.getInstancia();

    /**
     * Metodo controlador para el boton volver al inicio
     * @param event
     * @throws Exception
     */
    public void volverAInicio(ActionEvent event) throws Exception {
        bancoApp.navegarVentanas("/InicioView.fxml","Banco",false);
    }

    /**
     * Metodo controlador para el boton de registrarse
     * @param event
     * @throws Exception
     */
    public void registrarCuenta(ActionEvent event) throws Exception {
        try{
            banco.registrarUsuario(
                    txtNumeroIdentificacion.getText(),
                    txtNombre.getText(),
                    txtResidencia.getText(),
                    txtCorreoElectronico.getText(),
                    passFieldContrasena.getText()
            );
            crearAlerta("Registro existoso", Alert.AlertType.INFORMATION);
            bancoApp.navegarVentanas("/InicioView.fxml","Banco",false);
        }catch(Exception e){
            crearAlerta(e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    /**
     * Metodo que pemite crear y mostrar alertas en pantalla
     * @param mensaje mensaje que aparecera en la alerta
     * @param tipo tipo de alerta
     */
    public void crearAlerta(String mensaje, Alert.AlertType tipo){
        Alert alert = new Alert(tipo);
        alert.setTitle("Alerta");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}

