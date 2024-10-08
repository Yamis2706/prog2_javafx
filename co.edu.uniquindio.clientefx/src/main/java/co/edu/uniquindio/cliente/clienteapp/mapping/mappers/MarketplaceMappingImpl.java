package co.edu.uniquindio.cliente.clienteapp.mapping.mappers;


import co.edu.uniquindio.cliente.clienteapp.mapping.dto.VendedorDto;
import co.edu.uniquindio.cliente.clienteapp.model.Vendedor;
import co.edu.uniquindio.cliente.clienteapp.service.IMarketplaceMapping;

import java.util.ArrayList;
import java.util.List;

public class MarketplaceMappingImpl implements IMarketplaceMapping {


    @Override
    public List<VendedorDto> getClientesDto(List<Vendedor> listaClientes) {
        if(listaClientes == null){
            return null;
        }
        List<VendedorDto> listaClientesDto = new ArrayList<VendedorDto>(listaClientes.size());
        for (Vendedor cliente : listaClientes) {
            listaClientesDto.add(clienteToClienteDto(cliente));
        }

        return listaClientesDto;
    }

    @Override
    public VendedorDto clienteToClienteDto(Vendedor cliente) {
        return new VendedorDto(
                cliente.getNombre(),
                cliente.getApellido(),
                cliente.getCedula(),
                cliente.getEdad(),
                cliente.getDireccion(),
                cliente.getCelular(),
                cliente.getCategoria());
    }

    @Override
    public Vendedor clienteDtoToCliente(VendedorDto clienteDto) {
        return Vendedor.builder()
                .nombre(clienteDto.nombre())
                .apellido(clienteDto.apellido())
                .cedula(clienteDto.cedula())
                .edad(clienteDto.edad())
                .direccion(clienteDto.direccion())
                .celular(clienteDto.celular())
                .categoria(clienteDto.categoria())
                .build();
    }
}
