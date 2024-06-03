package org.example.campuswallet;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoanCalculatorController {
    @FXML private TextField loanAmountField;
    @FXML private TextField interestRateField;
    @FXML private TextField loanTermField;
    @FXML private Label resultLabel;

    @FXML
    public void handleCalculateLoan() {
        double loanAmount = Double.parseDouble(loanAmountField.getText());
        double annualInterestRate = Double.parseDouble(interestRateField.getText());
        int loanTerm = Integer.parseInt(loanTermField.getText());

        double monthlyInterestRate = annualInterestRate / 1200;
        int numberOfPayments = loanTerm * 12;
        double monthlyPayment = (loanAmount * monthlyInterestRate) /
                (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));

        resultLabel.setText(String.format("Monthly Payment: %.2f", monthlyPayment));
    }
}
