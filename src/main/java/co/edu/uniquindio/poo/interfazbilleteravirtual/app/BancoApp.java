package co.edu.uniquindio.poo.interfazbilleteravirtual.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class BancoApp extends Application {

    public static BancoApp INSTANCE;

    public BancoApp() {
        INSTANCE = this;
    }

    public static BancoApp getInstancia(){
            if(INSTANCE == null){
                INSTANCE = new BancoApp();
            }
            return INSTANCE;
    }

    private Stage primary;

    @Override
    public void start(Stage primary) throws Exception{
        this.primary = primary;
        navegarVentanas("/InicioView.fxml","Banco",false);
    }

    /**
     * Metodo que permite navegar entre ventanas
     * @param nombreArchivoFxml nombre del archivo de la ventana
     * @param tituloVentana titulo de la ventana
     * @param resize parametro para establecer si la ventana se puede o no agrandar
     * @throws Exception
     */
    public void navegarVentanas(String nombreArchivoFxml, String tituloVentana, Boolean resize) throws Exception {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource(nombreArchivoFxml));

            Parent parent = loader.load();
            Scene scene = new Scene(parent);
            primary.resizableProperty().setValue(resize);
            primary.setTitle(tituloVentana);
            primary.setScene(scene);
            primary.show();
        }catch(Exception e){
            e.printStackTrace();
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

    public static void main(String[] args) {
        launch(BancoApp.class,args);
    }
}
