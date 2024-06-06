package com.example.fabiopub.dataConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface IDBconfig {

    String host = "localhost";

    String port = "3306";

    String username = "root";

    String password = "";

    String database = "imprimerie";

    String URL = "jdbc:mysql://"+host+":"+port+"/"+database;

    static Connection getConnetion(){
        try{
            return DriverManager.getConnection(URL,username,password);
        } catch (SQLException e) {
            return null;
        }
    }
}
