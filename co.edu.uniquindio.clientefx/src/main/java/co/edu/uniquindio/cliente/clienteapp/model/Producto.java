package co.edu.uniquindio.cliente.clienteapp.model;

import co.edu.uniquindio.cliente.clienteapp.model.builder.ProductoBuilder;
import lombok.Getter;

public class Producto {
    @Getter
    private String nombre;
    private Enum categoria;
    private double precio;
    private Enum estado;
    private String idProducto;
    private String descripcion;
    MarketplaceProducto ownedByVentaUQ;

    public Producto(String nombre, Enum categoria, double precio, Enum estado, String idProducto, String descripcion) {
    }

    public Producto(String nombre, Enum categoria, double precio,
                    Enum estado, String idProducto,
                   String descripcion, MarketplaceProducto ownedByVentaUQ) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.estado = estado;
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.ownedByVentaUQ = ownedByVentaUQ;
    }

    public Producto(String nombre, String categoria,
                    double precio, Enum estado, String idProducto, String descripcion) {
    }

    public Producto() {

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public Enum getCategoria() {
        return categoria;
    }

    public void setCategoria(Enum categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Enum getEstado() {
        return estado;
    }

    public void setEstado(Enum estado) {
        this.estado = estado;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", categoria='" + categoria + '\'' +
                ", precio=" + precio +
                ", estado=" + estado +
                ", idProducto='" + idProducto + '\'' +
                ", descripcion='" + descripcion + '\'' +

                '}';
    }

    public String getDetalles() {
        return "ID: " + idProducto + " | " + nombre + " - " + categoria + ": $" +
                precio + " | Estado: " + estado + " | Descripción: " + descripcion;
    }

    public static ProductoBuilder builder(){
        return new ProductoBuilder();
    }
}