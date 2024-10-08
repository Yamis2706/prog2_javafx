package co.edu.uniquindio.cliente.clienteapp.controller;

import co.edu.uniquindio.cliente.clienteapp.factory.ModelFactory;
import co.edu.uniquindio.cliente.clienteapp.model.Vendedor;

import java.util.List;

public class VendedorController {

    private ModelFactory modelFactory = ModelFactory.getInstancia();

    public void crearVendedor(Vendedor vendedor) {
        modelFactory.crearVendedor(vendedor);
    }

    public void editarVendedor(Vendedor vendedor) {
        modelFactory.editarVendedor(vendedor);
    }

    public void eliminarVendedor(String cedula) {
        modelFactory.eliminarVendedor(cedula);
    }

    public List<Vendedor> listarvendedores() {
        return modelFactory.listarVendedores();
    }

}