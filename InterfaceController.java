package org.example.campuswallet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;


import java.io.IOException;

public class InterfaceController {

    @FXML
    private TextField sendAmountField;

    @FXML
    private TextField recipientAccountField;

    @FXML
    private Label accountDetailsLabel;

    public void initialize(String username){

    }
    private UserDAO userDAO;
    public InterfaceController() {
        // No initialization needed here, but you can add any setup logic if required
    }

    // Constructor injection for UserDAO
    public InterfaceController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @FXML
    private void handleAccountDetails() {
        // Implement logic to show account details page or dialog
        System.out.println("Account Details button clicked");
    }

    @FXML
    private void handleSendMoney(ActionEvent event) {
        loadTransactionPage(event);
    }

    @FXML
    private void handleAddMoney(ActionEvent event) {
        loadTransactionPage(event);
    }

    @FXML
    private void showAccountDetails() {
        // Fetch account details from the backend (replace this with your actual logic)
        String accountDetails = fetchAccountDetails();

        // Show account details in a dialog
        showAlert(Alert.AlertType.INFORMATION, "Account Details", accountDetails);
    }

    private boolean hasSufficientFunds(double amount) {
        // Replace this with your actual logic to check if sender has sufficient funds
        return true;
    }

    private void updateSenderBalance(double amount) {
        // Replace this with your actual logic to update sender's account balance
    }

    private void updateRecipientBalance(double amount, String recipientAccount) {
        // Replace this with your actual logic to update recipient's account balance
    }

    private void updateAccountBalance(double amount) {
        // Replace this with your actual logic to update user's account balance
    }

    private String fetchAccountDetails() {
        // Replace this with your actual logic to fetch account details from the backend
        return "Account Name: John Doe\nAccount Balance: $1000";
    }

    private void loadTransactionPage(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/campuswallet/transaction.fxml"));
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

    private void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
