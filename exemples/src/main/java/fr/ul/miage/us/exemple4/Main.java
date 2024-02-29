package fr.ul.miage.us.exemple4;
import fr.ul.miage.arbre.*;
import fr.ul.miage.us.Cat;
import fr.ul.miage.us.Item;
import fr.ul.miage.us.Tds;
import fr.ul.miage.us.Type;
public class Main {
	public static void main(String[]args) {
	//création des noeuds
 	Prog prog = new Prog();
	Fonction principal = new Fonction("main");
	Affectation aff = new Affectation();
	Idf i = new Idf("i");
	Lire lire = new Lire();
	Ecrire ecrire = new Ecrire();
	Plus plus = new Plus();
	Idf i2 = new Idf("i");
	Idf j = new Idf("j");
 	// on lie les noeuds 
 	prog.ajouterUnFils(principal);
	principal.ajouterUnFils(aff);
	aff.setFilsGauche(i);
	aff.setFilsDroit(lire);
	principal.ajouterUnFils(ecrire);
	ecrire.setLeFils(plus);
	plus.setFilsGauche(i2);
	plus.setFilsDroit(j);
	TxtAfficheur.afficher(prog);
    Tds tds4 = new Tds();
    //créer l'item de la table
    Item item_main = new Item("main",Type.VOID, Cat.FONCTION );
    Item item_i = new Item("i", Type.INT, Cat.GLOBAL);
    Item item_j = new Item("j", Type.INT, Cat.GLOBAL, 20);
    
    // ajouter l'item
    tds4.addItem(item_main);
    tds4.addItem(item_i);
    tds4.addItem(item_j);

    // afficher l'item de la table
    System.out.println(tds4.toString());
	}
}	
