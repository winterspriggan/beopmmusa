package com.example.beopmmufx.controller;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
public class Tab1Controller {
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
    private static ToggleGroup toggleGroup;
    private static void setRadioButton(RadioButton radioButton) {
        radioButton = new RadioButton();
        radioButton.setToggleGroup(toggleGroup);
    }
    public void start(Stage primaryStage) throws Exception {
        toggleGroup = new ToggleGroup();
        setRadioButton(RealEstateRegistration);
        setRadioButton(CommercialCorporationRegistration);
        setRadioButton(GuardianshipRegistration);
        setRadioButton(MovableAssetsAndBondCollateral);
        setRadioButton(Deposit);
        setRadioButton(Auction);
        setRadioButton(LitigationNonLitigationExecution);
        setRadioButton(PersonalBankruptcyAndPersonalRehabilitation);
        setRadioButton(OtherAgencyWork);
        setRadioButton(Consultation);
    }
}