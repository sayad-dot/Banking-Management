package org.example.campuswallet;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionDAO {
    private Connection connection;

    public TransactionDAO(Connection connection) {
        this.connection = connection;
    }

    public void addTransaction(Transaction transaction) throws SQLException {
        String query = "INSERT INTO transactions (sender_username, receiver_username, amount, timestamp) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, transaction.getSenderUsername());
            preparedStatement.setString(2, transaction.getReceiverUsername());
            preparedStatement.setDouble(3, transaction.getAmount());
            preparedStatement.setTimestamp(4, new Timestamp(transaction.getTimestamp().getTime()));
            preparedStatement.executeUpdate();
        }
    }

    public List<Transaction> getTransactionsByUsername(String username) throws SQLException {
        List<Transaction> transactions = new ArrayList<>();
        String query = "SELECT * FROM transactions WHERE sender_username = ? OR receiver_username = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, username);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String senderUsername = resultSet.getString("sender_username");
                    String receiverUsername = resultSet.getString("receiver_username");
                    double amount = resultSet.getDouble("amount");
                    Timestamp timestamp = resultSet.getTimestamp("timestamp");
                    Date date = new Date(timestamp.getTime());
                    Transaction transaction = new Transaction(id, senderUsername, receiverUsername, amount, date);
                    transactions.add(transaction);
                }
            }
        }
        return transactions;
    }

    // You can add more methods as needed for transaction-related operations
}
