package tn.esprit.interfaces;

import tn.esprit.models.Produit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TriProduit {

    public void sortByCategorie(ArrayList<Produit> produits) {
        Collections.sort(produits, Comparator.comparing(Produit::getCategorie));

    }
    public void sortByPrix(ArrayList<Produit> produits) {
        Collections.sort(produits, Comparator.comparing(Produit::getPrix));

    }

}

