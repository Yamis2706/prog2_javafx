package co.edu.uniquindio.cliente.clienteapp.viewcontroller;

import co.edu.uniquindio.cliente.clienteapp.controller.EmpleadoController;
import co.edu.uniquindio.cliente.clienteapp.mapping.dto.EmpleadoDto;
import co.edu.uniquindio.cliente.clienteapp.utils.Constantes;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class EmpleadoViewController implements Initializable {


    private EmpleadoController empleadoController;
    private ObservableList<EmpleadoDto> listaEmpleados =
            FXCollections.observableArrayList();
    private EmpleadoDto empleadoSeleccionado;


    @FXML
    private Button btnActualizarEmpleado;

    @FXML
    private Button btnAgregarEmpleado;

    @FXML
    private Button btnBuscarEmpleado;

    @FXML
    private Button btnEliminarEmpleado;

    @FXML
    private Button btnNuevoEmpleado;

    @FXML
    private TableColumn<EmpleadoDto, String> tcApellidoEmpleado;

    @FXML
    private TableColumn<EmpleadoDto, String> tcCedulaEmpleado;

    @FXML
    private TableColumn<EmpleadoDto, String> tcCelularEmpleado;

    @FXML
    private TableColumn<EmpleadoDto, String> tcDireccionEmpleado;

    @FXML
    private TableColumn<EmpleadoDto, String> tcEdadEmpleado;

    @FXML
    private TableColumn<EmpleadoDto, String> tcNombreEmpleado;

    @FXML
    private TableColumn<EmpleadoDto, String> tcContrasenaEmpleado;

    @FXML
    private TableColumn<EmpleadoDto, String> tcCorreoEmpleado;


    @FXML
    private TableView<EmpleadoDto> tvEmpleado;

    @FXML
    private TextField txtApellidoEmpleado;

    @FXML
    private TextField txtBuscarEmpleado;

    @FXML
    private TextField txtCedulaEmpleado;

    @FXML
    private TextField txtCelularEmpleado;

    @FXML
    private TextField txtDireccionEmpleado;

    @FXML
    private TextField txtEdadEmpleado;

    @FXML
    private TextField txtNombreEmpleado;

    @FXML
    private TextField txtCorreoEmpleado;

    @FXML
    private TextField txtContrasenaEmpleado;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        empleadoController = new EmpleadoController();
        initView();
    }

    private void initView() {
        initDataBinding();
        listarEmpleados();
        tvEmpleado.getItems().clear();
        tvEmpleado.setItems(listaEmpleados);
        listenerSelection();
    }

    private void listarEmpleados() {
        listaEmpleados.addAll(empleadoController.listarEmpleados());
    }

    private void initDataBinding() {
        tcNombreEmpleado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombre()));
        tcApellidoEmpleado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().apellido()));
        tcCedulaEmpleado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().cedula()));
        tcEdadEmpleado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().edad()));
        tcDireccionEmpleado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().direccion()));
        tcCelularEmpleado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().celular()));
        tcCorreoEmpleado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().correo()));
        tcContrasenaEmpleado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().contrasena()));
    }

    private void listenerSelection() {
        tvEmpleado.getSelectionModel().selectedItemProperty().addListener((obs,
                                                                           oldSelection, newSelection) -> {
            empleadoSeleccionado = newSelection;
            mostrarInformacionEmpleado(empleadoSeleccionado);
        });
    }

    private void mostrarInformacionEmpleado(EmpleadoDto empleadoSeleccionado) {
        if(empleadoSeleccionado != null){

            txtNombreEmpleado.setText(empleadoSeleccionado.nombre());
            txtApellidoEmpleado.setText(empleadoSeleccionado.apellido());
            txtCedulaEmpleado.setText(empleadoSeleccionado.cedula());
            txtEdadEmpleado.setText(String.valueOf(empleadoSeleccionado.edad()));
            txtDireccionEmpleado.setText(empleadoSeleccionado.direccion());
            txtCelularEmpleado.setText(empleadoSeleccionado.celular());
            txtCorreoEmpleado.setText(empleadoSeleccionado.correo());
            txtContrasenaEmpleado.setText(empleadoSeleccionado.contrasena());

        }
    }

    @FXML
    void onActualizarEmpleado(ActionEvent event) {
        if(empleadoSeleccionado!=null){

            EmpleadoDto editado = new EmpleadoDto(
                    txtNombreEmpleado.getText(),
                    txtApellidoEmpleado.getText(),
                    txtCedulaEmpleado.getText(),
                    txtEdadEmpleado.getText(),
                    txtDireccionEmpleado.getText(),
                    txtCelularEmpleado.getText(),
                    txtCorreoEmpleado.getText(),
                    txtContrasenaEmpleado.getText()

            );

            try {
                empleadoController.editarEmpleado(editado);

                int indice = obtenerItemTabla(editado.cedula());
                listaEmpleados.set(indice, editado);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Mensaje importante");
                alert.setContentText(Constantes.EMPLEADO_ACTUALIZADO);
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
        for (int i = 0; i < listaEmpleados.size(); i++) {
            if(listaEmpleados.get(i).cedula().equals(cedula)){
                return i;
            }
        }
        return -1;
    }

    @FXML
    void onAgregarEmpleado(ActionEvent event) {
        agregarEmpleado();
    }

    @FXML
    void onEliminarEmpleado(ActionEvent event) {

        if(empleadoSeleccionado != null){
            try {
                empleadoController.eliminarEmpleado(empleadoSeleccionado.cedula());
                listaEmpleados.remove(empleadoSeleccionado);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Mensaje urgente");
                alert.setContentText(Constantes.EMPLEADO_ELIMINADO);
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
    void onNuevoEmpleado(ActionEvent event) {

        txtNombreEmpleado.setText("");
        txtApellidoEmpleado.setText("");
        txtCedulaEmpleado.setText("");
        txtEdadEmpleado.setText("");
        txtDireccionEmpleado.setText("");
        txtCelularEmpleado.setText("");
        txtCorreoEmpleado.setText("");
        txtContrasenaEmpleado.setText("");
    }

    private void agregarEmpleado() {

        EmpleadoDto nuevo = new EmpleadoDto(
                txtNombreEmpleado.getText(),
                txtApellidoEmpleado.getText(),
                txtCedulaEmpleado.getText(),
                txtEdadEmpleado.getText(),
                txtDireccionEmpleado.getText(),
                txtCelularEmpleado.getText(),
                txtCorreoEmpleado.getText(),
                txtContrasenaEmpleado.getText()

        );

        try {
            empleadoController.crearEmpleado(nuevo);
            listaEmpleados.add(nuevo);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Mensaje urgente");
            alert.setContentText(Constantes.EMPLEADO_AGREGADO);
            alert.show();

        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Mensaje urgente");
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }
}
