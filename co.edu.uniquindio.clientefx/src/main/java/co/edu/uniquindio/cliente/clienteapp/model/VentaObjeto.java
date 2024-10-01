package co.edu.uniquindio.cliente.clienteapp.model;

import java.util.ArrayList;
import java.util.List;

public class VentaObjeto {

    private List<Cliente> clientes;

    public VentaObjeto(){
        this.clientes = new ArrayList<>();
    }

    public void crearCliente(Cliente cliente){
        clientes.add(cliente);
    }

    public void editarCliente(Cliente clienteEditado){
        Cliente cliente = obtenerCliente(clienteEditado.getCedula());
        cliente.setNombre(clienteEditado.getNombre());
        cliente.setApellido(clienteEditado.getApellido());
        cliente.setCedula(clienteEditado.getCedula());
        cliente.setCelular(clienteEditado.getCelular());
        cliente.setCategoria(clienteEditado.getCategoria());
        cliente.setDireccion(clienteEditado.getDireccion());
        cliente.setEdad(clienteEditado.getEdad());

    }

    public void eliminarCliente(String cedula){
        Cliente cliente = obtenerCliente(cedula);
        clientes.remove(cliente);
    }

    public Cliente obtenerCliente(String cedula){

        Cliente cliente= null;

        for (int i = 0; i < clientes.size(); i++) {
            if(clientes.get(i).getCedula().equals(cedula)){
                cliente = clientes.get(i);
            }
        }
        return cliente;
    }

    public List<Cliente> listarClientes() {
        return clientes;
    }
}
