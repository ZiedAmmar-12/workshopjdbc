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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import tn.esprit.models.Facture;
import tn.esprit.services.ServiceFacture;
import tn.esprit.services.ServicePersonne;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class AfficherFactureController implements Initializable {
    @FXML
    private TextField lbprixunitaire;

    @FXML
    private ListView<Facture> mylistcomm;

    public TextField getLbprixunitaire() {
        return lbprixunitaire;
    }

    public void setLbprixunitaire(int lbprixunitaire) {
        this.lbprixunitaire.setText(String.valueOf(lbprixunitaire));
    }

    public void setlbprixunitaire(int i) {
    }

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
    private TextField lbquantite;

    @FXML
    private AnchorPane idAnchor;
    public TextField getLbquantite() {
        return lbquantite;
    }

    public void setLbquantite(int lbquantite) {
        this.lbquantite.setText(String.valueOf(lbquantite));
    }

    public void setlbquantite(int i) {
    }

    @FXML
    private TextField lbmontantht;

    public TextField getLbmontantht() {
        return lbmontantht;
    }

    public void setLbmontantht(int lbmontantht) {
        this.lbmontantht.setText(String.valueOf(lbmontantht));
    }

    public void setlbmontantht(int i) {
    }

    @FXML
    private TextField lbtva;

    public TextField getLbtva() {
        return lbtva;
    }

    public void setLbtva(Float lbtva) {
        this.lbtva.setText(String.valueOf(lbtva));
    }

    public void setlbtva(Float i) {
    }

    @FXML
    private TextField lbmontantttc;

    public TextField getLbmontantttc() {
        return lbmontantttc;
    }

    public void setLbmontantttc(int lbmontantttc) {
        this.lbmontantttc.setText(String.valueOf(lbmontantttc));
    }

    public void setlbmontantttc(int i) {
    }

    @FXML
    private TextField lbdate;

    public TextField getLbdate() {
        return lbdate;
    }

    public void setLbdate(String lbdate) {
        this.lbdate.setText(String.valueOf(lbdate));
    }

    public void setlbdate(String i) {
    }

    @FXML
    private TextField lbtypedevise;

    public TextField getLbtypedevise() {
        return lbtypedevise;
    }

    public void setLbtypedevise(String lbtypedevise) {
        this.lbtypedevise.setText(String.valueOf(lbtypedevise));
    }

    public void setlbtypedevise(String i) {
    }

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
    int idF;
    @Override
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




    @FXML
    void imprimer(ActionEvent event) {

    }
}