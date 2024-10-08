package co.edu.uniquindio.cliente.clienteapp.mapping.mappers;


import co.edu.uniquindio.cliente.clienteapp.mapping.dto.VendedorDto;
import co.edu.uniquindio.cliente.clienteapp.model.Vendedor;
import co.edu.uniquindio.cliente.clienteapp.service.IMarketplaceMapping;

import java.util.ArrayList;
import java.util.List;

public class MarketplaceMappingImpl implements IMarketplaceMapping {


    @Override
    public List<VendedorDto> getVendedoresDto(List<Vendedor> listavendedores) {
        if(listavendedores == null){
            return null;
        }
        List<VendedorDto> listaClientesDto = new ArrayList<VendedorDto>(listavendedores.size());
        for (Vendedor cliente : listavendedores) {
            listaClientesDto.add(vendedorToVendedorDto(cliente));
        }

        return listaClientesDto;
    }

    @Override
    public VendedorDto vendedorToVendedorDto(Vendedor vendedor) {
        return new VendedorDto(
                vendedor.getNombre(),
                vendedor.getApellido(),
                vendedor.getCedula(),
                vendedor.getEdad(),
                vendedor.getDireccion(),
                vendedor.getCelular(),
                vendedor.getCategoria());
    }

    @Override
    public Vendedor vendedorDtoToVendedor(VendedorDto vendedorDto) {
        return Vendedor.builder()
                .nombre(vendedorDto.nombre())
                .apellido(vendedorDto.apellido())
                .cedula(vendedorDto.cedula())
                .edad(vendedorDto.edad())
                .direccion(vendedorDto.direccion())
                .celular(vendedorDto.celular())
                .categoria(vendedorDto.categoria())
                .build();
    }
}
