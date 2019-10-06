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
        if (!this.pieceKilo.equals("piece")) {
            System.out.println("Article non éligible à un soldage car il n'est pas vendu à l'unité.");
        } else if (0.0<taux && taux<1.0) {
            this.tauxSoldes = taux;
            this.enSoldes = true;
            this.prixVente = (1 - taux) * prixVente;
        } else {
            throw new PasEntre0et100ExceptionA();
        }
    }

    public void stopSoldes() {
        this.enSoldes = false;
        this.tauxSoldes = 0;
    }
}
