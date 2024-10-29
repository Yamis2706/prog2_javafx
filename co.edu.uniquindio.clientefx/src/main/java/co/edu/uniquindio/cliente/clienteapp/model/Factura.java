package co.edu.uniquindio.cliente.clienteapp.model;


import java.io.Serializable;


public class Factura implements Serializable {
    private final String codigoFactura;
    private float subtotal, total;

    public Factura(String codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    public String getCodigoFactura() {
        return codigoFactura;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Factura(String codigoFactura, float subtotal, float total) {
        this.codigoFactura = codigoFactura;
        this.subtotal = subtotal;
        this.total = total;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "codigoFactura='" + codigoFactura + '\'' +
                ", subtotal=" + subtotal +
                ", total=" + total +
                '}';
    }
}
