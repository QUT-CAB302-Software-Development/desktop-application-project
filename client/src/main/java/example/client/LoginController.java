package example.client;

import example.data.InvalidUserException;
import example.data.StaticUserDAO;
import example.data.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * The controller for the login view. This class is responsible for logging in
 * and registering users.
 */
public class LoginController {
    /**
     * The DAO for users.
     */
    private final StaticUserDAO userDAO;

    // The fields defined in the correlated FXML file.
    @FXML
    private Label welcomeField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField nameField;

    @FXML
    private Button loginButton;

    @FXML
    private Button registerButton;

    // Some flags to keep track of the state of the application.
    /**
     * True if the user is registering, false otherwise.
     */
    private boolean isRegistering = false;

    /**
     * Constructor initializes the LoginController.
     */
    public LoginController() {
        userDAO = new StaticUserDAO();
    }

    /**
     * Handles the login button click event.
     */
    @FXML
    protected void onLoginButtonClick() {
        // Get the email and password from the text fields.
        String email = emailField.getText();
        String password = passwordField.getText();

        // If the user is not valid, show an error message.
        if (!isValidUser(email, password)) {
            welcomeField.setText("Invalid username or password! If you are a new user, please Register.");
        } else {
            // If the user is registering, update the user's name in the database.
            if (isRegistering){
                User user = userDAO.getUser(email);
                user.setName(nameField.getText());
                userDAO.updateUser(user);
            }

            // If the user is valid, log them in.
            try {
                login();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Handles the register button click event.
     */
    @FXML
    protected void onRegisterButtonClick() {
        String email = emailField.getText();
        String password = passwordField.getText();
        if (isValidUser(email, password)) {
            welcomeField.setText("User already exists!");
        } else {
            // Disable the register button, the email field and the password field.
            emailField.setDisable(true);
            passwordField.setDisable(true);
            registerButton.setDisable(true);

            // Show the name field.
            nameField.setVisible(true);

            // Add the user to the database - without a name.
            try {
                userDAO.addUser(new User("", password, email));
            } catch (InvalidUserException e) {
                throw new RuntimeException(e);
            }
            welcomeField.setText("User created successfully! Please enter your full name and click Login.");
            isRegistering = true;
        }
    }

    /**
     * Checks if the user is valid.
     * @param email The email of the user.
     * @param password The password of the user.
     * @return True if the user is valid, false otherwise.
     */
    private boolean isValidUser(String email, String password) {
        return userDAO.getUser(email) != null && userDAO.getUser(email).getPassword().equals(password);
    }

    /**
     * Logs the user in and opens the main window.
     * @throws IOException If the main-view.fxml file is not found.
     */
    private void login() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main-view.fxml"));
        loader.setControllerFactory(c -> {
            // Grab the user from the database to construct the MainViewController.
            User user = userDAO.getUser(emailField.getText());
            return new MainViewController(user);
        });
        Parent root = loader.load();
        Stage stage = (Stage) loginButton.getScene().getWindow();
        stage.setScene(new Scene(root, 640, 480));
        stage.show();
    }
}