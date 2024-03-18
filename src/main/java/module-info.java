module com.example.gestorpedidoslorena {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires lombok;

    opens com.example.gestorpedidoslorena to javafx.fxml;
    exports com.example.gestorpedidoslorena;
    exports com.example.gestorpedidoslorena.controladores;
    opens com.example.gestorpedidoslorena.controladores to javafx.fxml;
}