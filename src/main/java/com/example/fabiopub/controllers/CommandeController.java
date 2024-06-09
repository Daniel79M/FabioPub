package com.example.fabiopub.controllers;

import com.example.fabiopub.Entity.Commande;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CommandeController implements Initializable {
    @FXML
    private Button AgreeButton;
    @FXML
    private javafx.scene.control.Button CancelButton;
    @FXML
    private Button updateButton;
    @FXML
    private Button deletebutton;

    private ObservableList<Commande> commandes ;
    @FXML
    private TableColumn<Commande, Integer> IdCol ;
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
    private DatePicker commandeDeliveryDate;

    FileChooser fileChooser = new FileChooser();
     int id = 0;
    @FXML
    private void createCommande() throws SQLException {

        id = this.commande.getId();
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
        alert.setTitle("Information");
        alert.setContentText("La commande a belle et bien été enregistré");
        alert.showAndWait();
        readCommande();
        commandeNameTextField.setText(null);
        commendTypeTextField.setText(null);
        commandeClientNametTextField.setText(null);
        commandeDate.setValue(null);
        commandeDeliveryDate.setValue(null);
        commandPriceTextField.setText(null);
        commandequantityTextField.setText(null);
        commandeDescriptionArea.setText(null);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fileChooser.setInitialDirectory(new File("C:\\Users\\LENOVO\\OneDrive\\Bureau\\JAVA\\Javafx\\fabioPub\\src\\main\\resources\\com\\example\\fabiopub"));

        try {
            readCommande();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void readCommande() throws SQLException {
        commandes = FXCollections.observableArrayList();

        commandeTable.setItems(commandes);
        IdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
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
    private void updatecommande() throws SQLException {

        commande.update(commande);


    }

    @FXML
    void deleteCommande(ActionEvent event) throws SQLException {

        commande.delete(id);
        readCommande();

    }
    @FXML
    void canceled(ActionEvent event) throws SQLException {
        commandeNameTextField.setText(null);
        commendTypeTextField.setText(null);
        commandeClientNametTextField.setText(null);
        commandeDate.setValue(null);
        commandeDeliveryDate.setValue(null);
        commandPriceTextField.setText(null);
        commandequantityTextField.setText(null);
        commandeDescriptionArea.setText(null);
        AgreeButton.setDisable(false);
        readCommande();
    }

    @FXML
    private void getData(){
        commande = commandeTable.getSelectionModel().getSelectedItem();

        commandeNameTextField.setText(commande.getNameOfCommande());
        commendTypeTextField.setText(commande.getType());
        commandeClientNametTextField.setText(commande.getClientName());
//        commandeDate.setValue(commande.getDateOfCommande());
//        commandeDeliveryDate.setValue(commande.getDeliveryDate());
//        commandPriceTextField.setText(commande.getPrice());
        commandequantityTextField.setText(commande.getQuantity());
        commandeDescriptionArea.setText(commande.getDescriptions());
        AgreeButton.setDisable(true);

    }


//    public void getFiles(ActionEvent actionEvent) throws FileNotFoundException {
//        File file = fileChooser.showOpenDialog(new Stage());
//        if (file != null){
//            saveSystem(file,filesArea.getText());
//        }
//    }
//
//    public void getText(ActionEvent actionEvent) {
//        File file =fileChooser.showOpenDialog(new Stage());
//
//        try {
//            Scanner scanner = new Scanner(file);
//            while (scanner.hasNextLine()){
//                filesArea.appendText(scanner.nextLine() +"\n");
//            }
//        }catch(FileNotFoundException e){
//            e.printStackTrace();
//        }
//    }
    //    private void saveSystem(File file, String contain) throws FileNotFoundException {
//        try {
//            PrintWriter printWriter = new PrintWriter(file);
//            printWriter.write(contain);
//            printWriter.close();
//        }catch (FileNotFoundException e){
//            e.printStackTrace();
//        }
//    }
//
//    void getText(MouseEvent event) throws FileNotFoundException {
//        File file =fileChooser.showOpenDialog(new Stage());
//
//            try {
//                Scanner scanner = new Scanner(file);
//                while (scanner.hasNextLine()){
//                    filesArea.appendText(scanner.nextLine() +"\n");
//                }
//            }catch(FileNotFoundException e){
//                    e.printStackTrace();
//        }
//    }

}
