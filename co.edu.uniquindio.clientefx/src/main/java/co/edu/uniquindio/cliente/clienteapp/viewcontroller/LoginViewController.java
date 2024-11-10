package co.edu.uniquindio.cliente.clienteapp.viewcontroller;

import co.edu.uniquindio.cliente.clienteapp.MarketplaceApplication;
import co.edu.uniquindio.cliente.clienteapp.controller.LoginController;
import co.edu.uniquindio.cliente.clienteapp.model.Empleado;
import co.edu.uniquindio.cliente.clienteapp.model.Persona;
import co.edu.uniquindio.cliente.clienteapp.model.Sesion;
import co.edu.uniquindio.cliente.clienteapp.model.Vendedor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class LoginViewController {

    private LoginController loginController;

    public LoginViewController(){
        this.loginController = new LoginController();
    }

    @FXML
    private TextField correo;

    @FXML
    private PasswordField password;

    @FXML
    void iniciarSesion(ActionEvent event) {

        String correoLogin = correo.getText();
        String passwordLogin = password.getText();

        try {
            Persona persona = loginController.validarUsuario(correoLogin,
                    passwordLogin);
            Sesion.getInstanciaSesion().setPersona(persona);

            if( persona instanceof Empleado){
                abrirVentana("MarketplaceApp.fxml");
            }else if( persona instanceof Vendedor){
                abrirVentana("Vendedor.fxml");
            }

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Mensaje urgente");
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }

    public void abrirVentana(String ventana){

        try {
            FXMLLoader fxmlLoader =
                    new FXMLLoader(MarketplaceApplication.class.getResource(
                            ventana));

            Stage stage = new Stage();

            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("App Marketplace");
            stage.setScene(scene);
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
