package co.edu.uniquindio.cliente.clienteapp.model;


import co.edu.uniquindio.cliente.clienteapp.enums.Categoria;
import co.edu.uniquindio.cliente.clienteapp.enums.EstadoVenta;
import co.edu.uniquindio.cliente.clienteapp.enums.TipoVenta;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Marketplace {
    private String codigoVenta;
    private Date fechaVenta;
    private String descripcion;
    private float totalVenta;
    private TipoVenta tipoVenta;
    private EstadoVenta estadoVenta;
    private Empleado empleadoAsociado;
    private Vendedor vendedorAsociado;
    List<Producto> listaProductosAsociados = new ArrayList<>();
    List<Marketplace>listaVentasAsociadas = new ArrayList<>();


    public Marketplace() {
    }


    public Marketplace(String codigoVenta, Date fechaVenta, String descripcion,
                       float totalVenta, TipoVenta tipoVenta, EstadoVenta estadoVenta,
                       Empleado empleadoAsociado, Vendedor vendedorAsociado) {
        this.codigoVenta = this.codigoVenta;
        this.fechaVenta = fechaVenta;
        this.descripcion = descripcion;
        this.totalVenta = totalVenta;
        this.tipoVenta = tipoVenta;
        this.estadoVenta = estadoVenta;
        this.empleadoAsociado = empleadoAsociado;
        this.vendedorAsociado = vendedorAsociado;
    }


    public String getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(String codigoVenta) {
        this.codigoVenta = this.codigoVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(float totalVenta) {
        this.totalVenta = totalVenta;
    }

    public TipoVenta getTipoVenta() {
        return tipoVenta;
    }

    public void setTipoVenta(TipoVenta tipoVenta) {
        this.tipoVenta = tipoVenta;
    }

    public EstadoVenta getEstadoVenta() {
        return estadoVenta;
    }

    public void setEstadoVenta(EstadoVenta estadoVenta) {
        this.estadoVenta = estadoVenta;
    }

    public Empleado getEmpleadoAsociado() {
        return empleadoAsociado;
    }

    public void setEmpleadoAsociado(Empleado empleadoAsociado) {
        this.empleadoAsociado = empleadoAsociado;
    }

    public Vendedor getVendedorAsociado() {
        return vendedorAsociado;
    }

    public void setVendedorAsociado(Vendedor vendedorAsociado) {
        this.vendedorAsociado = vendedorAsociado;
    }



    public Marketplace crearventa(Vendedor vendedor1, Vendedor vendedor2,
                            ArrayList<Producto> productos, TipoVenta tipoVenta,
                            EstadoVenta estadoVenta) {
        return null;
    }

    public Factura obtenerFactura() {
        return null;
    }

    public Marketplace obtenerVenta() {
        return null;
    }

    public ArrayList<Marketplace> listarTodasVentas() {
        return null;
    }

    public ArrayList<Marketplace> listarVentasFecha(LocalDate fecha) {
        return null;
    }

    public ArrayList<Marketplace> listarVentasEstado(EstadoVenta estadoVenta) {
        return null;
    }

    public ArrayList<Marketplace> listarVentasFechaEstado(LocalDate fecha,
                                                EstadoVenta estadoVenta) {
        return null;
    }

    public Vendedor agregarVendedor(String nombre, String apellido, String cedula, String edad,
                                    String direccion, String celular, Categoria categoria) {
        return null;
    }

    public Vendedor obtenerVendedor(String cedula) {
        return null;
    }

    public Empleado obtenerEmpleado(String cedula) {
        return null;
    }

    public Empleado validarUsuario(String cedula, String contrasena) {
        return null;
    }

    public void agregarEmpleado(String nombre, String apellido, String cedula, String edad) {
    }

    public Marketplace crearventa() {
        return null;
    }

    public void cambiarEstadoVenta(String codigoVenta, EstadoVenta estadoVenta, String descripcion) {
    }

    public Marketplace buscarVentaCodigo(String codigoVenta) {
        return null;
    }

    public ArrayList<Historial> consultarHistorialEstados(String codigoEnvio) {
        return null;
    }

    public ArrayList<Marketplace> listarVentas() {
        return null;
    }

    public void editarEmpleado(String nombre, String direccion, String cedula,
                               String correoElectronico, String contrasena) {
    }

    public int calcularVentasMes(int mes) {
        return mes;
    }


    @Override
    public String toString() {
        return "Marketplace{" +
                "codigoVenta='" + codigoVenta + '\'' +
                ", fechaVenta=" + fechaVenta +
                ", descripcion='" + descripcion + '\'' +
                ", totalVenta=" + totalVenta +
                ", tipoVenta=" + tipoVenta +
                ", estadoVenta=" + estadoVenta +
                ", empleadoAsociado=" + empleadoAsociado +
                ", vendedorAsociado=" + vendedorAsociado +
                '}';
    }
}
