package co.edu.uniquindio.cliente.clienteapp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class InicioController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Cedula: 109488, Celular: 312256");
    }
    private final PrincipalController principalController;

    public InicioController() {
        principalController = PrincipalController.getInstancia();
    }

    public void irIniciarSesion(ActionEvent event) {
        principalController.navegar("/login.fxml","Marketplace - Iniciar " +
                "Sesión");
    }

    public void irRegistroEmpleado(ActionEvent event) {
        principalController.navegar("/registro.fxml", "Marketplace - Registro de empleados");
    }

    public void irActualizar(ActionEvent event) {
        principalController.navegar("/editarEmpleado.fxml", "Marketplace - " +
                "Actualizar empleado");
    }

}
