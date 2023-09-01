package controllers;

import com.example.ca12.JewelleryApplication;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Search1Controller {
    public Button returnButton;
    public TextField jewelleryNameField;
    public static Search1Controller search1Controller;

    public void returnSearch(ActionEvent actionEvent) {
        JewelleryApplication.primaryStage.setScene(JewelleryApplication.scene1);
    }

    public void goToSearchResult(ActionEvent actionEvent) {
        if(Search2Controller.search2Controller.checkForHits()) {
            JewelleryApplication.primaryStage.setScene(JewelleryApplication.scene13);
            Search2Controller.search2Controller.populateResults();
        } else System.out.println("No results found for " + "\"" + jewelleryNameField.getText() + "\"");
    }

    public void initialize() {
        search1Controller = this;
    }
}
