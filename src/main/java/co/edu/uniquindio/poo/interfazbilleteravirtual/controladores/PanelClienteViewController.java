package co.edu.uniquindio.poo.interfazbilleteravirtual.controladores;

import co.edu.uniquindio.poo.interfazbilleteravirtual.app.BancoApp;
import co.edu.uniquindio.poo.interfazbilleteravirtual.modelo.entidades.*;
import co.edu.uniquindio.poo.interfazbilleteravirtual.modelo.enums.Categoria;
import javafx.beans.Observable;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class PanelClienteViewController implements Initializable{

    private final Banco banco = Banco.getInstancia();

    @FXML
    private TableColumn<Transaccion, String> clCategoria;

    @FXML
    private TableColumn<Transaccion, String> clFecha;

    @FXML
    private TableColumn<Transaccion, String> clTipo;

    @FXML
    private TableColumn<Transaccion, String> clUsuario;

    @FXML
    private TableColumn<Transaccion, String> clValor;

    @FXML
    private Label lbNroCuenta;

    @FXML
    private Label lbSaludo;

    @FXML
    private MenuButton menBtnAccionesPanel;

    @FXML
    private MenuItem menitemEditarPerfil;

    @FXML
    private MenuItem menItemCerrarSesion;

    @FXML
    private MenuItem menItemConsultar;

    @FXML
    private MenuItem menItemTransferir;

    @FXML
    private TableView<Transaccion> tbTablaTransferencias;

    private final BancoApp bancoApp = BancoApp.getInstancia();
    private final Sesion sesion = Sesion.getInstance();
    private ObservableList<Transaccion> transaccionesObservables;
    Usuario usuario = sesion.getUsuario();
    Billetera cuenta=banco.buscarBilleteraUsuario(usuario.getId());

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        clFecha.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getFecha().toString()));
        clValor.setCellValueFactory(cellData ->new SimpleStringProperty(String.valueOf(cellData.getValue().getMonto())));
        clUsuario.setCellValueFactory(cellData ->new SimpleStringProperty(cellData.getValue().getBilleteraOrigen().getUsuario().getNombre()));
        clCategoria.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTipo().toString()));

        transaccionesObservables = FXCollections.observableArrayList();

        lbSaludo.setText("Bienvenido " + usuario.getNombre() + " en este espacio puede ver sus transacciones.");
        lbNroCuenta.setText("Su numero de cuenta es " + cuenta.getNumero().toString());

    }

    /**
     * Metodo controlador del boton consultar saldo del menu button
     * @param event
     */
    public void consultarSaldo(ActionEvent event){
        float saldo=cuenta.consultarSaldo();
        bancoApp.crearAlerta("Su saldo es " + saldo, Alert.AlertType.INFORMATION);
    }

    /**
     * Metodo controlador del boton cerrar sesion del menu button
     * @param event
     */
    public void cerrarSesion(ActionEvent event) throws Exception {
        sesion.cerrearSesion();
        bancoApp.navegarVentanas("/InicioView.fxml","Banco",false);
    }

    /**
     * Metodo controlador del boton transferir del menu button
     * @param event
     * @throws Exception
     */
    public void irAtransferencia(ActionEvent event) throws Exception {
        abrirTransferencia();
    }
    public void editarPerfil(ActionEvent actionEvent) {
    }

    /**
     * Metodo para abrir la ventana para transferencias
     */
    public void abrirTransferencia() {
        try {

            // Cargar la vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/transferenciaView.fxml"));
            Parent root = loader.load();

            // Crear la escena
            Scene scene = new Scene(root);

            // Crear un nuevo escenario (ventana)
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Banco-Transferencia");

            // Mostrar la nueva ventana
            stage.show();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

