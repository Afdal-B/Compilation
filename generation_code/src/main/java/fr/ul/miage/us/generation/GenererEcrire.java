package fr.ul.miage.us.generation;
import fr.ul.miage.arbre.Ecrire;
import fr.ul.miage.arbre.Noeud;
import fr.ul.miage.us.Tds;
// Une fonction pour générer l'ecriture (Affichage)
public class GenererEcrire {

    public static String generer_ecrire(Noeud a,Tds tds) throws Exception{
    StringBuffer buf = new StringBuffer(); // je créé un objet vide
    buf.append(GenererExpression.generer_expression((((Ecrire)a).getLeFils()),tds));
    buf.append("\tPOP(R0)\n"+"\tWRINT()\n"); // le "\t" représente la tabulation en début de ligne dans notre code asm
    return buf.toString();
    }
}