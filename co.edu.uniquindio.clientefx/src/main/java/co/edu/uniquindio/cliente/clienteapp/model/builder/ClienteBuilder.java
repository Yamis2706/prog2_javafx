package co.edu.uniquindio.cliente.clienteapp.model.builder;


import co.edu.uniquindio.cliente.clienteapp.model.Categoria;
import co.edu.uniquindio.cliente.clienteapp.model.Cliente;

public class ClienteBuilder {

    protected String nombre;
    protected String apellido;
    protected String cedula;
    protected String edad;
    protected String direccion;
    protected String celular;
    protected Categoria categoria;



    public ClienteBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this; // Devuelve la instancia actual de ClienteBuilder
    }

    public ClienteBuilder apellido(String apellido) {
        this.apellido = apellido;
        return this; // Devuelve la instancia actual de ClienteBuilder
    }

    public ClienteBuilder cedula(String cedula) {
        this.cedula = cedula;
        return this; // Devuelve la instancia actual de ClienteBuilder
    }

    public ClienteBuilder edad(String edad) {
        this.edad = edad;
        return this; // Devuelve la instancia actual de ClienteBuilder
    }

    public ClienteBuilder direccion(String direccion) {
        this.direccion = direccion;
        return this; // Devuelve la instancia actual de ClienteBuilder
    }

    public ClienteBuilder celular(String celular) {
        this.celular = celular;
        return this; // Devuelve la instancia actual de ClienteBuilder
    }

    public ClienteBuilder categoria(Categoria categoria) {
        this.categoria = categoria;
        return this; // Devuelve la instancia actual de ClienteBuilder
    }

    public Cliente build() {
        return new Cliente(nombre, apellido, cedula, edad, direccion, celular
                , categoria);
    }
}

