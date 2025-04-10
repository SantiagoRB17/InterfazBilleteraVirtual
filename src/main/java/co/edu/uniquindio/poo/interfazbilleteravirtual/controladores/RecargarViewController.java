package co.edu.uniquindio.poo.interfazbilleteravirtual.controladores;

import co.edu.uniquindio.poo.interfazbilleteravirtual.app.BancoApp;
import co.edu.uniquindio.poo.interfazbilleteravirtual.modelo.entidades.Banco;
import co.edu.uniquindio.poo.interfazbilleteravirtual.modelo.entidades.Billetera;
import co.edu.uniquindio.poo.interfazbilleteravirtual.modelo.entidades.Sesion;
import co.edu.uniquindio.poo.interfazbilleteravirtual.modelo.entidades.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class RecargarViewController {

    @FXML
    private Button btnRecargar;

    @FXML
    private GridPane gridPaneFormularioRegistro;

    @FXML
    private TextField txtMonto;

    /**
     * Metodo que permite recargar la cuenta
     * @param event
     * @throws Exception
     */
    @FXML
    void recargarCuenta(ActionEvent event) throws Exception{
        try {
            banco.recargarBilletera(billetera.getNumero(),Float.parseFloat(txtMonto.getText()));
            bancoApp.crearAlerta("Monto recargado con exito", Alert.AlertType.INFORMATION);
            bancoApp.navegarVentanas("/panelClienteView.fxml","Banco-Panel Principal",false);
        }catch(Exception e) {
            bancoApp.crearAlerta(e.getMessage(), Alert.AlertType.ERROR);
        }

    }
    private final Banco banco=Banco.getInstancia();
    private final Sesion sesion=Sesion.getInstance();
    Usuario usuario=sesion.getUsuario();
    Billetera billetera=banco.buscarBilleteraUsuario(usuario.getId());
    BancoApp bancoApp=BancoApp.getInstancia();
    }

