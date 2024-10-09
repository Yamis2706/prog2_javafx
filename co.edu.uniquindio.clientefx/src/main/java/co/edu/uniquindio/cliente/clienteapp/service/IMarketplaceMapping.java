package co.edu.uniquindio.cliente.clienteapp.service;

import co.edu.uniquindio.cliente.clienteapp.mapping.dto.VendedorDto;
import co.edu.uniquindio.cliente.clienteapp.model.Vendedor;

import java.util.List;

public interface IMarketplaceMapping {

    List<VendedorDto> getVendedoresDto(List<Vendedor> listaVendedores);

    List<Vendedor> getVendedores(List<VendedorDto> listaVendedoresDto);

    VendedorDto vendedorToVendedorDto(Vendedor vendedor);

    Vendedor vendedorDtoToVendedor(VendedorDto vendedorDto);
}
