package co.edu.uniquindio.cliente.clienteapp.controller;

import co.edu.uniquindio.cliente.clienteapp.factory.ModelFactory;
import co.edu.uniquindio.cliente.clienteapp.mapping.dto.VendedorDto;
import co.edu.uniquindio.cliente.clienteapp.model.Vendedor;

import java.util.List;

public class VendedorController {

    ModelFactory modelFactory;

    public VendedorController(){
        modelFactory  = ModelFactory.getInstancia();
    }

    public void crearVendedor(VendedorDto vendedor) throws Exception {
        modelFactory.crearVendedor(vendedor);
    }

    public void editarVendedor(VendedorDto vendedor) throws Exception{
        modelFactory.editarVendedor(vendedor);
    }

    public void eliminarVendedor(String cedula) throws Exception{
        modelFactory.eliminarVendedor(cedula);
    }

    public List<VendedorDto> listarVendedores() {
        return modelFactory.listarVendedores();
    }

}