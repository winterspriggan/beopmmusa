package com.example.beopmmufx;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException;
public class HelloApplication extends Application {

    @FXML
    ImageView imageView;


    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        stage.setTitle("JJY Beommusa Lawyer's System");
        stage.setScene(new Scene(root, 300, 370));
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}