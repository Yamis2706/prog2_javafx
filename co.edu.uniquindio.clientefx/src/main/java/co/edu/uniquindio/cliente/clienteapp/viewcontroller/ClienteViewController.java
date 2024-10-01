package co.edu.uniquindio.cliente.clienteapp.viewcontroller;


import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.cliente.clienteapp.controller.ClienteController;
import co.edu.uniquindio.cliente.clienteapp.mapping.dto.ClienteDto;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ClienteViewController {


    ClienteController clienteController;
    ObservableList<ClienteDto> listaClientes = FXCollections.observableArrayList();
    ClienteDto clienteSeleccionado;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnNuevo;

    @FXML
    private TableView<ClienteDto> tableCliente;

    @FXML
    private TableColumn<ClienteDto, String> tcNombre;

    @FXML
    private TableColumn<ClienteDto, String> tcApellido;

    @FXML
    private TableColumn<ClienteDto, String> tcCedula;

    @FXML
    private TableColumn<ClienteDto, String> tcEdad;


    @FXML
    private TableColumn<ClienteDto, String> tcDireccion;

    @FXML
    private TableColumn<ClienteDto, String> tcTelefono;


    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextField txtdireccion;

    @FXML
    private TextField txtTelefono;



    @FXML
    void initialize() {
        clienteController = new ClienteController();
        initView();
    }

    private void initView() {
        initDataBinding();
        obtenerClientes();
        tableCliente.getItems().clear();
        tableCliente.setItems(listaClientes);
        listenerSelection();
    }

    private void obtenerClientes() {
        listaClientes.addAll(clienteController.obtenerClientes());
    }

    private void initDataBinding() {
        tcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombre()));
        tcApellido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().apellido()));
        tcCedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().cedula()));
        tcEdad.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().edad()));
        tcDireccion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().direccion()));
        tcCelular.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().celular()));
        tcCategoria.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().categoria()));
    }

    private void listenerSelection() {
        tableCliente.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            clienteSeleccionado = newSelection;
            mostrarInformacionCliente(clienteSeleccionado);
        });
    }

    private void mostrarInformacionCliente(ClienteDto clienteSeleccionado) {
        if(clienteSeleccionado != null){
            txtNombre.setText(clienteSeleccionado.nombre());
            txtApellido.setText(clienteSeleccionado.apellido());
            txtCedula.setText(clienteSeleccionado.cedula());
            txtEdad.setText(String.valueOf(clienteSeleccionado.edad()));
            txtdireccion.setText(clienteSeleccionado.direccion());
            txtTelefono.setText(clienteSeleccionado.celular());
        }
    }

    @FXML
    void onActualizarCliente(ActionEvent event) {

    }

    @FXML
    void onAgregarCliente(ActionEvent event) {

    }

    @FXML
    void onEliminarCliente(ActionEvent event) {

    }

    @FXML
    void onNuevoCliente(ActionEvent event) {

    }

}


