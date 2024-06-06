package com.example.fabiopub.controllers;

import com.example.fabiopub.models.Commande;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.Scanner;

public class CommandeController implements Initializable {
    private ObservableList<Commande> commandes;
    @FXML
    private TableColumn<Commande, Integer> IdCol;

    @FXML
    private TableColumn<Commande, String> clientCol;

    @FXML
    private TableView<Commande> commandeTable;

    @FXML
    private TableColumn<Commande, Date> dateCol;

    @FXML
    private TableColumn<Commande, Date> deliveryCol;

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

    @FXML
    private TextField commandPriceTextField;

    @FXML
    private TextField commandeClientNametTextField;

    @FXML
    private DatePicker commandeDate;

    @FXML
    private TextArea commandeDescriptionArea;

    @FXML
    private TextField commandeNameTextField;

    @FXML
    private TextField commandequantityTextField;

    @FXML
    private TextField commendTypeTextField;

    @FXML
    private TextArea filesArea;

    @FXML
    private DatePicker livraisonDate;

    FileChooser fileChooser = new FileChooser();

    @FXML
    void createCommande() throws SQLException {

        String nameOfCommande = this.commandeNameTextField.getText().trim();
        String type = this.commendTypeTextField.getText().trim();
        String clientName = this.commandeClientNametTextField.getText().trim() ;
        Date dateOfCommande = Date.valueOf(this.commandeDate.getValue());
        Date deliveryDate = Date.valueOf(this.commandeDate.getValue());
        String price = this.commandPriceTextField.getText();
        String quantity = this.commandequantityTextField.getText();
        String descriptions = this.commandeDescriptionArea.getText();

        Commande commande = new Commande();

        commande.setNameOfCommande(nameOfCommande);
        commande.setType(type);
        commande.setClientName(clientName);
        commande.setDateOfCommande(dateOfCommande);
        try {
            commande.getDateOfCommande();
        }catch (Exception e){

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Alert");
            alert.setContentText("Date format not valid");
            alert.showAndWait();
            return;
        }

        try {
            commande.setDeliveryDate(deliveryDate);
        }catch (Exception e){

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Alert");
            alert.setContentText("Date de livraison incorrect ");
            alert.showAndWait();
            return;
        }
        commande.setQuantity(quantity);
        commande.setPrice(Float.valueOf(price));
        commande.setDescriptions(descriptions);

        commande.create(commande);


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert");
        alert.setContentText("La commande a belle et bien été enregistré");
        alert.showAndWait();
    }

    private void saveSystem(File file, String contain) throws FileNotFoundException {
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.write(contain);
            printWriter.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    void getText(MouseEvent event) throws FileNotFoundException {
        File file =fileChooser.showOpenDialog(new Stage());

            try {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()){
                    filesArea.appendText(scanner.nextLine() +"\n");
                }
            }catch(FileNotFoundException e){
                    e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fileChooser.setInitialDirectory(new File("C:\\Users\\LENOVO\\OneDrive\\Bureau\\JAVA\\Javafx\\fabioPub\\src\\main\\resources\\com\\example\\fabiopub"));
    }

    public void getFiles(ActionEvent actionEvent) throws FileNotFoundException {
        File file = fileChooser.showOpenDialog(new Stage());
        if (file != null){
            saveSystem(file,filesArea.getText());
        }
    }

    public void getText(ActionEvent actionEvent) {
        File file =fileChooser.showOpenDialog(new Stage());

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                filesArea.appendText(scanner.nextLine() +"\n");
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

    //table view methode

    public void View(){
        commandes = FXCollections.observableArrayList(commandes);

        IdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("nameOfCommande"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        clientCol.setCellValueFactory(new PropertyValueFactory<>("clientName"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("dateOfCommande"));
        deliveryCol.setCellValueFactory(new PropertyValueFactory<>("deliveryDate"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("descriptions"));

        Commande commande =new Commande();

        try {
            commandes.addAll(commande.list());
            commandeTable.setItems(commandes);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
