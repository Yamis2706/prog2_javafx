package co.edu.uniquindio.cliente.clienteapp.service;

import co.edu.uniquindio.cliente.clienteapp.model.Vendedor;

import java.util.List;

/**
 * Contrato
 */
public interface IModelFactoryService {

    void crearCliente(Vendedor cliente);

    void editarCliente(Vendedor cliente);

    void eliminarCliente(String cedula);

    void editarVendedor(Vendedor vendedor);

    void eliminarVendedor(String cedula);

    List<Vendedor> listarClientes();

    void crearVendedor(Vendedor vendedor);

    List<Vendedor> listarVendedores();

    void crearVinculo(Vendedor v1, Vendedor v2);

   //void obtenerClientesPorCiudad(String ciudad);

}
