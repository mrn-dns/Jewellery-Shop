package controllers;

import com.example.ca12.JewelleryApplication;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import models.DisplayCase;

public class CaseStockView {

    public Button returnButton;
    public static CaseStockView caseStockView;
    public ListView<DisplayCase> casesListView;
    public int caseNo;
    public Button goToTraysBut;

    public void updateCasesListView() {
        casesListView.getItems().clear();
        for(DisplayCase displayCase : JewelleryApplication.allCases)
            casesListView.getItems().add(displayCase);
    }

    public void goToTrays(ActionEvent actionEvent) {
        if(casesListView.getSelectionModel().getSelectedItem()!=null) {
            caseNo = casesListView.getFocusModel().getFocusedItem().getId();
            JewelleryApplication.primaryStage.setScene(JewelleryApplication.scene9);
            TrayStockView.trayStockView.populateTrayList();
        } else System.out.println("Please select a case.");
    }


    public void returnStock(ActionEvent actionEvent) { //returns to main menu
        JewelleryApplication.primaryStage.setScene(JewelleryApplication.scene1);
    }

    public void initialize() {
        caseStockView=this;
    }


}
