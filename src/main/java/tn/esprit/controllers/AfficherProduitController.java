package tn.esprit.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import tn.esprit.models.Facture;
import tn.esprit.models.Produit;
import tn.esprit.services.ServiceFacture;
import tn.esprit.services.ServiceProduit;

import java.net.URL;
import java.util.ResourceBundle;



public class AfficherProduitController implements Initializable{
    @FXML
    private TextField lbnombreproduit;

    public TextField getLbnombreproduit() {
        return lbnombreproduit;
    }

    public void setLbnombreproduit(int lbnombreproduit) {
        this.lbnombreproduit.setText(String.valueOf(lbnombreproduit));
    }

    public void setlbnombreproduit(int i) {
    }

    @FXML
    private TextField lbname;

    public TextField getLbname() {
        return lbname;
    }

    public void setLbname(String lbname) {
        this.lbname.setText(String.valueOf(lbname));
    }

    public void setlbname(String i) {
    }

    @FXML
    private TextField lbcategorie;

    @FXML
    private ListView<Produit> mylistcomm;

    @FXML
    private AnchorPane idAnchor;

    @FXML
    private Text nbr_produit;

    @FXML
    String nb_produit;

    @FXML
    private Text name;

    String nm;

    @FXML
    private Text prix;

    String pr;



    public TextField getLbcategorie() {
        return lbcategorie;
    }

    public void setLbcategorie(String lbcategorie) {
        this.lbcategorie.setText(String.valueOf(lbnombreproduit));
    }

    public void setlbcategorie(String i) {
    }

    @FXML
    private TextField lbprix;

    public TextField getLbprix() {
        return lbprix;
    }

    public void setLbprix(Float lbprix) {
        this.lbprix.setText(String.valueOf(lbprix));
    }

    public void setlbprix(Float i) {
    }

    @FXML
    private Text quantite;

    String quantitenv;
    @FXML
    void delete(ActionEvent event) {
        ServiceProduit sp = new ServiceProduit();
        sp.delete(new Produit(idP));
    }

    int idP;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ServiceProduit sp = new ServiceProduit();
        mylistcomm.getItems().setAll(sp.getAll());
        mylistcomm.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            idP = newValue.getId();
            nb_produit = String.valueOf(newValue.getNb_produit());
            nm = String.valueOf(newValue.getName());
            pr = String.valueOf(newValue.getPrix());

            /*n = String.valueOf(newValue.getQuantite());
            monantnv = String.valueOf(newValue.getMontant_ht());
            datenv = String.valueOf(newValue.getDate());*/

            nbr_produit.setText(nb_produit);
            name.setText(nm);
            prix.setText(pr);

            System.out.println("nbr_produit " + nb_produit);

        });
        System.out.println("nbr_produit1 " + nbr_produit);
    }


}