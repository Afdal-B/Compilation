package fr.ul.miage.us.generation;
import fr.ul.miage.arbre.Affectation;
import fr.ul.miage.arbre.Noeud;
import fr.ul.miage.us.Tds;

public class GenererAffectation {
    public static String generer_affectation(Noeud a,Tds tds) throws Exception
    {
        StringBuffer buf = new StringBuffer();
        buf.append(GenererExpression.generer_expression(((Affectation)a).getFilsDroit(),tds));
        Noeud idf = ((Affectation)a).getFilsGauche();
        if(tds.isGlobal(idf.getLabel().split("/")[1]))
        {
            buf.append("\tPOP(R0)\n"+"\tST(R0,"+(((Affectation)a).getFilsGauche()).getLabel().split("/")[1]+")\n");
        }
        else if(tds.isLocal(idf.getLabel().split("/")[1]))
				{	
					int offset = 4 * tds.getItem(idf.getLabel().split("/")[1]+"LOCAL").getRang();
					buf.append("\tPOP(R0)\n"+"\tPUTFRAME(R0,"+offset+")\n");
				}
        return buf.toString();
    }
}
