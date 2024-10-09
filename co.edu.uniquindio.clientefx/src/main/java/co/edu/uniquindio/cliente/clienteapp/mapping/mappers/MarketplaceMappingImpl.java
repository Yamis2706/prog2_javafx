package co.edu.uniquindio.cliente.clienteapp.mapping.mappers;


import co.edu.uniquindio.cliente.clienteapp.mapping.dto.VendedorDto;
import co.edu.uniquindio.cliente.clienteapp.model.Vendedor;
import co.edu.uniquindio.cliente.clienteapp.service.IMarketplaceMapping;

import java.util.ArrayList;
import java.util.List;

public class MarketplaceMappingImpl implements IMarketplaceMapping {



    @Override
    public List<VendedorDto> getVendedoresDto(List<Vendedor> listaVendedores) {
        if(listaVendedores == null){
            return null;
        }
        List<VendedorDto> listaVendedoresDto =
                new ArrayList<VendedorDto>(listaVendedores.size());
        for (Vendedor vendedor : listaVendedores) {
            listaVendedoresDto.add(vendedorToVendedorDto(vendedor));
        }

        return listaVendedoresDto;
    }


    @Override
    public List<Vendedor> getVendedores(List<VendedorDto> listaVendedoresDto) {
        if(listaVendedoresDto == null){
            return null;
        }
        List<Vendedor> listaVendedores = new ArrayList<Vendedor>(listaVendedoresDto.size());
        for (VendedorDto vendedor : listaVendedoresDto) {
            listaVendedores.add(vendedorDtoToVendedor(vendedor));
        }

        return listaVendedores;
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
