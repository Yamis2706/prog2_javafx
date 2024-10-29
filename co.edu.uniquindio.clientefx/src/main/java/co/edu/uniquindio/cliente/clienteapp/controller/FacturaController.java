package co.edu.uniquindio.cliente.clienteapp.controller;

import co.edu.uniquindio.cliente.clienteapp.model.Factura;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class FacturaController implements Initializable {

    @FXML
    private TextField txtTotal;
    @FXML
    private TextField txtSubtotal;
    @FXML
    private TextField txtCodigoFactura;
    private Node nodeVentanaVentas;
    private final PrincipalController principalController;

    public FacturaController() {
        principalController = PrincipalController.getInstancia();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Factura factura = principalController.obtenerFactura();
        txtTotal.setText(String.valueOf(factura.getTotal()));
        txtSubtotal.setText(String.valueOf(factura.getSubtotal()));
        txtCodigoFactura.setText(factura.getCodigoFactura());

        txtTotal.setDisable(true);
        txtSubtotal.setDisable(true);
        txtCodigoFactura.setDisable(true);
    }

    public void inicializarValores(Node nodeVentanaVentas) {
        this.nodeVentanaVentas = nodeVentanaVentas;
    }

    /*
    public void regresarPanelVentas(ActionEvent event) {
        principalController.cerrarDosVentana(nodeVentanaVentas,txtTotal);
    }

     */
}
