package com.example.fabiopub.controllers;

import com.example.fabiopub.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.EventObject;
import java.util.Objects;

public class Homemain {
    public String show;
    public static void showConfirmationMessage (String titre, String message){
        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setTitle(titre);
        confirm.setContentText(message);
        confirm.showAndWait();
    }


    public static void showInformationMessage (String titre, String message){
        Alert confirm = new Alert(Alert.AlertType.INFORMATION);
        confirm.setTitle(titre);
        confirm.setContentText(message);
        confirm.showAndWait();
    }

    public static void showErrorMessage(String titre, String message){
        Alert error = new Alert(Alert.AlertType.ERROR);
        error.setTitle(titre);
        error.setContentText(message);
        error.showAndWait();
    }

    public void showPage(String title,String url, Label label) throws IOException {
        Stage primaryStage = (Stage) label.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource(url)));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
        primaryStage.close();

    }

//    public static void load( String url) throws IOException {
//        new Homemain().showPage(url);
//    }
//    private String show;
//    @FXML
//    private Button onback;
//
//    private void reDirector( Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(show));
//        Parent root = fxmlLoader.load();
//        stage.setScene(new Scene(root));
//        stage.show();
//
//
//    }
//
//    @FXML
//    public void connexion() throws IOException {
//        this.show ="connexion.fxml";
//        reDirector(new Stage());
//        Stage stage = (Stage)onback.getScene().getWindow();
//        stage.close();
//    }
//    @FXML
//    public void inscription() throws IOException {
//        this.show ="inscription.fxml";
//        reDirector(new Stage());
//    }
//
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//
//    }

}
