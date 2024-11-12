package co.edu.uniquindio.cliente.clienteapp.model;

public class GarantiaExtendidaDecorator extends ProductoDecorator {
    private int mesesGarantia;

    public GarantiaExtendidaDecorator(Producto productoDecorado, int mesesGarantia) {
        super(productoDecorado);
        this.mesesGarantia = mesesGarantia;
    }

    @Override
    public String getDetalles() {
        return productoDecorado.getDetalles() + " | Garantía extendida: " + mesesGarantia + " meses";
    }
}

