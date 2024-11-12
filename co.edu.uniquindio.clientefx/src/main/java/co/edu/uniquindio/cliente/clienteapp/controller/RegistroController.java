package co.edu.uniquindio.cliente.clienteapp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegistroControlador {

    @FXML
    private TextField txtCedula;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtCorreo;
    @FXML
    private TextField txtDireccion;
    @FXML
    private PasswordField txtPassword;

    private final MarketplaceController marketplaceController;

    public RegistroControlador() {
        marketplaceController = MarketplaceController.getInstancia();
    }


    public void registrarEmpleado(ActionEvent event) {

        try {
            marketplaceController.agregarEmpleado(txtNombre.getText(),
                    txtCedula.getText(),txtDireccion.getText(),txtCorreo.getText(),
                    txtPassword.getText());

            marketplaceController.mostrarAlerta("Empleado registrado correctamente",
                    Alert.AlertType.INFORMATION);
            marketplaceController.cerrarVentana(txtCedula);

        } catch (Exception e) {
            marketplaceController.mostrarAlerta(e.getMessage(), Alert.AlertType.ERROR);
        }
    }
}
