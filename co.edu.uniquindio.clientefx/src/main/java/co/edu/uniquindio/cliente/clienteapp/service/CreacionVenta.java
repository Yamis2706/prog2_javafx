package co.edu.uniquindio.cliente.clienteapp.service;

import co.edu.uniquindio.cliente.clienteapp.enums.EstadoVenta;
import co.edu.uniquindio.cliente.clienteapp.enums.TipoVenta;
import co.edu.uniquindio.cliente.clienteapp.model.Factura;
import co.edu.uniquindio.cliente.clienteapp.model.Producto;
import co.edu.uniquindio.cliente.clienteapp.model.Vendedor;
import co.edu.uniquindio.cliente.clienteapp.model.Venta;

import java.util.ArrayList;

public interface CreacionVenta {

    Venta crearVenta(Vendedor vendedor1, Vendedor vendedor2,
                     ArrayList<Producto> productos,
                      ArrayList<Venta> ventas) throws Exception;

    Factura crearFactura(Venta venta, float totalVenta, String codigo) throws Exception;

    float calcularVentas(Venta venta, int ventasMes) throws Exception;

    float calcularCostoVenta(Venta venta, int ventasMes);

    Venta crearVenta(Vendedor vendedor1, Vendedor vendedor2,
                     ArrayList<Producto> productos, TipoVenta tipoVenta, EstadoVenta estadoVenta);
}
