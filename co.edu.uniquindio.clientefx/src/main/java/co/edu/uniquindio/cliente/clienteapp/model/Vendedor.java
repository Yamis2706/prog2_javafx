package co.edu.uniquindio.cliente.clienteapp.model;

import co.edu.uniquindio.cliente.clienteapp.controller.observer.Observador;
import co.edu.uniquindio.cliente.clienteapp.enums.Categoria;
import co.edu.uniquindio.cliente.clienteapp.model.builder.VendedorBuilder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Vendedor extends Persona implements Observador {


    private String direccion;
    private String celular;
    private Categoria categoria;
    private Set<Vendedor> aliados = new HashSet<>();
    private ArrayList<Object> productos = new ArrayList<>();
    private List<Observador> aliadosObservadores = new ArrayList<>();



    public Vendedor(String nombre,
                    String apellido,
                    String cedula,
                    String edad,
                    String direccion,
                    String celular,
                    Categoria categoria,
                    String correo,
                    String contrasena,
                    ArrayList<Object> productos
    ) {

        super(nombre, apellido, cedula, edad, correo, contrasena);
        this.direccion = direccion;
        this.celular = celular;
        this.categoria = categoria;
        this.productos = productos;
    }

    public Vendedor() {
    }

    public static VendedorBuilder builder() {
        return new VendedorBuilder();
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }


    public void agregarAliado(Vendedor vendedor) {
        if (aliados.size() < 10) {
            aliados.add(vendedor);
            vendedor.getAliados().add(aliados.add(vendedor));
        }
    }

    public void agregarProducto(Producto producto, Vendedor vendedor) {
        productos.add(producto);
        notificarObservadores("Nuevo producto agregado por " + vendedor + ": "
                + producto.getNombre());
    }

    public void cambiarEstadoProducto(Producto producto, Enum nuevoEstado,
                                      Vendedor vendedor) {
        producto.setEstado(nuevoEstado);
        notificarObservadores("El producto " + producto.getNombre() + " de " + vendedor +
                " ha cambiado a estado: " + nuevoEstado);
    }

    @Override
    public void actualizar(String mensaje) {
        System.out.println("Notificación: " + mensaje);
    }


    public void agregarObservador(Observador observador) {
        aliadosObservadores.add(observador);
    }


    public void removerObservador(Observador observador) {
        aliadosObservadores.remove(observador);
    }

    public void notificarObservadores(String mensaje) {


        for (Observador observador : aliadosObservadores) {
            observador.actualizar(mensaje);
        }

    }


    <E> List<E> getAliados() {
        return List.of();
    }

    public <E> List<E> getProductos() {
        return List.of();
    }

    @Override
    public void notificar() throws Exception {

    }
}





    /*
    public Vendedor(String nombre, String apellido, String cedula, String direccion,
                    String usuario, String contrasena) {


        this.direccion = direccion;
        this.celular = celular;
        this.categoria = categoria;


        this.productos = new ArrayList<>();
        this.aliados = new ArrayList<>();
    }

     */




