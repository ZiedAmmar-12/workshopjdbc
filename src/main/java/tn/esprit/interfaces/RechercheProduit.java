package tn.esprit.interfaces;

import tn.esprit.models.Produit;
import tn.esprit.services.ServiceProduit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RechercheProduit {
    private Connection connection;
    private ArrayList<Produit> produits;
    private ServiceProduit serviceProduit;
    public RechercheProduit(ArrayList<Produit> produits) {
        this.produits = produits;
    }
    public RechercheProduit(Connection connection) {
        this.connection = connection;
    }

    public RechercheProduit(ServiceProduit serviceProduit) {
        this.serviceProduit = serviceProduit;
    }

    public ArrayList<Produit> searchById(int Id) {
        ArrayList<Produit> result = new ArrayList<>();
        for (Produit produit : serviceProduit.getAll()) {
            if (produit.getId() == Id) {
                result.add(produit);
            }
        }
        return result;
    }


    public ArrayList<Produit> searchByName(String name) {
        ArrayList<Produit> matchingComments = new ArrayList<>();
        String query = "SELECT * FROM `produit` WHERE LOWER(`name`) LIKE LOWER(?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, "%" + name + "%");

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Produit produit = new Produit();

                    produit.setId(resultSet.getInt("produit_id"));
                    produit.setNb_produit(resultSet.getInt("nb_produit"));
                    produit.setDescription(resultSet.getString("description"));
                    produit.setName(resultSet.getString("name"));
                    produit.setCategorie(resultSet.getString("categorie"));
                    produit.setPrix(resultSet.getFloat("prix"));

                    matchingComments.add(produit);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return matchingComments;
    }

    public ArrayList<Produit> searchByCategorie(String categorie) {
        ArrayList<Produit> matchingComments = new ArrayList<>();
        String query = "SELECT * FROM `produit` WHERE LOWER(`categorie`) LIKE LOWER(?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, "%" + categorie + "%");

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Produit produit = new Produit();

                    produit.setId(resultSet.getInt("produit_id"));
                    produit.setNb_produit(resultSet.getInt("nb_produit"));
                    produit.setDescription(resultSet.getString("description"));
                    produit.setName(resultSet.getString("name"));
                    produit.setCategorie(resultSet.getString("categorie"));
                    produit.setPrix(resultSet.getFloat("prix"));

                    matchingComments.add(produit);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return matchingComments;
    }
}

