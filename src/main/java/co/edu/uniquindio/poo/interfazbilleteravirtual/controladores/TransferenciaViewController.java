package co.edu.uniquindio.poo.interfazbilleteravirtual.controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class TransferenciaViewController implements Initializable {
    @FXML
    private GridPane gridPane_formularioTransferencia;
    @FXML
    private Button btn_transferir;

    @FXML
    private ComboBox<?> cmb_categorias;

    @FXML
    private TextField txt_montoATransferir;

    @FXML
    private TextField txt_numeroCuenta;

    @FXML
    void transferir(ActionEvent event) {

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

    }

}
