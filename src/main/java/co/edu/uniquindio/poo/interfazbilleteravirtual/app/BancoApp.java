package co.edu.uniquindio.poo.interfazbilleteravirtual.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
        this.primary.setTitle("Billtera Virtual");
        navegarVentanas("/InicioView.fxml","Banco",false);
    }

    public void navegarVentanas(String nombreArchivoFxml, String tituloVentana, Boolean resize) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(nombreArchivoFxml));

        Parent parent = loader.load();
        Scene inicioSesion = new Scene(parent);
        primary.resizableProperty().setValue(resize);
        primary.setScene(inicioSesion);
        primary.show();
    }


    public static void main(String[] args) {
        launch(BancoApp.class,args);
    }
}
