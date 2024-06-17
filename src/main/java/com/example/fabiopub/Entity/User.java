package com.example.fabiopub.Entity;

import com.example.fabiopub.dataConfig.IDBconfig;
import com.example.fabiopub.interfaces.ConnectInterface;
import com.example.fabiopub.interfaces.UserInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class User implements UserInterface, ConnectInterface {
    private int id;
    private String username;
    private String password;
    private String email;
    private Connection connection;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public List<String> list() {
        return List.of(username);
    }

    @Override
    public void Inscription(User user) throws SQLException {
        connection = IDBconfig.getConnetion();
        System.out.println(connection);
        if (connection != null) {
            String req = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
            PreparedStatement prepareStatement = this.connection.prepareStatement(req);
            prepareStatement.setString(1, user.getUsername());
            prepareStatement.setString(2, user.getPassword());
            prepareStatement.setString(3, user.getEmail());
            int row = prepareStatement.executeUpdate();
            System.out.printf(String.valueOf(row));
            prepareStatement.close();
            this.connection.close();
        }

    }

    @Override
    public boolean toConnect(User user) throws SQLException {
        connection = IDBconfig.getConnetion();
        int rows = 0;
        if (connection != null){
            String req = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement preparedStatement = this.connection.prepareStatement(req);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                rows++;
            }
            preparedStatement.close();
            this.connection.close();
        }
        return rows > 0;
    }

}
