package co.edu.uniquindio.cliente.clienteapp.mapping.dto;

import co.edu.uniquindio.cliente.clienteapp.enums.EstadoVenta;
import co.edu.uniquindio.cliente.clienteapp.enums.TipoVenta;
import co.edu.uniquindio.cliente.clienteapp.model.Producto;
import co.edu.uniquindio.cliente.clienteapp.model.Venta;

import java.time.LocalDate;
import java.util.ArrayList;

public record VentaDto(
     String codigoVenta,
     float totalVenta,
     ArrayList<Producto> productos,
     ArrayList<Venta> historialVentas,
     TipoVenta tipoVenta,
     LocalDate fechaCreacion,
     EstadoVenta estadoVenta,
     String descripcion
){
}
