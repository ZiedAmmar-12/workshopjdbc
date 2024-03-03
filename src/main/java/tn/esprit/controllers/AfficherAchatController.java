package tn.esprit.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AfficherAchatController {
    @FXML
    private TextField lbnombreachat;

    public TextField getLbnombreachat() {
        return lbnombreachat;
    }

    public void setLbnombreachat(int lbnombreachat) {
        this.lbnombreachat.setText(String.valueOf(lbnombreachat));
    }

    public void setlbnombreachat(int i) {
    }

    @FXML
    private TextField lbprix;

    public TextField getLbprix() {
        return lbprix;
    }

    public void setLbprix(float lbprix) {
        this.lbprix.setText(String.valueOf(lbprix));
    }

    public void setlbprix(float i) {
    }


}