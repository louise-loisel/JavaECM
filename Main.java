package projetjava;


import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
    
        // ----- Création d'articles ----

        Electromenager frigo = new Electromenager ("réfrigérateur", 200, (float) 400); //prix à la pièce
        Electromenager four = new Electromenager ("four", 170, (float) 259.9);
        Electromenager blender = new Electromenager ("blender", 50, (float) 103.5);

        Habit pantalon = new Habit("pantalon", 7, (float) 20.0) ;  // prix à la pièce
        Habit robe = new Habit("robe", 10, (float) 49.0) ;
        Habit écharpe = new Habit("écharpe", 5, (float) 10.0) ;

        Primeur banane = new Primeur("banane", (float)1, (float)2); // prix au kilo
        Primeur peche = new Primeur("peche", (float)1.52, (float)3.90); //

        // ----- Création de magasin et de sa sélection d'articles
        
        ArrayList<Article> articlesLidl = new ArrayList<Article>();
        articlesLidl.add(frigo);
        articlesLidl.add(blender);
        articlesLidl.add(pantalon);
        articlesLidl.add(robe);
        articlesLidl.add(banane);
        articlesLidl.add(peche);

        Magasin lidl = new Magasin ("lidl", "marseille canebière",7,(float)3059.63, articlesLidl);

        // le four et l'écharpe ne sont pas dans la sélection de ce magasin, on peut s'en assurer avec le booléen enVente
        System.out.println("Lorsqu'on cherche si des fours sont vendus à Lidl, le booléen enVente retourne : " + lidl.enVente(four));
        System.out.println("Lorsqu'on cherche un article de la sélection, comme des pêches, il retourne : " + lidl.enVente(peche));

        // ---- Tests sur les méthodes d'achat
        
        // Les articles de la sélection n'ont pas encore été achetés pas le magasin
       
        System.out.println(lidl.articleMagasin(frigo).enStock);// le booléen enStock retourne "false" puisque le magasin ne dispose pas encore de frigo
        lidl.achat(frigo,5);
        System.out.println(lidl.articleMagasin(frigo).getQteStock()); // on peut vérifier que le stock de frigo a bien changé
        System.out.println(lidl.articleMagasin(frigo).enStock); // ainsi que le booléen qui indique s'il est effectivement bien en stock
        
        lidl.achat(frigo,(float)5.5); // retourne un message d'erreur : on ne peut pas acheter une quantité de pièces non entière
        
        lidl.achat(banane,(float)6.0);
        
        System.out.println("2053.63 = ? " + lidl.getCaisse()); // après achats, on peut vérifier que la valeur de la caisse a bien diminué comme attendu

        // On ne pas pas faire des achats excédant la valeur de la caisse
        lidl.achat(frigo,1000); // message d'erreur
        
        //Ni des achats d'articles qui ne sont pas dans la sélection initiale (telle qu'entrée dans le constructeur du magasin)
        lidl.achat(four,2); // message d'erreur

        // ----- Tests sur les méthodes de vente

        lidl.vendre(four, 2);// on ne peut pas vendre des fours qui ne sont pas dans la sélection
        lidl.vendre(pantalon, 2); // rupture de stocks de pantalons
        lidl.vendre(banane,7); // la quantité de bananes à vendre excède le stock existant
        lidl.vendre(frigo,(float)3.5); // message erreur : on ne peut pas vendre un nombre non entier d'article type "piece"

        lidl.vendre(frigo,5);
        
        // Vérification de la bonne incrémentation de la caisse
        System.out.println("4053.63 = ? " + lidl.getCaisse());
        // de la mise à jour des quantités de stocks (il ne devrait plus rester de frigos en magasin)
        System.out.println("0 = ? " + lidl.articleMagasin(frigo).getQteStock());
        // de la mise à jour du booléen correspondant
        System.out.println("false = ? " + lidl.articleMagasin(frigo).enStock);

        // idem pour une vente de banane après laquelle il doit en rester en stock
        lidl.vendre(banane,4);
        System.out.println("4061.63 = ? " + lidl.getCaisse());
        System.out.println("2 = ? " + lidl.articleMagasin(banane).getQteStock());
        System.out.println("true = ? " + lidl.articleMagasin(banane).enStock);

        // ----- Tests sur les méthodes de remboursement

        // on souhaite retourner un four (pas dans la sélection) en bon état
        lidl.retourArticle(four,true);

        // on souhaite retourner un frigo en bon état
        lidl.retourArticle(frigo,true);
        // le remboursement est effectué, on vérifie que la caisse est décrémentée de la valeur de vente de l'article
        System.out.println("3661.63 = ? " + lidl.getCaisse());
        // le frigo est en bon état, on peut donc le remettre en vente dans le magasin, son stock augmente de 1
        System.out.println("1 = ? " + lidl.articleMagasin(frigo).getQteStock());
        //le booléen enStock change également
        System.out.println("true = ? " + lidl.articleMagasin(frigo).enStock);
        
        // on souhaite se faire rembourser des bananes pourries et qui ne seront donc pas remises en vente
        lidl.retourArticle(banane,false);
        // vérification de la bonne prise en compte de la caisse
        System.out.println("3259.63 = ? " + lidl.getCaisse());
        // les stocks de banane restent inchangés
        System.out.println("2 = ? " + lidl.articleMagasin(banane).getQteStock());


}




