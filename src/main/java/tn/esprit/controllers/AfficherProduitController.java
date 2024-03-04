package tn.esprit.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tn.esprit.models.Facture;
import tn.esprit.models.Produit;
import tn.esprit.services.ServiceFacture;
import tn.esprit.services.ServiceProduit;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class AfficherProduitController implements Initializable{

    @FXML
    private ListView<Produit> mylistcomm;

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

    @FXML
    void delete(ActionEvent event) {
        ServiceProduit sp = new ServiceProduit();
        sp.delete(new Produit(idP));
    }

    @FXML
    void tri(ActionEvent event) {
        // Appeler la méthode de tri des factures dans ServiceFacture
        ServiceProduit sp = new ServiceProduit();
        mylistcomm.getItems().setAll(sp.getAllSortedByPrix());
    }

    @FXML
    void retour(ActionEvent event) throws IOException {
        Parent page2 = FXMLLoader.load(getClass().getResource("/Fxml/AjouterProduit.fxml"));

        Scene scene2 = new Scene(page2);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene2);
        app_stage.show();
    }


    int idP;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ServiceProduit sp = new ServiceProduit();
        mylistcomm.getItems().setAll(sp.getAllSortedByPrix());
        mylistcomm.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            idP = newValue.getId();
            nb_produit = String.valueOf(newValue.getNb_produit());
            nm = String.valueOf(newValue.getName());
            pr = String.valueOf(newValue.getPrix());

            nbr_produit.setText(nb_produit);
            name.setText(nm);
            prix.setText(pr);

            System.out.println("nbr_produit " + nb_produit);
        });
        System.out.println("nbr_produit1 " + nbr_produit);
    }


}