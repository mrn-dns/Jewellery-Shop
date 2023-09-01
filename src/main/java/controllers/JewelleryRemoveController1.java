package controllers;

import com.example.ca12.JewelleryApplication;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import models.DisplayCase;
import models.DisplayTray;
import utils.GenLinkedList;
import utils.Node;

public class JewelleryRemoveController1 {

    public Button continueButton;
    public ChoiceBox<Integer> caseSelect;
    public ChoiceBox<String> traySelect;
    public static int caseNo;
    public static String trayNo;
    public static JewelleryRemoveController1 jewelleryRemoveController1;

    public static void updateCasesChoiceBox() {
        jewelleryRemoveController1.caseSelect.getItems().clear();
        for (DisplayCase displayCase : JewelleryApplication.allCases)
            jewelleryRemoveController1.caseSelect.getItems().add(displayCase.getId());
    }

    public void updateTraysChoiceBox() {
        jewelleryRemoveController1.traySelect.getItems().clear();
        int caseNo = jewelleryRemoveController1.caseSelect.getValue();
        for (DisplayCase displayCase : JewelleryApplication.allCases) {
            if (displayCase.getId() == caseNo)
                for (DisplayTray displayTray : displayCase.trays)
                    jewelleryRemoveController1.traySelect.getItems().add(displayTray.getId());
        }
    }

    public void initialize(){
        jewelleryRemoveController1=this;
    }

    public void nextJwDeleteView(ActionEvent actionEvent) {
        JewelleryApplication.primaryStage.setScene(JewelleryApplication.scene7);
        setData();
        JewelleryRemoveController2.jewelleryRemoveController2.updateJewelsListView();
    }

    public void selectDisplayCase(ActionEvent actionEvent) {
        updateTraysChoiceBox();
    }

    public void jewelReturn(ActionEvent actionEvent) { //returns to main menu
        JewelleryApplication.primaryStage.setScene(JewelleryApplication.scene1);
    }

    public void setData() { //prepares caseID and trayID for next view
        caseNo = caseSelect.getValue();
        trayNo = traySelect.getValue();
    }

}
