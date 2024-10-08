package co.edu.uniquindio.cliente.clienteapp.utils;

import co.edu.uniquindio.cliente.clienteapp.model.Categoria;
import co.edu.uniquindio.cliente.clienteapp.model.Vendedor;
import co.edu.uniquindio.cliente.clienteapp.model.MarketplaceObjeto;

public class DataUtil {

    public static MarketplaceObjeto inicializarDatos(){

        MarketplaceObjeto marketplaceObjeto = new MarketplaceObjeto();

        marketplaceObjeto.crearVendedor( new Vendedor("Vendedor 1", "Apellido",
                "12123",
                "33", "Calle 123", "121212121", Categoria.BASICO) );

        marketplaceObjeto.crearVendedor( new Vendedor("Vendedor 2", "Apellido", "23232",
                "33", "Calle 323", "4343434", Categoria.PREMIUM) );

        return new MarketplaceObjeto();

    }




}
