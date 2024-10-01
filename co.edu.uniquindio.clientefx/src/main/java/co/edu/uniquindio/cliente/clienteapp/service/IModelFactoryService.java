package co.edu.uniquindio.cliente.clienteapp.service;

import co.edu.uniquindio.cliente.clienteapp.model.Cliente;
import co.edu.uniquindio.cliente.clienteapp.model.Vendedor;

import java.util.List;

/**
 * Contrato
 */
public interface IModelFactoryService {

    void crearCliente(Cliente cliente);

    void editarCliente(Cliente cliente);

    void eliminarCliente(String cedula);

    List<Cliente> listarClientes();

    void crearVendedor(Vendedor vendedor);

    void crearVinculo(Vendedor v1, Vendedor v2);

}
