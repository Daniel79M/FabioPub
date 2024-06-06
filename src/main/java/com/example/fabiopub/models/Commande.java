package com.example.fabiopub.models;

import com.example.fabiopub.dataConfig.IDBconfig;
import com.example.fabiopub.interfaces.CommandeInterface;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Commande implements CommandeInterface {

    private int id;

    private String nameOfCommande;

    private String type;

    private String clientName;


    private Date dateOfCommande;

    private Date deliveryDate;

    private Float price;

    private int quantity;

    private  String descriptions;

    private Connection connection;

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Date getDateOfCommande() {
        return dateOfCommande;
    }

    public void setDateOfCommande(Date dateOfCommande) {
        this.dateOfCommande = dateOfCommande;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNameOfCommande() {
        return nameOfCommande;
    }

    public void setNameOfCommande(String nameOfCommande) {
        this.nameOfCommande = nameOfCommande;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
            preparedStatement.setInt(7,commande.getQuantity());
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
    public List<Commande> list() {
        return List.of();
    }
}
