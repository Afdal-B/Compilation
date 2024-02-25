package fr.ul.miage.us.exemple8;
import fr.ul.miage.arbre.*;
import fr.ul.miage.us.*;
public class Main {
    public static void main(String[] args) {
        // Creation des noeuds 
       Prog prog = new Prog();
       Fonction f = new Fonction("f");
       Affectation aff1 = new Affectation();
       Affectation aff2 = new Affectation();

       Idf x1 = new Idf("x");
       Idf x2 =new Idf("x");
       Plus plus1 = new Plus();
       Plus plus2 = new Plus();

       Idf i = new Idf("i");
       Idf j = new Idf("j");
       Retour retour = new Retour(f);
       Const const10 = new Const(10);

       Fonction principal = new Fonction("main");
       Idf a1 =new Idf("a");
       Idf a2 =new Idf("a");
       
       Appel appel = new Appel(f);
       Const const1 = new Const(1);
       Const const2 = new Const(2);


       Ecrire ecrire = new Ecrire();

        // Liaison des noeuds
       prog.ajouterUnFils(f);
       prog.ajouterUnFils(principal);
       f.ajouterUnFils(aff1);
       f.ajouterUnFils(retour);
       aff1.setFilsGauche(x1);
       aff1.setFilsDroit(plus1);
       plus1.setFilsGauche(i);
       plus1.setFilsDroit(j);
       retour.setLeFils(plus2);
       plus2.setFilsGauche(x2);
       plus2.setFilsDroit(const10);
       principal.ajouterUnFils(aff2);
       principal.ajouterUnFils(ecrire);
       aff2.setFilsGauche(a1);
       aff2.setFilsDroit(appel);
       appel.ajouterUnFils(const1);
       appel.ajouterUnFils(const2);
       ecrire.setLeFils(a2);
       //TxtAfficheur.afficher(prog);

       // Creer la TDS
       Tds tds8 = new Tds();
       //creer les items de la table 
       Item item_main = new Item("main",Type.VOID, Cat.FONCTION);
       Item item_a = new Item("a", Type.INT, Cat.GLOBAL);
       Item item_f = new Item("f",Type.INT,Cat.FONCTION,2,1);
       Item item_x = new Item("x",Type.INT,Cat.LOCAL,0,item_f);
       Item item_i = new Item("i",Type.INT,Cat.PARAM,0,item_f);
       Item item_j = new Item("j",Type.INT,Cat.PARAM,1,item_f);
       
       //Afficher un Item
       //System.out.println(item_x.toString());

       // Ajouter les items
       tds8.addItem(item_main);
       tds8.addItem(item_a);
       tds8.addItem(item_f);
       tds8.addItem(item_x);
       tds8.addItem(item_i);
       tds8.addItem(item_j);
       // Afficher la TDS
       System.out.println(tds8.toString());
    }
}
