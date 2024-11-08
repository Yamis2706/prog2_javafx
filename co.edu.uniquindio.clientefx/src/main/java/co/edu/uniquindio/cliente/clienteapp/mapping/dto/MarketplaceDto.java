package co.edu.uniquindio.cliente.clienteapp.mapping.dto;

import co.edu.uniquindio.cliente.clienteapp.enums.EstadoVenta;
import co.edu.uniquindio.cliente.clienteapp.enums.TipoVenta;
import co.edu.uniquindio.cliente.clienteapp.model.Marketplace;
import co.edu.uniquindio.cliente.clienteapp.model.Producto;

import java.time.LocalDate;
import java.util.ArrayList;

public record MarketplaceDto(
     String codigoVenta,
     float totalVenta,
     ArrayList<Producto> productos,
     ArrayList<Marketplace> listaVentasAsociadas,
     TipoVenta tipoVenta,
     LocalDate fechaVenta,
     EstadoVenta estadoVenta,
     String descripcion
){
}
