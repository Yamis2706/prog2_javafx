package co.edu.uniquindio.cliente.clienteapp.model.builder;


import co.edu.uniquindio.cliente.clienteapp.model.Categoria;
import co.edu.uniquindio.cliente.clienteapp.model.Vendedor;

public class VendedorBuilder {

    protected String nombre;
    protected String apellido;
    protected String cedula;
    protected String edad;
    protected String direccion;
    protected String celular;
    protected Categoria categoria;



    public VendedorBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this; // Devuelve la instancia actual de VendedorBuilder
    }

    public VendedorBuilder apellido(String apellido) {
        this.apellido = apellido;
        return this; // Devuelve la instancia actual de VendedorBuilder
    }

    public VendedorBuilder cedula(String cedula) {
        this.cedula = cedula;
        return this; // Devuelve la instancia actual de VendedorBuilder
    }

    public VendedorBuilder edad(String edad) {
        this.edad = edad;
        return this; // Devuelve la instancia actual de VendedorBuilder
    }

    public VendedorBuilder direccion(String direccion) {
        this.direccion = direccion;
        return this; // Devuelve la instancia actual de VendedorBuilder
    }

    public VendedorBuilder celular(String celular) {
        this.celular = celular;
        return this; // Devuelve la instancia actual de VendedorBuilder
    }

    public VendedorBuilder categoria(Categoria categoria) {
        this.categoria = categoria;
        return this; // Devuelve la instancia actual de VendedorBuilder
    }

    public Vendedor build() {
        return new Vendedor(nombre, apellido, cedula, edad, direccion, celular
                , categoria);
    }
}

