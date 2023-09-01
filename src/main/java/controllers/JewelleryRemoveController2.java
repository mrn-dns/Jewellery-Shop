package controllers;

import com.example.ca12.JewelleryApplication;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import models.DisplayCase;
import models.DisplayTray;
import models.JewelleryItem;

public class JewelleryRemoveController2 {


    public Button deleteButton;
    public ListView<JewelleryItem> jewelleryList;
    public static JewelleryRemoveController2 jewelleryRemoveController2;

    public void updateJewelsListView() {
        jewelleryList.getItems().clear();

        int dcId= JewelleryRemoveController1.caseNo;
        String trayID = JewelleryRemoveController1.trayNo;

        for(DisplayCase displayCase : JewelleryApplication.allCases)
            if(displayCase.getId()==dcId)
                for(DisplayTray displayTray : displayCase.trays)
                    if(displayTray.getId().equals(trayID))
                        for(JewelleryItem jewelleryItem : displayTray.jewels)
                            jewelleryList.getItems().add(jewelleryItem);
    }

    public void deleteJewel(ActionEvent actionEvent) {
        jewelleryList.getItems().remove(jewelleryList.getSelectionModel().getSelectedItem());
        int dcId= JewelleryRemoveController1.caseNo;
        String trayID = JewelleryRemoveController1.trayNo;

        for(DisplayCase displayCase : JewelleryApplication.allCases)
            if(displayCase.getId()==dcId)
                for(DisplayTray displayTray : displayCase.trays)
                    if(displayTray.getId().equals(trayID))
                        for(JewelleryItem jewelleryItem : displayTray.jewels) {
                            displayTray.jewels.removeElementByObject(jewelleryItem);
                            System.out.println("Jewellery item has been sucesfully deleted.");
                        }
    }

    public void jewelReturn(ActionEvent actionEvent) { //returns to main menu
        JewelleryApplication.primaryStage.setScene(JewelleryApplication.scene1);
    }

    public void initialize(){
        jewelleryRemoveController2=this;
    }
}
