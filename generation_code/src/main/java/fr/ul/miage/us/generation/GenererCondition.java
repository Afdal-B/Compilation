package fr.ul.miage.us.generation;
import fr.ul.miage.arbre.Different;
import fr.ul.miage.arbre.Egal;
import fr.ul.miage.arbre.Inferieur;
import fr.ul.miage.arbre.InferieurEgal;
import fr.ul.miage.arbre.Noeud;
import fr.ul.miage.arbre.Superieur;
import fr.ul.miage.arbre.SuperieurEgal;
import fr.ul.miage.us.Tds;
public class GenererCondition {
    public static String generer_condition(Noeud c,Tds tds) throws Exception{
    StringBuffer buf = new StringBuffer(); // je créé un objet vide
    if(c instanceof Superieur)
    {
        Superieur c_casted = (Superieur)c;
        buf.append("\tLD("+ c_casted.getFilsGauche().getLabel().split("/")[1] +",R1)\n"
        +"\tPUSH(R1)\n");
        buf.append(GenererExpression.generer_expression(c_casted.getFilsDroit(),tds)+"\tPOP(R2)\n"+"\tPOP(R1)\n");

    }
    if(c instanceof Inferieur)
    {
        Inferieur c_casted = (Inferieur)c;
        buf.append("\tLD("+ c_casted.getFilsGauche().getLabel().split("/")[1] +",R1)\n"
        +"\tPUSH(R1)\n");
        buf.append(GenererExpression.generer_expression(c_casted.getFilsDroit(),tds)+"\tPOP(R2)\n"+"\tPOP(R1)\n");

    }
    if(c instanceof Egal)
    {
        Egal c_casted = (Egal)c;
        buf.append("\tLD("+ c_casted.getFilsGauche().getLabel().split("/")[1] +",R1)\n"
        +"\tPUSH(R1)\n");
        buf.append(GenererExpression.generer_expression(c_casted.getFilsDroit(),tds)+"\tPOP(R2)\n"+"\tPOP(R1)\n");

        
    }
    if(c instanceof Different)
    {
        Different c_casted = (Different)c; 
        buf.append("\tLD("+ c_casted.getFilsGauche().getLabel().split("/")[1] +",R1)\n"
        +"\tPUSH(R1)\n");
        buf.append(GenererExpression.generer_expression(c_casted.getFilsDroit(),tds)+"\tPOP(R2)\n"+"\tPOP(R1)\n");

    }
    if(c instanceof SuperieurEgal)
    {
        SuperieurEgal c_casted = (SuperieurEgal)c;
        buf.append("\tLD("+ c_casted.getFilsGauche().getLabel().split("/")[1] +",R1)\n"
        +"\tPUSH(R1)\n");
        buf.append(GenererExpression.generer_expression(c_casted.getFilsDroit(),tds)+"\tPOP(R2)\n"+"\tPOP(R1)\n");

    }
    if(c instanceof InferieurEgal)
    {
        InferieurEgal c_casted = (InferieurEgal)c;
        buf.append("\tLD("+ c_casted.getFilsGauche().getLabel().split("/")[1] +",R1)\n"
        +"\tPUSH(R1)\n");
        buf.append(GenererExpression.generer_expression(c_casted.getFilsDroit(),tds)+"\tPOP(R2)\n"+"\tPOP(R1)\n");
    }
   
    switch (c.getCat()) {
        case SUP:
                buf.append("\tCMPLT(R2,R1,R3)\n"
                                    +"\tPUSH(R3)\n");
                break;

        case INF:
                buf.append("\tCMPLT(R1,R2,R3)\n"
                                    +"\tPUSH(R3)\n");
                break;
        case EG:
                buf.append("\tCMPEQ(R1,R2,R3)\n"
                                    +"\tPUSH(R3)\n");
                break;
        case INFE:
                buf.append("\tCMPLE(R1,R2,R3)\n"
                                    +"\tPUSH(R3)\n");
                break;
        case SUPE:
                buf.append("\tCMPLT(R2,R1,R3)\n"
                                    +"\tPUSH(R3)\n"
                                    +"\tCMPEQ(R1, R2, R3)\n"
                                    +"\tPUSH(R3)\n"
                                    +"\tPOP(R2)\n"
                                    +"\tPOP(R1)\n"
                                    +"\tOR(R1,R2,R3)"
                                    +"\tPUSH(R3)\n");
                break;
        case DIF:
                buf.append("\tCMPLT(R1,R2,R3)\n"
                                    +"\tPUSH(R3)\n"
                                    +"\tCMPLT(R2,R1,R3)\n"
                                    +"\tPUSH(R3)");
                buf.append("\tPOP(R2)\n"
                                +"\tPOP(R1)\n"
                                 +"\tOR(R1,R2,R3)\n");
                break;
        default:
            break;
        }
    buf.append("\tPOP(R1)\n");
    return buf.toString();
    }
}
