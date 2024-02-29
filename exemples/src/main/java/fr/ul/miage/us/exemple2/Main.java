package fr.ul.miage.us.exemple2;
import fr.ul.miage.arbre.Fonction;
import fr.ul.miage.arbre.Prog;
import fr.ul.miage.arbre.TxtAfficheur;
import fr.ul.miage.us.Cat;
import fr.ul.miage.us.Item;
import fr.ul.miage.us.Tds;
import fr.ul.miage.us.Type;

public class Main {
    public static void main(String[] args) {
        // Creation des noeuds 
       Prog prog = new Prog();
       Fonction principal = new Fonction("main");
       // liaison des noeuds
       prog.ajouterUnFils(principal);
       TxtAfficheur.afficher(prog);


       // créer la tds
    Tds tds2 = new Tds();
    //créer l'item de la table
    Item item_main = new Item("main",Type.VOID, Cat.FONCTION );
    Item item_i = new Item("i", Type.INT, Cat.GLOBAL, 10);
    Item item_j = new Item("j", Type.INT, Cat.GLOBAL, 20);
    Item item_k = new Item("k", Type.INT, Cat.GLOBAL);
    Item item_l = new Item("l", Type.INT, Cat.GLOBAL);
    // ajouter l'item
    tds2.addItem(item_main);
    tds2.addItem(item_i);
    tds2.addItem(item_j);
    tds2.addItem(item_k);
    tds2.addItem(item_l);
    // afficher l'item de la table
    System.out.println(tds2.toString());
}
}
