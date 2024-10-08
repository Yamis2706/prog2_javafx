package co.edu.uniquindio.cliente.clienteapp.model;

public class Empleado extends  Persona{
    MarketplaceObjeto ownedByVentaUQ;

    public Empleado() {
    }

    public MarketplaceObjeto getOwnedByVentaUQ() {
        return ownedByVentaUQ;
    }

    public void setOwnedByVentaUQ(MarketplaceObjeto ownedByVentaUQ) {
        this.ownedByVentaUQ = ownedByVentaUQ;
    }

}
