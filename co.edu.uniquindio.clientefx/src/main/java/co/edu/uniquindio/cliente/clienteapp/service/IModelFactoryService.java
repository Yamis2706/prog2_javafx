package co.edu.uniquindio.cliente.clienteapp.service;

import co.edu.uniquindio.cliente.clienteapp.mapping.dto.EmpleadoDto;
import co.edu.uniquindio.cliente.clienteapp.mapping.dto.ProductoDto;
import co.edu.uniquindio.cliente.clienteapp.mapping.dto.VendedorDto;
import co.edu.uniquindio.cliente.clienteapp.mapping.dto.MarketplaceDto;
import co.edu.uniquindio.cliente.clienteapp.model.Vendedor;

import java.util.List;

/**
 * Contrato
 */
public interface IModelFactoryService {

    void crearEmpleado(EmpleadoDto empleado) throws Exception;

    void editarVendedor(VendedorDto vendedor) throws Exception;

    void eliminarVendedor(String cedula) throws Exception;

    void crearVendedor(VendedorDto vendedor) throws Exception;

    void obtenerVendedor(String cedula) throws Exception;

    void editarEmpleado(EmpleadoDto empleado) throws Exception;

    void eliminarEmpleado(String cedula) throws Exception;

    void obtenerEmpleado(String cedula) throws Exception;

    List<VendedorDto> listarVendedores();

    List<EmpleadoDto> listarEmpleados();

    List<ProductoDto> listarProductos();

    void crearVinculo(Vendedor v1, Vendedor v2);

    void calcularVentasMes(MarketplaceDto venta);

   //void obtenerClientesPorCiudad(String ciudad);

}
