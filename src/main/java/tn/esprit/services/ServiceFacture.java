package tn.esprit.services;

import tn.esprit.interfaces.IService;
import tn.esprit.models.Facture;
import tn.esprit.utils.MyDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ServiceFacture implements IService<Facture> {
    private Connection cnx ;
    public ServiceFacture(){
        cnx =MyDataBase.getInstance().getCnx();
    }

    @Override
    public void add(Facture facture) {
        // ajouter une facture dans la bd
        //1 - req SQL done
        //2 - executer la req SQL done
        String qry = "INSERT INTO facture (prix_unitaire, quantite, montant_ht, tva, montant_ttc, date, type_devise) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stm = cnx.prepareStatement(qry);
            stm.setInt(1, facture.getPrix_unitaire());
            stm.setInt(2, facture.getQuantite());
            stm.setInt(3, facture.getMontant_ht());
            stm.setFloat(4, facture.getTva());
            stm.setInt(5, facture.getMontant_ttc());
            stm.setString(6, facture.getDate());
            stm.setString(7, facture.getType_devise());

            stm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public ArrayList<Facture> getAll() {


        //retourner toutes les factures dans la bd
        //1- req SQL done
        //2 -execution de la req done
        // 3- remplire la liste done
        // 4 - retourner la liste done
        ArrayList<Facture> factures = new ArrayList();
        String qry ="SELECT * FROM `facture`";
        try {
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()){
                Facture p = new Facture();
                p.setId(rs.getInt(1));
                p.setPrix_unitaire(rs.getInt("prix_unitaire"));
                p.setQuantite(rs.getInt("quantite"));
                p.setMontant_ht(rs.getInt("montant_ht"));
                p.setTva(rs.getFloat("tva"));
                p.setMontant_ttc(rs.getInt("montant_ttc"));
                p.setDate(rs.getString("date"));
                p.setType_devise(rs.getString("type_devise"));


                factures.add(p);
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return factures;
    }

    @Override
    public void update(Facture facture) {
        String qry = "UPDATE facture SET prix_unitaire = ?, quantite = ?, montants_ht = ?, tva = ?, montants_ttc = ?, date = STR_TO_DATE(?, '%d/%m/%Y'), type_device = ? WHERE id = ?";
        try {
            PreparedStatement stm = cnx.prepareStatement(qry);
            stm.setInt(1, facture.getPrix_unitaire());
            stm.setInt(2, facture.getQuantite());
            stm.setInt(3, facture.getMontant_ht());
            stm.setFloat(4, facture.getTva());
            stm.setInt(5, facture.getMontant_ttc());
            stm.setString(6, facture.getDate());
            stm.setString(7, facture.getType_devise());
            stm.setInt(8, facture.getId());

            stm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public boolean delete(Facture facture) {
        String qry = "DELETE FROM facture WHERE id= ?";
        try {
            PreparedStatement stm = cnx.prepareStatement(qry);
            stm.setInt(1, facture.getId());
            stm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }


        return false;
    }


    public List<Facture> afficherFacture() {
        List<Facture> list = new ArrayList<>();

        try {
            String req = "SELECT * FROM factures";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Facture(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getFloat(5), rs.getInt(6),rs.getString(7),rs.getString(8)));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    public List<Facture> getAllSortedByDate() {
        List<Facture> factures = getAll();
        factures.sort(Comparator.comparing(Facture::getDate));
        return factures;
    }
}