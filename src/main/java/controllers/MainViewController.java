package controllers;

import com.example.ca12.JewelleryApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import models.DisplayCase;
import models.DisplayTray;
import models.JewelleryItem;

public class MainViewController {

    public Button addTrayButton;
    public Button addCaseButton;
    public Button addJewelleryButton;
    public Button deleteJewelleryButton;
    public Pane mainPane;

    public void openTrayMenu(ActionEvent actionEvent) {
        JewelleryApplication.primaryStage.setScene(JewelleryApplication.scene3);
    }

    public void openCaseMenu(ActionEvent actionEvent) {
        JewelleryApplication.primaryStage.setScene(JewelleryApplication.scene2);
    }

    public void openJewelleryMenu(ActionEvent actionEvent) {
        JewelleryApplication.primaryStage.setScene(JewelleryApplication.scene4);
    }

    public void deleteJewelleryMenu(ActionEvent actionEvent) {
        JewelleryApplication.primaryStage.setScene(JewelleryApplication.scene6);
    }

    public void openStockMenu(ActionEvent actionEvent) {
        JewelleryApplication.primaryStage.setScene(JewelleryApplication.scene8);
        CaseStockView.caseStockView.updateCasesListView();
    }

    public void openSearchMenu(ActionEvent actionEvent) {
        JewelleryApplication.primaryStage.setScene(JewelleryApplication.scene12);
    }

    public void resetAll(ActionEvent actionEvent) { //clears entire stock
        for(DisplayCase displayCase : JewelleryApplication.allCases)
            JewelleryApplication.allCases.clear();
        System.out.println("Reset successful.");
    }

    public void showTotalValue(ActionEvent actionEvent) {
        int total = 0;
        for(DisplayCase displayCase : JewelleryApplication.allCases)
            for(DisplayTray displayTray : displayCase.trays)
                for(JewelleryItem jewelleryItem : displayTray.jewels)
                    total+=jewelleryItem.getPrice();

        System.out.println("Total: "+total); //overall total

        for(DisplayCase displayCase : JewelleryApplication.allCases) {   //shows value for each individual tray in a case
            int disCNo = displayCase.getId();
            for(DisplayTray displayTray : displayCase.trays) {
                String trNo = displayTray.getId();
                int totalSpecific = 0;
                for(JewelleryItem jewelleryItem : displayTray.jewels) {
                    totalSpecific = totalSpecific + jewelleryItem.getPrice();
                }
                System.out.println("Value of Case " + disCNo + ", " + "Tray " + trNo + " is " + totalSpecific );
            }
        }
    }


    //--------------------------------------------------
    //  Persistence Menu Items
    //--------------------------------------------------

    @FXML
    private void saveAllData() {
        try {
            System.out.println("Saved to file: " + CaseController.caseController.fileName());
            CaseController.caseController.save();
        } catch (Exception e) {
            System.err.println("Error reading from file: " + e);
        }
    }

    @FXML
    private void loadAllData() {
        try {
            System.out.println("Loading from file: " + CaseController.caseController.fileName());
            CaseController.caseController.load();
        } catch (Exception e) {
            System.err.println("Error reading from file: " + e);
        }
    }
}
