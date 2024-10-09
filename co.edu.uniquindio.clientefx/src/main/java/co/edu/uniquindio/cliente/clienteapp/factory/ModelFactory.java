package co.edu.uniquindio.cliente.clienteapp.factory;

import co.edu.uniquindio.cliente.clienteapp.mapping.dto.VendedorDto;
import co.edu.uniquindio.cliente.clienteapp.mapping.mappers.MarketplaceMappingImpl;
import co.edu.uniquindio.cliente.clienteapp.model.Vendedor;
import co.edu.uniquindio.cliente.clienteapp.model.MarketplaceObjeto;
import co.edu.uniquindio.cliente.clienteapp.service.IMarketplaceMapping;
import co.edu.uniquindio.cliente.clienteapp.service.IModelFactoryService;
import co.edu.uniquindio.cliente.clienteapp.utils.DataUtil;

import java.util.List;

public class ModelFactory implements IModelFactoryService {
    private static ModelFactory modelFactory;
    private MarketplaceObjeto marketplaceObjeto;
    private final IMarketplaceMapping mapper;

    public static ModelFactory getInstancia() {
        if(modelFactory == null) {
            modelFactory = new ModelFactory();
        }
        return modelFactory;
    }

    private ModelFactory(){
        mapper = new MarketplaceMappingImpl();
        try {
            marketplaceObjeto = DataUtil.inicializarDatos();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void crearVendedor(VendedorDto vendedor) throws Exception{
        Vendedor vendedorMappping = mapper.vendedorDtoToVendedor(vendedor);
        marketplaceObjeto.crearVendedor(vendedorMappping);
    }

    @Override
    public void editarVendedor(VendedorDto vendedor) throws Exception{
        Vendedor vendedorMappping = mapper.vendedorDtoToVendedor(vendedor);
        marketplaceObjeto.editarVendedor(vendedorMappping);
    }

    @Override
    public void eliminarVendedor(String cedula) throws Exception{
        marketplaceObjeto.eliminarVendedor(cedula);
    }

    @Override
    public void obtenerVendedor(String cedula) throws Exception{
        marketplaceObjeto.obtenerVendedor(cedula);
    }

    @Override
    public List<VendedorDto> listarVendedores() {
        return mapper.getVendedoresDto(marketplaceObjeto.listarVendedores());
    }

    @Override
    public void crearVinculo(Vendedor v1, Vendedor v2) {

    }
}
