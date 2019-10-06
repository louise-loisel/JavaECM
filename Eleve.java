package projetjava;
//Créer la classe Eleve qui hérite de la classe Personne qui a en plus les attributs : ine, promo, annee,

public class Eleve extends Personne {
    protected int promo, annee;
    protected String ine;

    public Eleve(String nom, String prenom, String numSecu, String ine, int promo, int annee, String adresse){
        super(nom, prenom, numSecu, adresse);
        this.ine = ine;
        this.promo=promo;
        this.annee=annee;
    }
    
}


