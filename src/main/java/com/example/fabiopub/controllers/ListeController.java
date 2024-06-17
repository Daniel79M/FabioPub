package com.example.fabiopub.controllers;

import com.example.fabiopub.Entity.Commande;
import com.example.fabiopub.HelloApplication;
import com.example.fabiopub.interfaces.CommandeInterface;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

//import static javafx.scene.control.*;

public class ListeController extends Homemain implements Initializable, CommandeInterface {
    @FXML
    private StackPane commadeStackPane;
    public String show;

    @FXML
    private void onCommande() throws IOException {
        this.show = "commande_form.fxml";
        reDirector(show);
    }
    @FXML
    private void onClient() throws IOException {
        this.show = "FirstHome.fxml";
        reDirector(show);
    }

    @FXML
    private void onListe() throws IOException {
        this.show = "commande_list.fxml";
        reDirector(show);
    }
    private void reDirector(String show) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource(show)));
        commadeStackPane.getChildren().removeAll();
        commadeStackPane.getChildren().setAll(root);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

        Parent root;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("commande_form.fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        commadeStackPane.getChildren().removeAll();
        commadeStackPane.getChildren().setAll(root);
    }

    @Override
    public void create(Commande commande) throws SQLException {
    }

    @Override
    public Commande update(Commande commande) throws SQLException {
        return null;
    }

    @Override
    public void delete(int id) {
    }

    @Override
    public List<Commande> list() throws SQLException {
        return List.of();
    }

    //    @FXML
//    private void getData(){
//        commande = commandeTable.getSelectionModel().getSelectedItem();
//        IdCol.setId(commande.getId());
//        nameCol.setText(commande.getNameOfCommande());
//        typeCol.setText(commande.getType());
//        clientCol.setText(commande.getClientName());
//        dateCol.setCellFactory(commande.getDateOfCommande());
//        deliveryCol.setCellValueFactory(commande.getDeliveryDate());
//        priceCol.setCellFactory(commande.getPrice());
//        quantityCol.setText(commande.getQuantity());
//        descriptionCol.setText(commande.getDescriptions());
//        AgreeButton.setDisable(true);
//
//    }


}
