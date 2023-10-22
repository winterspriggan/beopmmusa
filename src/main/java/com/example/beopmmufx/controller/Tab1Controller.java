package com.example.beopmmufx.controller;
import com.example.request.EventType;
import com.example.request.Request;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Tab1Controller implements Initializable {
    @FXML
    private RadioButton RealEstateRegistration;
    @FXML
    private RadioButton CommercialCorporationRegistration;
    @FXML
    private RadioButton GuardianshipRegistration;
    @FXML
    private RadioButton MovableAssetsAndBondCollateral;
    @FXML
    private RadioButton Deposit;
    @FXML
    private RadioButton Auction;
    @FXML
    private RadioButton LitigationNonLitigationExecution;
    @FXML
    private RadioButton PersonalBankruptcyAndPersonalRehabilitation;
    @FXML
    private RadioButton OtherAgencyWork;
    @FXML
    private RadioButton Consultation;
    @FXML
    private TextField textField;
    @FXML
    private ToggleGroup group;
    @FXML
    private Button button;

    public void onButtonClick() {
        RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
        if (selectedRadioButton != null && textField.getText() != null) {
            String selectedText = selectedRadioButton.getText();
            Alert dialog = new Alert(Alert.AlertType.CONFIRMATION);

            if(EventType.RealEstateRegistration.getTitle().trim().equals(selectedText.trim())) {
                double fee = Request.getBasicCompensation(EventType.RealEstateRegistration, Double.parseDouble(textField.getText()), 1);
                String st = String.valueOf(fee).replaceAll("\\.0*$", "");
                dialog.setHeaderText(selectedText+"\n법무사 협회 기준 보수는"+st+"원 입니다.");
//                dialog.setContentText("법무사 협회 기준 보수는 ");
            }
            dialog.show();
        } else {
            System.out.println(selectedRadioButton.getText()+" "+ textField.getText());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}