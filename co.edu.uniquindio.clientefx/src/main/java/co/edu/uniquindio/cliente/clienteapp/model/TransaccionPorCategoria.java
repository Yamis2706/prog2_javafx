package co.edu.uniquindio.cliente.clienteapp.model;

import co.edu.uniquindio.cliente.clienteapp.service.IStrategyTransaccion;

import static co.edu.uniquindio.cliente.clienteapp.enums.EstadoProducto.PUBLICADO;
import static co.edu.uniquindio.cliente.clienteapp.enums.EstadoProducto.VENDIDO;

public class TransaccionPorCategoria implements IStrategyTransaccion {

    private String categoriaPermitida;

    public TransaccionPorCategoria(String categoriaPermitida) {
        this.categoriaPermitida = categoriaPermitida;
    }

    @Override
    public boolean transaccionar(Vendedor vendedor1, Vendedor vendedor2, Producto producto) {

        if (producto.getCategoria().equals(categoriaPermitida) && producto.getEstado().equals(PUBLICADO)) {
            producto.setEstado(VENDIDO);
            vendedor2.getProductos().remove(producto);
            vendedor1.getProductos().add(producto);
            return true;
        }

        return false;
    }

}
