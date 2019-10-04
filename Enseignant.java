package projetjava;

public class Enseignant extends Personnel{
    // pourquoi tout protected? on les réutilise dans une autre sous-classe?
    protected float nbHeuresTot;
    protected String typeProf;
    protected float hMinPrime; // qu'est- ce?

    // j'ai rajouté quelques variables d'instance pour prendre en compte la consigne
    // "un enseignant peut aussi avoir une décharge d'heures (missions)"
    // elles interviennent dans le constructeur (possibilité de faire deux constructeurs, dont un un peu moins exhaustif)
    protected boolean decharge;
    protected float hdecharge;

    //constructeur sans décharge
    public Enseignant(String nom, String prenom, String numSecu, String adresse, String date_entree, float tempsTravail, String typeProf) {
        super(nom, prenom, numSecu, adresse, date_entree, tempsTravail);
        //initialise aussi nbHeuresSupp à 0? jpense qu'il faut aussi l'appeler dans le super
        this.typeProf = typeProf;
        if (this.typeProf == "PRAG") {
            this.fixe = 1400; // arbitrairement fixé? si oui, très malin
            this.hMinPrime = 192 * 2;
        } else if (this.typeProf == "MDC") { // comment on intègre le "qui doit faire autant de recherche"  de l'énoncé?
            this.fixe = 2000;
            this.hMinPrime = 192;
        } else if (this.typeProf == "PROF") {
            this.fixe = 1300;
            this.hMinPrime = 192 / 2;
        } else {
            this.fixe = 0;
            System.out.println("type de prof non connu");
        }
        this.taux = (float) 1.4;// ??? surtout qu'il est déjà initialisé dans personnel (pas très grave parce qu'on l'a appelé dans le super)
        this.nbHeuresTot = 0;// est ce que ça serait pas 100h ? le par défaut d'un salarié? mais du coup c'est plus grand que le hMinPrime d'un prof
        this.decharge=false;
        this.hdecharge=0;
    }

    //constructeur avec heures de décharge
    public Enseignant(String nom, String prenom, String numSecu, String adresse, String date_entree, float tempsTravail, String typeProf,boolean decharge, float decharge) {
        super(nom, prenom, numSecu, adresse, date_entree, tempsTravail);
        //initialise aussi nbHeuresSupp à 0? jpense qu'il faut aussi l'appeler dans le super
        this.typeProf = typeProf;
        if (this.typeProf == "PRAG") {
            this.fixe = 1400; // arbitrairement fixé? si oui, très malin
            this.hMinPrime = 192 * 2;
        } else if (this.typeProf == "MDC") { // comment on intègre le "qui doit faire autant de recherche"  de l'énoncé?
            this.fixe = 2000;
            this.hMinPrime = 192;
        } else if (this.typeProf == "PROF") {
            this.fixe = 1300;
            this.hMinPrime = 192 / 2;
        } else {
            this.fixe = 0;
            System.out.println("type de prof non connu");
        }
        this.taux = (float) 1.4;// ??? surtout qu'il est déjà initialisé dans personnel (pas très grave parce qu'on l'a appelé dans le super)
        this.nbHeuresTot = 0;// est ce que ça serait pas 100h ? le par défaut d'un salarié? mais du coup c'est plus grand que le hMinPrime d'un prof
        this.decharge=decharge;
        this.hdecharge=hdecharge;
    }

    // modifié avec la décharge d'heures --> à vérifier
    public void ajoutHeures(float h) {
    	this.nbHeuresTot+=h;// méthode d'incrémentation, j'espère qu'elle marche
    	if (this.decharge=false && this.nbHeuresTot>this.hMinPrime) {
    		float heuresSupp;// déclaration de nouvelle variable intermédiaire?
    		heuresSupp=this.nbHeuresTot-this.hMinPrime;
    		this.nbHeuresTot=this.hMinPrime;
    		this.nbHeuresSupp=heuresSupp;
    	}
    	else if(this.decharge=true && this.nbHeuresTot-this.hdecharge>this.hMinPrime){
            float heuresSupp;// déclaration de nouvelle variable intermédiaire?
            heuresSupp=this.nbHeuresTot-this.hdecharge-this.hMinPrime;
            this.nbHeuresTot=this.hMinPrime;
            this.nbHeuresSupp=heuresSupp;
        }
    }
    


    public float calculSalaire(){
    	float prime =0;
    	if (nbHeuresTot>=hMinPrime)
    		prime=500;//arbitraire?
    	return(this.fixe+(this.nbHeuresSupp*this.taux)+prime);
    	//il faut avoir fait tourné ajoutHeures avant pour que nbHeuresSupp ait une valeur?
    }



}