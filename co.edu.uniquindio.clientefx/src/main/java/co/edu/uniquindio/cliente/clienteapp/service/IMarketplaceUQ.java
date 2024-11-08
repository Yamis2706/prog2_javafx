package co.edu.uniquindio.cliente.clienteapp.service;


import co.edu.uniquindio.cliente.clienteapp.enums.Categoria;
import co.edu.uniquindio.cliente.clienteapp.enums.EstadoProducto;
import co.edu.uniquindio.cliente.clienteapp.enums.EstadoVenta;
import co.edu.uniquindio.cliente.clienteapp.enums.TipoVenta;
import co.edu.uniquindio.cliente.clienteapp.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface IMarketplaceUQ {
    boolean crearVendedor(String nombre,
                          String apellido,
                          String cedula,
                          String edad,
                          String direccion, 
                          String celular,
                          Categoria categoria);
    
    void eliminarVendedor(String cedula);
    List<Vendedor> obtenerVendedores();
    Vendedor obtenerVendedor(String cedula);
    void mostrarInformacionVendedores();
    void buscarVendedor(String cedula);
    boolean actualizarVendedor(String nombre,
                               String apellido,
                               String cedula,
                               String edad,
                               String direccion,
                               String celular,
                               Categoria categoria);

    boolean crearProducto(String nombre, String imagen,
                          String categoria, double precio,
                          EstadoProducto estado, String idProducto,
                          String descripcion);
    
    Producto obtenerProducto(String idProducto);
    
    Empleado obtenerEmpleado(String cedulaEmpleado);
    
    boolean crearVenta(String numeroVenta,
                       Date fechaVenta,
                       Date fechaEntrega,
                       String descripcion,
                       String cedulaVendedor,
                       String cedulaEmpleado,
                       String idProducto);

    boolean eliminarVenta(String numeroVenta);

    boolean actualizarVenta(String numeroVentaActual, 
                            String numeroVenta,
                            Date fechaVenta, 
                            Date fechaEntrega, 
                            String descripcion);

    Marketplace obtenerVenta(String numeroVenta);

    Marketplace crearVenta(Vendedor vendedor1, Vendedor vendedor2,
                     ArrayList<Producto> productos, TipoVenta tipoVenta,
                     EstadoVenta estadoVenta) throws Exception;

    Factura obtenerFactura();

    Marketplace obtenerVenta();

    ArrayList<Marketplace> listarTodasVentas() throws Exception;

    ArrayList<Marketplace> listarVentasFecha(LocalDate fecha) throws Exception;

    ArrayList<Marketplace> listarVentasEstado(EstadoVenta estadoVenta) throws Exception;

    ArrayList<Marketplace> listarVentasFechaEstado(LocalDate fecha,
                                             EstadoVenta estadoVenta) throws Exception;

    Vendedor agregarVendedor(String cedula, String nombre,
                             String direccion,
                             String ciudad, String numeroContacto, String correoElectronico) throws Exception;

    Vendedor agregarVendedor(String nombre,
                             String apellido,
                             String cedula,
                             String edad,
                             String direccion,
                             String celular,
                             Categoria categoria) throws Exception;

    Empleado validarUsuario(String cedula, String contrasena) throws Exception;

    void agregarEmpleado(String nombre, String apellido, String cedula,
                         String edad) throws Exception;

    void cambiarEstadoVenta(String codigoVenta, EstadoVenta estadoVenta,
                            String descripcion) throws Exception;

    ArrayList<Historial> consultarHistorialEstados(String codigoEnvio) throws Exception;

    ArrayList<Marketplace> listarVentas();

    void editarEmpleado(String nombre, String direccion, String cedula,
                        String correoElectronico, String contrasena) throws Exception;

    int calcularVentasMes(int mes);
}
