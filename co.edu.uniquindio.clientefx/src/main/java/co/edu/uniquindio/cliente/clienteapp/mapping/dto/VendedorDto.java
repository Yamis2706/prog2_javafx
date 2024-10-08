package co.edu.uniquindio.cliente.clienteapp.mapping.dto;

import co.edu.uniquindio.cliente.clienteapp.model.Categoria;

public record VendedorDto(
        String nombre,
        String apellido,
        String cedula,
        String edad,
        String direccion,
        String celular,
        Categoria categoria

) {
}