package tn.esprit.models;

public class Produit {

    private int id , nb_produit ;
    private String description , name , categorie , photo;
    private float prix ;

    public Produit() {
    }

    public Produit(int id ,int nb_produit, String description, String name , String categorie, float prix, String photo) {
        this.id = id;
        this.nb_produit = nb_produit;
        this.description = description;
        this.name = name;
        this.categorie = categorie;
        this.prix = prix;
        this.photo = photo;

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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", nb_produit=" + nb_produit +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", categorie='" + categorie + '\'' +
                ", prix=" + prix +
                ", photo='" + photo + '\'' +
                "}\n";
    }
}