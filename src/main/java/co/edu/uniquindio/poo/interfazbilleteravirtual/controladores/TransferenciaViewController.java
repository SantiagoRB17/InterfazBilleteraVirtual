package co.edu.uniquindio.poo.interfazbilleteravirtual.controladores;

import co.edu.uniquindio.poo.interfazbilleteravirtual.app.BancoApp;
import co.edu.uniquindio.poo.interfazbilleteravirtual.modelo.entidades.Banco;
import co.edu.uniquindio.poo.interfazbilleteravirtual.modelo.entidades.Billetera;
import co.edu.uniquindio.poo.interfazbilleteravirtual.modelo.entidades.Sesion;
import co.edu.uniquindio.poo.interfazbilleteravirtual.modelo.entidades.Usuario;
import co.edu.uniquindio.poo.interfazbilleteravirtual.modelo.enums.Categoria;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class TransferenciaViewController implements Initializable {
    @FXML
    private GridPane gridPaneFormularioTransferencia;
    @FXML
    private Button btnTransferir;

    @FXML
    private ComboBox<Categoria> cmbCategorias;

    @FXML
    private TextField txtMontoATransferir;

    @FXML
    private TextField txtNumeroCuenta;

    private final Banco banco= Banco.getInstancia();
    private final BancoApp bancoApp= BancoApp.getInstancia();
    private final Sesion sesion=Sesion.getInstance();
    Usuario usuario = sesion.getUsuario();
    Billetera cuenta=banco.buscarBilleteraUsuario(usuario.getId());

    PanelClienteViewController panelClienteViewController = new PanelClienteViewController();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        cmbCategorias.getItems().addAll(Categoria.values());
    }

    /**
     *Metodo controlador del boton transferir
     * @param event
     */
    public void transferir(ActionEvent event){
        try {
            banco.realizarTransferencia(cuenta.getNumero(), txtNumeroCuenta.getText(),
                    Float.parseFloat(txtMontoATransferir.getText()), cmbCategorias.getValue());
            bancoApp.crearAlerta("Transferencia Realizada con exito",Alert.AlertType.INFORMATION);
        }catch(Exception e){
            bancoApp.crearAlerta(e.getMessage(), Alert.AlertType.ERROR);
        }
    }
}
