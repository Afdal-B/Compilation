package fr.ul.miage.us.generation;
// Une fonction qui permet de generer la lecture d'un entier en console. 
public class GenererLire {
    public static String generer_lire() throws Exception{
    StringBuffer buf = new StringBuffer(); // je créé un objet vide
    buf.append("\tRDINT()\n"+"\tPUSH(R0)\n"); // le "\t" représente la tabulation en début de ligne dans notre code asm
    return buf.toString(); 
    }
}
