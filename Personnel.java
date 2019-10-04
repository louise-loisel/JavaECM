package projetjava;

/*Créer la classe Personnel qui hérite de Personne ; Cette classe ne doit pas pouvoir avoir d’instance. 
Elle a une variable d’instance date_entrée et une variable d’instance temps de travail à 100 si c’est une personne 
qui travaille à plein temps…
Elle a une méthode abstraite calculSalaire ().
Deux sous-classes de Personnel :
Enseignant, IATOS( personnel non enseignant)
Un IATOS a un fixe et chaque mois un nombre d’heures supplémentaires avec un taux propre à chacun. 
Un enseignant a un fixe qui est fonction de son échelon : PRAG, MDC, PROF, une prime 
(la même pour tous les enseignants seul peut faire une différence le temps de travail) qui n’est donnée que si 
l’enseignant a fait son service : 192 heures pour un MDC (qui doit faire autant de recherche), 
le double pur un PRAG et la moitié pour un PROF . Un enseignant peut avoir une décharge d’heures (missions). 
Et un enseignant peut aussi avoir des heures supplémentaires. Le taux à appliquer est le même pour tous.
A vous de créer vos classes correctement avec les bons attributs et les bonnes méthodes , les bonnes variables d’instance.
*/


public abstract class Personnel extends Personne {
    protected String dateEntree;
    protected int tempsTravail, fixe, nbHeuresSupp;
    protected float taux;

    public Personnel(String nom, String prenom, String numSecu, String adresse, String dateEntree, int tempsTravail){
        super(nom,prenom,numSecu,adresse);
        this.dateEntree=dateEntree;
        this.tempsTravail=tempsTravail;
        this.nbHeuresSupp=0;
        this.fixe=0;
        this.taux=0;

    }

    abstract float calculSalaire();

    public void ajoutHeuresSupp(int h){
        this.nbHeuresSupp+=h;
    }

}
