package co.edu.uniquindio.cliente.clienteapp.model;

public class Empleado extends  Persona{
    MarketplaceProducto ownedByVentaUQ;

    public Empleado() {
    }

    public MarketplaceProducto getOwnedByVentaUQ() {
        return ownedByVentaUQ;
    }

    public void setOwnedByVentaUQ(MarketplaceProducto ownedByVentaUQ) {
        this.ownedByVentaUQ = ownedByVentaUQ;
    }

}
