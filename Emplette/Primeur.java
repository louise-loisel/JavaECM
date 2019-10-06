package com.company.Emplette;

public class Primeur extends Article implements IPublicite, ISolde  {

    //----- Constructeur
    public Primeur(String nom, float prixAchat, float prixVente){
       super(nom, prixAchat, prixVente);
       this.pieceKilo="kilo";
        }
    
    //----- Méthodes PUB
    
    public void slogan(){
      System.out.println("Venez vous nourrir yes !");
  }

    //**** SOLDES

    public void tauxSoldes() {
        System.out.println("Le taux de soldes est de " + (tauxSoldes * 100) + "%.");
    }

    public void lancerSoldes(float taux) throws PasEntre0et100ExceptionA {
        if (!this.pieceKilo.equals("piece")) {                      //on ne solde que les produits vendus à l'unité
            System.out.println("Article non éligible à un soldage car il n'est pas vendu à l'unité.");
        } else if (0.0<taux && taux<1.0) {                          //on vérifie que le taux soit entre 0 et 1
            this.tauxSoldes = taux;                                 //on attribue un nouveau soldage
            this.enSoldes = true;                                   //les soldes sont en cours
            this.prixVente = (1 - taux) * prixVente;                //on attribue un nouveau prix aux articles
        } else {
            throw new PasEntre0et100ExceptionA();                   //catch de l'exception
        }
    }

    public void stopSoldes() { 
        this.prixVente = prixVente/(1-taux);                        //on rétablit le prix
        this.enSoldes = false;                                     //les soldes ne sont plus en cours                          
        this.tauxSoldes = 0;                                       //le taux est à 0
    }
}
