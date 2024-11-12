package co.edu.uniquindio.cliente.clienteapp.model;

import co.edu.uniquindio.cliente.clienteapp.service.IStrategyTransaccion;

public class MarketplaceFacade {


    private Vendedor vendedor;
    private Autenticacion autenticacion;
    private IStrategyTransaccion IStrategyTransaccion;

    public MarketplaceFacade() {

        this.vendedor = new Vendedor();
        this.autenticacion = new Autenticacion();
    }

    public void setEstrategiaTransaccion(IStrategyTransaccion IStrategyTransaccion) {
        this.IStrategyTransaccion = IStrategyTransaccion;
    }

    public void registrarVendedor(String nombre, String apellido, String cedula,
                                  String direccion, String usuario, String contrasena) {
    }

    public boolean autenticar(String usuario, String contrasena) {
        return autenticacion.autenticar(usuario, contrasena);
    }

    public void agregarProducto(String usuario, Producto producto) {

        Vendedor vendedor = buscarVendedor(usuario);

        if (vendedor != null) {
            vendedor.getProductos().add(producto);
        }
    }

    private Vendedor buscarVendedor(String usuario) {
        return null;
    }

    public Vendedor agregarAliado(String usuario1, String usuario2) {

        Vendedor vendedor1 = buscarVendedor(usuario1);
        Vendedor vendedor2 = buscarVendedor(usuario2);

        if (vendedor1 != null && vendedor2 != null) {
            vendedor1.agregarAliado(vendedor2);
        }

        return vendedor1;
    }

    public boolean realizarTransaccion(String usuarioVendedor, String usuarioComprador, Producto producto) {

        Vendedor vendedor = buscarVendedor(usuarioVendedor);
        Vendedor comprador = buscarVendedor(usuarioComprador);

        if (vendedor != null && comprador != null && IStrategyTransaccion != null) {

        }
        return IStrategyTransaccion.transaccionar(comprador, vendedor, producto);

    }

}


