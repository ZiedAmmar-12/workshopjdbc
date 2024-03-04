package tn.esprit.services;

import tn.esprit.interfaces.IService;
import tn.esprit.models.Produit;
import tn.esprit.utils.MyDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ServiceProduit implements IService<Produit> {
    private Connection cnx ;
    public ServiceProduit(){
        cnx =MyDataBase.getInstance().getCnx();
    }

    @Override
    public void add(Produit produit) {
        // ajouter un produit dans la bd
        //1 - req SQL done
        //2 - executer la req SQL done
        String qry ="INSERT INTO `produit`(`nb_produit`, `description`, name, categorie, `prix`) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement stm = cnx.prepareStatement(qry);
            stm.setInt(1,produit.getNb_produit());
            stm.setString(2,produit.getDescription());
            stm.setString(3,produit.getName());
            stm.setString(4,produit.getCategorie());
            stm.setFloat(5,produit.getPrix());

            stm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }


    }

    @Override
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

    @Override
    public void update(Produit produit) {
        String qry = "UPDATE produit SET description = ?, name = ?, categorie = ?, prix = ? WHERE id_produit = ?";
        try {
            PreparedStatement stm = cnx.prepareStatement(qry);
            stm.setString(1, produit.getDescription());
            stm.setString(2, produit.getName());
            stm.setString(3, produit.getCategorie());
            stm.setDouble(4, produit.getPrix());
            stm.setInt(5, produit.getId());

            stm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public boolean delete(Produit produit) {
        String qry = "DELETE FROM produit WHERE nb_produit = ? AND description = ? AND name = ? AND categorie = ?  AND prix = ?";
        try {
            PreparedStatement stm = cnx.prepareStatement(qry);
            stm.setInt(1,produit.getNb_produit());
            stm.setString(2, produit.getDescription());
            stm.setString(3, produit.getName());
            stm.setString(4, produit.getCategorie());
            stm.setFloat(5, produit.getPrix());

            stm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }


        return false;
    }

    public List<Produit> getAllSortedByPrix() {
        List<Produit> produits = getAll();
        produits.sort(Comparator.comparing(Produit::getPrix));
        return produits;
    }
}