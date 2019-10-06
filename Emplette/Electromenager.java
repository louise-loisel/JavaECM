package com.company.Emplette;

public class Electromenager extends Article implements IPublicite, ISolde {
  
  //constructeur
  public Electromenager(String nom, float prixAchat, float prixVente){
    super(nom, prixAchat, prixVente);
    this.pieceKilo="piece";
  }
  
  //slogan
  public void slogan(){
    System.out.println("Venez vous équipez pour la maison yes !");
  }

    //**** SOLDES
    @Override
    public void tauxSoldes() {
        System.out.println("Le taux de soldes est de " + (tauxSoldes * 100) + "%.");
    }
    @Override
    public void lancerSoldes(float taux) throws PasEntre0et100ExceptionA {
        if (!this.pieceKilo.equals("piece")) {
            System.out.println("Article non éligible à un soldage car il n'est pas vendu à l'unité.");
        }
        else if (0.0<taux && taux<1.0) {
            this.tauxSoldes = taux;
            this.enSoldes = true;
            this.prixVente = (1 - taux) * prixVente;
        }
        else {
            throw new PasEntre0et100ExceptionA();
        }
    }
    @Override
    public void stopSoldes() {
        this.enSoldes = false;
        this.tauxSoldes = 0;
    }
}
