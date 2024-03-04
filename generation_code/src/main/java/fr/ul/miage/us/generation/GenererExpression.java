package fr.ul.miage.us.generation;
import fr.ul.miage.arbre.Division;
import fr.ul.miage.arbre.Moins;
import fr.ul.miage.arbre.Multiplication;
import fr.ul.miage.arbre.Noeud;
import fr.ul.miage.arbre.Plus;
import fr.ul.miage.us.Tds;
public class GenererExpression {
    public static String generer_expression(Noeud a, Tds tds) throws Exception{
		StringBuffer buf = new StringBuffer();
		switch (a.getCat()) {
		case CONST:
			buf.append("\tCMOVE(" +a.getLabel().split("/")[1] +",R0)\n"
					+ "\tPUSH(R0)\n");
			break;
		case IDF:
			String label=a.getLabel().split("/")[1];
			if(tds.isGlobal(label))
				{buf.append("\tLD(" + label +",R0)\n"
					+ "\tPUSH(R0)\n");}
			else if(tds.isLocal(label))
				{	
					int offset = 4 * tds.getItem(label+"LOCAL").getRang();
					buf.append("\tGETFRAME("+offset+",R0)\n"+"\tPUSH(R0)\n");
				}
			else if(tds.isParam(label))
				{	// le nombre de parametre de la fonction 
					int n = tds.getItem(label+"PARAM").getScope().getNombre_de_parametre();
					// le rang du paramètre
					int r = tds.getItem(label+"PARAM").getRang();
					int offset = 4 *(-2-n+r);
					buf.append("\tGETFRAME("+offset+",R0)\n"+"\tPUSH(R0)\n");
				}
			break;
		case PLUS:
			buf.append(generer_expression(((Plus)a).getFilsGauche(),tds));
			buf.append(generer_expression(((Plus)a).getFilsDroit(),tds));
			buf.append("\tPOP(R2)\n"
					+ "\tPOP(R1)\n"
					+ "\tADD(R1,R2,R3)\n"
					+ "\tPUSH(R3)\n");
			break;
		case MOINS:
			buf.append(generer_expression(((Moins)a).getFilsGauche(),tds));
			buf.append(generer_expression(((Moins)a).getFilsDroit(),tds));
			buf.append("\tPOP(R2)\n"
					+ "\tPOP(R1)\n"
					+ "\tSUB(R1,R2,R3)\n"
					+ "\tPUSH(R3)\n");
			break;
		case MUL:
			buf.append(generer_expression(((Multiplication)a).getFilsGauche(),tds));
			buf.append(generer_expression(((Multiplication)a).getFilsDroit(),tds));
			buf.append("\tPOP(R2)\n"
					+ "\tPOP(R1)\n"
					+ "\tMUL(R1,R2,R3)\n"
					+ "\tPUSH(R3)\n");
			break;
		case DIV:
			buf.append(generer_expression(((Division)a).getFilsGauche(),tds));
			buf.append(generer_expression(((Division)a).getFilsDroit(),tds));
			buf.append("\tPOP(R2)\n"
					+ "\tPOP(R1)\n"
					+ "\tDIV(R1,R2,R3)\n"
					+ "\tPUSH(R3)\n");
			break;
		case LIRE:
			buf.append(GenererLire.generer_lire());
			break;
		case APPEL:
			buf.append(GenererAppel.generer_appel(a, tds));
			break;
		default:
			throw new Exception("Erreur de génération : expression");
		}
		return buf.toString();
	}
}