package co.edu.uniquindio.cliente.clienteapp.service;

import co.edu.uniquindio.cliente.clienteapp.mapping.dto.VendedorDto;
import co.edu.uniquindio.cliente.clienteapp.model.Vendedor;

import java.util.List;

public interface IMarketplaceMapping {
    List<VendedorDto> getClientesDto(List<Vendedor> listaClientes);

    VendedorDto clienteToClienteDto(Vendedor cliente);

    Vendedor clienteDtoToCliente(VendedorDto clienteDto);
}
