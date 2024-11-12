package co.edu.uniquindio.cliente.clienteapp.viewcontroller;

import co.edu.uniquindio.cliente.clienteapp.controller.AdminController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    private AdminController adminController;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnEliminar;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtxCedulaEliminar;

    private MarketplaceAppController marketplaceController;

    public void setMarketplaceController(MarketplaceAppController marketplaceController) {
        this.marketplaceController = marketplaceController;
    }

    @FXML
    void onActionAgregar(ActionEvent event) {
        agregarVendedor();
    }

    @FXML
    void onActionEliminar(ActionEvent event) throws Exception {
        eliminarVendedor();
    }

    @FXML
    void initialize() {
        adminController = new AdminController();
    }

    private void agregarVendedor() {
        String nombre = txtNombre.getText();
        String cedula = txtCedula.getText();
        if (cedula != null && !cedula.isEmpty()) {
            if(adminController.agregarVendedor(nombre, cedula)){
                marketplaceController.agregarTabVendedor(cedula);
            }else{
                System.out.println("Vendedor ya existe");
            }
        } else {
            System.out.println("Cédula no puede estar vacía.");
        }
    }

    private void eliminarVendedor() throws Exception {
        String cedula = txtxCedulaEliminar.getText();
        if (cedula != null && !cedula.isEmpty()) {
            if(adminController.eliminarVendedor(cedula)){
                marketplaceController.eliminarTabVendedor(cedula);
            }
        }
    }
}
