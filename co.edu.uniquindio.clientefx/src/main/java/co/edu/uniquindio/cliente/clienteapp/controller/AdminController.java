package co.edu.uniquindio.cliente.clienteapp.controller;

import co.edu.uniquindio.cliente.clienteapp.factory.ModelFactory;

public class AdminController {

    ModelFactory modelFactory;

    public AdminController(){
        System.out.println("Llamando al singleton desde EmpleadoServiceController");
        modelFactory = ModelFactory.getInstancia();
    }

    public boolean agregarVendedor(String nombre, String cedula) {
        return modelFactory.crearVendedor(nombre, cedula);
    }

    public boolean eliminarVendedor(String cedula) {
        return modelFactory.eliminarVendedor(cedula);
    }
}