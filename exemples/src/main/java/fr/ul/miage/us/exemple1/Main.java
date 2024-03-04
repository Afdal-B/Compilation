package fr.ul.miage.us.exemple1;
import fr.ul.miage.arbre.Fonction;
import fr.ul.miage.arbre.Prog;
import fr.ul.miage.arbre.TxtAfficheur;
import fr.ul.miage.us.Cat;
import fr.ul.miage.us.Item;
import fr.ul.miage.us.Tds;
import fr.ul.miage.us.Type;
import fr.ul.miage.us.generation.GenererProg;
public class Main {
    public static void main(String[] args) throws Exception{
        // Creation des noeuds 
    Prog prog = new Prog();
    Fonction principal = new Fonction("main");
       // liaison des noeuds
    prog.ajouterUnFils(principal);
    TxtAfficheur.afficher(prog);


    // créer la tds
    Tds tds1 = new Tds();
    //créer l'item de la table
    Item item_main = new Item("main",Type.VOID, Cat.FONCTION );
    // ajouter l'item
    tds1.addItem(item_main);
    // afficher l'item de la table
    System.out.println(tds1.toString());
    // Afficher le code assembleur généré à partir de l'arbre et de la TDS 
    System.out.println(GenererProg.genererProg(prog, tds1));
}
}
