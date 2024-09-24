package co.edu.uniquindio.cliente_fx.cliente_fx.controller;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.cliente_fx.cliente_fx.controller.ClienteController;
import co.edu.uniquindio.cliente_fx.cliente_fx.model.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ClienteController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAgregarCliente;

    @FXML
    private RadioButton rbtnClienteBasico;

    @FXML
    private RadioButton rbtnClientePremium;

    @FXML
    private RadioButton rbtnClienteVIP;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtCelular;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextArea txtResultado;

    @FXML
    void onAgregarCliente(ActionEvent event) {
        agregarCliente();
    }

    @FXML
    void initialize() {
    }


    private void agregarCliente() {

        Cliente cliente = new Cliente();

        cliente.setNombre(txtNombre.getText());
        cliente.setApellido(txtApellido.getText());
        cliente.setCedula(txtCedula.getText());
        cliente.setEdad(Integer.parseInt(txtEdad.getText()));
        cliente.setDireccion(txtDireccion.getText());
        cliente.setCelular(txtCelular.getText());
        txtResultado.setText(cliente.toString());


    }

}
