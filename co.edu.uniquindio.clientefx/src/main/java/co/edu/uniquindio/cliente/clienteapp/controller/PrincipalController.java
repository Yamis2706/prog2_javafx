package co.edu.uniquindio.cliente.clienteapp.controller;

import co.edu.uniquindio.cliente.clienteapp.enums.Categoria;
import co.edu.uniquindio.cliente.clienteapp.enums.EstadoProducto;
import co.edu.uniquindio.cliente.clienteapp.enums.EstadoVenta;
import co.edu.uniquindio.cliente.clienteapp.enums.TipoVenta;
import co.edu.uniquindio.cliente.clienteapp.model.*;
import co.edu.uniquindio.cliente.clienteapp.service.IMarketplaceUQ;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PrincipalController implements IMarketplaceUQ {
    private final Marketplace marketplace;
    public static PrincipalController INSTANCIA;
    //private Sesion sesion;

    private PrincipalController() {
        marketplace = new Marketplace();
    }

    public static PrincipalController getInstancia() {
        if (INSTANCIA == null) {
            INSTANCIA = new PrincipalController();
        }
        return INSTANCIA;
    }

    public Sesion getInstanciaSesion() {
        return Sesion.getInstanciaSesion();
    }

    @Override
    public Venta crearVenta(Vendedor vendedor1, Vendedor vendedor2,
                            ArrayList<Producto> productos, TipoVenta tipoVenta,
                            EstadoVenta estadoVenta) throws Exception {
        return marketplace.crearventa(vendedor1, vendedor2, productos,
                tipoVenta, estadoVenta);
    }

    @Override
    public Factura obtenerFactura() {
        return marketplace.obtenerFactura();
    }

    @Override
    public Venta obtenerVenta() {
        return marketplace.obtenerVenta();
    }

    @Override
    public ArrayList<Venta> listarTodasVentas() throws Exception {
        return marketplace.listarTodasVentas();
    }


    @Override
    public ArrayList<Venta> listarVentasFecha(LocalDate fecha) throws Exception {
        return marketplace.listarVentasFecha(fecha);
    }


    @Override
    public ArrayList<Venta> listarVentasEstado(EstadoVenta estadoVenta) throws Exception {
        return marketplace.listarVentasEstado(estadoVenta);
    }

    @Override
    public ArrayList<Venta> listarVentasFechaEstado(LocalDate fecha,
                                                    EstadoVenta estadoVenta) throws Exception {
        return marketplace.listarVentasFechaEstado(fecha, estadoVenta);
    }

    @Override
    public Vendedor agregarVendedor(String cedula, String nombre, String direccion, String ciudad, String numeroContacto, String correoElectronico) throws Exception {
        return null;
    }

    @Override
    public Vendedor agregarVendedor(String nombre,
                                    String apellido,
                                    String cedula,
                                    String edad,
                                    String direccion,
                                    String celular,
                                    Categoria categoria) throws Exception {
        return marketplace.agregarVendedor(nombre, apellido, cedula, edad,
                direccion, celular, categoria);
    }

    @Override
    public boolean crearVendedor(String nombre, String apellido, String cedula, String edad, String direccion, String celular, Categoria categoria) {
        return false;
    }

    @Override
    public void eliminarVendedor(String cedula) {

    }

    @Override
    public List<Vendedor> obtenerVendedores() {
        return List.of();
    }

    @Override
    public Vendedor obtenerVendedor(String cedula) {
        return marketplace.obtenerVendedor(cedula);
    }

    @Override
    public void mostrarInformacionVendedores() {

    }

    @Override
    public void buscarVendedor(String cedula) {

    }

    @Override
    public boolean actualizarVendedor(String nombre, String apellido, String cedula,
                                      String edad, String direccion, String celular,
                                      Categoria categoria) {
        return false;
    }

    @Override
    public boolean crearProducto(String nombre, String imagen, String categoria,
                                 double precio, EstadoProducto estado, String idProducto,
                                 String descripcion) {
        return false;
    }

    @Override
    public Producto obtenerProducto(String idProducto) {
        return null;
    }

    @Override
    public Empleado obtenerEmpleado(String cedula) {
        return marketplace.obtenerEmpleado(cedula);
    }

    @Override
    public boolean crearVenta(String numeroVenta, Date fechaVenta, Date fechaEntrega, String descripcion, String cedulaVendedor, String cedulaEmpleado, String idProducto) {
        return false;
    }

    @Override
    public boolean eliminarVenta(String numeroVenta) {
        return false;
    }

    @Override
    public boolean actualizarVenta(String numeroVentaActual, String numeroVenta, Date fechaVenta, Date fechaEntrega, String descripcion) {
        return false;
    }

    @Override
    public Marketplace obtenerVenta(String numeroVenta) {
        return null;
    }

    @Override
    public Empleado validarUsuario(String cedula, String contrasena) throws Exception {
        return marketplace.validarUsuario(cedula, contrasena);
    }

    @Override
    public void agregarEmpleado(String nombre, String apellido, String cedula,
                                String edad) throws Exception {
        marketplace.agregarEmpleado(nombre, apellido, cedula, edad);
    }

    public Venta crearVenta(String codigoVenta,
                            float totalVenta,
                            ArrayList<Producto> productos,
                            ArrayList<Venta> historialVentas,
                            LocalDate fechaCreacion,
                            TipoVenta tipoVenta,
                            EstadoVenta estadoVenta) throws Exception {
        return marketplace.crearventa();
    }

    @Override
    public void cambiarEstadoVenta(String codigoVenta, EstadoVenta estadoVenta,
                                   String descripcion) throws Exception {
        marketplace.cambiarEstadoVenta(codigoVenta, estadoVenta, descripcion);
    }

    public Venta buscarVentaCodigo(String codigoVenta) throws Exception {
        return marketplace.buscarVentaCodigo(codigoVenta);
    }

    @Override
    public ArrayList<Historial> consultarHistorialEstados(String codigoEnvio) throws Exception {
        return marketplace.consultarHistorialEstados(codigoEnvio);
    }


    @Override
    public ArrayList<Venta> listarVentas() {
        return marketplace.listarVentas();
    }

    @Override
    public void editarEmpleado(String nombre, String direccion, String cedula,
                               String correoElectronico, String contrasena) throws Exception {
        marketplace.editarEmpleado(nombre, direccion, cedula, correoElectronico, contrasena);
    }

    @Override
    public int calcularVentasMes(int mes) {
        return marketplace.calcularVentasMes(mes);
    }

    public FXMLLoader navegar(String nombreVista, String titulo) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource(nombreVista));
            Parent root = loader.load();

            // Crear la escena
            Scene scene = new Scene(root);

            // Crear un nuevo escenario (ventana)
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle(titulo);

            // Mostrar la nueva ventana
            stage.show();

            return loader;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void navegarVentanaLogin(String nombreArchivoFxml, String tituloVentana,
                                    Empleado empleado) {

        try {

            // Cargar la vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource(nombreArchivoFxml));
            Parent root = loader.load();


            // Obtener el controlador de la nueva ventana
           /* Object controller = loader.getController();
            controller.inicializarValores(empleado);

            */

            // Crear la escena
            Scene scene = new Scene(root);

            // Crear un nuevo escenario (ventana)
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle(tituloVentana);

            // Mostrar la nueva ventana
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void navegarVentanaFactura(String nombreArchivoFxml, String tituloVentana, Node node) {

        try {

            // Cargar la vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource(nombreArchivoFxml));
            Parent root = loader.load();


            // Obtener el controlador de la nueva ventana
            FacturaController controller = loader.getController();
            controller.inicializarValores(node);

            // Crear la escena
            Scene scene = new Scene(root);

            // Crear un nuevo escenario (ventana)
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle(tituloVentana);

            // Mostrar la nueva ventana
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

