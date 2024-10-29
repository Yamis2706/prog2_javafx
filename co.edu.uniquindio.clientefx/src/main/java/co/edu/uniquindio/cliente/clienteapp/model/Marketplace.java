package co.edu.uniquindio.cliente.clienteapp.model;


import co.edu.uniquindio.cliente.clienteapp.enums.Categoria;
import co.edu.uniquindio.cliente.clienteapp.enums.EstadoVenta;
import co.edu.uniquindio.cliente.clienteapp.enums.TipoVenta;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Marketplace {
    private String numeroVenta;
    private Date fechaVenta;
    private Date fechaEntregaProducto;
    private String descripcion;
    private Empleado empleadoAsociado;
    private Vendedor vendedorAsociado;
    List<Producto> listaProductosAsociados = new ArrayList<>();


    public Marketplace() {
    }

    public String getNumeroVenta() {
        return numeroVenta;
    }

    public void setNumeroVenta(String numeroVenta) {
        this.numeroVenta = numeroVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Date getFechaEntregaProducto() {
        return fechaEntregaProducto;
    }

    public void setFechaEntregaProducto(Date fechaEntregaProducto) {
        this.fechaEntregaProducto = fechaEntregaProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public List<Producto> getListaProductosAsociados() {
        return listaProductosAsociados;
    }

    public void setListaProductosAsociados(List<Producto> listaObjetosAsociados) {
        this.listaProductosAsociados = listaProductosAsociados;
    }


    public Venta crearventa(Vendedor vendedor1, Vendedor vendedor2,
                            ArrayList<Producto> productos, TipoVenta tipoVenta,
                            EstadoVenta estadoVenta) {
        return null;
    }

    public Factura obtenerFactura() {
        return null;
    }

    public Venta obtenerVenta() {
        return null;
    }

    public ArrayList<Venta> listarTodasVentas() {
        return null;
    }

    public ArrayList<Venta> listarVentasFecha(LocalDate fecha) {
        return null;
    }

    public ArrayList<Venta> listarVentasEstado(EstadoVenta estadoVenta) {
        return null;
    }

    public ArrayList<Venta> listarVentasFechaEstado(LocalDate fecha, EstadoVenta estadoVenta) {
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

    public Venta crearventa() {
        return null;
    }

    public void cambiarEstadoVenta(String codigoVenta, EstadoVenta estadoVenta, String descripcion) {
    }

    public Venta buscarVentaCodigo(String codigoVenta) {
        return null;
    }

    public ArrayList<Historial> consultarHistorialEstados(String codigoEnvio) {
        return null;
    }

    public ArrayList<Venta> listarVentas() {
        return null;
    }

    public void editarEmpleado(String nombre, String direccion, String cedula, String correoElectronico, String contrasena) {
    }

    public int calcularVentasMes(int mes) {
        return mes;
    }
}
