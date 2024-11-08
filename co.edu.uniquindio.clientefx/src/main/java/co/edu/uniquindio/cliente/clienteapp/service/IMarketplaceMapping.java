package co.edu.uniquindio.cliente.clienteapp.service;

import co.edu.uniquindio.cliente.clienteapp.mapping.dto.EmpleadoDto;
import co.edu.uniquindio.cliente.clienteapp.mapping.dto.VendedorDto;
import co.edu.uniquindio.cliente.clienteapp.model.Empleado;
import co.edu.uniquindio.cliente.clienteapp.model.Vendedor;

import java.util.List;

public interface IMarketplaceMapping {

    List<VendedorDto> getVendedoresDto(List<Vendedor> listaVendedores);

    List<EmpleadoDto> getEmpleadosDto(List<Empleado> listaEmpleados);

    List<Vendedor> getVendedores(List<VendedorDto> listaVendedoresDto);

    List<Empleado> getEmpleados(List<EmpleadoDto> listaEmpleadosDto);

    VendedorDto vendedorToVendedorDto(Vendedor vendedor);

    EmpleadoDto empleadoToEmpleadoDto(Empleado empleado);

    Vendedor vendedorDtoToVendedor(VendedorDto vendedorDto);

    Empleado empleadoDtoToEmpleado(EmpleadoDto empleadoDto);
}
