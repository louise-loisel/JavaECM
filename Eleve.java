package com.company;

	// -------------- ATTRIBUTS -------
    public class Eleve extends Personne {
    protected int promo, annee;
    protected String ine;

    // ------------ CONSTRUCTEUR

    public Eleve(String nom, String prenom, String numSecu, String ine, int promo, int annee, String adresse){
        super(nom, prenom, numSecu, adresse);
        this.ine = ine;
        this.promo=promo;
        this.annee=annee;
    }
    
}


