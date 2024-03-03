package tn.esprit.controllers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tn.esprit.models.Produit;
import tn.esprit.services.ServiceProduit;
import javafx.embed.swing.SwingFXUtils;

import javax.imageio.ImageIO;

public class AjouterProduitController {

    /*public TextField nametf;
    public TextField categorietf;
    public TextField prixtf;*/
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField nombreproduittf;

    @FXML
    private TextField descriptiontf;

    @FXML
    private Text msj;

    @FXML
    private TextField nametf;

    @FXML
    private TextField categorietf;


    @FXML TextField prixtf;


    private final ServiceProduit ps = new ServiceProduit();

    private boolean validateFields() {
        return !nombreproduittf.getText().isEmpty() && !descriptiontf.getText().isEmpty()
                && !nametf.getText().isEmpty() && !categorietf.getText().isEmpty() && !prixtf.getText().isEmpty();
    }
    @FXML
    void AjouterProduit(ActionEvent event) throws WriterException {
        if (validateFields()) {

            ps.add(new Produit(0,Integer.parseInt(nombreproduittf.getText()),descriptiontf.getText(),nametf.getText(),categorietf.getText(),Integer.parseInt(prixtf.getText())));

        String texttoqr=" Nom : "+nametf.getText()+"\n Categorie : "+categorietf.getText()+"\n Description : "+descriptiontf.getText()+"\n Prix : "+prixtf.getText();
        String fileName = "QRCode_" + nametf.getText();
       this.generateQRCodeAndSave(texttoqr, fileName);
            msj.setText("Produit ajouté avec succès.");
        } else {
            msj.setText("Veuillez remplir tous les champs.");
        }
    }

    public String generateQRCodeAndSave(String text, String fileName) throws WriterException {
        // Generate the QR code

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, 250, 250);
        BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);

        // Convert the BufferedImage to a JavaFX Image
        Image fxImage = SwingFXUtils.toFXImage(bufferedImage, null);

        // Save the image to the specified directory
        String directoryPath = "C:\\Users\\User\\Desktop\\workshopjdbc-master\\src\\main\\java\\tn\\esprit\\Qrimages";
        Path directory = Paths.get(directoryPath);
        if (!Files.exists(directory)) {
            try {
                Files.createDirectories(directory);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String filePath = directoryPath + "/" + fileName + ".png";
        File file = new File(filePath);
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(fxImage, null), "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filePath;
    }
    @FXML
    void afficherProduit(ActionEvent event) throws IOException {
        Parent page2 = FXMLLoader.load(getClass().getResource("/Fxml/AfficherProduit.fxml"));

        Scene scene2 = new Scene(page2);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene2);
        app_stage.show();
    }

    @FXML
    void initialize() {


        assert nombreproduittf != null : "fx:id=\"nombreproduittf\" was not injected: check your FXML file 'AjouterProduit.fxml'.";

        assert descriptiontf != null : "fx:id=\"descriptiontf\" was not injected: check your FXML file 'AjouterProduit.fxml'.";

        assert nametf != null : "fx:id=\"nametf\" was not injected: check your FXML file 'AjouterProduit.fxml'.";

        assert categorietf != null : "fx:id=\"categorietf\" was not injected: check your FXML file 'AjouterProduit.fxml'.";

        assert prixtf != null : "fx:id=\"prixtf\" was not injected: check your FXML file 'AjouterProduit.fxml'.";

    }

}