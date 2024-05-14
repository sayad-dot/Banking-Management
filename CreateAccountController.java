package org.example.campuswallet;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Node;


public class CreateAccountController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField dobField;

    @FXML
    private TextField idField;

    @FXML
    private PasswordField passwordField;

    private UserDAO userDAO;

    public CreateAccountController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    public CreateAccountController() {

        this.userDAO = new UserDAO();
        // No initialization needed here, but you can add any setup logic if required
    }

//    @FXML
//    private void handleSubmitButton() {
//        // Get user input
//        String name = nameField.getText();
//        String phone = phoneField.getText();
//        String email = emailField.getText();
//        String dob = dobField.getText();
//        String id = idField.getText();
//        String password = passwordField.getText();
//
//        // Perform validation if needed
//
//        // Create a new User object with the provided information
//        User newUser = new User(name, phone, email, dob, id, password);
//
//        // Call the createUser method of the UserDAO to insert the new user into the database
//        boolean createdSuccessfully = userDAO.createUser(newUser);
//
//        // Show alert based on the result
//        if (createdSuccessfully) {
//            showAlert(Alert.AlertType.INFORMATION, "Account Creation", "Account created successfully.");
//        } else {
//            showAlert(Alert.AlertType.ERROR, "Account Creation Failed", "Failed to create account. Please try again.");
//        }
//    }

    @FXML
    private void handleSubmitButton() {
        String name = nameField.getText();
        String phone = phoneField.getText();
        String email = emailField.getText();
        String dob = dobField.getText();
        String id = idField.getText();
        String password = passwordField.getText();








        // Perform validation if needed

        // Create a new User object with the provided information
        User newUser = new User(name, phone, email, dob, id, password);

        // Call the createUser method of the UserDAO to insert the new user into the database
        boolean createdSuccessfully = userDAO.createUser(newUser);

        // Show alert based on the result
        if (createdSuccessfully) {
            showAlert(Alert.AlertType.INFORMATION, "Account Creation", "Account created successfully.");

            // Close the current stage (window)
            Stage stage = (Stage) nameField.getScene().getWindow();
            stage.close();
        } else {
            showAlert(Alert.AlertType.ERROR, "Account Creation Failed", "Failed to create account. Please try again.");
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
