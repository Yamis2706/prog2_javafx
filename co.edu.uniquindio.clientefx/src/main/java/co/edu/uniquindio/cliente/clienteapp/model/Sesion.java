package co.edu.uniquindio.cliente.clienteapp.model;


import java.io.Serializable;

public class Sesion implements Serializable {
    public static Sesion INSTANCIA;
    private Persona persona;

    private Marketplace marketplace;

    private Sesion() {
    }

    public static Sesion getInstanciaSesion() {
        if (INSTANCIA == null) {
            INSTANCIA = new Sesion();
        }
        return INSTANCIA;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public void cerrarSesion() {
        persona = null;
    }
}
