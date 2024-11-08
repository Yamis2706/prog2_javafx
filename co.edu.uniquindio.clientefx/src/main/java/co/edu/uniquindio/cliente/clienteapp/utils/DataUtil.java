package co.edu.uniquindio.cliente.clienteapp.utils;

import co.edu.uniquindio.cliente.clienteapp.enums.Categoria;
import co.edu.uniquindio.cliente.clienteapp.model.Vendedor;
import co.edu.uniquindio.cliente.clienteapp.model.MarketplaceProducto;

public class DataUtil {

    public static MarketplaceProducto inicializarDatos() throws Exception{

        MarketplaceProducto marketplaceProducto = new MarketplaceProducto();

        marketplaceProducto.crearVendedor( new Vendedor("Daniel ", "Quintero",
                "12123",
                "27", "Calle 123", "121212121", Categoria.BASICO) );

        marketplaceProducto.crearVendedor( new Vendedor("Emily", "Londoño",
                "23232",
                "19", "Calle 323", "4343434", Categoria.PREMIUM ) );

        marketplaceProducto.crearVendedor( new Vendedor("Yamis", "Burgos",
                "109488",
                "38", "Calle 567", "312256", Categoria.VIP) );

        return marketplaceProducto;
    }
}
