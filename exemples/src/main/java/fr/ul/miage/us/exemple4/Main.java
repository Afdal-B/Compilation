package fr.ul.miage.us.exemple4;
import fr.ul.miage.arbre.*;
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
	}
}	
