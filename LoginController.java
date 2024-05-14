
package org.example.campuswallet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    // Map to store username-password pairs
    private Map<String, String> credentials;

    public LoginController() {
        // Initialize the credentials map and add username-password pairs
        credentials = new HashMap<>();
        credentials.put("sayad", "sayad");
        credentials.put("nafi", "nafi");
        credentials.put("rashikh", "rashikh");
        // Add more username-password pairs as needed
    }

    @FXML
    private void handleLogin(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Check if the provided username exists in the credentials map
        if (credentials.containsKey(username)) {
            // If the username exists, check if the provided password matches the stored password
            if (credentials.get(username).equals(password)) {
                // Login successful
                // Navigate to main banking interface or perform other actions

                // For demonstration, display a success message
                showAlert(Alert.AlertType.INFORMATION, "Login Successful", "Welcome, " + username + "!");

                // Load the interface.fxml file
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/campuswallet/interface.fxml"));
                    Parent root = loader.load();

                    // Set the controller for the interface.fxml file
                    InterfaceController interfaceController = loader.getController();
                    // Pass username to interfaceController if needed
                    interfaceController.initialize(username);

                    // Show the interface scene
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(new Scene(root));
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace(); // Handle exception
                }
            } else {
                // Password does not match
                showAlert(Alert.AlertType.ERROR, "Login Failed", "Invalid password.");
            }
        } else {
            // Username does not exist
            showAlert(Alert.AlertType.ERROR, "Login Failed", "Invalid username.");
        }
    }

    @FXML
    private void handleCreateAccountButton(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/campuswallet/CreateAccount.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            // Get the stage from the event source
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Utility method to show alert dialog
    private void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}

