package co.edu.uniquindio.cliente.clienteapp.viewcontroller;


import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.cliente.clienteapp.controller.VendedorController;
import co.edu.uniquindio.cliente.clienteapp.model.Categoria;
import co.edu.uniquindio.cliente.clienteapp.model.Vendedor;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class VendedorViewController implements Initializable {

    private VendedorController vendedorController;
    private ObservableList<Vendedor> listaVendedores =
            FXCollections.observableArrayList();
    private Vendedor vendedorSeleccionado;

    @FXML
    private Button btnActualizarVendedor;

    @FXML
    private Button btnAgregarVendedor;

    @FXML
    private Button btnEliminarVendedor;

    @FXML
    private Button btnNuevoVendedor;

    @FXML
    private RadioButton rbtnVendedorBasico;

    @FXML
    private RadioButton rbtnVendedorPremium;

    @FXML
    private RadioButton rbtnVendedorVIP;

    @FXML
    private TableView<Vendedor> tvVendedor;

    @FXML
    private TableColumn<Vendedor, String> tcNombre;

    @FXML
    private TableColumn<Vendedor, String> tcApellido;

    @FXML
    private TableColumn<Vendedor, String> tcCedula;

    @FXML
    private TableColumn<Vendedor, String> tcCategoria;

    @FXML
    private TableColumn<Vendedor, String> tcCelular;

    @FXML
    private TableColumn<Vendedor, String> tcDireccion;

    @FXML
    private TableColumn<Vendedor, String> tcEdad;

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
        vendedorController = new VendedorController();
        initView();
    }

    private void initView() {
        initDataBinding();
        obtenerVendedores();
        tvVendedor.getItems().clear();
        tvVendedor.setItems(listaVendedores);
        listenerSelection();
    }

    private void obtenerVendedores() {
        listaVendedores.addAll(vendedorController.listarvendedores());
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
        tvVendedor.getSelectionModel().selectedItemProperty().addListener((obs,
                                                                  oldSelection, newSelection) -> {
            vendedorSeleccionado = newSelection;
            mostrarInformacionVendedor(vendedorSeleccionado);
        });
    }

    private void mostrarInformacionVendedor(Vendedor vendedorSeleccionado) {
        if(vendedorSeleccionado != null){

            if(vendedorSeleccionado.getCategoria() == Categoria.BASICO){
                rbtnVendedorBasico.setSelected(true);
                rbtnVendedorPremium.setSelected(false);
                rbtnVendedorVIP.setSelected(false);
            }else if(vendedorSeleccionado.getCategoria() == Categoria.PREMIUM){
                rbtnVendedorPremium.setSelected(true);
                rbtnVendedorBasico.setSelected(false);
                rbtnVendedorVIP.setSelected(false);
            } else if (vendedorSeleccionado.getCategoria() == Categoria.VIP) {
                rbtnVendedorVIP.setSelected(true);
                rbtnVendedorPremium.setSelected(false);
                rbtnVendedorBasico.setSelected(false);
            }

            txtNombre.setText(vendedorSeleccionado.getNombre());
            txtApellido.setText(vendedorSeleccionado.getApellido());
            txtCedula.setText(vendedorSeleccionado.getCedula());
            txtEdad.setText(String.valueOf(vendedorSeleccionado.getEdad()));
            txtDireccion.setText(vendedorSeleccionado.getDireccion());
            txtCelular.setText(vendedorSeleccionado.getCelular());

        }
    }

    @FXML
    void onActualizarVendedor(ActionEvent event) {
        if(vendedorSeleccionado!=null){

            vendedorSeleccionado.setNombre(txtNombre.getText());
            vendedorSeleccionado.setApellido(txtApellido.getText());
            vendedorSeleccionado.setCedula(txtCedula.getText());
            vendedorSeleccionado.setEdad(txtEdad.getText());
            vendedorSeleccionado.setDireccion(txtDireccion.getText());
            vendedorSeleccionado.setCelular(txtCelular.getText());
            vendedorSeleccionado.setCategoria( vendedorSeleccionado.getCategoria() );

            vendedorController.editarVendedor(vendedorSeleccionado);

            int indice = listaVendedores.indexOf(vendedorSeleccionado);
            listaVendedores.set(indice, vendedorSeleccionado);
        }
    }

    @FXML
    void onAgregarVendedor(ActionEvent event) {
        agregarVendedor();
    }

    @FXML
    void onEliminarVendedor(ActionEvent event) {

        if(vendedorSeleccionado != null){
            vendedorController.eliminarVendedor(vendedorSeleccionado.getCedula());
            listaVendedores.remove(vendedorSeleccionado);
        }

    }


    @FXML
    void onNuevoVendedor(ActionEvent event) {

        txtNombre.setText("");
        txtApellido.setText("");
        txtCedula.setText("");
        txtEdad.setText("");
        txtDireccion.setText("");
        txtCelular.setText("");
        rbtnVendedorBasico.setSelected(false);
        rbtnVendedorPremium.setSelected(false);
        rbtnVendedorVIP.setSelected(false);
    }

    private void agregarVendedor() {

        Vendedor vendedor = new Vendedor();

        Categoria categoria = null;
        boolean vendedorBasico = rbtnVendedorBasico.isSelected();
        boolean vendedorPremium = rbtnVendedorPremium.isSelected();
        boolean vendedorVIP = rbtnVendedorVIP.isSelected();

        if(vendedorBasico == true){
            categoria = Categoria.BASICO;
        }else if(vendedorPremium == true){
            categoria = Categoria.PREMIUM;
        } else if (vendedorVIP == true) {
            categoria = Categoria.VIP;
        }


       // String nombre = txtNombre.getText() ;

        vendedor.setNombre(txtNombre.getText());
        vendedor.setApellido(txtApellido.getText());
        vendedor.setCedula(txtCedula.getText());
        vendedor.setEdad(txtEdad.getText());
        vendedor.setDireccion(txtDireccion.getText());
        vendedor.setCelular(txtCelular.getText());
        vendedor.setCategoria( categoria );

        listaVendedores.add(vendedor);
        vendedorController.crearVendedor(vendedor);

    }


    /*private VendedorDto crearClienteDto(){
        return VendedorDto(
                txtNombre.getText(),
                txtApellido.getText(),
                txtCedula.getText(),
                txtEdad.getText(),
                txtDireccion.getText(),
                txtCelular.getText())
    }

     */


}


