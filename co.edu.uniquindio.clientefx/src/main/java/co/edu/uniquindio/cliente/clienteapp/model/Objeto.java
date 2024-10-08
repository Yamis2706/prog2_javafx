package co.edu.uniquindio.cliente.clienteapp.model;

public class Objeto {
    private String nombre;
    private String idObjeto;
    MarketplaceObjeto ownedByVentaUQ;

    public Objeto() {
    }

    public Objeto(String nombre, String idObjeto) {
        this.nombre = nombre;
        this.idObjeto = idObjeto;
    }

    public Objeto(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdObjeto() {
        return idObjeto;
    }

    public void setIdObjeto(String idObjeto) {
        this.idObjeto = idObjeto;
    }

    public MarketplaceObjeto getOwnedByVentaUQ() {
        return ownedByVentaUQ;
    }

    public void setownedByVentaUQ(MarketplaceObjeto ownedByVentaUQ) {
        this.ownedByVentaUQ = ownedByVentaUQ;
    }

    @Override
    public String toString() {
        return "Objeto{" +
                "nombre='" + nombre + '\'' +
                ", idObjeto='" + idObjeto + '\'' +
                '}';
    }
}