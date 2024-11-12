package co.edu.uniquindio.cliente.clienteapp.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import co.edu.uniquindio.cliente.clienteapp.enums.EstadoVenta;
import co.edu.uniquindio.cliente.clienteapp.enums.TipoVenta;
import lombok.*;

@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString

public class Historial implements Serializable {
    private final String codigoVenta;
    private LocalDate fechaVenta;
    private LocalDate descripcion;
    private EstadoVenta estadoVenta;

}
