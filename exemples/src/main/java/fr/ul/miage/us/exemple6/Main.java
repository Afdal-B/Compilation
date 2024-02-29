package fr.ul.miage.us.exemple6;

import fr.ul.miage.arbre.*;
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
    Idf i2 = new Idf("i");
    Idf i3 = new Idf("i");
    Idf i4 = new Idf("i");
    Idf i5 = new Idf("i");
    Const const1 = new Const(0);
	TantQue tq1 = new TantQue();
	Inferieur inf = new Inferieur();
	Idf n = new Idf("n");
	Bloc bloc = new Bloc();
	Ecrire ecrire = new Ecrire();
	Affectation aff2 = new Affectation();
	Plus plus = new Plus();
	Const const2 = new Const(1);
 	
    prog.ajouterUnFils(principal);
	principal.ajouterUnFils(aff1);
    principal.ajouterUnFils(tq1);
	aff1.setFilsGauche(i1);
	aff1.setFilsDroit(const1);
	tq1.setCondition(inf);
	tq1.setBloc(bloc);
    inf.setFilsGauche(i2);
    inf.setFilsDroit(n);
	bloc.ajouterUnFils(ecrire);
    bloc.ajouterUnFils(aff2);
	ecrire.setLeFils(i3);
	aff2.setFilsGauche(i4);
	aff2.setFilsDroit(plus);
	plus.setFilsGauche(i5);
	plus.setFilsDroit(const2);
	TxtAfficheur.afficher(prog);

    Tds tds6 = new Tds();
    //créer l'item de la table
    Item item_main = new Item("main",Type.VOID, Cat.FONCTION );
    Item item_i = new Item("i", Type.INT, Cat.GLOBAL);
    Item item_n = new Item("n", Type.INT, Cat.GLOBAL, 5);
    
    // ajouter l'item
    tds6.addItem(item_main);
    tds6.addItem(item_i);
    tds6.addItem(item_n);

    // afficher l'item de la table
    System.out.println(tds6.toString());
    }
    
}
