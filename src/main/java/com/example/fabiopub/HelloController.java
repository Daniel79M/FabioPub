package com.example.fabiopub;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private StackPane containerStackpane;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        Parent root;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("commande-View.fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        containerStackpane.getChildren().removeAll();
        containerStackpane.getChildren().setAll(root);
    }
}