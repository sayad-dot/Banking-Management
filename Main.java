package org.example.campuswallet;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        // Load the FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/campuswallet/login.fxml"));
        Parent root = loader.load();

        // Set the scene
        primaryStage.setTitle("Banking Management System - Login");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
