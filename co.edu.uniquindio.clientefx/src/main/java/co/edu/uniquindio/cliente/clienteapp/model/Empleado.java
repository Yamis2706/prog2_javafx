package co.edu.uniquindio.cliente.clienteapp.model;

import co.edu.uniquindio.cliente.clienteapp.enums.Categoria;
import co.edu.uniquindio.cliente.clienteapp.model.builder.EmpleadoBuilder;
import co.edu.uniquindio.cliente.clienteapp.model.builder.VendedorBuilder;

public class Empleado extends  Persona{

    private String direccion;
    private String celular;
    MarketplaceProducto ownedByVentaUQ;

    public Empleado() {
    }

    public Empleado(String nombre, String apellido, String cedula, String edad,
                    String direccion, String celular, String correo,
                    String contrasena) {
        super(nombre, apellido, cedula, edad, correo, contrasena);
        this.direccion = direccion;
        this.celular = celular;
    }



    public static EmpleadoBuilder builder(){
        return new EmpleadoBuilder();
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


}
