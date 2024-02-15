package fr.miage.ul;
public class item {
    private String nom;
    private int rang,n_bloc,nb_param;
    private float val;
    private String scope;
    private enum cat{
        FONCTION,GLOBAL,PARAM,LOCAL;
    }

    // Les constructeur de classe 
    public item(String nom, type type , cat cat)
    {
        this.nom = nom;
        
    }

    public String getNom()
    {
        return nom;
    }

    public int getRang()
    {
        return rang;

    }
    public int getNbloc()
    {
        return n_bloc;
    }
    public float getVal()
    {
        return val;
    }
    public String getScope()
    {
        return scope;
    }
    public type getType()
    {
    }
}
