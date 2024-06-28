package com.example.fabiopub.Entity;

import com.example.fabiopub.dataConfig.IDBconfig;
import com.example.fabiopub.interfaces.CommandeInterface;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;

public class Commande implements CommandeInterface {

    private int id ;

    private String nameOfCommande;

    private String type;

    private String clientName;


    private String dateOfCommande;

    private String deliveryDate;

    private Float price;

    private String quantity;

    private  String descriptions;

    private Connection connection;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getDateOfCommande() {
        return dateOfCommande;
    }

    public void setDateOfCommande(String dateOfCommande) {
        this.dateOfCommande = dateOfCommande;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
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
            preparedStatement.setString(4,commande.getDateOfCommande());
            preparedStatement.setString(5,commande.getDeliveryDate());
            preparedStatement.setFloat(6,commande.getPrice());
            preparedStatement.setString(7,commande.getQuantity());
            preparedStatement.setString(8,commande.getDescriptions());
            preparedStatement.execute();
            preparedStatement.close();
            this.connection.close();
        }

    }

    @Override
    public Commande update(Commande commande) {
        connection = IDBconfig.getConnetion();
        if (connection != null) {
            String update = "UPDATE commande SET nameOfCommande = ?, type = ?, clientName = ?, dateOfCommande = ?, deliveryDate = ?, price = ?, quantity = ?, descriptions = ? WHERE id = ?";
            try {
                PreparedStatement preparedStatement = this.connection.prepareStatement(update);
                preparedStatement.setString(1, nameOfCommande);
                preparedStatement.setString(2, type);
                preparedStatement.setString(3, clientName);
                preparedStatement.setString(4, dateOfCommande);
                preparedStatement.setString(5, deliveryDate);
                preparedStatement.setFloat(6, price);
                preparedStatement.setString(7, quantity);
                preparedStatement.setString(8, descriptions);
                preparedStatement.setInt(9, commande.id);
                preparedStatement.executeUpdate();
                commande.update(commande);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        
        return commande;
    }

    @Override
    public void delete(int id) {
        connection = IDBconfig.getConnetion();
        if (connection != null){
            String req = "DELETE FROM commande WHERE id = ?";
            try {
                PreparedStatement preparedStatement = this.connection.prepareStatement(req);
                preparedStatement.setInt(1,id);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }


    }

    @Override
    public List<Commande>list() throws SQLException {
        List<Commande> commandes = new ArrayList<>();

        connection = IDBconfig.getConnetion();

        if (connection != null) {
            String req = "SELECT * FROM commande";

            PreparedStatement preparedStatement = this.connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Commande command = new Commande();
                command.setId(resultSet.getInt("id"));
                command.setNameOfCommande(resultSet.getString("nameOfCommande"));
                command.setType(resultSet.getString("type"));
                command.setClientName(resultSet.getString("clientName"));
                command.setDateOfCommande(resultSet.getString(valueOf("dateOfCommande")));
                command.setDeliveryDate(resultSet.getString(valueOf("deliveryDate")));
                command.setPrice(resultSet.getFloat(valueOf("price")));
                command.setQuantity(resultSet.getString("quantity"));
                command.setDescriptions(resultSet.getString("descriptions"));

                commandes.add(command);
            }


        }
        return commandes;
    }
}
