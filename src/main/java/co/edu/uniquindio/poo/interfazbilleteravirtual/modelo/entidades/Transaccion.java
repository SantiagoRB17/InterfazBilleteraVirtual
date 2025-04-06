package co.edu.uniquindio.poo.interfazbilleteravirtual.modelo.entidades;

import co.edu.uniquindio.poo.interfazbilleteravirtual.modelo.enums.Categoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Transaccion {
    private String id;
    private float monto;
    private LocalDateTime fecha;
    private Categoria tipo;
    private Billetera billeteraOrigen, billeteraDestino;
    private float comision;

}
