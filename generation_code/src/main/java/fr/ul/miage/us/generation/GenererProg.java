package fr.ul.miage.us.generation;
import fr.ul.miage.arbre.Noeud;
import fr.ul.miage.us.Tds;
// Une fonction qui permet de generer un programme complet , Cette fonction appelera implicitement toutes le autres fonctions
public class GenererProg {
    public static String genererProg(Noeud a, Tds tds) throws Exception
    {
        StringBuffer buf = new StringBuffer();
        buf.append(".include beta.uasm\n" + //
                ".include intio.uasm\n" + //
                ".options tty\n" + //
                "\n" + //
                "CMOVE(pile,SP)\n" + //
                "BR(debut)\n");

        buf.append(GenererDeclaration.generer_declaration(tds));
        buf.append("debut:\n\tCALL(main)\n\tHALT()\n");
        for (Noeud f:(a.getFils()))
        {
            buf.append(GenererFonction.generer_fonction(f, tds));
        }


        buf.append("\npile:\n");
        return buf.toString();
    }
}
