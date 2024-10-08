package co.edu.uniquindio.cliente.clienteapp.factory;

import co.edu.uniquindio.cliente.clienteapp.mapping.mappers.MarketplaceMappingImpl;
import co.edu.uniquindio.cliente.clienteapp.model.Categoria;
import co.edu.uniquindio.cliente.clienteapp.model.Vendedor;
import co.edu.uniquindio.cliente.clienteapp.model.MarketplaceObjeto;
import co.edu.uniquindio.cliente.clienteapp.service.IMarketplaceMapping;
import co.edu.uniquindio.cliente.clienteapp.service.IModelFactoryService;
import co.edu.uniquindio.cliente.clienteapp.utils.DataUtil;

import java.util.List;

public class ModelFactory implements IModelFactoryService {
    private static ModelFactory modelFactory;
    private MarketplaceObjeto ventaObjeto;
    private IMarketplaceMapping mapper;

    public static ModelFactory getInstancia() {
        if(modelFactory == null) {
            modelFactory = new ModelFactory();
        }
        return modelFactory;
    }

    private ModelFactory(){
        mapper = new MarketplaceMappingImpl();
        ventaObjeto = DataUtil.inicializarDatos();
    }

    private void inicializarDatos(){
        Vendedor cliente1 = Vendedor.builder()
                .nombre("Sara")
                .apellido("López")
                .cedula("1091")
                .edad("24")
                .direccion("Calarcá")
                .celular("312256")
                .categoria(Categoria.VIP)
                .build();

        Vendedor cliente2 = Vendedor.builder()
                .nombre("Emily")
                .apellido("Quintero")
                .cedula("1090")
                .edad("19")
                .direccion("Armenia")
                .celular("302284")
                .categoria(Categoria.PREMIUM)
                .build();
    }

    /*@Override
    public List<VendedorDto> obtenerClientes() {
        return mapper.getClienteDto(ventaObjeto.getListaClientes());
    }*/

    @Override
    public void crearVendedor(Vendedor vendedor) {
        ventaObjeto.crearVendedor(vendedor);
    }

    @Override
    public void crearCliente(Vendedor cliente) {

    }

    @Override
    public void editarCliente(Vendedor cliente) {

    }

    @Override
    public void eliminarCliente(String cedula) {

    }

    @Override
    public void editarVendedor(Vendedor vendedor) {
        ventaObjeto.editarVendedor(vendedor);
    }

    @Override
    public void eliminarVendedor(String cedula) {
        ventaObjeto.eliminarVendedor(cedula);
    }

    @Override
    public List<Vendedor> listarClientes() {
        return List.of();
    }

    @Override
    public List<Vendedor> listarVendedores() {
        return ventaObjeto.listarVendedores();
    }

    @Override
    public void crearVinculo(Vendedor v1, Vendedor v2) {

    }
}
