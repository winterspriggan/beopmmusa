package com.example.beopmmufx.controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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
    private ToggleGroup group;
    @FXML
    private Button button;
    @FXML
    private TabPane mainTab;


    public void onButtonClick() throws  IOException {
            RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
            String selectedText = selectedRadioButton.getText();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/beopmmufx/dialog.fxml"));
        Parent parent = loader.load();
        CompensationDialogController controller = loader.getController();
        controller.setEventType(selectedText);
        Stage dialog = new Stage(StageStyle.UTILITY);
        Stage previousStage = (Stage) mainTab.getScene().getWindow();
        dialog.initOwner(previousStage);
        dialog.initModality(Modality.WINDOW_MODAL);
        dialog.setTitle(selectedText);
        Scene scene = new Scene(parent);
        dialog.setScene(scene);
        dialog.setResizable(false);
        dialog.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}