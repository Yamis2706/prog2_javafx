package co.edu.uniquindio.cliente.clienteapp.model;

import co.edu.uniquindio.cliente.clienteapp.enums.Categoria;
import co.edu.uniquindio.cliente.clienteapp.enums.EstadoVenta;
import co.edu.uniquindio.cliente.clienteapp.enums.TipoVenta;
import co.edu.uniquindio.cliente.clienteapp.factory.VentaContado;
import co.edu.uniquindio.cliente.clienteapp.factory.VentaCredito;
import co.edu.uniquindio.cliente.clienteapp.service.CreacionVenta;
import co.edu.uniquindio.cliente.clienteapp.utils.Constantes;

import java.util.ArrayList;
import java.util.List;

public class MarketplaceProducto {

    private List<Vendedor> vendedores;
    private List<Empleado> empleados;
    private List<Venta> ventas;
    private List<Factura> facturas;


    public MarketplaceProducto(){

        this.vendedores = new ArrayList<>();
        this.empleados = new ArrayList<>();
        this.ventas = new ArrayList<>();
        this.facturas = new ArrayList<>();

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

    public Venta crearVenta(Vendedor vendedor1, Vendedor vendedor2,
                            ArrayList<Producto> productos,
                            TipoVenta tipoVenta, EstadoVenta estadoVenta) throws Exception {

        CreacionVenta creacionVenta;
        if (tipoVenta == TipoVenta.CONTADO) {
            creacionVenta = new VentaContado();
        } else {
            creacionVenta = new VentaCredito();
        }

        Venta venta = creacionVenta.crearVenta(vendedor1, vendedor2, productos, tipoVenta, estadoVenta);
        int ventasMes = calcularVentasMes(venta.getFechaCreacion().getMonthValue());
        float valor = creacionVenta.calcularCostoVenta(venta, ventasMes);
        String codigo = crearCodigoVenta();
        Factura factura = creacionVenta.crearFactura(venta, valor, codigo);

        ventas.add(venta);
        facturas.add(factura);
        guardarDatos();

        return venta;

    }

    private void guardarDatos() {
    }

    private String crearCodigoVenta() {
        return "";
    }


    public int calcularVentasMes(int mes) {
        int ventasMes = 0;

        for (Venta venta : ventas) {
            if (venta.getFechaCreacion().getMonthValue() == mes) {
                ventasMes++;
            }
        }
        return ventasMes;
    }


    public Empleado obtenerEmpleado(String cedula) {

        Empleado empleado= null;

        for (int i = 0; i < empleados.size(); i++) {
            if(empleados.get(i).getCedula().equals(cedula)){
                empleado = empleados.get(i);
            }
        }
        return empleado;
    }

}
