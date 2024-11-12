package co.edu.uniquindio.cliente.clienteapp.model;

public abstract class ProductoDecorator extends Producto {
    protected Producto productoDecorado;

    public ProductoDecorator(Producto productoDecorado) {
        super(productoDecorado.getNombre(), productoDecorado.getCategoria(),
                productoDecorado.getPrecio(), productoDecorado.getEstado(),
                productoDecorado.getIdProducto(), productoDecorado.getDescripcion());
        this.productoDecorado = productoDecorado;
    }

    @Override
    public String getDetalles() {
        return productoDecorado.getDetalles();
    }

    @Override
    public double getPrecio() {
        return productoDecorado.getPrecio();
    }
}

