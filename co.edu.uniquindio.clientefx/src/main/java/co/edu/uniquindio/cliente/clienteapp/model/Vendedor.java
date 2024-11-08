package co.edu.uniquindio.cliente.clienteapp.model;

import co.edu.uniquindio.cliente.clienteapp.enums.Categoria;
import co.edu.uniquindio.cliente.clienteapp.model.builder.VendedorBuilder;


public class Vendedor {

    private String nombre;
    private String apellido;
    private String cedula;
    private String edad;
    private String direccion;
    private String celular;
    private Categoria categoria;
    private String correo;
    private String contrasena;

    public Vendedor() {
    }

    public Vendedor(String nombre,
                    String apellido,
                    String cedula,
                    String edad,
                    String direccion,
                    String celular,
                    Categoria categoria,
                    String correo,
                    String contrasena
                    ) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.edad = (edad);
        this.direccion = direccion;
        this.celular = celular;
        this.categoria = categoria;
        this.correo = correo;
        this.contrasena = contrasena;
    }


    public static VendedorBuilder builder(){
        return new VendedorBuilder();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", cedula='" + cedula + '\'' +
                ", edad=" + edad +
                ", direccion='" + direccion + '\'' +
                ", celular='" + celular + '\'' +
                ", categoria='" + categoria + '\'' +
                ", correo='" + correo + '\'' +
                ", contrasena='" + contrasena + '\'' +

                '}';
    }
}



//public static VendedorBuilder builder(){
//  return new VendedorBuilder();
//}
