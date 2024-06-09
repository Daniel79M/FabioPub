package com.example.fabiopub.interfaces;

import com.example.fabiopub.Entity.Commande;

import java.sql.SQLException;
import java.util.List;


public interface CommandeInterface {
    void create(Commande commande) throws SQLException;
    Commande update(Commande commande) throws SQLException;
    void delete(int id);
    List<Commande>list() throws SQLException;
}
