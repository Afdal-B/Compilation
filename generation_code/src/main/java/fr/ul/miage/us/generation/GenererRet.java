package fr.ul.miage.us.generation;
// Une fonction qui permet de libéré la pile .
public class GenererRet {

    public static String generer_ret() throws Exception{
    StringBuffer buf = new StringBuffer();
    buf.append("\tPOP(BP)\n"+"\tPOP(LP)\n"+"\tRTN()\n"); 
    return buf.toString();
    }
}
