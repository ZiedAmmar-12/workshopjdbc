package tn.esprit.interfaces;

import tn.esprit.models.Facture;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TriFacture {

    private Connection cnx ;

    // Vos autres méthodes dans ServiceFacture...

    public List<Facture> getAllSortedByDate() {
        List<Facture> factures = getAll();
        factures.sort(Comparator.comparing(Facture::getDate));
        return factures;
    }

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
}

