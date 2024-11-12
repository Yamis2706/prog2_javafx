package co.edu.uniquindio.cliente.clienteapp.model;

import static co.edu.uniquindio.cliente.clienteapp.enums.EstadoProducto.PUBLICADO;
import static co.edu.uniquindio.cliente.clienteapp.enums.EstadoProducto.VENDIDO;

public class TransaccionAliadosDirectos {

    public boolean transaccionar(Vendedor vendedor1, Vendedor vendedor2, Producto producto) {

        if (vendedor1.getAliados().contains(vendedor2) && producto.getEstado().equals(PUBLICADO)) {

            producto.setEstado(VENDIDO);
            vendedor2.getProductos().remove(producto);
            vendedor1.getProductos().add(producto);

            return true;
        }

        return false;
    }

}
