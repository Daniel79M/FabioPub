package com.example.fabiopub.models;

import com.example.fabiopub.dataConfig.IDBconfig;
import com.example.fabiopub.interfaces.CommandeInterface;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;

public class Commande implements CommandeInterface {

    private String id;

    private String nameOfCommande;

    private String type;

    private String clientName;


    private Date dateOfCommande;

    private Date deliveryDate;

    private Float price;

    private String quantity;

    private  String descriptions;

    private Connection connection;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameOfCommande() {
        return nameOfCommande;
    }

    public void setNameOfCommande(String nameOfCommande) {
        this.nameOfCommande = nameOfCommande;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Date getDateOfCommande() {
        return dateOfCommande;
    }

    public void setDateOfCommande(Date dateOfCommande) {
        this.dateOfCommande = dateOfCommande;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Commande commande) throws SQLException {
        connection = IDBconfig.getConnetion();
        if (connection !=  null){
            String req = "INSERT INTO commande (nameOfCommande, type, clientName, dateOfCommande, deliveryDate, price ,quantity, descriptions) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = this.connection.prepareStatement(req);
            preparedStatement.setString(1,commande.getNameOfCommande());
            preparedStatement.setString(2,commande.getType());
            preparedStatement.setString(3,commande.getClientName());
            preparedStatement.setDate(4,commande.getDateOfCommande());
            preparedStatement.setDate(5,commande.getDeliveryDate());
            preparedStatement.setFloat(6,commande.getPrice());
            preparedStatement.setString(7,commande.getQuantity());
            preparedStatement.setString(8,commande.getDescriptions());
            preparedStatement.execute();
            preparedStatement.close();
            this.connection.close();
        }

    }

    @Override
    public void update(Commande commande) {

    }

    @Override
    public void cancel(int id) {

    }

    @Override
    public List<Commande> list() throws SQLException {
        List<Commande> commandes = new ArrayList<>();
        connection = IDBconfig.getConnetion();
        if(connection != null ){
            String req = "SELECT * FROM commande";
            PreparedStatement preparedStatement = this.connection.prepareCall(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Commande commande = new Commande();
                commande.setId(resultSet.getString(id));
                commande.setNameOfCommande(resultSet.getString(nameOfCommande));
                commande.setType(resultSet.getString(type));
                commande.setClientName(resultSet.getString(clientName));
                commande.setDateOfCommande(resultSet.getDate(valueOf(dateOfCommande)));
                commande.setDeliveryDate(resultSet.getDate(valueOf(deliveryDate)));
                commande.setPrice(resultSet.getFloat(valueOf(price)));
                commande.setQuantity(resultSet.getString(quantity));
                commande.setDescriptions(resultSet.getString(descriptions));

                commandes.add(commande);
            }
            preparedStatement.close();
            this.connection.close();

        }
        return commandes;
    }
//    public List<Product> list() throws SQLException {
//        List<Product> products = new ArrayList<>();
//        connection = IDBConfig.getConnection();
//        if (connection != null) {
//            String req = "SELECT * FROM products";
//            PreparedStatement prepareStatement = this.connection.prepareStatement(req);
//            ResultSet resultSet = prepareStatement.executeQuery();
//            while (resultSet.next()) {
//                Product product = new Product();
//                product.setId(resultSet.getInt("id"));
//                product.setName(resultSet.getString("name"));
//                product.setDescription(resultSet.getString("description"));
//                product.setQuantity(resultSet.getInt("quantity"));
//                product.setThresholdQuantity(resultSet.getInt("thresholdQuantity")
//                );
//                products.add(product);
//            }
//            prepareStatement.close();
//            this.connection.close();
//        }
//        return products;
//    }
}
