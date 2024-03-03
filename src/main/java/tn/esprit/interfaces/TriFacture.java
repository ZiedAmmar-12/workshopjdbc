package tn.esprit.interfaces;

import tn.esprit.models.Facture;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TriFacture {

    public void sortByDate(ArrayList<Facture> factures) {
        Collections.sort(factures, Comparator.comparing(Facture::getDate));

    }

}

