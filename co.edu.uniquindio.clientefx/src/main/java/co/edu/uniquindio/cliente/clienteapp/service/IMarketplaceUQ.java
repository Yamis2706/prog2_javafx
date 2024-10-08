package co.edu.uniquindio.cliente.clienteapp.service;


import co.edu.uniquindio.cliente.clienteapp.model.*;

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
    List<Vendedor> obtenervendedores();
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

    boolean crearObjeto(String idObjeto, 
                        String descripcion);
    
    Objeto obtenerObjeto(String idObjeto);
    
    Empleado obtenerEmpleado(String cedulaEmpleado);
    
    boolean crearVenta(String numeroVenta,
                       Date fechaVenta,
                       Date fechaEntrega,
                       String descripcion,
                       String cedulaVendedor,
                       String cedulaEmpleado,
                       String idObjeto);

    boolean eliminarVenta(String numeroVenta);

    boolean actualizarVenta(String numeroVentaActual, 
                            String numeroVenta,
                            Date fechaVenta, 
                            Date fechaEntrega, 
                            String descripcion);

    Marketplace obtenerVenta(String numeroVenta);

}
