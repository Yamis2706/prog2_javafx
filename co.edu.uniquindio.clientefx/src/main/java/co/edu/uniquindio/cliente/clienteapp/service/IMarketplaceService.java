package co.edu.uniquindio.cliente.clienteapp.service;

import co.edu.uniquindio.cliente.clienteapp.model.Producto;

public interface IMarketplaceService {

    boolean agregarProducto(String usuario, Producto producto);
    boolean realizarTransaccion(String usuarioVendedor, String usuarioComprador, Producto producto);
}

