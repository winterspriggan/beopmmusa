package com.example.beopmmufx;

import com.example.beopmmufx.controller.Tab1Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        stage.setTitle("JJY Beommusa Lawyer's System");
        stage.setScene(new Scene(root, 1280, 960));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}