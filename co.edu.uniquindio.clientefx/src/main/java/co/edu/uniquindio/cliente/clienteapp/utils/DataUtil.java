package co.edu.uniquindio.cliente.clienteapp.utils;

import co.edu.uniquindio.cliente.clienteapp.model.Categoria;
import co.edu.uniquindio.cliente.clienteapp.model.Cliente;
import co.edu.uniquindio.cliente.clienteapp.model.VentaObjeto;

public class DataUtil {

    public static VentaObjeto inicializarDatos(){

        VentaObjeto ventaObjeto = new VentaObjeto();

        ventaObjeto.crearCliente( new Cliente("Cliente 1", "Apellido", "12123",
                "33", "Calle 123", "121212121", Categoria.BASICO) );

        ventaObjeto.crearCliente( new Cliente("Cliente 2", "Apellido", "23232",
                "33", "Calle 323", "4343434", Categoria.PREMIUM) );

        return ventaObjeto;

    }
}
