package co.edu.uniquindio.cliente.clienteapp.controller;

import co.edu.uniquindio.cliente.clienteapp.factory.ModelFactory;
import co.edu.uniquindio.cliente.clienteapp.model.Cliente;

import java.util.List;

public class ClienteController {

    private ModelFactory modelFactory = ModelFactory.getInstancia();

    public void crearCliente(Cliente cliente) {
        modelFactory.crearCliente(cliente);
    }

    public void editarCliente(Cliente cliente) {
        modelFactory.editarCliente(cliente);
    }

    public void eliminarCliente(String cedula) {
        modelFactory.eliminarCliente(cedula);
    }

    public List<Cliente> listarClientes() {
        return modelFactory.listarClientes();
    }

}