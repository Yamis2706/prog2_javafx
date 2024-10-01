package co.edu.uniquindio.cliente.clienteapp.mapping.dto;

import co.edu.uniquindio.cliente.clienteapp.model.Categoria;

public record ClienteDto(
        String nombre,
        String apellido,
        String cedula,
        int edad,
        String direccion,
        String celular,
        Categoria categoria

) {
}