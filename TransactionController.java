package org.example.campuswallet;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class TransactionController {

    @FXML
    private TextField amountField;

    private UserDAO userDAO;

    public TransactionController() {
        // No initialization needed here, but you can add any setup logic if required
    }

    // Constructor injection for UserDAO
    public TransactionController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @FXML
    private void handleSubmit() {
        String amountText = amountField.getText();

        if (amountText.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error", "Please enter an amount.");
            return;
        }

        double amount = Double.parseDouble(amountText);

        if (amount < 0) {
            showAlert(Alert.AlertType.ERROR, "Error", "Invalid amount. Amount cannot be negative.");
            return;
        }

        // Perform the transaction logic here
        // For demonstration purposes, just showing a success message
        showAlert(Alert.AlertType.INFORMATION, "Success", "Transaction completed successfully.");
    }

    private void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
