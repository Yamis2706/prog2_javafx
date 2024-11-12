package co.edu.uniquindio.cliente.clienteapp.model;

import java.util.HashMap;
import java.util.Map;

public class Autenticacion {

    private Map<String, String> credenciales = new HashMap<>();

    public boolean autenticar(String usuario, String contrasena) {
        return credenciales.containsKey(usuario) && credenciales.get(usuario).equals(contrasena);
    }

    public void registrarUsuario(String usuario, String contrasena) {
        credenciales.put(usuario, contrasena);
    }


}
