package com.example.beopmmufx.controller;

import com.example.request.EventType;
import com.example.request.Request;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CompensationDialogController implements Initializable {

    @FXML
    private Label title;
    private String eventType;
    private int count;

    private RadioButton[] radioButtons;
    private HBox[] hBoxes;
    private TextField[] textFields;
    private  ToggleGroup toggleGroup;

    @FXML
    public AnchorPane compensationPane;
    @FXML
    private VBox vBox;

    public void setEventType(String eventType) {
        this.eventType = eventType.trim();
        this.title.setText(eventType);
        setting(this.eventType);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }


    private void setting(String eventType) {
        switch (eventType) {
            case "부동산 등기":
                setRealEstateRegistration();
            case "상업 법인 등기":
            case "후견 등기":
            case "공탁 사건":
            case "개인파산 및 개인회생":
            case "동산, 채권 담보 등기":
            case "경매 공매":
            case "송무 비송 집행":
            case "상담 및 실비 변상":
            case "기타 대행업무":
            default:
        }
    }


    public void setRealEstateRegistration() {
        toggleGroup = new ToggleGroup();
        radioButtons = new RadioButton[4];
        hBoxes = new HBox[radioButtons.length];
        textFields = new TextField[radioButtons.length];
        radioButtons[0] = new RadioButton("1. 부동산 등기                 ");
        radioButtons[1] = new RadioButton("2. 담보권의 추가 설정 등기");
        radioButtons[2] = new RadioButton("3. 그 밖의 등기                ");
        radioButtons[3] = new RadioButton("4. 신탁 등기                   ");
        for(int i=0; i<radioButtons.length; i++) {
            radioButtons[i].setToggleGroup(toggleGroup);
            hBoxes[i] = new HBox();
            textFields[i] = new TextField();
            hBoxes[i].getChildren().add(radioButtons[i]);
            hBoxes[i].getChildren().add(textFields[i]);
            this.vBox.getChildren().add(hBoxes[i]);
        }
    }

    @FXML
    public void buttonClicked() {
    }
}
