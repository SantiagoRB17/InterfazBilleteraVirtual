package co.edu.uniquindio.poo.interfazbilleteravirtual.controladores;

import co.edu.uniquindio.poo.interfazbilleteravirtual.app.BancoApp;
import co.edu.uniquindio.poo.interfazbilleteravirtual.modelo.entidades.Banco;
import co.edu.uniquindio.poo.interfazbilleteravirtual.modelo.entidades.Sesion;
import co.edu.uniquindio.poo.interfazbilleteravirtual.modelo.entidades.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class EditarPerfilViewController {

    @FXML
    private Button btnRegistrarse;

    @FXML
    private GridPane gridPaneFormularioRegistro;

    @FXML
    private PasswordField passFieldContrasena;

    @FXML
    private TextField txtCorreoElectronico;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtResidencia;

    @FXML
    void editarCuenta(ActionEvent event) throws Exception {
        try {
            banco.editarUsuario(usuario.getId(),txtNombre.getText(),txtResidencia.getText(),txtCorreoElectronico.getText(),passFieldContrasena.getText());
            bancoApp.crearAlerta("Datos editados con exito",Alert.AlertType.INFORMATION);
            bancoApp.navegarVentanas("/panelClienteView.fxml","Banco-Panel Principal",false);
        }catch(Exception e) {
            bancoApp.crearAlerta(e.getMessage(), Alert.AlertType.ERROR);
        }

    }
    private final Banco banco=Banco.getInstancia();
    private final Sesion sesion=Sesion.getInstance();
    Usuario usuario=sesion.getUsuario();
    BancoApp bancoApp=BancoApp.getInstancia();
 }


