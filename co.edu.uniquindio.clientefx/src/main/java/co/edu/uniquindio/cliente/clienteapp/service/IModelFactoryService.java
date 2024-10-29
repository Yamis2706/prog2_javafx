package co.edu.uniquindio.cliente.clienteapp.service;

import co.edu.uniquindio.cliente.clienteapp.mapping.dto.VendedorDto;
import co.edu.uniquindio.cliente.clienteapp.mapping.dto.VentaDto;
import co.edu.uniquindio.cliente.clienteapp.model.Vendedor;

import java.util.List;

/**
 * Contrato
 */
public interface IModelFactoryService {

    void editarVendedor(VendedorDto vendedor) throws Exception;

    void eliminarVendedor(String cedula) throws Exception;

    void crearVendedor(VendedorDto vendedor) throws Exception;

    void obtenerVendedor(String cedula) throws Exception;

    void obtenerEmpleado(String cedula) throws Exception;

    List<VendedorDto> listarVendedores();

    void crearVinculo(Vendedor v1, Vendedor v2);

    void calcularVentasMes(VentaDto venta);

   //void obtenerClientesPorCiudad(String ciudad);

}
