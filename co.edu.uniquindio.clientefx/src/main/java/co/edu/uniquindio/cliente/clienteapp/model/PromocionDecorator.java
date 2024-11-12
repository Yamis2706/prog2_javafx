package co.edu.uniquindio.cliente.clienteapp.model;

public class PromocionDecorator extends ProductoDecorator {
    private double descuento;

    public PromocionDecorator(Producto productoDecorado, double descuento) {
        super(productoDecorado);
        this.descuento = descuento;
    }

    @Override
    public double getPrecio() {
        return productoDecorado.getPrecio() - (productoDecorado.getPrecio() * descuento);
    }

    @Override
    public String getDetalles() {
        return productoDecorado.getDetalles() + " | Promoción: -" + (descuento * 100) + "%";
    }
}

