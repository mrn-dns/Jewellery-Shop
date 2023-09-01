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

public class MaterialStockView {
    public Button returnButton;
    public ListView<Material> materialListView;
    public static MaterialStockView materialStockView;

    public void populateMaterialList() {
        materialListView.getItems().clear();
        String jewlleryDescription = JeweleryStockView.jeweleryStockView.jewelleryDescription;
        for(DisplayCase displayCase : JewelleryApplication.allCases) {
                for(DisplayTray displayTray : displayCase.trays)
                    for(JewelleryItem jewelleryItem : displayTray.jewels)
                        if(jewelleryItem.getDescription().equals(jewlleryDescription))
                            for(Material material : jewelleryItem.materials)
                                materialListView.getItems().add(material);

        }
    }

    public void returnStock(ActionEvent actionEvent) {
        JewelleryApplication.primaryStage.setScene(JewelleryApplication.scene1);
    }

    public void returnToJewels(ActionEvent actionEvent) {
        JewelleryApplication.primaryStage.setScene(JewelleryApplication.scene10);
    }

    public void initialize() {
        materialStockView = this;
    }
}
