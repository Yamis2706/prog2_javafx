package co.edu.uniquindio.cliente.clienteapp.model.builder;


import co.edu.uniquindio.cliente.clienteapp.enums.Categoria;
import co.edu.uniquindio.cliente.clienteapp.model.Vendedor;

public class VendedorBuilder {

    protected String nombre;
    protected String apellido;
    protected String cedula;
    protected String edad;
    protected String direccion;
    protected String celular;
    protected Categoria categoria;

    public VendedorBuilder() {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.edad = edad;
        this.direccion = direccion;
        this.celular = celular;
        this.categoria = categoria;
    }

    public VendedorBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public VendedorBuilder apellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public VendedorBuilder cedula(String cedula) {
        this.cedula = cedula;
        return this;
    }

    public VendedorBuilder edad(String edad) {
        this.edad = edad;
        return this;
    }

    public VendedorBuilder direccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public VendedorBuilder celular(String celular) {
        this.celular = celular;
        return this;
    }

    public VendedorBuilder categoria(Categoria categoria) {
        this.categoria = categoria;
        return this;
    }

    public Vendedor build() {
        return new Vendedor();
    }
}

