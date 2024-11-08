package co.edu.uniquindio.cliente.clienteapp.controller;

import co.edu.uniquindio.cliente.clienteapp.factory.ModelFactory;
import co.edu.uniquindio.cliente.clienteapp.mapping.dto.EmpleadoDto;
import co.edu.uniquindio.cliente.clienteapp.mapping.dto.VendedorDto;

import java.util.List;

public class EmpleadoController {

    ModelFactory modelFactory;

    public EmpleadoController(){
        modelFactory  = ModelFactory.getInstancia();
    }

    public void crearEmpleado(EmpleadoDto empleado) throws Exception {
        modelFactory.crearEmpleado(empleado);
    }

    public void editarEmpleado(EmpleadoDto empleado) throws Exception{
        modelFactory.editarEmpleado(empleado);
    }

    public void eliminarEmpleado(String cedula) throws Exception{
        modelFactory.eliminarEmpleado(cedula);
    }

    public List<EmpleadoDto> listarEmpleados() {
        return modelFactory.listarEmpleados();
    }

}
