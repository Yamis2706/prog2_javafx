package co.edu.uniquindio.cliente.clienteapp.service;

import co.edu.uniquindio.cliente.clienteapp.model.Vendedor;

import java.util.List;

/**
 * Contrato
 */
public interface IModelFactoryService {

    void editarVendedor(Vendedor vendedor);

    void eliminarVendedor(String cedula);

    void crearVendedor(Vendedor vendedor);

    List<Vendedor> listarVendedores();

    void crearVinculo(Vendedor v1, Vendedor v2);

   //void obtenerClientesPorCiudad(String ciudad);

}
