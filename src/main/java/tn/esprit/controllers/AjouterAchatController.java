package tn.esprit.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tn.esprit.models.Achat;
import tn.esprit.services.ServiceAchat;

public class AjouterAchatController {

    public TextField nombreachattf;
    public TextField prixtf;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField no;

    @FXML
    private TextField getPrixtf;


    private final ServiceAchat ps = new ServiceAchat();

    @FXML
    void AjouterAchat(ActionEvent event) {
        ps.add(new Achat(0,Integer.parseInt(nombreachattf.getText()),Integer.parseInt(prixtf.getText())));

    }
    @FXML
    void afficherAchat(ActionEvent event) throws IOException {
        Parent page2 = FXMLLoader.load(getClass().getResource("/Fxml/AfficherAchat.fxml"));

        Scene scene2 = new Scene(page2);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene2);
        app_stage.show();
    }

    @FXML
    void initialize() {

        assert nombreachattf != null : "fx:id=\"nombreachattf\" was not injected: check your FXML file 'AjouterProduit.fxml'.";

        assert prixtf != null : "fx:id=\"prixtf\" was not injected: check your FXML file 'AjouterProduit.fxml'.";


    }

    public void AfficherAchat(ActionEvent actionEvent) {
    }
}