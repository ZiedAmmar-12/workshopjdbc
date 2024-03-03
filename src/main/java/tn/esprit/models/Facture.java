package tn.esprit.models;

public class Facture {

    private int id ,prix_unitaire, quantite, montant_ht, montant_ttc ;
    private float tva;
    private String date, type_devise ;

    public Facture(int id, int prix_unitaire, int quantite, int montant_ht, int montant_ttc, float tva, String type_devise) {
        this.id = id;
        this.prix_unitaire = prix_unitaire;
        this.quantite = quantite;
        this.montant_ht = montant_ht;
        this.montant_ttc = montant_ttc;
        this.tva = tva;
        this.type_devise = type_devise;
    }

    public Facture() {
    }

    public Facture(int id ,int prix_unitaire, int quantite, int montant_ht, float tva,int montant_ttc, String date, String type_devise) {
        this.id = id;
        this.prix_unitaire= prix_unitaire;
        this.quantite= quantite;
        this.montant_ht= montant_ht;
        this.tva= tva;
        this.montant_ttc = montant_ttc;
        this.date = date;
        this.type_devise = type_devise;

    }

    public Facture(int prix_unitaire, int quantite, int montant_ht, int montant_ttc, float tva, String date, String type_devise) {
        this.prix_unitaire = prix_unitaire;
        this.quantite = quantite;
        this.montant_ht = montant_ht;
        this.montant_ttc = montant_ttc;
        this.tva = tva;
        this.date = date;
        this.type_devise = type_devise;
    }

    public Facture(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrix_unitaire() {
        return prix_unitaire;
    }

    public void setPrix_unitaire(int prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    public int getMontant_ht() {
        return montant_ht;
    }

    public void setMontant_ht(int montant_ht) {
        this.montant_ht = montant_ht;
    }
    public float getTva() {
        return tva;
    }

    public void setTva(float tva) {
        this.tva = tva;
    }

    public int getMontant_ttc() {
        return montant_ttc;
    }

    public void setMontant_ttc(int montant_ttc) {
        this.montant_ttc = montant_ttc;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType_devise() {
        return type_devise;
    }

    public void setType_devise(String type_devise) {
        this.type_devise = type_devise;
    }

    @Override
    public String toString() {
        return "Facture{" +
                "id=" + id +
                ", prix_unitaire=" + prix_unitaire + '\'' +
                ", quantités=" + quantite + '\'' +
                ", montants_ht=" + montant_ht + '\'' +
                ", tva=" + tva + '\'' +
                ", montants_ttc=" + montant_ttc + '\'' +
                ", date='" + date + '\'' +
                ", type device='" + type_devise + '\'' +
                "}\n";
    }
}