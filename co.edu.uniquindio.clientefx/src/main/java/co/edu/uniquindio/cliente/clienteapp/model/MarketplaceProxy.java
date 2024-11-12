package co.edu.uniquindio.cliente.clienteapp.model;

import co.edu.uniquindio.cliente.clienteapp.service.IMarketplaceService;
import co.edu.uniquindio.cliente.clienteapp.service.IMarketplaceServiceImpl;


public class MarketplaceProxy implements IMarketplaceService {
    private IMarketplaceServiceImpl servicioReal;
    private Autenticacion autenticacion;

    public MarketplaceProxy(IMarketplaceServiceImpl servicioReal, Autenticacion autenticacion) {
        this.servicioReal = servicioReal;
        this.autenticacion = autenticacion;
    }

    private boolean estaAutenticado(String usuario, String contrasena) {
        return autenticacion.autenticar(usuario, contrasena);
    }

    public boolean agregarProducto(String usuario, String contrasena, Producto producto) {
        if (estaAutenticado(usuario, contrasena)) {
            return servicioReal.agregarProducto(usuario, producto);
        }
        System.out.println("Acceso denegado. Autenticación fallida.");
        return false;
    }

    public boolean realizarTransaccion(String usuarioVendedor, String contrasenaVendedor, String usuarioComprador, Producto producto) {
        if (estaAutenticado(usuarioVendedor, contrasenaVendedor)) {
            return servicioReal.realizarTransaccion(usuarioVendedor, usuarioComprador, producto);
        }
        System.out.println("Acceso denegado. Autenticación fallida.");
        return false;
    }

    @Override
    public boolean agregarProducto(String usuario, Producto producto) {
        return false;
    }

    @Override
    public boolean realizarTransaccion(String usuarioVendedor, String usuarioComprador, Producto producto) {
        return false;
    }
}

