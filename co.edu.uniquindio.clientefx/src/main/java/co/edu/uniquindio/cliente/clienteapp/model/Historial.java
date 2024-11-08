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
    private float totalVenta;
    private ArrayList<Producto> productos;
    private ArrayList <Marketplace> listaVentasAsociadas;
    private LocalDate fechaVenta;
    private TipoVenta tipoVenta;
    private EstadoVenta estadoVenta;

}
