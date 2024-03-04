package fr.ul.miage.us.generation;

import fr.ul.miage.arbre.Noeud;
import fr.ul.miage.arbre.Retour;
import fr.ul.miage.us.Tds;

public class GenererRetour {
    public static String generer_retour(Noeud a,Tds tds) throws Exception
    {
        StringBuffer buf = new StringBuffer();
        // On calcul l'offset de retour
        buf.append(GenererExpression.generer_expression(((Retour)a).getLeFils(), tds));
        String label = a.getLabel().split("/")[2];
        int n = tds.getItem(label+"FONCTION").getNombre_de_parametre();
        int offset = (n+3)*-4;
        buf.append("\tPOP(R0)\n"+"\tPUTFRAME(R0,"+offset+")\n");
        return buf.toString();
    }
}
