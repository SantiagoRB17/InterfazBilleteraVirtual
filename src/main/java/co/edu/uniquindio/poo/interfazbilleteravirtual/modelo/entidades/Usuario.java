package co.edu.uniquindio.poo.interfazbilleteravirtual.modelo.entidades;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Usuario {

    private String id, nombre, direccion, email, password;

}
