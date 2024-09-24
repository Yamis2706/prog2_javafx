package co.edu.uniquindio.cliente_fx.cliente_fx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("¡Bienvenido, ¿qué quieres hacer hoy?!");
    }
}