package co.edu.uniquindio.cliente.clienteapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class VendedorApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader =
                new FXMLLoader(VendedorApplication.class.getResource("Vendedor.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("App Vendedor");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}