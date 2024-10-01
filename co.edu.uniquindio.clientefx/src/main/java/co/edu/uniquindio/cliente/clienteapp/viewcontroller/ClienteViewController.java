package co.edu.uniquindio.cliente.clienteapp.viewcontroller;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import co.edu.uniquindio.cliente.clienteapp.controller.ClienteController;
import co.edu.uniquindio.cliente.clienteapp.mapping.dto.ClienteDto;
import co.edu.uniquindio.cliente.clienteapp.model.Categoria;
import co.edu.uniquindio.cliente.clienteapp.model.Cliente;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class ClienteViewController implements Initializable {

    private ClienteController clienteController;
    private ObservableList<Cliente> listaClientes = FXCollections.observableArrayList();
    private Cliente clienteSeleccionado;

    @FXML
    private Button btnActualizarCliente;

    @FXML
    private Button btnAgregarCliente;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnNuevoCliente;

    @FXML
    private RadioButton rbtnClienteBasico;

    @FXML
    private RadioButton rbtnClientePremium;

    @FXML
    private RadioButton rbtnClienteVIP;

    @FXML
    private TableView<Cliente> tvCliente;

    @FXML
    private TableColumn<Cliente, String> tcNombre;

    @FXML
    private TableColumn<Cliente, String> tcApellido;

    @FXML
    private TableColumn<Cliente, String> tcCedula;

    @FXML
    private TableColumn<Cliente, String> tcCategoria;

    @FXML
    private TableColumn<Cliente, String> tcCelular;

    @FXML
    private TableColumn<Cliente, String> tcDireccion;

    @FXML
    private TableColumn<Cliente, String> tcEdad;

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


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        clienteController = new ClienteController();
        initView();
    }

    private void initView() {
        initDataBinding();
        obtenerClientes();
        tvCliente.getItems().clear();
        tvCliente.setItems(listaClientes);
        listenerSelection();
    }

    private void obtenerClientes() {
        listaClientes.addAll(clienteController.listarClientes());
    }

    private void initDataBinding() {
        tcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tcApellido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellido()));
        tcCedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        tcEdad.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEdad()));
        tcDireccion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDireccion()));
        tcCelular.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCelular()));
        tcCategoria.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCategoria().toString()));
    }

    private void listenerSelection() {
        tvCliente.getSelectionModel().selectedItemProperty().addListener((obs,
                                                                  oldSelection, newSelection) -> {
            clienteSeleccionado = newSelection;
            mostrarInformacionCliente(clienteSeleccionado);
        });
    }

    private void mostrarInformacionCliente(Cliente clienteSeleccionado) {
        if(clienteSeleccionado != null){

            if(clienteSeleccionado.getCategoria() == Categoria.BASICO){
                rbtnClienteBasico.setSelected(true);
                rbtnClientePremium.setSelected(false);
                rbtnClienteVIP.setSelected(false);
            }else if(clienteSeleccionado.getCategoria() == Categoria.PREMIUM){
                rbtnClientePremium.setSelected(true);
                rbtnClienteBasico.setSelected(false);
                rbtnClienteVIP.setSelected(false);
            } else if (clienteSeleccionado.getCategoria() == Categoria.VIP) {
                rbtnClienteVIP.setSelected(true);
                rbtnClientePremium.setSelected(false);
                rbtnClienteBasico.setSelected(false);
            }

            txtNombre.setText(clienteSeleccionado.getNombre());
            txtApellido.setText(clienteSeleccionado.getApellido());
            txtCedula.setText(clienteSeleccionado.getCedula());
            txtEdad.setText(String.valueOf(clienteSeleccionado.getEdad()));
            txtDireccion.setText(clienteSeleccionado.getDireccion());
            txtCelular.setText(clienteSeleccionado.getCelular());

        }
    }

    @FXML
    void onActualizarCliente(ActionEvent event) {
        if(clienteSeleccionado!=null){

            clienteSeleccionado.setNombre(txtNombre.getText());
            clienteSeleccionado.setApellido(txtApellido.getText());
            clienteSeleccionado.setCedula(txtCedula.getText());
            clienteSeleccionado.setEdad(txtEdad.getText());
            clienteSeleccionado.setDireccion(txtDireccion.getText());
            clienteSeleccionado.setCelular(txtCelular.getText());
            clienteSeleccionado.setCategoria( clienteSeleccionado.getCategoria() );

            clienteController.editarCliente(clienteSeleccionado);

            int indice = listaClientes.indexOf(clienteSeleccionado);
            listaClientes.set(indice, clienteSeleccionado);
        }
    }

    @FXML
    void onAgregarCliente(ActionEvent event) {
        agregarCliente();
    }

    @FXML
    void onEliminarCliente(ActionEvent event) {

        if(clienteSeleccionado != null){
            clienteController.eliminarCliente(clienteSeleccionado.getCedula());
            listaClientes.remove(clienteSeleccionado);
        }

    }

    @FXML
    void onNuevoCliente(ActionEvent event) {
        txtNombre.setText("");
        txtApellido.setText("");
        txtCedula.setText("");
        txtEdad.setText("");
        txtDireccion.setText("");
        txtCelular.setText("");
        rbtnClienteBasico.setSelected(false);
        rbtnClientePremium.setSelected(false);
        rbtnClienteVIP.setSelected(false);
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
        cliente.setEdad(txtEdad.getText());
        cliente.setDireccion(txtDireccion.getText());
        cliente.setCelular(txtCelular.getText());
        cliente.setCategoria( categoria );

        listaClientes.add(cliente);
        clienteController.crearCliente(cliente);

    }


}


