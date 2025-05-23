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
    private MenuItem menItemRecargar;

    @FXML
    private TableView<Transaccion> tbTablaTransferencias;

    private final BancoApp bancoApp = BancoApp.getInstancia();
    private final Sesion sesion = Sesion.getInstance();
    private ObservableList<Transaccion> transaccionesObservables;
    Usuario usuario = sesion.getUsuario();
    Billetera cuenta=banco.buscarBilleteraUsuario(usuario.getId());

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        clTipo.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getTipoTransaccion()));
        clFecha.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getFecha().toString()));
        clValor.setCellValueFactory(cellData ->new SimpleStringProperty(String.valueOf(cellData.getValue().getMonto())));
        clUsuario.setCellValueFactory(cellData ->new SimpleStringProperty(cellData.getValue().getBilleteraOrigen().getUsuario().getNombre()));
        clCategoria.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTipo().toString()));

        transaccionesObservables = FXCollections.observableArrayList();
        cargarTransferencias();

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

    /**
     * Metodo que permite abrir una ventana para hacer transferencias
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

            stage.setOnHidden(e -> cargarTransferencias());

            // Mostrar la nueva ventana
            stage.show();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Metodo que carga las transacciones de la cuenta a la tabla de transacciones
     */
    public void cargarTransferencias(){
        transaccionesObservables.setAll(cuenta.obtenerTransacciones());
        tbTablaTransferencias.setItems(transaccionesObservables);
    }

    /**
     *Metodo controlador para el boton de editar perfil
     * @param actionEvent
     * @throws Exception
     */
    public void editarPerfil(ActionEvent actionEvent) throws Exception {
            bancoApp.navegarVentanas("/EditarPerfil.fxml","Banco-EditarPerfil",false);
    }

    /**
     * Metodo controlador para el boton de recargar cuenta
     * @param actionEvent
     * @throws Exception
     */
    public  void recargarCuenta(ActionEvent actionEvent) throws Exception {
        bancoApp.navegarVentanas("/recargaView.fxml","Banco-Recarga-Cuenta",false);
    }
}

