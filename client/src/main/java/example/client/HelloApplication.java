package example.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.HttpClientBuilder;
//import org.apache.http.HttpEntity;
//import org.apache.http.util.EntityUtils;

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
        String url = "https://dummyjson.com/users";

//        fetchFromUrl(url);
        launch();
    }

//    private static User handleJsonObject(JSONObject obj) {
//        String name = obj.getString("name");
//        String email = obj.getString("email");
//        String password = obj.getString("password");
//        return new User(name, password, email);
//    }
//
//    private static void fetchFromUrl(String url) {
//        // Connect to https://dummyjson.com/products/1, and console log the response.
//        // Use the HttpClient class to make a request to the dummyjson API.
//        // Set up the HTTP client
//        HttpClient client = HttpClientBuilder.create().build();
//
//        // Set up the request
//        HttpGet request = new HttpGet(url);
//
//        // Execute the request
//        HttpEntity entity = null;
//        try {
//            entity = client.execute(request).getEntity();
//            // Read the response
//            String response = EntityUtils.toString(entity);
//            // Print the response
//            System.out.println(response);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
}