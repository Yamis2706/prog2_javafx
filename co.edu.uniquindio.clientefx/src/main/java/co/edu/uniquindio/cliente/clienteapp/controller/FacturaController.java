package co.edu.uniquindio.cliente.clienteapp.controller;

import co.edu.uniquindio.cliente.clienteapp.factory.ModelFactory;
import co.edu.uniquindio.cliente.clienteapp.model.Factura;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class FacturaController {

    private final ModelFactory modelFactory;

    public FacturaController() {
        modelFactory = ModelFactory.getInstancia();
    }



}
