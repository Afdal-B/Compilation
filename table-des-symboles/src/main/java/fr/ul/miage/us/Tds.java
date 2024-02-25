package fr.ul.miage.us;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
public class Tds {
    private HashMap<String,Item> tds;
    //Notre constructeur initialise une tds vide
    public Tds() {
        tds = new HashMap<>();
    }
    // Une méthode pour ajouter des items à notre tds
    public void addItem(Item item)
    {   
        // La cle de notre item dans la tds : une concaténation du nom 
        // et de la catégorie de l'item
        String cle ;
        cle = item.getNom() + item.getCategorie().name();
        tds.put(cle,item);
    }

    // une methode pour ajouter une liste d'items 
    public void addItemList(List<Item> itemList)
    {
        for (Item item : itemList)
        {
            this.addItem(item);
        }
    }

    // Une méthode pour recuperer des items
    public Item getItem(String cle)
    {
        return tds.get(cle);
    }
    // Une methode pour verifier si un item existe dans notre tds
    public boolean exist(String cle)
    {
        return tds.containsKey(cle);
    } 
    // Une methode pour supprimer un item de notre tds 
    public void deleteItem(String cle)
    {
        tds.remove(cle);
    }

    // Une methode pour afficher une tds
    @Override
    public String toString()
    {   
        StringBuilder result = new StringBuilder();
        tds.forEach((cle,item)->{
            result.append(item.toString()).append("\n");
        });
        // Convertir le StringBuilder en String avant de le retourner
        return result.toString();
    }






}