package fr.ul.miage.us;
public class Item {
    private String nom;
    // Integer au lieu de int pour leur permettre d'être égal à null
    private Integer rang,nombre_de_bloc,nombre_de_parametre,valeur;
    private Item scope;
    private Type type;
    private Cat categorie;
    // Les constructeur de classe 
    public Item(String nom,Type type, Cat categorie, Integer rang, Item scope) {
        this.nom = nom;
        this.rang = rang;
        this.scope = scope;
        this.type = type;
        this.categorie = categorie;
    }
    public Item(String nom, Type type, Cat categorie, Integer nombre_de_parametre, Integer nombre_de_bloc) {
        this.nom = nom;
        this.nombre_de_bloc = nombre_de_bloc;
        this.nombre_de_parametre = nombre_de_parametre;
        this.type = type;
        this.categorie = categorie;
    }
    public Item(String nom, Type type, Cat categorie, Integer valeur) {
        this.nom = nom;
        this.valeur = valeur;
        this.type = type;
        this.categorie = categorie;
    }
    public Item(String nom, Type type, Cat categorie) {
        this.nom = nom;
        this.type = type;
        this.categorie = categorie;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public Integer getRang() {
        return rang;
    }
    public void setRang(Integer rang) {
        this.rang = rang;
    }
    public Integer getNombre_de_bloc() {
        return nombre_de_bloc;
    }
    public void setNombre_de_bloc(Integer nombre_de_bloc) {
        this.nombre_de_bloc = nombre_de_bloc;
    }
    public Integer getNombre_de_parametre() {
        return nombre_de_parametre;
    }
    public void setNombre_de_parametre(Integer nombre_de_parametre) {
        this.nombre_de_parametre = nombre_de_parametre;
    }
    public Integer getValeur() {
        // Si la valeur d'un item n'est pas donné, on pourra l'initialiser à 0
        if(valeur == null)
            return 0;
        return valeur;
    }
    public void setValeur(Integer valeur) {
        this.valeur = valeur;
    }
    public Cat getCategorie() {
        return categorie;
    }
    public void setCategorie(Cat categorie) {
        this.categorie = categorie;
    }
    public Type getType() {
        return type;
    }
    public void setType(Type type) {
        this.type = type;
    }
    public Item getScope() {
        return scope;
    }
    public void setScope(Item scope) {
        this.scope = scope;
    }
    @Override
    public String toString()
    {
        String result ="{ nom: "+nom+" type: "+type.name()+" cat: "+categorie.name();
        if(valeur != null)
            result+= " val: "+valeur;
        if(nombre_de_parametre != null)
            result += " nbparam: " + nombre_de_parametre;
        if(nombre_de_bloc != null)
            result += " nbloc: "+ nombre_de_bloc;
        if(rang != null)
            result += " rang: "+ rang;
        if(scope != null)
            result += " scope: "+ scope.getNom();
        return result +" }";
     }
     
}
