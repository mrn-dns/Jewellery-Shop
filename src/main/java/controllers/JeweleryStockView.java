package controllers;

import com.example.ca12.JewelleryApplication;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import models.DisplayCase;
import models.DisplayTray;
import models.JewelleryItem;

public class JeweleryStockView {

    public Button returnButton;
    public ListView<JewelleryItem> jewelleryListView;
    public static JeweleryStockView jeweleryStockView;
    public String jewelleryDescription;

    public void populateJewelList() {
        jewelleryListView.getItems().clear();
        String trayNo = TrayStockView.trayStockView.trayNo;
        for(DisplayCase displayCase : JewelleryApplication.allCases) {
                for(DisplayTray displayTray : displayCase.trays)
                    if(displayTray.getId().equals(trayNo))
                        for(JewelleryItem jewelleryItem : displayTray.jewels)
                            jewelleryListView.getItems().add(jewelleryItem);
        }
    }

    public void returnStock(ActionEvent actionEvent) { //returns to main menu
        JewelleryApplication.primaryStage.setScene(JewelleryApplication.scene1);
    }

    public void returnToTrays(ActionEvent actionEvent) { //one step back into Trays in Stock View
        JewelleryApplication.primaryStage.setScene(JewelleryApplication.scene9);
    }

    public void goToMaterials(ActionEvent actionEvent) { //one step forwards into Materials of jewelleryItem
        if(jewelleryListView.getSelectionModel().getSelectedItem()!=null) {
            jewelleryDescription = jewelleryListView.getFocusModel().getFocusedItem().getDescription();
            MaterialStockView.materialStockView.populateMaterialList();
            JewelleryApplication.primaryStage.setScene(JewelleryApplication.scene11);
        } else System.out.println("Please select a jewel.");
    }

    public void initialize() {
        jeweleryStockView = this;
    }
}
