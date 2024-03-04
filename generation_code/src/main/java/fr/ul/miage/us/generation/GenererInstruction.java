package fr.ul.miage.us.generation;

import fr.ul.miage.arbre.Noeud;
import fr.ul.miage.us.Tds;

public class GenererInstruction {
    public static String generer_instruction(Noeud a,Tds tds) throws Exception
    {
        StringBuffer buf = new StringBuffer();
        switch (a.getCat()) {
            case AFF:
                buf.append(GenererAffectation.generer_affectation(a,tds));
                break;
            case SI:
                buf.append(GenererSi.generer_si(a,tds));
                break;
            case TQ:
                buf.append(GenererTantQue.generer_tantque(a,tds));
                break;
            case ECR:
                buf.append(GenererEcrire.generer_ecrire(a,tds));
                break;
            case RET:
                buf.append(GenererRetour.generer_retour(a,tds));
                break;
            case LIRE:
                buf.append(GenererLire.generer_lire());
                break;
            case APPEL:
                buf.append(GenererAppel.generer_appel(a,tds));
                break;
            default:
                throw new Exception("Erreur: Generer instruction ");
        }

        return buf.toString();
    }
}
