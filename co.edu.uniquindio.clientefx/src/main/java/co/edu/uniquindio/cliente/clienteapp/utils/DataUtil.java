package co.edu.uniquindio.cliente.clienteapp.utils;

import co.edu.uniquindio.cliente.clienteapp.model.Categoria;
import co.edu.uniquindio.cliente.clienteapp.model.Vendedor;
import co.edu.uniquindio.cliente.clienteapp.model.MarketplaceObjeto;

public class DataUtil {

    public static MarketplaceObjeto inicializarDatos() throws Exception{

        MarketplaceObjeto marketplaceObjeto = new MarketplaceObjeto();

        marketplaceObjeto.crearVendedor( new Vendedor("Daniel ", "Quintero",
                "12123",
                "27", "Calle 123", "121212121", Categoria.BASICO) );

        marketplaceObjeto.crearVendedor( new Vendedor("Emily", "Londoño",
                "23232",
                "19", "Calle 323", "4343434", Categoria.PREMIUM) );

        marketplaceObjeto.crearVendedor( new Vendedor("Yamis", "Burgos",
                "761781",
                "38", "Calle 567", "312256", Categoria.VIP) );

        return marketplaceObjeto;
    }
}
