package tn.esprit.interfaces;

import tn.esprit.models.Achat;
import tn.esprit.services.ServiceAchat;

import java.sql.Connection;
import java.util.ArrayList;

public class RechercheAchat {
    private Connection connection;
    private ArrayList<Achat> achats;
    private ServiceAchat serviceAchat;
    public RechercheAchat(ArrayList<Achat> achats) {
        this.achats = achats;
    }
    public RechercheAchat(Connection connection) {
        this.connection = connection;
    }

    public RechercheAchat(ServiceAchat serviceAchat) {
        this.serviceAchat = serviceAchat;
    }

    public ArrayList<Achat> searchById(int Id) {
        ArrayList<Achat> result = new ArrayList<>();
        for (Achat achat : serviceAchat.getAll()) {
            if (achat.getId() == Id) {
                result.add(achat);
            }
        }
        return result;
    }



}

