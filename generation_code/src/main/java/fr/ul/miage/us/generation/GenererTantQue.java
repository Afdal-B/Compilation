package fr.ul.miage.us.generation;
import fr.ul.miage.arbre.Noeud;
import fr.ul.miage.arbre.TantQue;
import fr.ul.miage.us.Tds;
public class GenererTantQue {
    public static String generer_tantque(Noeud a,Tds tds) throws Exception{
        StringBuffer buf = new StringBuffer();
        buf.append("\tBR(condition_check)\n"
        + "\tloop:\n");
        buf.append(GenererBloc.generer_bloc(((TantQue)a).getBloc(),tds));
        buf.append("\tcondition_check:\n");
        buf.append(GenererCondition.generer_condition(((TantQue)a).getCondition(),tds));
        buf.append("\tBF(R1,loop_exit)\n"+"\tBR(loop)\n"
        + "\tloop_exit: \n");

        return buf.toString();

}
    
}