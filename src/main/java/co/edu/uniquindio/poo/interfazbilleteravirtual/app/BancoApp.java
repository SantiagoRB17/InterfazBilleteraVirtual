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
        abrirInicio();
    }

    public void abrirInicio() throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/InicioView.fxml"));
        Parent parent = loader.load();

        Scene inicio = new Scene(parent);
        primary.resizableProperty().setValue(Boolean.FALSE);
        primary.setScene(inicio);
        primary.show();
    }

    public void abrirIniciarSesion() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/IniciarSesionView.fxml"));
        Parent parent=loader.load();

        Scene inicioSesion = new Scene(parent);
        primary.resizableProperty().setValue(Boolean.FALSE);
        primary.setScene(inicioSesion);
        primary.show();
    }
    public void abrirRegistro()throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/RegistroView.fxml"));
        Parent parent = loader.load();

        Scene registro = new Scene(parent);
        primary.resizableProperty().setValue(Boolean.FALSE);
        primary.setScene(registro);
        primary.show();
    }

    public static void main(String[] args) {
        launch(BancoApp.class,args);
    }
}
