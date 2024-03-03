package tn.esprit.interfaces;

import tn.esprit.models.Facture;
import tn.esprit.services.ServiceFacture;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RechercheFacture {
    private Connection connection;
    private ArrayList<Facture> factures;
    private ServiceFacture serviceFacture;
    public RechercheFacture(ArrayList<Facture> factures) {
        this.factures = factures;
    }
    public RechercheFacture(Connection connection) {
        this.connection = connection;
    }

    public RechercheFacture(ServiceFacture serviceFacture) {
        this.serviceFacture = serviceFacture;
    }

    public ArrayList<Facture> searchById(int Id) {
        ArrayList<Facture> result = new ArrayList<>();
        for (Facture facture : serviceFacture.getAll()) {
            if (facture.getId() == Id) {
                result.add(facture);
            }
        }
        return result;
    }


    public ArrayList<Facture> searchByDate(String date) {
        ArrayList<Facture> matchingComments = new ArrayList<>();
        String query = "SELECT * FROM `facture` WHERE (`date`) LIKE (?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, "%" + date + "%");

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Facture facture = new Facture();

                    facture.setId(resultSet.getInt("facture_id"));
                    facture.setPrix_unitaire(resultSet.getInt("prix_unitaire"));
                    facture.setQuantite(resultSet.getInt("quantité"));
                    facture.setMontant_ht(resultSet.getInt("montant_ht"));
                    facture.setTva(resultSet.getFloat("tva"));
                    facture.setMontant_ttc(resultSet.getInt("montant_ttc"));
                    facture.setDate(resultSet.getString("date"));
                    facture.setType_devise(resultSet.getString("type_devise"));

                    matchingComments.add(facture);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return matchingComments;
    }
    // You can add more search methods based on your requirements
}

