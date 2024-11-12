package co.edu.uniquindio.cliente.clienteapp.controller;

import co.edu.uniquindio.cliente.clienteapp.model.Historial;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ConsultarHistorialEstados implements Initializable {
    @FXML
    private TextField txtCodigoEnvio;
    @FXML
    private TableView<Historial> tablaHistorialEstados;
    @FXML
    private TableColumn<Historial, String> tablaCodigo;
    @FXML
    private TableColumn<Historial, String> tablaEstado;
    @FXML
    private TableColumn<Historial, String> tablaFecha;
    @FXML
    private TableColumn<Historial, String> tablaDescripcion;

    private final MarketplaceController marketplaceController;

    public ConsultarHistorialEstados() {
        marketplaceController = MarketplaceController.getInstancia();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tablaCodigo.setCellValueFactory(CellData -> new SimpleStringProperty(CellData.getValue().getCodigoVenta()));
        tablaFecha.setCellValueFactory(CellData -> new SimpleStringProperty(CellData.getValue().getFechaVenta().toString()));
        tablaDescripcion.setCellValueFactory(CellData -> new SimpleStringProperty(CellData.getValue().getDescripcion()));
        tablaEstado.setCellValueFactory(CellData -> new SimpleStringProperty(CellData.getValue().getCodigoVenta().toString()));

    }

    public void buscarHistorialEstado(ActionEvent event) {

        try {
            ArrayList<Historial> historialEstados = marketplaceController.consultarHistorialEstados(txtCodigoEnvio.getText());
            tablaHistorialEstados.setItems(FXCollections.observableArrayList(historialEstados));

        } catch (Exception e) {
            marketplaceController.mostrarAlerta(e.getMessage(),
                    Alert.AlertType.ERROR);
        }

    }

}
