package com.example.fabiopub;

import com.example.fabiopub.Entity.Commande;
import com.example.fabiopub.controllers.Homemain;
import com.example.fabiopub.interfaces.CommandeInterface;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController extends Homemain implements Initializable {
    @FXML
    private ObservableList<Commande> commandes ;
    @FXML
    private TableColumn<Commande, Integer> idCol ;
    @FXML
    private TableColumn<Commande, String> clientCol;
    @FXML
    private TableView<Commande> commandeTable;
    @FXML
    private TableColumn<Commande, Date> dateCol ;
    @FXML
    private TableColumn<Commande, Date> deliveryCol ;
    @FXML
    private TableColumn<Commande, String> descriptionCol;
    @FXML
    private TableColumn<Commande, String> nameCol;
    @FXML
    private TableColumn<Commande, Float> priceCol;
    @FXML
    private TableColumn<Commande, String> quantityCol;
    @FXML
    private TableColumn<Commande, String> typeCol;

    private Commande commande = new Commande();

    int id = 0;

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {

        commandes = FXCollections.observableArrayList();
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("nameOfCommande"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        clientCol.setCellValueFactory(new PropertyValueFactory<>("clientName"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("dateOfCommande"));
        deliveryCol.setCellValueFactory(new PropertyValueFactory<>("deliveryDate"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("descriptions"));
        Commande commande = new Commande();
        try {
            commandes.addAll(commande.list());
            commandeTable.setItems(commandes);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    private void deleteCommande() throws SQLException {
        Homemain.showConfirmationMessage("Confirmation","Etes-vous sùr de vouloir suprimer cette commande de la liste ?");
        commande.delete(id);
        readCommande();

    }
    @FXML
    private void readCommande(){
        commandes = FXCollections.observableArrayList();
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("nameOfCommande"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        clientCol.setCellValueFactory(new PropertyValueFactory<>("clientName"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("dateOfCommande"));
        deliveryCol.setCellValueFactory(new PropertyValueFactory<>("deliveryDate"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("descriptions"));
        Commande commande = new Commande();
        try {
            commandes.addAll(commande.list());
            commandeTable.setItems(commandes);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void getData(){
        commande = commandeTable.getSelectionModel().getSelectedItem();
            commande.delete(id);
//        commandeNameTextField.setText(commande.getNameOfCommande());
//        commendTypeTextField.setText(commande.getType());
//        commandeClientNametTextField.setText(commande.getClientName());

////        commandeDate.setValue(commande.getDateOfCommande());
////        commandeDeliveryDate.setValue(commande.getDeliveryDate());
////        commandPriceTextField.setText(commande.getPrice());
//        commandequantityTextField.setText(commande.getQuantity());
//        commandeDescriptionArea.setText(commande.getDescriptions());
//        AgreeButton.setDisable(true);
//
    }


}