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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tn.esprit.models.Facture;
import tn.esprit.services.ServiceFacture;

public class AjouterFactureController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text msj;

    @FXML
    private TextField prixunitairetf;

    @FXML
    private TextField quantitetf;

    @FXML
    private TextField montanthttf;

    @FXML
    private TextField tvatf;

    @FXML
    private TextField montantttctf;

    @FXML
    private TextField datetf;

    @FXML
    private TextField typedevisetf;


    private final ServiceFacture ps = new ServiceFacture();

    @FXML
    void AjouterFacture(ActionEvent event) {
            String prixUnitaireText = prixunitairetf.getText();
            String quantiteText = quantitetf.getText();
            String montantHTText = montanthttf.getText();
            String tvaText = tvatf.getText();
            String montantTTCtText = montantttctf.getText();
            String dateText = datetf.getText();
            String typeDevisText = typedevisetf.getText();

            if (prixUnitaireText.isEmpty() || quantiteText.isEmpty() || montantHTText.isEmpty() ||
                    tvaText.isEmpty() || montantTTCtText.isEmpty() || dateText.isEmpty() ||
                    typeDevisText.isEmpty()) {
                // Not all fields are filled, set error message
                msj.setText("Please fill all fields.");
                return; // Exit the method
            }

            try {
                Facture facture = new Facture(
                        Integer.parseInt(prixUnitaireText),
                        Integer.parseInt(quantiteText),
                        Integer.parseInt(montantHTText),
                        Integer.parseInt(montantTTCtText),
                        Integer.parseInt(tvaText),

                        dateText,
                        typeDevisText);
                ps.add(facture);
                // Set success message
                msj.setText("Facture added successfully.");
            } catch (NumberFormatException e) {
                // Handle the case where parsing of text to integer fails
                msj.setText("Error: Please enter valid numbers.");
            }
        }


    @FXML
    void afficherFacture(ActionEvent event) throws IOException {
        Parent page2 = FXMLLoader.load(getClass().getResource("/Fxml/AfficherFacture.fxml"));

        Scene scene2 = new Scene(page2);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene2);
        app_stage.show();
    }

    @FXML
    void gestionproduit(ActionEvent event) throws IOException {
        Parent page2 = FXMLLoader.load(getClass().getResource("/Fxml/AjouterProduit.fxml"));

        Scene scene2 = new Scene(page2);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene2);
        app_stage.show();
    }


    @FXML
    void initialize() {

        assert prixunitairetf != null : "fx:id=\"prixunitairetf\" was not injected: check your FXML file 'AjouterFacture.fxml'.";

        assert quantitetf != null : "fx:id=\"quantitetf\" was not injected: check your FXML file 'AjouterFacture.fxml'.";

        assert montanthttf != null : "fx:id=\"montanthttf\" was not injected: check your FXML file 'AjouterFacture.fxml'.";

        assert tvatf != null : "fx:id=\"tvatf\" was not injected: check your FXML file 'AjouterFacture.fxml'.";

        assert montantttctf != null : "fx:id=\"montantttctf\" was not injected: check your FXML file 'AjouterFacture.fxml'.";

        assert datetf != null : "fx:id=\"datetf\" was not injected: check your FXML file 'AjouterFacture.fxml'.";

        assert typedevisetf != null : "fx:id=\"typedevisetf\" was not injected: check your FXML file 'AjouterFacture.fxml'.";


    }

}