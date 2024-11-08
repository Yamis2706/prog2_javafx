package co.edu.uniquindio.cliente.clienteapp.service;

import co.edu.uniquindio.cliente.clienteapp.enums.EstadoVenta;
import co.edu.uniquindio.cliente.clienteapp.enums.TipoVenta;
import co.edu.uniquindio.cliente.clienteapp.model.Factura;
import co.edu.uniquindio.cliente.clienteapp.model.Marketplace;
import co.edu.uniquindio.cliente.clienteapp.model.Producto;
import co.edu.uniquindio.cliente.clienteapp.model.Vendedor;

import java.util.ArrayList;

public interface  CreacionVenta {



    Factura crearFactura(Marketplace venta, float totalVenta, String codigo) throws Exception;

    float calcularVentas(Marketplace venta, int ventasMes) throws Exception;

    float calcularCostoVenta(Marketplace venta, int ventasMes);

    Marketplace crearVenta(Vendedor vendedor1, Vendedor vendedor2,
                           ArrayList<Producto> productos,
                           ArrayList<Marketplace> ventas) throws Exception;

    Marketplace crearVenta(Vendedor vendedor1, Vendedor vendedor2,
                           ArrayList<Producto> productos, TipoVenta tipoVenta, EstadoVenta estadoVenta);
}
