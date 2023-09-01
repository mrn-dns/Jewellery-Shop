package com.example.ca12;

import controllers.CaseController;
import controllers.JewelleryController2;
import controllers.TrayController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.DisplayCase;
import utils.GenLinkedList;

import java.io.IOException;

public class JewelleryApplication extends Application {

    public static Scene scene1,scene2,scene3,scene4,scene5,scene6,scene7,scene8,scene9,scene10,scene11,scene12,scene13;
    public static Stage primaryStage;
    public static GenLinkedList<DisplayCase> allCases = new GenLinkedList<>();

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(JewelleryApplication.class.getResource("main-view.fxml"));
        scene1 = new Scene(fxmlLoader.load(), 600, 400);
        fxmlLoader = new FXMLLoader(JewelleryApplication.class.getResource("case-view.fxml"));
        scene2 = new Scene(fxmlLoader.load(), 600, 400);
        fxmlLoader = new FXMLLoader(JewelleryApplication.class.getResource("tray-view.fxml"));
        scene3 = new Scene(fxmlLoader.load(), 600, 400);
        fxmlLoader = new FXMLLoader(JewelleryApplication.class.getResource("jw-view-1.fxml"));
        scene4 = new Scene(fxmlLoader.load(), 600, 400);
        fxmlLoader = new FXMLLoader(JewelleryApplication.class.getResource("jw-view-2.fxml"));
        scene5 = new Scene(fxmlLoader.load(), 600, 400);
        fxmlLoader = new FXMLLoader(JewelleryApplication.class.getResource("jw-delete-1.fxml"));
        scene6 = new Scene(fxmlLoader.load(), 600, 400);
        fxmlLoader = new FXMLLoader(JewelleryApplication.class.getResource("jw-delete-2.fxml"));
        scene7 = new Scene(fxmlLoader.load(), 600, 400);
        fxmlLoader = new FXMLLoader(JewelleryApplication.class.getResource("cases-stock-view.fxml"));
        scene8 = new Scene(fxmlLoader.load(), 600, 400);
        fxmlLoader = new FXMLLoader(JewelleryApplication.class.getResource("tray-stock-view.fxml"));
        scene9 = new Scene(fxmlLoader.load(), 600, 400);
        fxmlLoader = new FXMLLoader(JewelleryApplication.class.getResource("jewellery-stock-view.fxml"));
        scene10 = new Scene(fxmlLoader.load(), 600, 400);
        fxmlLoader = new FXMLLoader(JewelleryApplication.class.getResource("material-stock-view.fxml"));
        scene11 = new Scene(fxmlLoader.load(), 600, 400);
        fxmlLoader = new FXMLLoader(JewelleryApplication.class.getResource("search1.fxml"));
        scene12 = new Scene(fxmlLoader.load(), 600, 400);
        fxmlLoader = new FXMLLoader(JewelleryApplication.class.getResource("search2.fxml"));
        scene13 = new Scene(fxmlLoader.load(), 600, 400);

        stage.setTitle("Jewellery Store");
        stage.setScene(scene1);
        stage.show();
        primaryStage=stage;
    }

    public static void main(String[] args) {
        launch();
    }



}