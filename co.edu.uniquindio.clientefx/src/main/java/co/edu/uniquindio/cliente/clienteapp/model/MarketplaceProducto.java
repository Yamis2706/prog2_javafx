package co.edu.uniquindio.cliente.clienteapp.model;

import co.edu.uniquindio.cliente.clienteapp.enums.Categoria;
import co.edu.uniquindio.cliente.clienteapp.enums.EstadoVenta;
import co.edu.uniquindio.cliente.clienteapp.enums.TipoVenta;
import co.edu.uniquindio.cliente.clienteapp.factory.VentaContado;
import co.edu.uniquindio.cliente.clienteapp.factory.VentaCredito;
import co.edu.uniquindio.cliente.clienteapp.service.CreacionVenta;
import co.edu.uniquindio.cliente.clienteapp.utils.Constantes;
import com.sun.management.UnixOperatingSystemMXBean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MarketplaceProducto {

    private List<Persona> personas;
    private List<Marketplace> ventas;
    private List<Factura> factura;

    public MarketplaceProducto(){
        this.personas = new ArrayList<>();
        this.ventas = new ArrayList<>();
        this.factura = new ArrayList<>();
    }


    public void crearVendedor(Vendedor vendedor) throws Exception{


        if(vendedor.getNombre() == null || vendedor.getNombre().isBlank()){
            throw new Exception(Constantes.INGRESE_NOMBRE);
        }

        if(vendedor.getApellido() == null || vendedor.getApellido().isBlank()){
            throw new Exception(Constantes.INGRESE_APELLIDO);
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

        personas.add(vendedor);
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
        personas.remove(vendedor);
    }

    public Vendedor obtenerVendedor(String cedula){

        Vendedor vendedor= null;

        for (int i = 0; i < personas.size(); i++) {
            if(personas.get(i).getCedula().equals(cedula) && personas.get(i) instanceof Vendedor){
                vendedor = (Vendedor) personas.get(i);
            }
        }
        return vendedor;
    }

    public Factura obtenerFactura(){
        return (Factura) factura;
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
        List<Vendedor> lista = new ArrayList<>();

        for(Persona persona : personas){
            if(persona instanceof  Vendedor){
                lista.add((Vendedor) persona);
            }
        }

        return lista;

    }
    public List<Empleado> listarEmpleados() {
        List<Empleado> lista = new ArrayList<>();

        for(Persona persona : personas){
            if(persona instanceof  Empleado){
                lista.add((Empleado) persona);
            }
        }

        return lista;
    }

    public Marketplace crearVenta(Vendedor vendedor1, Vendedor vendedor2,
                            ArrayList<Producto> productos,
                            TipoVenta tipoVenta, EstadoVenta estadoVenta) throws Exception {

        CreacionVenta creacionVenta;
        if (tipoVenta == TipoVenta.CONTADO) {
            creacionVenta = new VentaContado();
        } else {
            creacionVenta = new VentaCredito();
        }

        Marketplace venta = creacionVenta.crearVenta(vendedor1, vendedor2, productos,
                tipoVenta, estadoVenta);
        int ventasMes = calcularVentasMes(venta.getFechaVenta().getMonth());
        float valor = creacionVenta.calcularCostoVenta(venta, ventasMes);
        String codigo = crearCodigoVenta();
        Factura factura = creacionVenta.crearFactura(venta, valor, codigo);

        ventas.add(venta);
        //facturas.add(factura);
        guardarDatos();

        return venta;

    }

    public ArrayList<Marketplace> listarTodasVentas() {
        return null;
    }

    public ArrayList<Marketplace> listarVentasFecha(LocalDate fecha) {
        return null;
    }

    public ArrayList<Marketplace> listarVentasEstado(EstadoVenta estadoVenta) {
        return null;
    }

    public Marketplace buscarVentaCodigo(String codigoVenta) {
        return null;
    }


    private void guardarDatos() {
    }

    private String crearCodigoVenta() {
        return "";
    }


    public int calcularVentasMes(int mes) {
        int ventasMes = 0;

        for (Marketplace venta : ventas) {
            if (venta.getFechaVenta().getMonth() == mes) {
                ventasMes++;
            }
        }
        return ventasMes;
    }




    public void crearEmpleado(Empleado empleado) throws Exception{


        if(empleado.getNombre() == null || empleado.getNombre().isBlank()){
            throw new Exception(Constantes.INGRESE_NOMBRE);
        }

        if(empleado.getApellido() == null || empleado.getApellido().isBlank()){
            throw new Exception(Constantes.INGRESE_APELLIDO);
        }


        if(empleado.getCedula() == null || empleado.getCedula().isBlank()){
            throw new Exception(Constantes.INGRESE_CEDULA);
        }


        if(empleado.getEdad() == null || empleado.getEdad().isBlank()){
            throw new Exception(Constantes.INGRESE_EDAD);
        }

        if(empleado.getDireccion() == null || empleado.getDireccion().isBlank()){
            throw new Exception(Constantes.INGRESE_DIRECCION);
        }

        if(empleado.getCelular() == null || empleado.getCelular().isBlank()){
            throw new Exception(Constantes.INGRESE_CELULAR);
        }

        if(empleado.getCorreo() == null || empleado.getCorreo().isBlank()){
            throw new Exception(Constantes.INGRESE_CORREO);
        }

        if(empleado.getContrasena() == null || empleado.getContrasena().isBlank()){
            throw new Exception(Constantes.INGRESE_CONTRASENA);
        }

        if( obtenerEmpleado( empleado.getCedula() ) !=null ){
            throw new Exception(Constantes.CEDULA_EXISTENTE);
        }

        personas.add(empleado);
    }

    public void editarEmpleado(Empleado empleadoEditado) throws Exception{
        Empleado empleado = obtenerEmpleado(empleadoEditado.getCedula());
        empleado.setNombre(empleadoEditado.getNombre());
        empleado.setApellido(empleadoEditado.getApellido());
        empleado.setCedula(empleadoEditado.getCedula());
        empleado.setEdad(empleadoEditado.getEdad());
        empleado.setDireccion(empleadoEditado.getDireccion());
        empleado.setCelular(empleadoEditado.getCelular());

    }

    public void eliminarEmpleado(String cedula) throws Exception{
        Empleado empleado = obtenerEmpleado(cedula);
        personas.remove(empleado);
    }


    public Empleado obtenerEmpleado(String cedula) {

        Empleado empleado= null;

        for (int i = 0; i < personas.size(); i++) {
            if(personas.get(i).getCedula().equals(cedula) && personas.get(i) instanceof Empleado) {
                empleado = (Empleado) personas.get(i);
            }
        }
        return empleado;
    }


    public Persona validarUsuario(String correo, String contrasena) throws Exception{
        Persona persona = buscarPorCorreo(correo);
        if (persona!= null){
            if (persona.getContrasena().equals(contrasena)){
                return persona;
            }
        }
        throw new Exception("Los datos de acceso son incorrectos");
    }

    private Persona buscarPorCorreo(String correo){

        for(Persona persona : personas){
            if(persona.getCorreo().equals(correo)){
                return persona;
            }
        }

        return  null;
    }



    public void crearProducto(Producto producto) {
    }

    public void obtenerProducto(Producto producto) {
    }

    public void actualizarProducto(Producto producto) {
    }

    public void eliminarProducto(Producto producto) {
    }

    public List<Producto> listarProductos() {
        return List.of();
    }
}
