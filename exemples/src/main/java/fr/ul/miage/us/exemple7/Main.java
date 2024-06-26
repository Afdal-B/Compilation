package fr.ul.miage.us.exemple7;
import fr.ul.miage.arbre.*;
import fr.ul.miage.us.Cat;
import fr.ul.miage.us.Item;
import fr.ul.miage.us.Tds;
import fr.ul.miage.us.Type;
import fr.ul.miage.us.generation.GenererAppel;
import fr.ul.miage.us.generation.GenererFonction;
import fr.ul.miage.us.generation.GenererInstruction;
import fr.ul.miage.us.generation.GenererProg;
public class Main {
    public static void main(String[] args) throws Exception {
      
            Prog prog = new Prog();
            Fonction principal = new Fonction ("main");
            Fonction f= new Fonction ("f");
            Affectation aff1 = new Affectation();		//affectation gauche de la function f
            Affectation aff2 = new Affectation();		//2 affectation partant de la gauche. Celle au mileu de la fonvtion f
            Affectation aff3 = new Affectation();		//affectation a droite
            Plus plus1 = new Plus();
            Plus plus2 = new Plus();
            Idf x1 = new Idf("x");
            Idf y1 = new Idf("y");
            Idf x2 = new Idf("x");
            Idf y2 = new Idf("y");
            Idf a1 = new Idf("a");     
            Idf a2 = new Idf("a");

            Idf i = new Idf("i");
            Ecrire ecrire = new Ecrire();
            Appel appel = new Appel(f);
            Const const1 = new Const(1);
            Const const3 = new Const(3);
            Const const1_2 = new Const(1); 
            prog.ajouterUnFils(f);
            prog.ajouterUnFils(principal);
            principal.ajouterUnFils(appel);
            principal.ajouterUnFils(ecrire);
            appel.ajouterUnFils(const3);
            ecrire.ajouterUnFils(a2);
            f.ajouterUnFils(aff1);
            f.ajouterUnFils(aff2);
            f.ajouterUnFils(aff3);
            aff1.setFilsGauche(x1);
            aff1.setFilsDroit(const1);
            aff2.setFilsGauche(y1);
            aff2.setFilsDroit(const1_2);
            aff3.setFilsGauche(a1);
            aff3.setFilsDroit(plus1);
            plus1.setFilsGauche(i);
            plus1.setFilsDroit(plus2);
            plus2.setFilsGauche(x2);
            plus2.setFilsDroit(y2);
            TxtAfficheur.afficher(prog);

            Tds tds7 = new Tds();
            //créer l'item de la table
            Item item_main = new Item("main",Type.VOID, Cat.FONCTION );
            Item item_a = new Item("a", Type.INT, Cat.GLOBAL, 10);
            Item item_f = new Item("f", Type.VOID, Cat.FONCTION, 1, 2);
            Item item_i = new Item("i", Type.INT, Cat.PARAM, 0, item_f);
            Item item_x = new Item("x", Type.INT, Cat.LOCAL, 0, item_f);
            Item item_y = new Item("y", Type.INT, Cat.LOCAL, 1, item_f);
            // ajouter l'item
            tds7.addItem(item_main);
            tds7.addItem(item_a);
            tds7.addItem(item_f);
            tds7.addItem(item_i);
            tds7.addItem(item_x);
            tds7.addItem(item_y);
            // afficher l'item de la table
            System.out.println(tds7.toString());
            System.out.println(GenererProg.genererProg(prog, tds7));
        

    }
}
