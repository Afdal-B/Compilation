package fr.ul.miage.us;

public class Main {

    public static String generer_expression(Noeud a) throws Exception{
		StringBuffer buf = new StringBuffer();
		switch (a.getCat()) {
		case CONST:
			buf.append("\tCMOVE(" + a.getLabel() +",R0)\n"
					+ "\tPUSH(R0)\n");
			break;
		case IDF:
			buf.append("\tLD(" + a.getLabel() +",R0)\n"
					+ "\tPUSH(R0)\n");
			break;
		case PLUS:
			buf.append(generer_expression(((Plus)a).getFilsGauche()));
			buf.append(generer_expression(((Plus)a).getFilsDroit()));
			buf.append("\tPOP(R2)\n"
					+ "\tPOP(R1)\n"
					+ "\tADD(R1,R2,R3)\n"
					+ "\tPUSH(R3)\n");
			break;
		case MOINS:
			buf.append(generer_expression(((Moins)a).getFilsGauche()));
			buf.append(generer_expression(((Moins)a).getFilsDroit()));
			buf.append("\tPOP(R2)\n"
					+ "\tPOP(R1)\n"
					+ "\tSUB(R1,R2,R3)\n"
					+ "\tPUSH(R3)\n");
			break;
		case MUL:
			buf.append(generer_expression(((Multiplication)a).getFilsGauche()));
			buf.append(generer_expression(((Multiplication)a).getFilsDroit()));
			buf.append("\tPOP(R2)\n"
					+ "\tPOP(R1)\n"
					+ "\tMUL(R1,R2,R3)\n"
					+ "\tPUSH(R3)\n");
			break;
		case DIV:
			buf.append(generer_expression(((Division)a).getFilsGauche()));
			buf.append(generer_expression(((Division)a).getFilsDroit()));
			buf.append("\tPOP(R2)\n"
					+ "\tPOP(R1)\n"
					+ "\tDIV(R1,R2,R3)\n"
					+ "\tPUSH(R3)\n");
			break;
		default:
			throw new Exception("Erreur de génération : expression");
		}
		return buf.toString();
	}

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}