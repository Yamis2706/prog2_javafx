package co.edu.uniquindio.cliente.clienteapp.controller;

import co.edu.uniquindio.cliente.clienteapp.model.Empleado;
import co.edu.uniquindio.cliente.clienteapp.model.Sesion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField txtCedula;

    @FXML
    private PasswordField txtContrasena;

    private final PrincipalController principalController;

    public LoginController(){
        principalController = PrincipalController.getInstancia();
    }

    public void logiarse(ActionEvent event){
        try {
            Empleado empleado = principalController.validarUsuario(
                    txtCedula.getText(),
                    txtContrasena.getText());
            Sesion sesion = principalController.getInstanciaSesion();
            sesion.setEmpleado(empleado);

            principalController.mostrarAlerta("Inicio de sesión exitoso",
                    Alert.AlertType.INFORMATION);
            principalController.navegarVentanaLogin("/MarketplaceApp.fxml",
                    "Marketplace - MarketplaceApp", empleado);
            principalController.cerrarVentana(e.getMessage(),
                    Alert.AlertType.ERROR);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
