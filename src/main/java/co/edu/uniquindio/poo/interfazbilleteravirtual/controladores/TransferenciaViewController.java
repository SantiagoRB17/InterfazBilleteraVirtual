package co.edu.uniquindio.poo.interfazbilleteravirtual.controladores;

import co.edu.uniquindio.poo.interfazbilleteravirtual.modelo.enums.Categoria;
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
    private GridPane gridPaneFormularioTransferencia;
    @FXML
    private Button btnTransferir;

    @FXML
    private ComboBox<Categoria> cmbCategorias;

    @FXML
    private TextField txtMontoATransferir;

    @FXML
    private TextField txtNumeroCuenta;

    @FXML
    void transferir(ActionEvent event) {

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        cmbCategorias.getItems().addAll(Categoria.values());
    }

}
