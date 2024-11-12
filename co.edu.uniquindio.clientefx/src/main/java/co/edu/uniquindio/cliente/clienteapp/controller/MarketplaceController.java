package co.edu.uniquindio.cliente.clienteapp.controller;

import co.edu.uniquindio.cliente.clienteapp.model.*;
import co.edu.uniquindio.cliente.clienteapp.service.IMarketplaceServiceImpl;
import co.edu.uniquindio.cliente.clienteapp.service.IStrategyTransaccion;

import java.util.ArrayList;

public class MarketplaceController {
    private MarketplaceProxy proxy;
    private final Marketplace marketplace;
    private Sesion sesion;
    public static MarketplaceController INSTANCIA;

    private MarketplaceController(){
        marketplace = new Marketplace();
    }

    public static MarketplaceController getInstancia(){
        if(INSTANCIA == null){
            INSTANCIA = new MarketplaceController();
        }
        return INSTANCIA;
    }

    public Sesion getInstanciaSesion() {
        return Sesion.getInstanciaSesion();
    }

    public MarketplaceController(Marketplace marketplace){
        this.marketplace = marketplace;
        MarketplaceFacade facade = new MarketplaceFacade();
        Autenticacion autenticacion = new Autenticacion();
        IMarketplaceServiceImpl servicioReal = new IMarketplaceServiceImpl(facade);
        this.proxy = new MarketplaceProxy(servicioReal, autenticacion);
        facade.setEstrategiaTransaccion((IStrategyTransaccion) new TransaccionAliadosDirectos());

    }

    private MarketplaceFacade facade = new MarketplaceFacade();

    public void registrarVendedorDesdeGUI(String nombre, String apellido, String cedula,
                                          String direccion, String usuario, String contrasena) {
        facade.registrarVendedor(nombre, apellido, cedula, direccion, usuario, contrasena);

    }


public boolean autenticarDesdeGUI(String usuario, String contrasena) {
    return facade.autenticar(usuario, contrasena);
    }


    public void cambiarEstrategia(String tipoEstrategia) {

        switch (tipoEstrategia) {

            case "Directa":

                facade.setEstrategiaTransaccion((IStrategyTransaccion) new TransaccionAliadosDirectos());
                break;
            case "Por Categoría":
                facade.setEstrategiaTransaccion(
                        new TransaccionPorCategoria("Electrónica"));

                break;
        }
    }
        public boolean realizarTransaccionDesdeGUI(String usuarioVendedor, String usuarioComprador,
                                                   Producto producto) {

            return facade.realizarTransaccion(usuarioVendedor, usuarioComprador, producto);
        }

    public boolean agregarProductoDesdeGUI(String usuario, String contrasena, Producto producto) {
        return proxy.agregarProducto(usuario, contrasena, producto);
    }

    public boolean realizarTransaccionDesdeGUI(String usuarioVendedor,
                                               String contrasenaVendedor,
                                               String usuarioComprador,
                                               Producto producto) {
        return proxy.realizarTransaccion(usuarioVendedor, contrasenaVendedor, usuarioComprador, producto);
    }

    public ArrayList<Historial> consultarHistorialEstados(String text) {
        return null;
    }
}
