package co.edu.uniquindio.cliente.clienteapp.model;


import java.io.Serializable;

public class Sesion implements Serializable {
    public static Sesion INSTANCIA;


    private Vendedor vendedor;

    private Marketplace marketplace;

    private Sesion() {
    }

    public static Sesion getInstanciaSesion() {
        if (INSTANCIA == null) {
            INSTANCIA = new Sesion();
        }
        return INSTANCIA;
    }
    /**
     * Metodo que se encarga de volver nulo al usuario al momento de cerrar sesion
     */
    public void cerrarSesion() {
        vendedor = null;
    }
}
