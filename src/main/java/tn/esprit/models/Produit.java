package tn.esprit.models;

public class Produit {

    private int id , nb_produit ;
    private String description , name , categorie ;
    private float prix ;

    public Produit() {
    }

    public Produit(int id ,int nb_produit, String description, String name , String categorie, float prix) {
        this.id = id;
        this.nb_produit = nb_produit;
        this.description = description;
        this.name = name;
        this.categorie = categorie;
        this.prix = prix;
    }

    public Produit(int idP) {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNb_produit() {
        return nb_produit;
    }

    public void setNb_produit(int nbProduit) {
        this.nb_produit = nbProduit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", nombreproduit=" + nb_produit +
                ", description='" + description + '\'' +
                ", prix='" + prix + '\'' +
                "}\n";
    }
}