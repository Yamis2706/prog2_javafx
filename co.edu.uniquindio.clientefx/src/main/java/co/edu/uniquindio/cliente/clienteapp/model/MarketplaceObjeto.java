package co.edu.uniquindio.cliente.clienteapp.model;

import co.edu.uniquindio.cliente.clienteapp.utils.Constantes;

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

    public void crearVendedor(Vendedor vendedor) throws Exception{


        if(vendedor.getNombre() == null || vendedor.getNombre().isBlank()){
            throw new Exception(Constantes.INGRESE_NOMBRE);
        }

        if(vendedor.getApellido() == null || vendedor.getApellido().isBlank()){
            throw new Exception(Constantes.INGRESE_APELIIDO);
        }


        if(vendedor.getCedula() == null || vendedor.getCedula().isBlank()){
            throw new Exception(Constantes.INGRESE_CEDULA);
        }


        if(vendedor.getEdad() == null || vendedor.getEdad().isBlank()){
            throw new Exception(Constantes.INGRESE_EDAD);
        }

        if(vendedor.getDireccion() == null || vendedor.getDireccion().isBlank()){
            throw new Exception(Constantes.INGRESE_DIRECCION);
        }

        if(vendedor.getCelular() == null || vendedor.getCelular().isBlank()){
            throw new Exception(Constantes.INGRESE_CELULAR);
        }


        if( obtenerVendedor( vendedor.getCedula() ) !=null ){
            throw new Exception(Constantes.CEDULA_EXISTENTE);
        }

        vendedores.add(vendedor);
    }

    public void editarVendedor(Vendedor vendedorEditado) throws Exception{
        Vendedor vendedor = obtenerVendedor(vendedorEditado.getCedula());
        vendedor.setNombre(vendedorEditado.getNombre());
        vendedor.setApellido(vendedorEditado.getApellido());
        vendedor.setCedula(vendedorEditado.getCedula());
        vendedor.setEdad(vendedorEditado.getEdad());
        vendedor.setDireccion(vendedorEditado.getDireccion());
        vendedor.setCelular(vendedorEditado.getCelular());
        vendedor.setCategoria(vendedorEditado.getCategoria());

    }

    public void eliminarVendedor(String cedula) throws Exception{
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


    private Vendedor getListaVendedores(String nombre,
                                        String apellido,
                                        String cedula,
                                        String edad,
                                        String direccion,
                                        String celular,
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
}
