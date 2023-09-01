module com.example.ca12 {
    requires javafx.controls;
    requires javafx.fxml;
    requires xstream;


    opens com.example.ca12 to javafx.fxml;
    exports com.example.ca12;
    exports utils;
    opens utils to javafx.fxml;
    exports models;
    opens models to javafx.fxml;
    exports controllers;
    opens controllers to javafx.fxml;
}