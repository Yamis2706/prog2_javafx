package co.edu.uniquindio.cliente.clienteapp.model.builder;

import co.edu.uniquindio.cliente.clienteapp.enums.Categoria;
import co.edu.uniquindio.cliente.clienteapp.model.Empleado;
import co.edu.uniquindio.cliente.clienteapp.model.Vendedor;

public class EmpleadoBuilder {

    protected String nombre;
    protected String apellido;
    protected String cedula;
    protected String edad;
    protected String direccion;
    protected String celular;
    protected String correo;
    protected String contrasena;




    public EmpleadoBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public EmpleadoBuilder apellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public EmpleadoBuilder cedula(String cedula) {
        this.cedula = cedula;
        return this;
    }

    public EmpleadoBuilder edad(String edad) {
        this.edad = edad;
        return this;
    }

    public EmpleadoBuilder direccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public EmpleadoBuilder celular(String celular) {
        this.celular = celular;
        return this;
    }

    public EmpleadoBuilder correo(String celular) {
        this.correo = correo;
        return this;
    }

    public EmpleadoBuilder contrasena(String celular) {
        this.contrasena = contrasena;
        return this;
    }


    public Empleado build() {
        return new Empleado(nombre,  apellido,  cedula,  edad,
                 direccion,  celular, correo,
                 contrasena);
    }
}
