package fr.ul.miage.us.generation;

import java.util.ArrayList;
import java.util.List;
import fr.ul.miage.arbre.Noeud;
import fr.ul.miage.us.Tds;

public class GenererBloc {
    public static String generer_bloc(Noeud b,Tds tds) throws Exception{
    StringBuffer buf = new StringBuffer();
    List<Noeud> l = new ArrayList<>(); //declaration de la liste ou je vais stocker les fils de l'arbre
    l=b.getFils();
    for ( Noeud fils : l ){  //une boucle pour parcourir la liste
    switch (fils.getCat()){
        case ECR:// pour le ECRIRE le LIRE et AFFECTATION il doit y avoir autre chose a //la place
           buf.append(GenererEcrire.generer_ecrire(fils,tds));
            break;
        case LIRE: 
            buf.append(GenererExpression.generer_expression(fils,tds));
            break;
        case AFF:
            buf.append(GenererAffectation.generer_affectation(fils,tds));
            break;
        default:
            throw new Exception("Erreur : generer bloc");
    }
    }
    return buf.toString();
}
}
