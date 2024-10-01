package co.edu.uniquindio.cliente.clienteapp.factory;

import co.edu.uniquindio.cliente.clienteapp.mapping.dto.ClienteDto;
import co.edu.uniquindio.cliente.clienteapp.model.Cliente;
import co.edu.uniquindio.cliente.clienteapp.model.Vendedor;
import co.edu.uniquindio.cliente.clienteapp.model.VentaObjeto;
import co.edu.uniquindio.cliente.clienteapp.service.IModelFactoryService;
import co.edu.uniquindio.cliente.clienteapp.utils.DataUtil;

import java.util.List;

public class ModelFactory implements IModelFactoryService {
    private static ModelFactory modelFactory;
    private VentaObjeto ventaObjeto;
    //private IVentaMapping mapper;

    public static ModelFactory getInstancia() {
        if(modelFactory == null) {
            modelFactory = new ModelFactory();
        }
        return modelFactory;
    }

    private ModelFactory(){
        //mapper = new VentaMappingImpl();
        ventaObjeto = DataUtil.inicializarDatos();
    }


    /*@Override
    public List<ClienteDto> obtenerClientes() {
        return mapper.getClienteDto(ventaObjeto.getListaClientes());
    }*/

    @Override
    public void crearCliente(Cliente cliente) {
        ventaObjeto.crearCliente(cliente);
    }

    @Override
    public void editarCliente(Cliente cliente) {
        ventaObjeto.editarCliente(cliente);
    }

    @Override
    public void eliminarCliente(String cedula) {
        ventaObjeto.eliminarCliente(cedula);
    }

    @Override
    public List<Cliente> listarClientes() {
        return ventaObjeto.listarClientes();
    }

    @Override
    public void crearVendedor(Vendedor vendedor) {

    }

    @Override
    public void crearVinculo(Vendedor v1, Vendedor v2) {

    }
}
