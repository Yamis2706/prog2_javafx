package co.edu.uniquindio.cliente.clienteapp.model;

import co.edu.uniquindio.cliente.clienteapp.enums.Categoria;
import co.edu.uniquindio.cliente.clienteapp.model.builder.EmpleadoBuilder;
import co.edu.uniquindio.cliente.clienteapp.model.builder.VendedorBuilder;

public class Empleado extends  Persona{


    private String nombre;
    private String apellido;
    private String cedula;
    private String edad;
    private String direccion;
    private String celular;
    private Categoria categoria;
    private String correo;
    private String contrasena;
    MarketplaceProducto ownedByVentaUQ;

    public Empleado() {
    }

    public Empleado(String nombre, String apellido, String cedula, String edad,
                    String direccion, String celular, Categoria categoria, String correo,
                    String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.edad = edad;
        this.direccion = direccion;
        this.celular = celular;
        this.categoria = categoria;
        this.correo = correo;
        this.contrasena = contrasena;


    }


    public static EmpleadoBuilder builder(){
        return new EmpleadoBuilder();
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getApellido() {
        return apellido;
    }

    @Override
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String getCedula() {
        return cedula;
    }

    @Override
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    @Override
    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
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

    @Override
    public String getCorreo() {
        return correo;
    }

    @Override
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String getContrasena() {
        return contrasena;
    }

    @Override
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

}
