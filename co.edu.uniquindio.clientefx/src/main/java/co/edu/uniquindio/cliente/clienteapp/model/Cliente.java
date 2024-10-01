package co.edu.uniquindio.cliente.clienteapp.model;

import co.edu.uniquindio.cliente.clienteapp.model.builder.ClienteBuilder;


public class Cliente {

    private String nombre;
    private String apellido;
    private String cedula;
    private String edad;
    private String direccion;
    private String celular;
    private Categoria categoria;

    public Cliente() {
    }

    public Cliente(String nombre,
                   String apellido,
                   String cedula,
                   String edad,
                   String direccion,
                   String celular,
                   Categoria categoria
                   ) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.edad = (edad);
        this.direccion = direccion;
        this.celular = celular;
        this.categoria = categoria;
    }

    public static ClienteBuilder builder(){
        return new ClienteBuilder();
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public String getEdad() {
        return edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCelular() {
        return celular;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", cedula='" + cedula + '\'' +
                ", edad=" + edad +
                ", direccion='" + direccion + '\'' +
                ", celular='" + celular + '\'' +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}



//public static ClienteBuilder builder(){
//  return new ClienteBuilder();
//}
