package co.edu.uniquindio.cliente.clienteapp.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Venta {
    private String numeroVenta;
    private Date fechaVenta;
    private Date fechaEntregaObjeto;
    private String descripcion;
    private Empleado empleadoAsociado;
    private Cliente clienteAsociado;
    List<Objeto> listaObjetosAsociados = new ArrayList<>();


    public Venta() {
    }

    public String getNumeroVenta() {
        return numeroVenta;
    }

    public void setNumeroVenta(String numeroVenta) {
        this.numeroVenta = numeroVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Date getFechaEntregaObjeto() {
        return fechaEntregaObjeto;
    }

    public void setFechaEntregaObjeto(Date fechaEntregaObjeto) {
        this.fechaEntregaObjeto = fechaEntregaObjeto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Empleado getEmpleadoAsociado() {
        return empleadoAsociado;
    }

    public void setEmpleadoAsociado(Empleado empleadoAsociado) {
        this.empleadoAsociado = empleadoAsociado;
    }

    public Cliente getClienteAsociado() {
        return clienteAsociado;
    }

    public void setClienteAsociado(Cliente clienteAsociado) {
        this.clienteAsociado = clienteAsociado;
    }

    public List<Objeto> getListaObjetosAsociados() {
        return listaObjetosAsociados;
    }

    public void setListaObjetosAsociados(List<Objeto> listaObjetosAsociados) {
        this.listaObjetosAsociados = listaObjetosAsociados;
    }
}
