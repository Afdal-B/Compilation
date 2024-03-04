package fr.ul.miage.us.generation;

public class GenererRet {

    public static String generer_ret() throws Exception{
    StringBuffer buf = new StringBuffer(); // je créé un objet vide
    buf.append("\tPOP(BP)\n"+"\tPOP(LP)\n"+"\tRTN()\n"); // le "\t" représente la tabulation en début de ligne dans notre code asm
    return buf.toString();
    }
}
