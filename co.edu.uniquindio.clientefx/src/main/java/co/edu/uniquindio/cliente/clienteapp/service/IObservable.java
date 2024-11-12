package co.edu.uniquindio.cliente.clienteapp.service;

import co.edu.uniquindio.cliente.clienteapp.controller.observer.Observador;

public interface IObservable {

    void agregarObservador(Observador observador);
    void removerObservador(Observador observador);
    void notificarObservadores(String mensaje);
}
