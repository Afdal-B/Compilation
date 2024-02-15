package fr.ul.miage;
import fr.ul.miage.arbre.*;
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
    }
}