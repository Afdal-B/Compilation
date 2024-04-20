package fr.ul.miage.us.generation;

import java.util.ArrayList;
import java.util.List;

import fr.ul.miage.arbre.Fonction;
import fr.ul.miage.arbre.Noeud;
import fr.ul.miage.us.Tds;
// Une fonction qui permet de generer une fonction 
public class GenererFonction {
    public static String generer_fonction(Noeud a, Tds tds) throws Exception
    {
        StringBuffer buf = new StringBuffer();
        String label = a.getLabel().split("/")[1];
        buf.append(label+":\n");
        buf.append(PreparerPile.preparer_pile());
        // On recupère son nombre de variables local 
        int nbVariablesLocales = tds.nbVariablesLocales(tds.getItem(a.getLabel().split("/")[1]+"FONCTION"));
        buf.append("\tALLOCATE("+nbVariablesLocales+")\n");
        // Recupere tout les fils de la fonction 
        List<Noeud> fils = new ArrayList<>();
        fils = ((Fonction)a).getFils();
        for (Noeud f: fils)
        {   // On genere des instructions pour chaque fils. 
            buf.append(GenererInstruction.generer_instruction(f,tds));
        }

        buf.append("\tDEALLOCATE("+nbVariablesLocales+")\n");
        buf.append(GenererRet.generer_ret());
        return buf.toString();
    }
}
