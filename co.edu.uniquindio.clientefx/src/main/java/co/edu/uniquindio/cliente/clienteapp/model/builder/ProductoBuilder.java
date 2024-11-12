package co.edu.uniquindio.cliente.clienteapp.model.builder;

import co.edu.uniquindio.cliente.clienteapp.model.Producto;

public class ProductoBuilder {


    protected String nombre;
    protected Enum categoria;
    protected double precio;
    protected Enum estado;
    protected String idProducto;
    protected String descripcion;


    public ProductoBuilder() {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.estado = estado;
        this.idProducto = idProducto;
        this.descripcion = descripcion;
    }

    public ProductoBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ProductoBuilder categoria(Enum categoria) {
        this.categoria = categoria;
        return this;
    }

    public ProductoBuilder precio(double precio) {
        this.precio = precio;
        return this;
    }

    public ProductoBuilder estado(Enum estado) {
        this.estado = estado;
        return this;
    }

    public ProductoBuilder idProducto(String idProducto) {
        this.idProducto = idProducto;
        return this;
    }

    public ProductoBuilder descripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public Producto build() {
        return new Producto();
    }
}
