package tn.esprit.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AfficherProduitController {
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
}