package fr.ul.miage.us.generation;
//Une fonction qui permet de préparer la pile avant utilisation.
public class PreparerPile {
    public static String preparer_pile() throws Exception{
    StringBuffer buf = new StringBuffer(); // je créé un objet vide
    buf.append("\tPUSH(LP)\n"+"\tPUSH(BP)\n"+"\tMOVE(SP,BP)\n"); // le "\t" représente la tabulation en début de ligne dans notre code asm
    return buf.toString();
    }
}
