package co.edu.uniquindio.cliente.clienteapp.model;

import co.edu.uniquindio.cliente.clienteapp.enums.Categoria;
import co.edu.uniquindio.cliente.clienteapp.model.builder.VendedorBuilder;


public class Vendedor extends Persona{

    private String direccion;
    private String celular;
    private Categoria categoria;

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

        super(nombre, apellido, cedula, edad, correo, contrasena);
        this.direccion = direccion;
        this.celular = celular;
        this.categoria = categoria;

    }


    public static VendedorBuilder builder(){
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

}



//public static VendedorBuilder builder(){
//  return new VendedorBuilder();
//}
