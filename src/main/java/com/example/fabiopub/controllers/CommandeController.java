package com.example.fabiopub.controllers;

import com.example.fabiopub.Entity.Commande;
import com.example.fabiopub.interfaces.CommandeInterface;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class CommandeController implements Initializable{

//    @FXML
//    private ObservableList<Commande> commandes ;
//    @FXML
//    private TableColumn<Commande, Integer> IdCol ;
//    @FXML
//    private TableColumn<Commande, String> clientCol;
//    @FXML
//    private TableView<Commande> commandeTable;
//    @FXML
//    private TableColumn<Commande, Date> dateCol ;
//    @FXML
//    private TableColumn<Commande, Date> deliveryCol ;
//    @FXML
//    private TableColumn<Commande, String> descriptionCol;
//    @FXML
//    private TableColumn<Commande, String> nameCol;
//    @FXML
//    private TableColumn<Commande, Float> priceCol;
//    @FXML
//    private TableColumn<Commande, String> quantityCol;
//    @FXML
//    private TableColumn<Commande, String> typeCol;
@FXML
private Button AgreeButton;

    @FXML
    private Button CancelButton;

    @FXML
    private TextArea CommandeDescription;

    @FXML
    private TextField CommandePrice;

    @FXML
    private TextField CommandeQuantity;

    @FXML
    private TextField commandeClientNametTextField;

    @FXML
    private DatePicker commandeDate;

    @FXML
    private DatePicker commandeDeliveryDate;

    @FXML
    private TextField commandeNameTextField;

    @FXML
    private TextField commendTypeTextField;

    @FXML
    private TextArea filesArea;


    FileChooser fileChooser = new FileChooser();

    private Commande commande = new Commande();

    int id = 0;

    @FXML
    private void createCommande() throws SQLException {

        id = this.commande.getId();
        String nameOfCommande = this.commandeNameTextField.getText().trim();
        String type = this.commendTypeTextField.getText().trim();
        String clientName = this.commandeClientNametTextField.getText().trim() ;
        Date dateOfCommande = Date.valueOf(this.commandeDate.getValue());
        Date deliveryDate = Date.valueOf(this.commandeDate.getValue());
        String price = this.CommandePrice.getText();
        String quantity = this.CommandeQuantity.getText();
        String descriptions = this.CommandeDescription.getText();

        Commande commande = new Commande();
        commande.setNameOfCommande(nameOfCommande);
        commande.setType(type);
        commande.setClientName(clientName);
        commande.setDateOfCommande(String.valueOf(dateOfCommande));
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
            commande.setDeliveryDate(String.valueOf(deliveryDate));
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
//        readCommande();
        commandeNameTextField.setText(null);
        commendTypeTextField.setText(null);
        commandeClientNametTextField.setText(null);
        commandeDate.setValue(null);
        commandeDeliveryDate.setValue(null);
        CommandePrice.setText(null);
        CommandeQuantity.setText(null);
        CommandeDescription.setText(null);
    }


//    @FXML
//    private void getData(){
//        commande = commandeTable.getSelectionModel().getSelectedItem();
//
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
//    }

    @FXML
    private void canceled() throws SQLException {
        commandeNameTextField.setText(null);
        commendTypeTextField.setText(null);
        commandeClientNametTextField.setText(null);
        commandeDate.setValue(null);
        commandeDeliveryDate.setValue(null);
        CommandePrice.setText(null);
        CommandeQuantity.setText(null);
        CommandeDescription.setText(null);
        AgreeButton.setDisable(false);
//        readCommande();
    }

    public void readCommande() throws SQLException {

//        commandes = FXCollections.observableArrayList(list());
//
//        commandeTable.setItems(list());
//        IdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
//        nameCol.setCellValueFactory(new PropertyValueFactory<>("nameOfCommande"));
//        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
//        clientCol.setCellValueFactory(new PropertyValueFactory<>("clientName"));
//        dateCol.setCellValueFactory(new PropertyValueFactory<>("dateOfCommande"));
//        deliveryCol.setCellValueFactory(new PropertyValueFactory<>("deliveryDate"));
//        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
//        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
//        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("descriptions"));
//        Commande commande = new Commande();
//        try {
//            commandes.addAll(commande.list());
//            commandeTable.setItems(commandes);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

    }
//    @FXML
//    private void updatecommande() throws SQLException {
//
//        commande.update(commande);
//
//
//    }
//
//


//    FileChooser fileChooser = new FileChooser();



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



//        fileChooser.setInitialDirectory(new File("C:\\Users\\LENOVO\\OneDrive\\Bureau\\JAVA\\Javafx\\fabioPub\\src\\main\\resources\\com\\example\\fabiopub"));
//
//        try {
//            readCommande();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

    }

//    @Override
//    public void create(Commande commande) throws SQLException {
//
//    }
//
//    @Override
//    public Commande update(Commande commande) throws SQLException {
//        return null;
//    }
//
//    @Override
//    public void delete(int id) {
//
//    }

//    @Override
//    public ObservableList<Commande> list() throws SQLException {
//        return commandes;
//    }


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
