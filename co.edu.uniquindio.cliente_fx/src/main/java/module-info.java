module co.edu.uniquindio.cliente_fx.cliente_fx {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.cliente_fx.cliente_fx to javafx.fxml;
    exports co.edu.uniquindio.cliente_fx.cliente_fx;
    opens co.edu.uniquindio.cliente_fx.cliente_fx.controller;
    exports co.edu.uniquindio.cliente_fx.cliente_fx.controller;
}