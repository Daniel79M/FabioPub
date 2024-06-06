package com.example.fabiopub.controllers;

import com.example.fabiopub.models.Commande;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
        int quantity = Integer.parseInt(this.commandequantityTextField.getText());
        String descriptions = this.commandeDescriptionArea.getText();

        Commande commande = new Commande();

        commande.setNameOfCommande(nameOfCommande);
        commande.setType(type);
        commande.setClientName(clientName);
        commande.setDateOfCommande(dateOfCommande);
        try {
            commande.setDeliveryDate(deliveryDate);
        }catch (Exception e){

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Alert");
            alert.setContentText("Date de livraison incorrect ");
            alert.showAndWait();
            return;
        }
        try{
            commande.setQuantity(quantity);
        }catch (Exception e){

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Alert");
            alert.setContentText("veuiller entrer un chiffre ");
            alert.showAndWait();
            return;
        }


        try {
            commande.getDateOfCommande();
        }catch (Exception e){

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Alert");
            alert.setContentText("Date format not valid");
            alert.showAndWait();
            return;
        }
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
}
