package tn.esprit.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;
import tn.esprit.models.Facture;
import tn.esprit.services.ServiceFacture;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AfficherFactureController implements Initializable {


    @FXML
    private ListView<Facture> mylistcomm;

    @FXML
    private AnchorPane idAnchor;

    @FXML
    private Text date;

    String datenv;
    @FXML
    private Text montant;

    String monantnv;

    @FXML
    private Text prixuni;

    String prixnvnv;
    @FXML
    private Text quantite;

    String quantitenv;


    @FXML
    void showFac(ActionEvent event) {
        PrinterJob job = PrinterJob.createPrinterJob();
        if(job != null){
            Window primaryStage = null;
            job.showPrintDialog(primaryStage);

            Node root=this.idAnchor
                    ;
            job.printPage(root);

            job.endJob();



        }
    }

    @FXML
    void delete(ActionEvent event) {
        ServiceFacture sp = new ServiceFacture();
        sp.delete(new Facture(idF));
    }

    @FXML
    void tri(ActionEvent event) {
        // Appeler la méthode de tri des factures dans ServiceFacture
        ServiceFacture sp = new ServiceFacture();
        mylistcomm.getItems().setAll(sp.getAllSortedByDate());
    }

    @FXML
    void retour(ActionEvent event) throws IOException {
        Parent page2 = FXMLLoader.load(getClass().getResource("/Fxml/AjouterFacture.fxml"));

        Scene scene2 = new Scene(page2);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene2);
        app_stage.show();
    }




    int idF;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialiser la liste des factures triées par date
        ServiceFacture sp = new ServiceFacture();
        mylistcomm.getItems().setAll(sp.getAllSortedByDate());

        // Sélectionner un élément dans la liste affiche les détails de la facture correspondante
        mylistcomm.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                idF = newValue.getId();
                prixnvnv = String.valueOf(newValue.getPrix_unitaire());
                quantitenv = String.valueOf(newValue.getQuantite());
                monantnv = String.valueOf(newValue.getMontant_ht());
                datenv = String.valueOf(newValue.getDate());

                prixuni.setText(prixnvnv);
                quantite.setText(quantitenv);
                montant.setText(monantnv);
                date.setText(datenv);

                System.out.println("prixnvnv " + prixnvnv);
            }
        });


        System.out.println("prixnvnv1 " + prixnvnv);
    }

    /*@Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ServiceFacture sp = new ServiceFacture();
        mylistcomm.getItems().setAll(sp.getAll());
        mylistcomm.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            idF = newValue.getId();
            prixnvnv = String.valueOf(newValue.getPrix_unitaire());
            quantitenv = String.valueOf(newValue.getQuantite());
            monantnv = String.valueOf(newValue.getMontant_ht());
            datenv = String.valueOf(newValue.getDate());

            prixuni.setText(prixnvnv);
            quantite.setText(quantitenv);
            montant.setText(monantnv);
            date.setText(datenv);

            System.out.println("prixnvnv " + prixnvnv);

        });
        System.out.println("prixnvnv1 " + prixnvnv);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialiser la liste des factures triées par date
        ServiceFacture sp = new ServiceFacture();
        mylistcomm.getItems().setAll(sp.getAllSortedByDate());

        // Sélectionner un élément dans la liste affiche les détails de la facture correspondante
        mylistcomm.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            idF = newValue.getId();
            prixnvnv = String.valueOf(newValue.getPrix_unitaire());
            quantitenv = String.valueOf(newValue.getQuantite());
            monantnv = String.valueOf(newValue.getMontant_ht());
            datenv = String.valueOf(newValue.getDate());

            prixuni.setText(prixnvnv);
            quantite.setText(quantitenv);
            montant.setText(monantnv);
            date.setText(datenv);

            System.out.println("prixnvnv " + prixnvnv);
        });

        System.out.println("prixnvnv1 " + prixnvnv);
    }*/



    @FXML
    void imprimer(ActionEvent event) {

    }
}