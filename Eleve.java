package projetjava;

public class Eleve extends Personne {
    int ine, promo, annee;

    public Eleve(String nom, String prenom, String numSecu, int ine, int promo, int annee, String adresse){
        super(nom, prenom, numSecu, adresse);
        this.ine = ine;
        this.promo=promo;
        this.annee=annee;
    }
    
}


