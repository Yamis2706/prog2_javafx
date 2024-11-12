package co.edu.uniquindio.cliente.clienteapp.service;

import co.edu.uniquindio.cliente.clienteapp.model.Producto;
import co.edu.uniquindio.cliente.clienteapp.model.Vendedor;

public interface IStrategyTransaccion {

    boolean transaccionar(Vendedor vendedor1, Vendedor vendedor2, Producto producto);
}
