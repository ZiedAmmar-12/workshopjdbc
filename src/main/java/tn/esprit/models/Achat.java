package tn.esprit.models;

public class Achat {

    private int id , nb_achats ;
    private float prix ;

    public Achat() {
    }

    public Achat(int id ,int nb_achats,float prix) {
        this.id = id;
        this.nb_achats = nb_achats;
        this.prix = prix;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNb_achats() {
        return nb_achats;
    }

    public void setNb_achats(int nb_achats) {
        this.nb_achats = nb_achats;
    }


    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Achat{" +
                "id=" + id +
                ", nombreachats=" + nb_achats + '\'' +
                ", prix='" + prix + '\'' +
                "}\n";
    }
}