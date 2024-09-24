package co.edu.uniquindio.cliente.clienteapp.model;

public class Cliente {

    private String nombre;
    private String apellido;
    private String cedula;
    private int edad;
    private String direccion;
    private String celular;


    public Cliente() {
    }

    public Cliente(String nombre,
                   String apellido,
                   String cedula,
                   int edad,
                   String direccion,
                   String celular
                   ) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.edad = edad;
        this.direccion = direccion;
        this.celular = celular;

    }


    //public static ClienteBuilder builder(){
      //  return new ClienteBuilder();
    //}


    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public int getEdad() {
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

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCelular(String celular) {
        this.celular = celular;
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
                '}';
    }
}
