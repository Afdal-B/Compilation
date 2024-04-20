package fr.ul.miage.rs;
import fr.ul.miage.arbre.Noeud;
import fr.ul.miage.arbre.Prog;
import fr.ul.miage.arbre.TxtAfficheur;
import fr.ul.miage.us.Tds;
import generated.fr.ul.miage.rs.langage.ParserCup;
import generated.fr.ul.miage.rs.langage.Yylex;
import java.io.FileReader;
import java.util.ArrayList;
import fr.ul.miage.us.Item;
import fr.ul.miage.arbre.Bloc;
import fr.ul.miage.us.generation.*;
import fr.ul.miage.us.Tds;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        if (args.length != 1) {
            System.err.println("Usage : parser <nom de fichier>");
            System.exit(1);
        }
        try {
            Yylex scanner = new Yylex(new FileReader(args[0]));
            ParserCup parser = new ParserCup(scanner);
            parser.parse();
            Prog prog =(Prog)((parser.res).get(1));
            Tds tds =(Tds)((parser.res).get(0));
            System.out.println(tds.toString());
            TxtAfficheur.afficher(prog);

            System.out.println(GenererProg.genererProg(prog,tds));
            //System.out.println(GenererAffectation.generer_affectation(prog.getFils().get(0).getFils().get(0),tds));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        System.out.println("Terminé !");
    }
}
