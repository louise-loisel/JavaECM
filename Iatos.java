package com.company;

public class Iatos extends Personnel{
/***************CONSTRUCTEUR***********/
    public Iatos(String nom, String prenom, String numSecu, String adresse, String date_entree, int tempsTravail, float taux){
        super(nom,prenom,numSecu,adresse,date_entree,tempsTravail);
        this.taux=taux;
        this.fixe=1200;
    }
/***************METHODE***********/
    public float calculSalaire() //au mois
    {
        float nbHeuresSupp=0;
        if ((this.tempsTravail*0.01)*152 < nbHeuresTot){  //152 est le nombre d'h sur un mois pour un 35h
            nbHeuresSupp= nbHeuresTot - (this.tempsTravail*0.01)*152;
        }
        return(this.fixe*(this.tempsTravail*0.01)+nbHeuresSupp*this.taux);
    }

/***************GETTER ET SETTER***********/
    public float getTaux(){ return this.taux;}
    public float getFixe(){ return this.fixe;}
    
    public void setTaux(float taux) {
        this.taux = taux;
    }
    public void setFixe(float fixe) {
        this.fixe = fixe;
    }
    
}
