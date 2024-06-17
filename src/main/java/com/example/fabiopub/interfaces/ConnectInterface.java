package com.example.fabiopub.interfaces;

import com.example.fabiopub.Entity.User;

import java.sql.SQLException;

public interface ConnectInterface {
    void Inscription(User user) throws SQLException;
    boolean toConnect(User user) throws SQLException;
}
