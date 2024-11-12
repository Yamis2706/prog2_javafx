package co.edu.uniquindio.cliente.clienteapp.service;

import co.edu.uniquindio.cliente.clienteapp.model.MarketplaceFacade;
import co.edu.uniquindio.cliente.clienteapp.model.Producto;

public class IMarketplaceServiceImpl implements IMarketplaceService {
    private MarketplaceFacade facade;

    public IMarketplaceServiceImpl(MarketplaceFacade facade) {
        this.facade = facade;
    }

    @Override
    public boolean agregarProducto(String usuario, Producto producto) {
        facade.agregarProducto(usuario, producto);
        return true;
    }

    @Override
    public boolean realizarTransaccion(String usuarioVendedor, String usuarioComprador, Producto producto) {
        return facade.realizarTransaccion(usuarioVendedor, usuarioComprador, producto);
    }

}

