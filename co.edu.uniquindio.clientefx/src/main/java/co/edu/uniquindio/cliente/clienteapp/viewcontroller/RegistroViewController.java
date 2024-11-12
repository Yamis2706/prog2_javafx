package co.edu.uniquindio.cliente.clienteapp.viewcontroller;

import co.edu.uniquindio.cliente.clienteapp.controller.LoginController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegistroViewController {

    private RegistroController registroController;

    public RegistroViewController(){
        this.registroController = new RegistroController();
    }


    public class RegistroController {

        @FXML
        private TextField txtCedula;

        @FXML
        private TextField txtEmail;

        @FXML
        private TextField txtNombre;

        @FXML
        private PasswordField txtPassword;

        @FXML
        private TextField txtTelefono;

        @FXML
        void registrar(ActionEvent event) {

        }

        @FXML
        void volver(ActionEvent event) {

        }

    }
}
