module com.example.client {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens example.client to javafx.fxml;
    exports example.client;

    exports example.data;
}