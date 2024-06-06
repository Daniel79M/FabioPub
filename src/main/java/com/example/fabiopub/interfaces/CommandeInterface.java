package com.example.fabiopub.interfaces;

import com.example.fabiopub.models.Commande;

import java.sql.SQLException;
import java.util.List;

public interface CommandeInterface {
    void create(Commande commande) throws SQLException;
    void update(Commande commande) throws SQLException;
    void cancel(int id);
    List<Commande> list();
}
