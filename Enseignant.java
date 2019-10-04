package projetjava;
/*Un enseignant a un fixe qui est fonction de son échelon : PRAG, MDC, PROF, une prime 
(la même pour tous les enseignants seul peut faire une différence le temps de travail) 
qui n’est donnée que si l’enseignant a fait son service : 192 heures pour un MDC (qui doit faire autant de recherche),
le double pur un PRAG et la moitié pour un PROF . Un enseignant peut avoir une décharge d’heures (missions). 
Et un enseignant peut aussi avoir des heures supplémentaires. Le taux à appliquer est le même pour tous.
A vous de créer vos classes correctement avec les bons attributs et les bonnes méthodes , les bonnes variables d’instance.
*/
public class Enseignant extends Personnel{
    private float nbHeuresTot;
    private String typeProf;
    private float hMinPrime; // qu'est- ce?

    // j'ai rajouté quelques variables d'instance pour prendre en compte la consigne
    // "un enseignant peut aussi avoir une décharge d'heures (missions)"
    // elles interviennent dans le constructeur (possibilité de faire deux constructeurs, dont un un peu moins exhaustif)
    protected boolean decharge;
    protected float hdecharge;
    
    //variables de classes, salaires et prime fixes
    static float fixePRAG=2000;
    static float fixeMDC=2500;
    static float fixePROF=1500;
    static float prime=500;

    //constructeur sans décharge
    public Enseignant(String nom, String prenom, String numSecu, String adresse, String date_entree, float tempsTravail, String typeProf) {
        super(nom, prenom, numSecu, adresse, date_entree, tempsTravail);
        //initialise aussi nbHeuresSupp à 0? jpense qu'il faut aussi l'appeler dans le super
        this.typeProf = typeProf;
        if (this.typeProf == "PRAG") {
            this.fixe = fixePRAG; // arbitrairement fixé? si oui, très malin
            this.hMinPrime = 192 * 2;
        } else if (this.typeProf == "MDC") { // comment on intègre le "qui doit faire autant de recherche"  de l'énoncé?
            this.fixe = fixeMDC;
            this.hMinPrime = 192;
        } else if (this.typeProf == "PROF") {
            this.fixe = fixePROF;
            this.hMinPrime = 192 / 2;
        } else {
            this.fixe = 0;
            System.out.println("type de prof non connu");
        }
        this.taux = (float) 12.5;//le taux à appliquer est le même pour tous
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
            this.fixe = fixePRAG // arbitrairement fixé? si oui, très malin
            this.hMinPrime = 192 * 2;
        } else if (this.typeProf == "MDC") { // comment on intègre le "qui doit faire autant de recherche"  de l'énoncé?
            this.fixe = fixeMDC;
            this.hMinPrime = 192;
        } else if (this.typeProf == "PROF") {
            this.fixe = fixePROF;
            this.hMinPrime = 192 / 2;
        } else {
            this.fixe = 0;
            System.out.println("type de prof non connu");
        }
        this.taux = (float) 12.5;// ??? surtout qu'il est déjà initialisé dans personnel (pas très grave parce qu'on l'a appelé dans le super)
        this.nbHeuresTot = 0;// est ce que ça serait pas 100h ? le par défaut d'un salarié? mais du coup c'est plus grand que le hMinPrime d'un prof
        this.decharge=decharge;
        this.hdecharge=hdecharge;
    }

 
    // modifié avec la décharge d'heures --> à vérifier
    public void ajoutHeures(float h) {
    	this.nbHeuresTot+=h;// méthode d'incrémentation, j'espère qu'elle marche
    	/*
        if (this.decharge=false && this.nbHeuresTot>this.hMinPrime) {
    		float heuresSupp;// déclaration de nouvelle variable intermédiaire?
    		heuresSupp=this.nbHeuresTot-this.hMinPrime;
    		this.nbHeuresTot=this.hMinPrime;
    		this.nbHeuresSupp+=heuresSupp;
    	}
    	else if(this.decharge=true && this.nbHeuresTot-this.hdecharge>this.hMinPrime){
            float heuresSupp;// déclaration de nouvelle variable intermédiaire?
            heuresSupp=this.nbHeuresTot-this.hdecharge-this.hMinPrime;
            this.nbHeuresTot=this.hMinPrime;
            this.nbHeuresSupp+=heuresSupp;
        }
        */
    }

    public float calculSalaire(){
    	float salaire=this.fixe+(this.nbHeuresSupp*this.taux);
    	if (nbHeuresTot>=hMinPrime || (decharge=true && (nbHeuresTot-decharge>=hMinPrime))
            {salaire+=prime;//arbitraire}
    	return(salaire);
    }
    
            //SETS
    public static void setPrime(float nvlePrime) {
        prime = nvlePrime;
    }

    public static void setFixeMDC(float nvFixeMDC) {
        fixeMDC = nvFixeMDC;
    }
    public static void setFixePRAG(float nvfixePRAG) {
        fixePRAG = nvfixePRAG;
    }
    public static void setFixePROF(float nvfixePROF) {
        fixePROF = nvfixePROF;
    }


}
