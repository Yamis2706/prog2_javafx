package co.edu.uniquindio.cliente.clienteapp.model;


import co.edu.uniquindio.cliente.clienteapp.enums.EstadoVenta;
import co.edu.uniquindio.cliente.clienteapp.enums.TipoVenta;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;


public class Venta implements Serializable {


    private final String codigoVenta;
    private float totalVenta;
    private ArrayList <Producto> productos;
    //private ArrayList <Venta> historialVentas;
    private TipoVenta tipoVenta;
    private LocalDate fechaCreacion;
    private EstadoVenta estadoVenta;
    private String descripcion;


    public Venta(String codigoVenta, float totalVenta, ArrayList<Producto> productos,
                  TipoVenta tipoVenta,
                 LocalDate fechaCreacion, EstadoVenta estadoVenta, String descripcion) {
        this.codigoVenta = codigoVenta;
        this.totalVenta = totalVenta;
        this.productos = productos;
        this.tipoVenta = tipoVenta;
        this.fechaCreacion = fechaCreacion;
        this.estadoVenta = estadoVenta;
        this.descripcion = descripcion;
    }


    public String getCodigoVenta() {
        return codigoVenta;
    }

    public float getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(float totalVenta) {
        this.totalVenta = totalVenta;
    }

    public ArrayList<Producto> getObjetos() {
        return productos;
    }

    public void setObjetos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public TipoVenta getTipoVenta() {
        return tipoVenta;
    }

    public void setTipoVenta(TipoVenta tipoVenta) {
        this.tipoVenta = tipoVenta;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public EstadoVenta getEstadoVenta() {
        return estadoVenta;
    }

    public void setEstadoVenta(EstadoVenta estadoVenta) {
        this.estadoVenta = estadoVenta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
