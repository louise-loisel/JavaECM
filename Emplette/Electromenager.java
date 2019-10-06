package com.company.Emplette;

public class Electromenager extends Article implements IPublicite, ISolde {
  
  //---- Constructeur
  public Electromenager(String nom, float prixAchat, float prixVente){
        super(nom, prixAchat, prixVente);
        this.pieceKilo="piece";
  }
  
  //---- Méthodes pub
  public void slogan(){
        System.out.println("Venez vous équipez pour la maison yes !");
  }

   //**** SOLDES
    @Override
  //Afficher le soldage
    public void tauxSoldes() {
        System.out.println("Le taux de soldes est de " + (tauxSoldes * 100) + "%.");
    }
  
  //Lancer les soldes
    @Override
    public void lancerSoldes(float taux) throws PasEntre0et100ExceptionA {
        if (!this.pieceKilo.equals("piece")) { //on ne solde que les produits vendus à l'unité
            System.out.println("Article non éligible à un soldage car il n'est pas vendu à l'unité."); 
        }
        else if (0.0<taux && taux<1.0) {                //on vérifie que le taux soit entre 0 et 1
            this.tauxSoldes = taux;                     //on attribue un nouveau soldage
            this.enSoldes = true;                       //les soldes sont en cours
            this.prixVente = (1 - taux) * prixVente;    //on attribue un nouveau prix aux articles
        }
        else {
            throw new PasEntre0et100ExceptionA();       //catch de l'exception
        }
    }
  
   //Stopper les soldes
    @Override   
    public void stopSoldes() {
        this.prixVente = this.tauxSoldes * prixVente + prixVente;     //on rétablit le prix
        this.enSoldes = false;                        //les soldes ne sont plus en cours
        this.tauxSoldes = 0;                          //le taux est à 0
    }
}
