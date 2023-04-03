package example.client;

import example.data.StaticUserDAO;
import example.data.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

/**
 * The controller for the main view. This class is responsible for displaying
 * information after a successful login and can be used to navigate to other
 * views, including logging out.
 */
public class MainViewController implements Initializable {
    // The model for this view.
    private final User user;
    private final StaticUserDAO userDAO;

    @FXML
    private Label nameLabel;

    @FXML
    private Button logOutButton;

    @FXML
    private TableView<User> userTable;

    @FXML
    private TableColumn<User, String> nameColumn;

    @FXML
    private TableColumn<User, String> emailColumn;

    /**
     * Creates a new MainViewController for the given user after a successful login.
     * Note that the constructor does not have access to the FXML fields, so we
     * cannot initialize them here. Instead, we initialize them in the initialize
     * method.
     * @param user The user to display.
     */
    public MainViewController(User user){
        this.user = user;
        userDAO = new StaticUserDAO();
    }

    /**
     * Initializes the view before it is shown. This method is called automatically
     * after the FXML file has been loaded.
     * @param url The URL.
     * @param resourceBundle The resource bundle.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Set the welcome label to display the user's name.
        nameLabel.setText("Welcome, " + user.getName() + "!");

        // Set the table to display the users.
        Set<User> users = userDAO.listUsers();
        // The email and name columns are defined in the FXML file. We need to
        // specify which fields of the User class to display in each column.
        // Source: https://jenkov.com/tutorials/javafx/tableview.html
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        // Add the users to the table.
        userTable.getItems().addAll(users);
    }

    /**
     * Handles the log out button click event.
     */
    @FXML
    protected void onLogOutButtonClick() {
        try {
            logOut();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Logs the user out and returns to the login screen.
     */
    private void logOut () throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login-view.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) logOutButton.getScene().getWindow();
        stage.setScene(new Scene(root, 640, 480));
        stage.show();
    }
}
