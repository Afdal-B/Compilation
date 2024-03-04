package fr.ul.miage.us;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import fr.ul.miage.us.Cat;
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
    // Une fonction qui retourne les items qui sont de categories GLOBAL
    public List<Item> getGlobalVariable()
    {
        List <Item> globalList = new ArrayList<>();
        // On parcours notre table et si la clé se termine avec "GLOBAL", l'item correspondant est alors une variable globale
        tds.forEach((cle,item)->{
            if(cle.endsWith("GLOBAL"))
            {
                globalList.add(item);
            }
        });
        return globalList;
    }

    // Une fonction qui retourne les items qui sont de categories LOCAL
    public List<Item> getLocalVariable()
    {
        List <Item> localList = new ArrayList<>();
        // On parcours notre table et si la clé se termine avec "LOCAL", l'item correspondant est alors une variable LOCAL
        tds.forEach((cle,item)->{
            if(cle.endsWith("LOCAL"))
            {
                localList.add(item);
            }
        });
        return localList;
    }

     // Une fonction qui retourne les items qui sont de categories FONCTION
     public List<Item> getFonction()
     {
         List <Item> fonctionList = new ArrayList<>();
         // On parcours notre table et si la clé se termine avec "FONCTION", l'item correspondant est alors une fonction
         tds.forEach((cle,item)->{
             if(cle.endsWith("FONCTION"))
             {
                 fonctionList.add(item);
             }
         });
         return fonctionList;
     }
     // Une fonction qui retourne le nombre de variables locales d'une fonction f donné
     public int nbVariablesLocales(Item fonction)
     {  
        // On prend la liste des variables locales 
        List<Item> l = new ArrayList<>();
        l = this.getLocalVariable();
        int counter = 0;
        for (Item localVariable : l)
        {   /* Si une variable locale est dans la portée de notre fonction, 
            alors on incrémente le nombre de variables locales de cette fonction*/
            if(localVariable.getScope()==fonction)
            {
                counter++;
            }

        }
        return counter;
     }

     // Une fonction qui indique si une variable est local ou non
     public boolean isLocal(String nomVariable)
     {
        return this.exist(nomVariable+"LOCAL");
     }
     // Une fonction qui indique si une variable est global ou non 
     public boolean isGlobal(String nomVariable )
     {
        return this.exist(nomVariable+"GLOBAL");
     }
     // Une fonction qui indique si une variable est global ou non 
     public boolean isParam(String nomVariable)
     {
        return this.exist(nomVariable+"PARAM");
     }
}