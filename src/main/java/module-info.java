module co.edu.uniquindio.poo.interfazbilleteravirtual {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires javafx.graphics;

    opens co.edu.uniquindio.poo.interfazbilleteravirtual.app to javafx.fxml;
    opens co.edu.uniquindio.poo.interfazbilleteravirtual.controladores to javafx.fxml;
    exports co.edu.uniquindio.poo.interfazbilleteravirtual.app;
    exports co.edu.uniquindio.poo.interfazbilleteravirtual.controladores;
    exports co.edu.uniquindio.poo.interfazbilleteravirtual.modelo.entidades;
    exports co.edu.uniquindio.poo.interfazbilleteravirtual.modelo.enums;
    exports co.edu.uniquindio.poo.interfazbilleteravirtual.modelo.vo;
    exports co.edu.uniquindio.poo.interfazbilleteravirtual.config;

}