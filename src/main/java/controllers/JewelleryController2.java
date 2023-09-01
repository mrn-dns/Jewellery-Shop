package controllers;

import com.example.ca12.JewelleryApplication;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import models.DisplayCase;
import models.DisplayTray;
import models.JewelleryItem;
import models.Material;
import utils.GenLinkedList;
import utils.Node;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.List;

public class JewelleryController2 {


    public ChoiceBox<String> typeField,genderField;
    public TextArea jewDescField,matDescField;
    public TextField matWeight,imageField,priceField;
    public ListView<Material> matList;
    public ChoiceBox<Integer> matQuality;
    public Button addMatButton,backButton;
    public GenLinkedList<Material> materials = new GenLinkedList<>();

    public void addJewel(ActionEvent actionEvent) {

        JewelleryItem ji = new JewelleryItem(jewDescField.getText(),typeField.getValue(),genderField.getValue(),Integer.parseInt(priceField.getText()),imageField.getText());

        int dcId= JewelleryController1.caseNo; //retrieves case id selected from previous window
        String trayID = JewelleryController1.trayNo; //retrieves tray id selected from previous window

        Node<DisplayCase> temp= JewelleryApplication.allCases.getHead();

        while(temp!=null && temp.getContents().getId()!=dcId) { temp=temp.getNext(); } //executes until correct case is found

        if(temp!=null) {
            Node<DisplayTray> tempTr = temp.getContents().getTrays().getHead();
            while(tempTr!=null && !tempTr.getContents().getId().equals(trayID)) { tempTr=tempTr.getNext(); }//executes until correct tray is found
            if(tempTr!=null) {
                tempTr.getContents().getJewels().addElement(ji);
                System.out.println("Jewel added.");
                for(Material material : materials) {
                    if(tempTr.getContents().jewels.getTemp().getContents().getDescription().equals(ji.getDescription())) {
                        ji.materials.addElement(material);
                        System.out.println('\t' + "Material added.");
                    }
                }
                materials.clear(); //empty material list once jewel added
            }
        }
        resetJewel();
    }

    public void addMaterial(ActionEvent actionEvent) { //method to create sublist of materials for jewel
        Material newMat = new Material(matDescField.getText(),Integer.parseInt(matWeight.getText()),matQuality.getValue());
        matList.getItems().add(newMat);
        materials.addElement(newMat);
    }

    public void resetJewel() { //empties all fields once jewel is added
        typeField.valueProperty().set(null);genderField.valueProperty().set(null);jewDescField.clear();matDescField.clear();
        matWeight.clear();imageField.clear();priceField.clear();matList.getItems().clear();matQuality.valueProperty().set(null);
    }

    public void jewelReturn2(ActionEvent actionEvent) { //returns to main menu
        JewelleryApplication.primaryStage.setScene(JewelleryApplication.scene1);
    }

    public void goBack(ActionEvent actionEvent) {
        JewelleryApplication.primaryStage.setScene(JewelleryApplication.scene4);
    }

    public void initialize(){
        matQuality.getItems().addAll(1,2,3,4,5);
        typeField.getItems().addAll("Necklace","Ring","Earring","Watch");
        genderField.getItems().addAll("Male", "Female", "Unisex");
    }


}
