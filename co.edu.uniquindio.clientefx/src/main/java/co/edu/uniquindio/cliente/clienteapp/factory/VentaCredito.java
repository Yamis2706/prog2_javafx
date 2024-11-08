package co.edu.uniquindio.cliente.clienteapp.factory;

import co.edu.uniquindio.cliente.clienteapp.enums.EstadoVenta;
import co.edu.uniquindio.cliente.clienteapp.enums.TipoVenta;
import co.edu.uniquindio.cliente.clienteapp.model.Factura;
import co.edu.uniquindio.cliente.clienteapp.model.Marketplace;
import co.edu.uniquindio.cliente.clienteapp.model.Producto;
import co.edu.uniquindio.cliente.clienteapp.model.Vendedor;
import co.edu.uniquindio.cliente.clienteapp.service.CreacionVenta;

import java.util.ArrayList;

public class VentaCredito implements CreacionVenta {

    @Override
    public Factura crearFactura(Marketplace venta, float totalVenta, String codigo) throws Exception {
        return null;
    }

    @Override
    public float calcularVentas(Marketplace venta, int ventasMes) throws Exception {
        return 0;
    }

    @Override
    public float calcularCostoVenta(Marketplace venta, int ventasMes) {
        return 0;
    }

    @Override
    public Marketplace crearVenta(Vendedor vendedor1, Vendedor vendedor2,
                                  ArrayList<Producto> productos, ArrayList<Marketplace> ventas)
            throws Exception {
        return null;
    }

    @Override
    public Marketplace crearVenta(Vendedor vendedor1, Vendedor vendedor2,
                        ArrayList<Producto> productos, TipoVenta tipoVenta, EstadoVenta estadoVenta) {
        return null;
    }
}
