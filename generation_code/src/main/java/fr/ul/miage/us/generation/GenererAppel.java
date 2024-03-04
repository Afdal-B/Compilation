package fr.ul.miage.us.generation;

import fr.ul.miage.arbre.Noeud;
import fr.ul.miage.us.Tds;
import fr.ul.miage.us.Type;
import fr.ul.miage.arbre.Appel;
public class GenererAppel {
    public static String generer_appel(Noeud a,Tds tds) throws Exception{
        StringBuffer buf =new StringBuffer();
        // Si la fonction retourne une valeur on fait un allocate(1)
        String label = a.getLabel().split("/")[2];
        if(tds.getItem(label+"FONCTION").getType() == Type.INT)
        {
            buf.append("\tALLOCATE(1)\n");
        }
        for (Noeud f:((Appel)a).getFils())
        {
            buf.append(GenererExpression.generer_expression(f,tds));
        }
        
        

        buf.append("\tCALL("+a.getLabel().split("/")[2]+")\n");
        buf.append("\tDEALLOCATE("+tds.getItem(label+"FONCTION").getNombre_de_parametre()+")\n");
        return buf.toString();
    }
}
