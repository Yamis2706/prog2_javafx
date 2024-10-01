package co.edu.uniquindio.cliente.clienteapp.model;

public class Empleado extends  Persona{
    VentaObjeto ownedByVentaUQ;

    public Empleado() {
    }

    public VentaObjeto getOwnedByVentaUQ() {
        return ownedByVentaUQ;
    }

    public void setOwnedByVentaUQ(VentaObjeto ownedByVentaUQ) {
        this.ownedByVentaUQ = ownedByVentaUQ;
    }

}
