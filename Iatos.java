package projetjava;

public class Iatos extends Personnel{
    // pas de variables déclarées ici?
    public iatos(String nom, String prenom, String numSecu, String adresse, String date_entree, int tempsTravail, float nbHeuresSupp, float taux){
        super(nom,prenom,numSecu,adresse,date_entree,tempsTravail);
        // est ce que super appelle le constructeur de Personnel qui met des valeurs par défaut à nbHeuresSupp, fixe et taux?
        // ou est ce que super appelle les variables d'instance? dans ce cas nbHeuresSupp, fixe et taux ne sont pas initialisées par super
        this.taux=taux;
        this.fixe=1200;//ne l'ai pas appelé dans le super
        this.nbHeuresSupp=nbHeuresSupp;
        //nbHeuresSupp doit nécessairement être initialisé ici parce que le seul moyen de le calculer c'est dans Enseignant

    }

    public int calculSalaire(){
        return(this.fixe*(this.tempsTravail/100)+this.nbHeuresSupp*this.taux);
    }
    //ai modifié : avant on faisait fixe*(tempsTravail/100) + nbHeuresSupp*taux
    //mais je pense pas que 1200 soit un salaire horaire, donc pourquoi diviser par 100?
    // Surtout que pour l'instant, sa valeur par défaut dans le constructeur de Personnel c'est 0.

}