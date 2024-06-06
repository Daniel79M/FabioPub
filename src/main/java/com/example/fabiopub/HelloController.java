package com.example.fabiopub;

import com.example.fabiopub.models.Commande;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
//    private ObservableList<Commande> commandes;
//    @FXML
//    public TableColumn<?,?> IdCol;
//
//    @FXML
//    public TableColumn<?,?> clientCol;
//
//    @FXML
//    public TableView<Commande> commandeTable;
//
//    @FXML
//    public TableColumn<Commande, Date> dateCol;
//
//    @FXML
//    public TableColumn<Commande, Date> deliveryCol;
//
//    @FXML
//    public TableColumn<Commande, String> descriptionCol;
//
//    @FXML
//    public TableColumn<Commande, String> nameCol;
//
//    @FXML
//    public TableColumn<Commande, Float> priceCol;
//
//    @FXML
//    public TableColumn<Commande, String> quantityCol;
//
//    @FXML
//    private TableColumn<Commande, String> typeCol;
    @FXML
    private StackPane containerStackpane;

    public String show;

//    public HelloController(ObservableList<Commande> commandes) {
//        this.commandes = commandes;
//    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        Parent root;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("sa.fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        containerStackpane.getChildren().removeAll();
//        containerStackpane.getChildren().setAll(root);
//        commandes = FXCollections.observableArrayList();
//        IdCol = new TableColumn<>();
//
//        IdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
//        nameCol.setCellValueFactory(new PropertyValueFactory<>("nameOfCommande"));
//        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
//        clientCol.setCellValueFactory(new PropertyValueFactory<>("clientName"));
//        dateCol.setCellValueFactory(new PropertyValueFactory<>("dateOfCommande"));
//        deliveryCol.setCellValueFactory(new PropertyValueFactory<>("deliveryDate"));
//        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
//        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
//        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("descriptions"));
//
//        Commande commande =new Commande();
//
//        try {
//            commandes.addAll(commande.list());
//            commandeTable.setItems(commandes);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }

    public void readCommande() throws IOException {
        this.show = "sa.fxml";
        reDirector(show);
    }

    private void reDirector(String file) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource(file)));
        containerStackpane.getChildren().removeAll();
        containerStackpane.getChildren().setAll(root);
    }
}