package fr.ul.miage.us.exemple3;
import fr.ul.miage.arbre.*;
import fr.ul.miage.us.Cat;
import fr.ul.miage.us.Item;
import fr.ul.miage.us.Tds;
import fr.ul.miage.us.Type;
public class Main {
    public static void main(String[] args) {
    	Prog prog = new Prog();
		Fonction principal = new Fonction ("main");
		Affectation affG = new Affectation();
		Affectation affD = new Affectation();
		Idf k = new Idf("k");
		Idf i = new Idf("i");
		Idf j = new Idf("j");
		Idf l = new Idf("l");
		Plus plus = new Plus();
		Multiplication mul = new Multiplication();
		Const c1 = new Const(2);
		Const c2 = new Const(3);
		
		prog.ajouterUnFils(principal);
		principal.ajouterUnFils(affG);
		principal.ajouterUnFils(affD);
		affG.setFilsGauche(k);
		affG.setFilsDroit(c1);
		affD.setFilsGauche(l);
		affD.setFilsDroit(plus);
		plus.setFilsGauche(i);
		plus.setFilsDroit(mul);
		mul.setFilsGauche(c2 );
		mul.setFilsDroit(j);
		TxtAfficheur.afficher(prog);

        Tds tds3 = new Tds();
    //créer l'item de la table
    Item item_main = new Item("main",Type.VOID, Cat.FONCTION );
    Item item_i = new Item("i", Type.INT, Cat.GLOBAL, 10);
    Item item_j = new Item("j", Type.INT, Cat.GLOBAL, 20);
    Item item_k = new Item("k", Type.INT, Cat.GLOBAL);
    Item item_l = new Item("l", Type.INT, Cat.GLOBAL);
    // ajouter l'item
    tds3.addItem(item_main);
    tds3.addItem(item_i);
    tds3.addItem(item_j);
    tds3.addItem(item_k);
    tds3.addItem(item_l);
    // afficher l'item de la table
    System.out.println(tds3.toString());
    }
    }
