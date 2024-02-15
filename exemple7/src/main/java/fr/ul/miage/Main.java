package fr.ul.miage;
import fr.ul.miage.arbre.*;

public class Main {
    public static void main(String[] args) {
      
            Prog prog = new Prog();
            Fonction principal1 = new Fonction ("main");
            Fonction principal2= new Fonction ("f");
            Affectation affG = new Affectation();		//affectation gauche de la function f
            Affectation affM = new Affectation();		//2 affectation partant de la gauche. Celle au mileu de la fonvtion f
            Affectation affD = new Affectation();		//affectation a droite
            Plus plus = new Plus();
            Plus plus2 = new Plus();
            Idf x = new Idf("x");
            Idf y = new Idf("y");
            Idf a = new Idf("a");
            Idf l = new Idf("l");
            Idf i = new Idf("i");
            Ecrire ecrire = new Ecrire();
            Appel appel = new Appel(principal2);
            Const c1 = new Const(1);
            Const c2 = new Const(3);
            
            prog.ajouterUnFils(principal1);
            prog.ajouterUnFils(principal2);
            principal1.ajouterUnFils(appel);
            principal1.ajouterUnFils(ecrire);
            appel.ajouterUnFils(c2);
            ecrire.ajouterUnFils(a);
            principal2.ajouterUnFils(affG);
            principal2.ajouterUnFils(affM);
            principal2.ajouterUnFils(affD);
            affG.setFilsGauche(x);
            affG.setFilsDroit(c1);
            affM.setFilsGauche(y);
            affM.setFilsDroit(c1);
            affD.setFilsGauche(a);
            affD.setFilsDroit(plus);
            plus.setFilsGauche(i);
            plus.setFilsDroit(plus2);
            plus2.setFilsGauche(x);
            plus2.setFilsDroit(y);
            
            TxtAfficheur.afficher(prog);
    }
}