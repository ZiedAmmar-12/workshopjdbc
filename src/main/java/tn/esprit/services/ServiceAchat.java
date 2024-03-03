package tn.esprit.services;

import tn.esprit.interfaces.IService;
import tn.esprit.models.Achat;
import tn.esprit.models.Produit;
import tn.esprit.utils.MyDataBase;

import java.sql.*;
import java.util.ArrayList;

public class ServiceAchat implements IService<Achat> {
    private Connection cnx ;
    public ServiceAchat(){
        cnx =MyDataBase.getInstance().getCnx();
    }

    @Override
    public void add(Achat achat) {
        // ajouter une achat dans la bd
        //1 - req SQL done
        //2 - executer la req SQL done
        String qry ="INSERT INTO `achats`(`nombre_achats`, `prix`) VALUES (?,?,?)";
        try {
            PreparedStatement stm = cnx.prepareStatement(qry);
            stm.setInt(1,achat.getNb_achats());
            stm.setFloat(2,achat.getPrix());

            stm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }


    }

    @Override
    public ArrayList<Achat> getAll() {


        //retourner toutes les achats dans la bd
        //1- req SQL done
        //2 -execution de la req done
        // 3- remplire la liste done
        // 4 - retourner la liste done
        ArrayList<Achat> achats = new ArrayList();
        String qry ="SELECT * FROM `achats`";
        try {
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()){
                Achat a = new Achat();
                a.setId(rs.getInt(1));
                a.setNb_achats(rs.getInt("nombre_achats"));
                a.setPrix(rs.getInt("prix"));

                achats.add(a);
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return achats;
    }

    @Override
    public void update(Achat achat) {
        String qry = "UPDATE achat SET nb_achats = ?, prix = ? WHERE id = ?";
        try {
            PreparedStatement stm = cnx.prepareStatement(qry);
            stm.setInt(1, achat.getNb_achats());
            stm.setFloat(2, achat.getPrix());
            stm.setInt(3, achat.getId());

            stm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public boolean delete(Achat achat) {
        String qry = "DELETE FROM achats WHERE nb_achats = ? AND prix = ?";
        try {
            PreparedStatement stm = cnx.prepareStatement(qry);
            stm.setInt(1, achat.getNb_achats());
            stm.setFloat(2, achat.getPrix());

            stm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }


        return false;
    }
}