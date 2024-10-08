package co.edu.uniquindio.cliente.clienteapp.model;

import java.util.ArrayList;
import java.util.List;

public class MarketplaceObjeto {

    List<Vendedor> listaVendedores = new ArrayList<>();
    List<Empleado> listaEmpleados = new ArrayList<>();
    List<Objeto> listaObjetos = new ArrayList<>();
    List<Marketplace> listaVentas = new ArrayList<>();

    private String nombre;

    private List<Vendedor> vendedores;

    public MarketplaceObjeto(){
        this.vendedores = new ArrayList<>();
    }

    public void crearVendedor(Vendedor cliente){
        vendedores.add(cliente);
    }

    public void editarVendedor(Vendedor vendedorEditado){
        Vendedor vendedor = obtenerVendedor(vendedorEditado.getCedula());
        vendedor.setNombre(vendedorEditado.getNombre());
        vendedor.setApellido(vendedorEditado.getApellido());
        vendedor.setCedula(vendedorEditado.getCedula());
        vendedor.setEdad(vendedorEditado.getEdad());
        vendedor.setDireccion(vendedorEditado.getDireccion());
        vendedor.setCelular(vendedorEditado.getCelular());
        vendedor.setCategoria(vendedorEditado.getCategoria());

    }

    public void eliminarVendedor(String cedula){
        Vendedor vendedor = obtenerVendedor(cedula);
        vendedores.remove(vendedor);
    }

    public Vendedor obtenerVendedor(String cedula){

        Vendedor vendedor= null;

        for (int i = 0; i < vendedores.size(); i++) {
            if(vendedores.get(i).getCedula().equals(cedula)){
                vendedor = vendedores.get(i);
            }
        }
        return vendedor;
    }


    private Vendedor getBuildVendedor(String nombre, String apellido,
                                     String cedula, String edad,
                                     String direccion, String celular,
                                     Categoria categoria) {
        return Vendedor.builder()
                .nombre(nombre)
                .apellido(apellido)
                .cedula(cedula)
                .edad(edad)
                .direccion(direccion)
                .celular(celular)
                .categoria(categoria)
                .build();
    }

    public List<Vendedor> listarVendedores() {
        return vendedores;
    }

   /* public String obtenerClientesPorCiudad(String ciudad) {
        String resultado = "";

        for (Vendedor cliente: getListaClientes()) {
            if(cliente.getDireccion().equalsIgnoreCase(ciudad)){
                resultado = resultado + cliente.toString()+ "\n";
            }
        }

        return resultado;
    }*/
}
