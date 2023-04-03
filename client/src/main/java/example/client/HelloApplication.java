package example.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The main application class. This class is responsible for initializing the
 * application and loading the first view.
 */
public class HelloApplication extends Application {
    /**
     * Starts the application by loading the first view.
     * @param stage The primary stage.
     * @throws IOException If the view cannot be loaded.
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 480);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main method. This method is responsible for launching the application.
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        launch();
    }
}