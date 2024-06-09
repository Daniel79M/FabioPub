package com.example.fabiopub.controllers;

import com.example.fabiopub.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class TableBordController implements Initializable {
    @FXML
    private StackPane containerStackpane;

    public String show;
    @FXML
    public void backToHome() throws IOException {
        this.show = "homeView.fxml";
        reDirector(show);
    }

//    public void readCommande() throws IOException {
//        this.show = "sa.fxml";
//        reDirector(show);
//    }

    public void createCommande() throws IOException {

        this.show = "commande-View.fxml";
        reDirector(show);
    }

    private void reDirector(String show) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource(show)));
        containerStackpane.getChildren().removeAll();
        containerStackpane.getChildren().setAll(root);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Parent root;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("homeView.fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        containerStackpane.getChildren().removeAll();
        containerStackpane.getChildren().setAll(root);
    }
}
