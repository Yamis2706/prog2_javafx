package co.edu.uniquindio.cliente.clienteapp.controller.observer;

public interface Observador {

    void notificar() throws Exception;
    void actualizar(String mensaje);


}
