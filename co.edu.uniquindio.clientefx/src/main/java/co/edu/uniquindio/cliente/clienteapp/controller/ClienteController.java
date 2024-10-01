package co.edu.uniquindio.cliente.clienteapp.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import co.edu.uniquindio.cliente.clienteapp.mapping.dto.ClienteDto;
import co.edu.uniquindio.cliente.clienteapp.model.Categoria;
import co.edu.uniquindio.cliente.clienteapp.model.Cliente;
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

    private List<Cliente> clientes;

    @FXML
    void onAgregarCliente(ActionEvent event) {
        agregarCliente();
    }

    @FXML
    void initialize() {
        clientes = new ArrayList<>();
    }


    private void agregarCliente() {

        Cliente cliente = new Cliente();

        Categoria categoria = null;
        boolean clienteBasico = rbtnClienteBasico.isSelected();
        boolean clientePremium = rbtnClientePremium.isSelected();
        boolean clienteVIP = rbtnClienteVIP.isSelected();

        if(clienteBasico == true){
            categoria = Categoria.BASICO;
        }else if(clientePremium == true){
            categoria = Categoria.PREMIUM;
        } else if (clienteVIP == true) {
            categoria = Categoria.VIP;
        }

        cliente.setNombre(txtNombre.getText());
        cliente.setApellido(txtApellido.getText());
        cliente.setCedula(txtCedula.getText());
        cliente.setEdad(Integer.parseInt(txtEdad.getText()));
        cliente.setDireccion(txtDireccion.getText());
        cliente.setCelular(txtCelular.getText());
        cliente.setCategoria( categoria );

        clientes.add(cliente);

        txtResultado.setText(imprimirLista());

    }

    public String imprimirLista(){

        String texto = "";

        for(Cliente cliente : clientes){
            texto += cliente.toString() +"\n";
        }
        return texto;
    }

    public ClienteDto obtenerClientes() {
    }
}