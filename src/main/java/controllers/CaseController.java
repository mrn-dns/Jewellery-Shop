package controllers;

import com.example.ca12.JewelleryApplication;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import models.Material;
import utils.GenLinkedList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import models.DisplayCase;
import models.DisplayTray;
import models.JewelleryItem;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CaseController {

    public Button addCaseButton;
    public TextField caseID;
    public ChoiceBox<String> setFreeStd;
    public RadioButton radioLit;
    public ToggleGroup litGroup;
    public RadioButton radioUnlit;
    public Button showCaseButton;
    public Button returnCaseButton;
    public static CaseController caseController;

    //methods

    public void addCase(ActionEvent actionEvent) {
       if(isValidCaseID(caseID.getText())) {
           DisplayCase dc = new DisplayCase(Integer.parseInt(caseID.getText()),setFreeStd.getValue().contains("Free"),radioLit.isSelected());
           if(isUniqueID(Integer.parseInt(caseID.getText()))) {
               JewelleryApplication.allCases.addElement(dc);
               TrayController.updateCasesChoiceBox();
               JewelleryController1.updateCasesChoiceBox();
               JewelleryRemoveController1.updateCasesChoiceBox();
               resetCase();
               System.out.println("Case added.");
           } else System.out.println("NON-UNIQUE ID");
       } else System.out.println("Invalid CaseID.");
    }

    public void showCases() { //console display method
        for(DisplayCase displayCase : JewelleryApplication.allCases) {
            System.out.println(displayCase);
            for(DisplayTray displayTray : displayCase.trays) {
                System.out.println(displayTray);
                for(JewelleryItem jewelleryItem : displayTray.jewels) {
                    System.out.println(jewelleryItem);
                    for(Material material : jewelleryItem.materials)
                        System.out.println(material);
                }
            }
        }
    }

    public static boolean isValidCaseID(String str) { //checks if correct ID type was introduced
        String expression = "^[0-9]*$";
        return str.matches(expression);
    }

    public boolean isUniqueID(int id) { //checks for ID uniqueness
        boolean unique = true;
        for(DisplayCase displayCase : JewelleryApplication.allCases)
            if(displayCase.getId()==id)
                unique=false;
        return unique;
    }

    public void resetCase() { //empties all fields
        caseID.clear();setFreeStd.valueProperty().set(null);litGroup.selectToggle(null);
    }

    public void initialize(){
        setFreeStd.getItems().addAll("Wall mounted","Free standing");
        caseController = this;
    }

    public void caseReturn(ActionEvent actionEvent) { //returns to main menu
        JewelleryApplication.primaryStage.setScene(JewelleryApplication.scene1);
    }

    //---------------------
    // Persistence Methods
    //---------------------
    /**
     * The load method uses the XStream component to read all the objects from the xml
     * file stored on the hard disk.  The read objects are loaded into the associated ArrayList
     *
     * @throws Exception An exception is thrown if an error occurred during the load e.g. a missing file.
     */
    @SuppressWarnings("unchecked")
    public void load() throws Exception {
        //list of classes that you wish to include in the serialisation, separated by a comma
        Class<?>[] classes = new Class[]{DisplayCase.class};

        //setting up the xstream object with default security and the above classes
        XStream xstream = new XStream(new DomDriver());
        xstream.addPermission(AnyTypePermission.ANY);
        xstream.allowTypes(classes);

        //doing the actual serialisation to an XML file
        ObjectInputStream in = xstream.createObjectInputStream(new FileReader("cases.xml"));
        JewelleryApplication.allCases = (GenLinkedList<DisplayCase>) in.readObject();
        in.close();
    }

    /**
     * The save method uses the XStream component to write all the objects in the ArrayList
     * to the xml file stored on the hard disk.
     *
     * @throws Exception An exception is thrown if an error occurred during the save e.g. drive is full.
     */
    public void save() throws Exception {
        try {
            XStream xstream = new XStream(new DomDriver());
            ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("cases.xml"));
            out.writeObject(JewelleryApplication.allCases);
            out.close();
        } catch (Exception e) {
            System.out.println("Error writing this file : " + e);
        }
    }

    public String fileName(){
        return "cases.xml";
    }

}
