package controllers;

import com.example.ca12.JewelleryApplication;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import models.DisplayCase;
import models.DisplayTray;
public class JewelleryController1 {

    public ChoiceBox<Integer> caseSelect;
    public ChoiceBox<String> traySelect;
    public static int caseNo;
    public static String trayNo;
    public static JewelleryController1 jewelleryController1;
    public Button continueButton;

    public static void updateCasesChoiceBox() {
        jewelleryController1.caseSelect.getItems().clear();
        for(DisplayCase displayCase : JewelleryApplication.allCases)
            jewelleryController1.caseSelect.getItems().add(displayCase.getId());
    }

    public void updateTraysChoiceBox() {
        jewelleryController1.traySelect.getItems().clear();
        int caseNo= jewelleryController1.caseSelect.getValue();
        for(DisplayCase displayCase : JewelleryApplication.allCases) {
            if(displayCase.getId()==caseNo)
                for(DisplayTray displayTray : displayCase.trays)
                    jewelleryController1.traySelect.getItems().add(displayTray.getId());
        }
    }

    public void initialize(){
        jewelleryController1=this;
    }

    public void nextJwView(ActionEvent actionEvent) {
        JewelleryApplication.primaryStage.setScene(JewelleryApplication.scene5);
        setData();
    }

    public void jewelReturn(ActionEvent actionEvent) { //returns to main menu
        JewelleryApplication.primaryStage.setScene(JewelleryApplication.scene1);
    }

    public void selectDisplayCase(ActionEvent actionEvent) {
        updateTraysChoiceBox();
    }

    public void setData() {
        caseNo = caseSelect.getValue();
        trayNo=traySelect.getValue();
    }

}
