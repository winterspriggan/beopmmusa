package com.example.beopmmufx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("전준열 법무사님! 반갑습니다. 무엇을 도와드릴까요 ?");
    }
}