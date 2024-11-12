package co.edu.uniquindio.cliente.clienteapp.utils;

import co.edu.uniquindio.cliente.clienteapp.enums.Categoria;
import co.edu.uniquindio.cliente.clienteapp.model.*;

import static co.edu.uniquindio.cliente.clienteapp.enums.EstadoProducto.PUBLICADO;

public class DataUtil {

    private static Producto productoDecorado;

    public static MarketplaceProducto inicializarDatos() throws Exception{

        MarketplaceProducto marketplaceProducto = new MarketplaceProducto();

        marketplaceProducto.crearVendedor( new Vendedor("Daniel ", "Quintero",
                "12123",
                "27", "Calle 123", "121212121", Categoria.BASICO, "@daniel",
                "123") );

        marketplaceProducto.crearVendedor( new Vendedor("Emily", "Londoño",
                "23232",
                "19", "Calle 323", "4343434", Categoria.PREMIUM, "@emily",
                "456" ) );

        marketplaceProducto.crearVendedor( new Vendedor("Yamis", "Burgos",
                "109488",
                "38", "Calle 567", "312256", Categoria.VIP, "@yamis",
                "789") );



        marketplaceProducto.crearEmpleado( new Empleado("Sara", "Montes",
                "56345",
                "27", "Calle 45", "987654", "@sara",
                "593") );

        marketplaceProducto.crearEmpleado( new Empleado("Felipe", "Castaño",
                "34567",
                "45", "Calle 29", "362861", "@felipe",
                "496") );

        marketplaceProducto.crearEmpleado( new Empleado("Camila", "Sánchez",
                "97253",
                "19", "Calle 03", "752954", "@camila",
                "270") );




        marketplaceProducto.crearProducto(new Producto(productoDecorado.getNombre(),
                productoDecorado.getCategoria(), productoDecorado.getPrecio(),
                productoDecorado.getEstado(), productoDecorado.getIdProducto(),
                productoDecorado.getDescripcion()));

        Producto producto = new Producto("SPlus", "Smartphone", 500000,
                PUBLICADO, "Sm304", "Teléfono de alta gama");

        producto = new PromocionDecorator(producto, 0.20);

        producto = new GarantiaExtendidaDecorator(producto, 24);


        return marketplaceProducto;



    }


}
