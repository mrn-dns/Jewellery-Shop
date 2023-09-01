package controllers;

import com.example.ca12.JewelleryApplication;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import models.DisplayCase;
import models.DisplayTray;
import utils.GenLinkedList;

public class TrayStockView {
    public Button returnButton;
    public ListView<DisplayTray> trayListView;
    public static TrayStockView trayStockView;
    public String trayNo;

    public void populateTrayList() {
        trayListView.getItems().clear();
        int caseId = CaseStockView.caseStockView.caseNo;
        for(DisplayCase displayCase : JewelleryApplication.allCases) {
            if(displayCase.getId()==caseId) {
                for(DisplayTray displayTray : displayCase.trays)
                    trayListView.getItems().add(displayTray);
            }
        }
    }

    public void returnStock(ActionEvent actionEvent) {
        JewelleryApplication.primaryStage.setScene(JewelleryApplication.scene1);
    }

    public void initialize() {
        trayStockView = this;
    }

    public void returnToCases(ActionEvent actionEvent) {
        JewelleryApplication.primaryStage.setScene(JewelleryApplication.scene8);
    }

    public void goToJewels(ActionEvent actionEvent) {
        if(trayListView.getSelectionModel().getSelectedItem()!=null) {
            trayNo = trayListView.getFocusModel().getFocusedItem().getId();
            JewelleryApplication.primaryStage.setScene(JewelleryApplication.scene10);
            JeweleryStockView.jeweleryStockView.populateJewelList();
        } else System.out.println("Please select a tray.");
    }
}
