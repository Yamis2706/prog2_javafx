package co.edu.uniquindio.cliente.clienteapp.controller;

import co.edu.uniquindio.cliente.clienteapp.factory.ModelFactory;
import co.edu.uniquindio.cliente.clienteapp.model.Empleado;
import co.edu.uniquindio.cliente.clienteapp.model.Persona;
import co.edu.uniquindio.cliente.clienteapp.model.Sesion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    private final ModelFactory modelFactory;

    public LoginController(){
        modelFactory = ModelFactory.getInstancia();
    }

    public Persona validarUsuario(String correo, String contrasena) throws Exception{
        return modelFactory.validarUsuario(correo, contrasena);
    }
}
