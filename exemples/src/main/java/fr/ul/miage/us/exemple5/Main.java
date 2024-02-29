package fr.ul.miage.us.exemple5;

import fr.ul.miage.arbre.Affectation;
import fr.ul.miage.arbre.Bloc;
import fr.ul.miage.arbre.Const;
import fr.ul.miage.arbre.Ecrire;
import fr.ul.miage.arbre.Fonction;
import fr.ul.miage.arbre.Idf;
import fr.ul.miage.arbre.Lire;
import fr.ul.miage.arbre.Prog;
import fr.ul.miage.arbre.Si;
import fr.ul.miage.arbre.Superieur;
import fr.ul.miage.arbre.TxtAfficheur;
import fr.ul.miage.us.Cat;
import fr.ul.miage.us.Item;
import fr.ul.miage.us.Tds;
import fr.ul.miage.us.Type;

public class Main {
    public static void main(String[] args) {
    Prog prog = new Prog();
	Fonction principal = new Fonction("main");
	Affectation aff1 = new Affectation();
	Idf i1 = new Idf("i");
    Lire lire = new Lire();
    Si si1 = new Si();
    Superieur sup = new Superieur();
    Idf i2 = new Idf("i");
    Const const1 = new Const(10);
    Bloc bloc1 = new Bloc();
    Ecrire ecrire1 = new Ecrire();
    Const const2 = new Const(1);
    Bloc bloc2 = new Bloc();
    Ecrire ecrire2 = new Ecrire();
    Const const3 = new Const(2);
	
 	
    prog.ajouterUnFils(principal);
	principal.ajouterUnFils(aff1);
    principal.ajouterUnFils(si1);
	aff1.setFilsGauche(i1);
	aff1.setFilsDroit(lire);
	si1.setCondition(sup);
	si1.setBlocAlors(bloc1);
    si1.setBlocSinon(bloc2);
    sup.setFilsGauche(i2);
    sup.setFilsDroit(const1);
	bloc1.ajouterUnFils(ecrire1);
    bloc2.ajouterUnFils(ecrire2);
	ecrire1.setLeFils(const2);
	ecrire2.setLeFils(const3);
	TxtAfficheur.afficher(prog);


    //création des tables de symboles 
    Tds tds5 = new Tds();
    //créer l'item de la table
    Item item_main = new Item("main",Type.VOID, Cat.FONCTION );
    Item item_i = new Item("i", Type.INT, Cat.GLOBAL);
    
    // ajouter l'item
    tds5.addItem(item_main);
    tds5.addItem(item_i);

    // afficher l'item de la table
    System.out.println(tds5.toString());
}
}
