package fr.miage.ul;
public class item {
    public enum type{
        INT,VOID;
    }
    public enum cat{
        FONCTION,GLOBAL,PARAM,LOCAL;
    }
    private String nom;
    private type type;
    
}
