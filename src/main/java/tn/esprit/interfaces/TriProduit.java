package tn.esprit.interfaces;

import tn.esprit.models.Facture;
import tn.esprit.models.Produit;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TriProduit {

    private Connection cnx ;

    public List<Produit> getAllSortedByPrix() {
        List<Produit> produits = getAll();
        produits.sort(Comparator.comparing(Produit::getPrix));
        return produits;
    }

    public ArrayList<Produit> getAll() {


        //retourner tout les produits dans la bd
        //1- req SQL done
        //2 -execution de la req done
        // 3- remplire la liste done
        // 4 - retourner la liste done
        ArrayList<Produit> produits = new ArrayList();
        String qry ="SELECT * FROM `produit`";
        try {
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()){
                Produit pr = new Produit();
                pr.setId(rs.getInt(1));
                pr.setNb_produit(rs.getInt("nb_produit"));
                pr.setDescription(rs.getString(3));
                pr.setName(rs.getString("name"));
                pr.setCategorie(rs.getString("categorie"));
                pr.setPrix(rs.getInt("prix"));

                produits.add(pr);
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return produits;
    }

}

