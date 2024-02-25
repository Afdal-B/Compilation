package fr.ul.miage.us.exemple7;
import fr.ul.miage.arbre.*;

public class Main {
    public static void main(String[] args) {
      
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
            prog.ajouterUnFils(principal);
            prog.ajouterUnFils(f);
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
    }
}
