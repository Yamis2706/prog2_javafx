package co.edu.uniquindio.cliente.clienteapp.factory;

import co.edu.uniquindio.cliente.clienteapp.enums.EstadoVenta;
import co.edu.uniquindio.cliente.clienteapp.enums.TipoVenta;
import co.edu.uniquindio.cliente.clienteapp.model.Factura;
import co.edu.uniquindio.cliente.clienteapp.model.Producto;
import co.edu.uniquindio.cliente.clienteapp.model.Vendedor;
import co.edu.uniquindio.cliente.clienteapp.model.Venta;
import co.edu.uniquindio.cliente.clienteapp.service.CreacionVenta;

import java.util.ArrayList;

public class VentaCredito implements CreacionVenta {
    @Override
    public Venta crearVenta(Vendedor vendedor1, Vendedor vendedor2, ArrayList<Producto> productos, ArrayList<Venta> ventas) throws Exception {
        return null;
    }

    @Override
    public Factura crearFactura(Venta venta, float totalVenta, String codigo) throws Exception {
        return null;
    }

    @Override
    public float calcularVentas(Venta venta, int ventasMes) throws Exception {
        return 0;
    }

    @Override
    public float calcularCostoVenta(Venta venta, int ventasMes) {
        return 0;
    }

    @Override
    public Venta crearVenta(Vendedor vendedor1, Vendedor vendedor2, ArrayList<Producto> productos, TipoVenta tipoVenta, EstadoVenta estadoVenta) {
        return null;
    }
}
