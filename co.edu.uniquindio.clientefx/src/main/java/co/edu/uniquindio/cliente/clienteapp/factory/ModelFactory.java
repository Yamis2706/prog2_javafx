package co.edu.uniquindio.cliente.clienteapp.factory;

import co.edu.uniquindio.cliente.clienteapp.mapping.dto.EmpleadoDto;
import co.edu.uniquindio.cliente.clienteapp.mapping.dto.VendedorDto;
import co.edu.uniquindio.cliente.clienteapp.mapping.dto.MarketplaceDto;
import co.edu.uniquindio.cliente.clienteapp.mapping.mappers.MarketplaceMappingImpl;
import co.edu.uniquindio.cliente.clienteapp.model.Empleado;
import co.edu.uniquindio.cliente.clienteapp.model.Persona;
import co.edu.uniquindio.cliente.clienteapp.model.Vendedor;
import co.edu.uniquindio.cliente.clienteapp.model.MarketplaceProducto;
import co.edu.uniquindio.cliente.clienteapp.service.IMarketplaceMapping;
import co.edu.uniquindio.cliente.clienteapp.service.IModelFactoryService;
import co.edu.uniquindio.cliente.clienteapp.utils.DataUtil;

import java.util.List;

public class ModelFactory implements IModelFactoryService {

    private static ModelFactory modelFactory;
    private MarketplaceProducto marketplaceProducto;
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
            marketplaceProducto = DataUtil.inicializarDatos();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void crearVendedor(VendedorDto vendedor) throws Exception{
        Vendedor vendedorMappping = mapper.vendedorDtoToVendedor(vendedor);
        marketplaceProducto.crearVendedor(vendedorMappping);
    }

    @Override
    public void editarVendedor(VendedorDto vendedor) throws Exception{
        Vendedor vendedorMappping = mapper.vendedorDtoToVendedor(vendedor);
        marketplaceProducto.editarVendedor(vendedorMappping);
    }

    @Override
    public void eliminarVendedor(String cedula) throws Exception{
        marketplaceProducto.eliminarVendedor(cedula);
    }

    @Override
    public void obtenerVendedor(String cedula) throws Exception{
        marketplaceProducto.obtenerVendedor(cedula);
    }


    @Override
    public void crearEmpleado(EmpleadoDto empleado) throws Exception{
        Empleado empleadoMappping = mapper.empleadoDtoToEmpleado(empleado);
        marketplaceProducto.crearEmpleado(empleadoMappping);
    }

    @Override
    public void editarEmpleado(EmpleadoDto empleado) throws Exception{
        Empleado empleadoMappping = mapper.empleadoDtoToEmpleado(empleado);
        marketplaceProducto.editarEmpleado(empleadoMappping);
    }

    @Override
    public void eliminarEmpleado(String cedula) throws Exception{
        marketplaceProducto.eliminarEmpleado(cedula);
    }

    @Override
    public void obtenerEmpleado(String cedula) throws Exception{
        marketplaceProducto.obtenerEmpleado(cedula);
    }

    @Override
    public List<VendedorDto> listarVendedores() {
        return mapper.getVendedoresDto(marketplaceProducto.listarVendedores());
    }

    @Override
    public List<EmpleadoDto> listarEmpleados() {
        return mapper.getEmpleadosDto(marketplaceProducto.listarEmpleados());
    }

    @Override
    public void crearVinculo(Vendedor v1, Vendedor v2) {

    }

    @Override
    public void calcularVentasMes(MarketplaceDto venta) {

    }

    public Persona validarUsuario(String correo, String contrasena) throws Exception{
        return marketplaceProducto.validarUsuario(correo, contrasena);
    }

}
