package controllers;

import com.example.ca12.JewelleryApplication;
import utils.Node;
import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import models.DisplayCase;
import models.DisplayTray;

public class TrayController {

    public ChoiceBox<String> trayColor;
    public TextField heightField,widthField,trayID;
    public ChoiceBox<Integer> caseSelect;
    public static TrayController trayController;

    public void addTray(ActionEvent actionEvent) {
        DisplayTray dt = new DisplayTray(trayID.getText(),Integer.parseInt(heightField.getText()),Integer.parseInt(widthField.getText()),trayColor.getValue());

        int dcId= caseSelect.getValue(); //Pick DC to use somehow e.g. id in textfield, or choicebox
        for(DisplayCase displayCase : JewelleryApplication.allCases) {
            if(displayCase.getId()==dcId) {
                if(isValidTrayID(trayID.getText())) {
                    displayCase.trays.addElement(dt);
                    System.out.println("Tray added.");
                } else
                    System.out.println("Non-valid TrayID. Try A12");
            }
        }
        resetTray();
    }

    public static void updateCasesChoiceBox() {
        TrayController.trayController.caseSelect.getItems().clear();
        Node<DisplayCase> temp=JewelleryApplication.allCases.getTemp();
        while(temp!=null) {
            TrayController.trayController.caseSelect.getItems().add(temp.getContents().getId());
            temp=temp.getNext();
        }
    }

    public static boolean isValidTrayID(String name) {
        String expression = "\\b[a-zA-Z]{1}\\d{1,3}\\b";
        return name.matches(expression);
    }


    public void resetTray() {
        trayID.clear();heightField.clear();widthField.clear();trayColor.valueProperty().set(null);caseSelect.valueProperty().set(null);
    }

    public void initialize(){
        trayController=this;
        trayColor.getItems().addAll("RED","BLUE","YELLOW","GREEN","PURPLE","PINK","ORANGE","WHITE","BLACK" );
    }

    public void trayReturn(ActionEvent actionEvent) {
        JewelleryApplication.primaryStage.setScene(JewelleryApplication.scene1);
    }

}
