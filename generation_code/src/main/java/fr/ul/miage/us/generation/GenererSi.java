package fr.ul.miage.us.generation;
import fr.ul.miage.arbre.Noeud;
import fr.ul.miage.arbre.Si;
import fr.ul.miage.us.Tds;

public class GenererSi {
 public static String generer_si(Noeud a,Tds tds) throws Exception{
        StringBuffer buf = new StringBuffer();
        buf.append(GenererCondition.generer_condition(((Si)a).getCondition(),tds));
        buf.append("\tBF(R1,else)\n");
        buf.append(GenererBloc.generer_bloc(((Si)a).getBlocAlors(),tds));
        buf.append("\tBR(end_if)\n" +
        "\telse:\n");
        buf.append(GenererBloc.generer_bloc(((Si)a).getBlocSinon(),tds));
        buf.append("\tend_if:\n");
        return buf.toString();
    }
    
}