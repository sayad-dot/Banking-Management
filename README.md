# CampusWallet

CampusWallet is a Java-based desktop application designed to manage financial transactions and provide useful financial tools for users on a campus. The application allows users to view their account details, send money, add money, convert currencies, and calculate loan payments.

## Table of Contents

- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [License](#license)

## Features

1. **User Authentication**: Secure login and registration functionality for users.
2. **View Account Details**: Users can view their current account balance and transaction history.
3. **Send Money**: Users can transfer money to other users within the campus wallet system.
4. **Add Money**: Users can add money to their account.
5. **Currency Converter**: Users can convert currencies based on the latest exchange rates.
6. **Loan Calculator**: Users can calculate monthly loan payments based on the loan amount, interest rate, and loan term.
7. **Notifications**: Users receive notifications for important events (simple implementation).
8. **Database Integration**: All user data and transactions are stored in a MySQL database.

## Installation

### Prerequisites

- Java JDK 8 or higher
- MySQL Database
- Maven
- IntelliJ IDEA (or any other Java IDE)

### Setup

1. **Clone the repository:**
    ```sh
    git clone https://github.com/your-username/CampusWallet.git
    cd CampusWallet
    ```

2. **Set up the MySQL Database:**

   Create a MySQL database and user, then run the following SQL script to create the necessary tables:

    ```sql
    CREATE DATABASE campuswallet;

    USE campuswallet;

    CREATE TABLE users (
        id INT AUTO_INCREMENT PRIMARY KEY,
        username VARCHAR(255) NOT NULL UNIQUE,
        password VARCHAR(255) NOT NULL
    );

    CREATE TABLE transactions (
        id INT AUTO_INCREMENT PRIMARY KEY,
        user_id INT,
        amount DOUBLE,
        type VARCHAR(255),
        FOREIGN KEY (user_id) REFERENCES users(id)
    );
    ```

3. **Update database configuration:**

   Open `DatabaseConnection.java` and update the database URL, username, and password:
    ```java
    private static final String URL = "jdbc:mysql://localhost:3306/campuswallet";
    private static final String USERNAME = "your-username";
    private static final String PASSWORD = "your-password";
    ```

4. **Build the project:**
    ```sh
    mvn clean install
    ```

5. **Run the project:**

   Open the project in IntelliJ IDEA (or your preferred IDE) and run the `Main` class located in `org.example.campuswallet`.

## Usage

### User Authentication

- **Login**: Enter your username and password to log in.
- **Register**: Create a new account by providing a unique username and password.

### Main Features

- **View Account Details**: Click on "Show Details" to view your current balance and transaction history.
- **Send Money**: Click on "Send Money" and enter the recipient's username and the amount to transfer.
- **Add Money**: Click on "Add Money" and enter the amount to add to your account.
- **Currency Converter**: Click on "Currency Converter", enter the amount, select the currencies, and click "Convert".
- **Loan Calculator**: Click on "Loan Calculator", enter the loan details, and click "Calculate Loan".

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

