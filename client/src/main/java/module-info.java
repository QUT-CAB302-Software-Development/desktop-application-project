module com.example.client {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
//    requires org.apache.httpcomponents.httpclient;
//    requires org.apache.httpcomponents.httpcore;

    opens example.client to javafx.fxml;
    exports example.client;

    exports example.data;
}