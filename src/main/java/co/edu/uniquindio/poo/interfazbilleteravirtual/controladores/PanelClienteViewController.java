package co.edu.uniquindio.poo.interfazbilleteravirtual.controladores;

import co.edu.uniquindio.poo.interfazbilleteravirtual.modelo.entidades.Banco;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class PanelClienteViewController implements Initializable{

    private final Banco banco = Banco.getInstancia();

    @FXML
    private TableColumn<?, ?> cl_categoria;

    @FXML
    private TableColumn<?, ?> cl_fecha;

    @FXML
    private TableColumn<?, ?> cl_tipo;

    @FXML
    private TableColumn<?, ?> cl_usuario;

    @FXML
    private TableColumn<?, ?> cl_valor;

    @FXML
    private Label lb_nroCuenta;

    @FXML
    private Label lb_saludo;

    @FXML
    private MenuButton menBtn_accionesPanel;

    @FXML
    private MenuItem menItem_cerrarSesion;

    @FXML
    private MenuItem menItem_consultar;

    @FXML
    private MenuItem menItem_transferir;

    @FXML
    private TableView<?> tb_tablaTransferencias;

    @FXML
    void cerrarSesion(ActionEvent event) {

    }

    @FXML
    void consultarSaldo(ActionEvent event) {

    }

    @FXML
    void irAtransferencia(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

    }

}

