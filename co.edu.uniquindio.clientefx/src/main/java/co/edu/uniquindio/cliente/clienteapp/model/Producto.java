package co.edu.uniquindio.cliente.clienteapp.model;

import lombok.Getter;

public class Producto {
    @Getter
    private String nombre;
    private String imagen;
    private String categoria;
    private double precio;
    private Enum estado;
    private String idProducto;
    private String descripcion;
    MarketplaceProducto ownedByVentaUQ;

    public Producto() {
    }

    public Producto(String nombre, String imagen, String categoria, double precio,
                    Enum estado, String idProducto,
                   String descripcion, MarketplaceProducto ownedByVentaUQ) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.categoria = categoria;
        this.precio = precio;
        this.estado = estado;
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.ownedByVentaUQ = ownedByVentaUQ;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
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
                ", imagen='" + imagen + '\'' +
                ", categoria='" + categoria + '\'' +
                ", precio=" + precio +
                ", estado=" + estado +
                ", idProducto='" + idProducto + '\'' +
                ", descripcion='" + descripcion + '\'' +

                '}';
    }
}