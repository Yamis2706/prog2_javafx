package co.edu.uniquindio.cliente.clienteapp.viewcontroller;


import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.cliente.clienteapp.controller.VendedorController;
import co.edu.uniquindio.cliente.clienteapp.mapping.dto.VendedorDto;
import co.edu.uniquindio.cliente.clienteapp.model.Categoria;
import co.edu.uniquindio.cliente.clienteapp.utils.Constantes;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class VendedorViewController implements Initializable {

    private VendedorController vendedorController;
    private ObservableList<VendedorDto> listaVendedores = FXCollections.observableArrayList();
    private VendedorDto vendedorSeleccionado;

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
    private TableView<VendedorDto> tvVendedor;

    @FXML
    private TableColumn<VendedorDto, String> tcNombre;

    @FXML
    private TableColumn<VendedorDto, String> tcApellido;

    @FXML
    private TableColumn<VendedorDto, String> tcCedula;

    @FXML
    private TableColumn<VendedorDto, String> tcCategoria;

    @FXML
    private TableColumn<VendedorDto, String> tcCelular;

    @FXML
    private TableColumn<VendedorDto, String> tcDireccion;

    @FXML
    private TableColumn<VendedorDto, String> tcEdad;

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
        listarVendedores();
        tvVendedor.getItems().clear();
        tvVendedor.setItems(listaVendedores);
        listenerSelection();
    }

    private void listarVendedores() {
        listaVendedores.addAll(vendedorController.listarVendedores());
    }

    private void initDataBinding() {
        tcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombre()));
        tcApellido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().apellido()));
        tcCedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().cedula()));
        tcEdad.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().edad()));
        tcDireccion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().direccion()));
        tcCelular.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().celular()));
        tcCategoria.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().categoria().toString()));
    }

    private void listenerSelection() {
        tvVendedor.getSelectionModel().selectedItemProperty().addListener((obs,
                                                                  oldSelection, newSelection) -> {
            vendedorSeleccionado = newSelection;
            mostrarInformacionVendedor(vendedorSeleccionado);
        });
    }

    private void mostrarInformacionVendedor(VendedorDto vendedorSeleccionado) {
        if(vendedorSeleccionado != null){

            if(vendedorSeleccionado.categoria() == Categoria.BASICO){
                rbtnVendedorBasico.setSelected(true);
                rbtnVendedorPremium.setSelected(false);
                rbtnVendedorVIP.setSelected(false);
            }else if(vendedorSeleccionado.categoria() == Categoria.PREMIUM){
                rbtnVendedorPremium.setSelected(true);
                rbtnVendedorBasico.setSelected(false);
                rbtnVendedorVIP.setSelected(false);
            } else if (vendedorSeleccionado.categoria() == Categoria.VIP) {
                rbtnVendedorVIP.setSelected(true);
                rbtnVendedorPremium.setSelected(false);
                rbtnVendedorBasico.setSelected(false);
            }

            txtNombre.setText(vendedorSeleccionado.nombre());
            txtApellido.setText(vendedorSeleccionado.apellido());
            txtCedula.setText(vendedorSeleccionado.cedula());
            txtEdad.setText(String.valueOf(vendedorSeleccionado.edad()));
            txtDireccion.setText(vendedorSeleccionado.direccion());
            txtCelular.setText(vendedorSeleccionado.celular());

        }
    }

    @FXML
    void onActualizarVendedor(ActionEvent event) {
        if(vendedorSeleccionado!=null){

            VendedorDto editado = new VendedorDto(
                    txtNombre.getText(),
                    txtApellido.getText(),
                    txtCedula.getText(),
                    txtEdad.getText(),
                    txtDireccion.getText(),
                    txtCelular.getText(),
                    vendedorSeleccionado.categoria()
            );

            try {
                vendedorController.editarVendedor(editado);

                int indice = obtenerItemTabla(editado.cedula());
                listaVendedores.set(indice, editado);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Mensaje urgente");
                alert.setContentText(Constantes.VENDEDOR_ACTUALIZADO);
                alert.show();

            }catch (Exception e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Mensaje urgente");
                alert.setContentText(e.getMessage());
                alert.show();
            }

        }
    }

    public int obtenerItemTabla(String cedula){
        for (int i = 0; i < listaVendedores.size(); i++) {
            if(listaVendedores.get(i).cedula().equals(cedula)){
                return i;
            }
        }
        return -1;
    }

    @FXML
    void onAgregarVendedor(ActionEvent event) {
        agregarVendedor();
    }

    @FXML
    void onEliminarVendedor(ActionEvent event) {

        if(vendedorSeleccionado != null){
            try {
                vendedorController.eliminarVendedor(vendedorSeleccionado.cedula());
                listaVendedores.remove(vendedorSeleccionado);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Mensaje urgente");
                alert.setContentText(Constantes.VENDEDOR_ELIMINADO);
                alert.show();

            }catch (Exception e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Mensaje urgente");
                alert.setContentText(e.getMessage());
                alert.show();
            }
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

        VendedorDto nuevo = new VendedorDto(
                txtNombre.getText(),
                txtApellido.getText(),
                txtCedula.getText(),
                txtEdad.getText(),
                txtDireccion.getText(),
                txtCelular.getText(),
                categoria
        );

        try {
            vendedorController.crearVendedor(nuevo);
            listaVendedores.add(nuevo);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Mensaje urgente");
            alert.setContentText(Constantes.VENDEDOR_AGREGADO);
            alert.show();

        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Mensaje urgente");
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }
}


