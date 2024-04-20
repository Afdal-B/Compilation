package fr.ul.miage.us.generation;
import java.util.ArrayList;
import java.util.List;

import fr.ul.miage.us.Item;
import fr.ul.miage.us.Tds;
// Une fonction qui permet de generer les variables globales en utilisant la TDS 
public class GenererDeclaration {
    public static String generer_declaration(Tds tds) throws Exception
    {   StringBuffer buf = new StringBuffer();
        // je recupère les variables globales de ma TDS
        List <Item> variable_globales = new ArrayList<>();
        variable_globales = tds.getGlobalVariable();
        for (Item item : variable_globales)
        {
            buf.append(item.getNom()+":LONG("+item.getValeur()+")\n");
        }
        return buf.toString();

    }
}
