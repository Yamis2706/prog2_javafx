package co.edu.uniquindio.cliente.clienteapp.model;


import java.io.Serializable;

public class Sesion implements Serializable {
    public static Sesion INSTANCIA;


    private Empleado empleado;

    private Marketplace marketplace;

    private Sesion() {
    }

    public static Sesion getInstanciaSesion() {
        if (INSTANCIA == null) {
            INSTANCIA = new Sesion();
        }
        return INSTANCIA;
    }

    public void cerrarSesion() {
        empleado = null;
    }
}
