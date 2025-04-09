package co.edu.uniquindio.poo.interfazbilleteravirtual.controladores;

import co.edu.uniquindio.poo.interfazbilleteravirtual.modelo.entidades.Banco;
import co.edu.uniquindio.poo.interfazbilleteravirtual.modelo.entidades.Transaccion;
import co.edu.uniquindio.poo.interfazbilleteravirtual.modelo.entidades.Usuario;
import co.edu.uniquindio.poo.interfazbilleteravirtual.modelo.enums.Categoria;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class PanelClienteViewController implements Initializable{

    private final Banco banco = Banco.getInstancia();

    @FXML
    private TableColumn<Transaccion, String> clCategoria;

    @FXML
    private TableColumn<Transaccion, LocalDateTime> clFecha;

    @FXML
    private TableColumn<Transaccion, Categoria> clTipo;

    @FXML
    private TableColumn<Categoria, Usuario> clUsuario;

    @FXML
    private TableColumn<Categoria, Double> clValor;

    @FXML
    private Label lbNroCuenta;

    @FXML
    private Label lbSaludo;

    @FXML
    private MenuButton menBtnAccionesPanel;

    @FXML
    private MenuItem menItemCerrarSesion;

    @FXML
    private MenuItem menItemConsultar;

    @FXML
    private MenuItem menItemTransferir;

    @FXML
    private TableView<Transaccion> tbTablaTransferencias;

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
        clCategoria.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().get));

    }

}

