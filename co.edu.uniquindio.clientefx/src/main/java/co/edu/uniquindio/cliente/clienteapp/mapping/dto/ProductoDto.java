package co.edu.uniquindio.cliente.clienteapp.mapping.dto;

public record ProductoDto (
        String nombre,
        Enum categoria,
        double precio,
        Enum estado,
        String idProducto,
        String descripcion


        )

{

}
