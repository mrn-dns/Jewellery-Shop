package controllers;

import com.example.ca12.JewelleryApplication;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import models.DisplayCase;
import models.DisplayTray;
import models.JewelleryItem;
import models.Material;
import utils.GenLinkedList;

public class Search2Controller {
    public Button returnButton;
    public ListView<JewelleryItem> searchResultsList;
    public static Search2Controller search2Controller;

    public boolean checkForHits() {
        boolean hit = false;
        String jewDesc = Search1Controller.search1Controller.jewelleryNameField.getText();
        for (DisplayCase displayCase : JewelleryApplication.allCases) {
            for (DisplayTray displayTray : displayCase.trays)
                for (JewelleryItem jewelleryItem : displayTray.jewels)
                    if (jewelleryItem.getDescription().equalsIgnoreCase(jewDesc)) {
                        hit = true;
                        break;
                    }
        }
        return hit;
    }

    public void populateResults() {
        searchResultsList.getItems().clear();
        String jewelleryDesc = Search1Controller.search1Controller.jewelleryNameField.getText();
        for (DisplayCase displayCase : JewelleryApplication.allCases)
            for (DisplayTray displayTray : displayCase.trays)
                for (JewelleryItem jewelleryItem : displayTray.jewels)
                    if(jewelleryItem.getDescription().equalsIgnoreCase(jewelleryDesc))
                        searchResultsList.getItems().add(jewelleryItem);
    }

    public void returnSearch(ActionEvent actionEvent) {
        JewelleryApplication.primaryStage.setScene(JewelleryApplication.scene1);
    }

    public void goBackSearch(ActionEvent actionEvent) {
        JewelleryApplication.primaryStage.setScene(JewelleryApplication.scene12);
    }

    public void initialize() {
        search2Controller = this;
    }
}
