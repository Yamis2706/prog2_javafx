package co.edu.uniquindio.cliente.clienteapp.viewcontroller;

import co.edu.uniquindio.cliente.clienteapp.controller.EmpleadoController;
import co.edu.uniquindio.cliente.clienteapp.enums.Categoria;
import co.edu.uniquindio.cliente.clienteapp.mapping.dto.EmpleadoDto;
import co.edu.uniquindio.cliente.clienteapp.mapping.dto.VendedorDto;
import co.edu.uniquindio.cliente.clienteapp.utils.Constantes;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import java.net.URL;
import java.util.ResourceBundle;

public class EmpleadoViewController implements Initializable {


    private EmpleadoController empleadoController;
    private ObservableList<EmpleadoDto> listaEmpleados =
            FXCollections.observableArrayList();
    private EmpleadoDto empleadoSeleccionado;













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
        tcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombre()));
        tcApellido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().apellido()));
        tcCedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().cedula()));
        tcEdad.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().edad()));
        tcDireccion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().direccion()));
        tcCelular.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().celular()));
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

            txtNombre.setText(empleadoSeleccionado.nombre());
            txtApellido.setText(empleadoSeleccionado.apellido());
            txtCedula.setText(empleadoSeleccionado.cedula());
            txtEdad.setText(String.valueOf(empleadoSeleccionado.edad()));
            txtDireccion.setText(empleadoSeleccionado.direccion());
            txtCelular.setText(empleadoSeleccionado.celular());

        }
    }

    @FXML
    void onActualizarEmpleado(ActionEvent event) {
        if(empleadoSeleccionado!=null){

            EmpleadoDto editado = new EmpleadoDto(
                    txtNombre.getText(),
                    txtApellido.getText(),
                    txtCedula.getText(),
                    txtEdad.getText(),
                    txtDireccion.getText(),
                    txtCelular.getText(),
                    empleadoSeleccionado
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

        txtNombre.setText("");
        txtApellido.setText("");
        txtCedula.setText("");
        txtEdad.setText("");
        txtDireccion.setText("");
        txtCelular.setText("");
    }

    private void agregarEmpleado() {

        EmpleadoDto nuevo = new EmpleadoDto(
                txtNombre.getText(),
                txtApellido.getText(),
                txtCedula.getText(),
                txtEdad.getText(),
                txtDireccion.getText(),
                txtCelular.getText()
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
