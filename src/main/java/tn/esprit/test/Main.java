package tn.esprit.test;

import tn.esprit.models.Achat;
import tn.esprit.models.Facture;
import tn.esprit.models.Produit;
import tn.esprit.services.ServiceAchat;
import tn.esprit.services.ServiceProduit;
import tn.esprit.services.ServiceFacture;

public class Main {
    public static void main(String[] args) {


        Produit pr1 = new Produit(2000,25,"mohamed","pull","vetements",25);


        Achat a1 = new Achat(1000,22, 25);

        Facture f1 = new Facture(1000,10,20,200,5,190,"2024/02/23","TND");
        Facture f2 = new Facture(2000,10,30,300,5,285,"2024/02/21","EURO");


        ServiceProduit sp1 = new ServiceProduit();

        ServiceAchat sp2 = new ServiceAchat();

        ServiceFacture sp3 = new ServiceFacture();


        //  sp.add(p1);
        //sp.add(p2);
        //sp.add(p3);

        // System.out.println(sp.getAll());
        // sp.delete(p1);
        //System.out.println(sp.getAll());


        sp1.add(pr1);

        System.out.println(sp1.getAll());

        //sp1.add(pr2);
       // sp1.delete(pr1);
        /*sp2.add(a1);
        System.out.println(sp2.getAll());*/

        //sp3.add(f1);
        //sp3.add(f2);
        //System.out.println(sp3.getAll());
        //sp3.delete(f2);
        //sp3.update(f1);






    }
}