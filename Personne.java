package projetjava;
/*On veut modéliser des Personnes composées des attributs suivants :
private String Nom;
private String Prenom;
private String NumSecu;
private int anneeNaissance;
private char sexe;
private int deptNaissance;

1)	Créer la classe Personne, 
2)	Ecrire ensuite un constructeur permettant de ne saisir que le nom et le prénom et initialisant les autres attributs de manière cohérente (valeurs »neutres »)
3)	Générer la méthode toString , plus la modifier afin qu’elle n’affiche que les champs vraiment renseignés.
4)	Ecrire ensuite un constructeur permettant de  ne saisir que le nom , le prénom ,  le numéro de sécurité sociale et l’adresse.
5)	Ecrire une méthode « anneeNaissance » à usage restreint ( juste dans la classe) permettant de calculer  l’année de naissance en connaissant le numéro de sécurité sociale.
6)	Ecrire une méthode « sexe» à usage restreint ( juste dans la classe) permettant de calculer  le sexe  en connaissant le numéro de sécurité sociale.
7)	Ecrire une méthode « deptNaissance » à usage restreint ( juste dans la classe) permettant de calculer  le département de naissance en connaissant le numéro de sécurité sociale.
8)	Compléter le deuxième constructeur en initialisant les attributs pouvant être déduits du numéro de sécurité sociale.
9)	Ecrire les setters et les getters sachant que certains n’ont pas lieu d’être. Compléter le setter du numéro de sécurité sociale afin qu’il permette aussi de mettre à jour les attributs qui peuvent en être déduits.
10)	Ecrire une méthode calculAge.
*/

public class Personne { //protected car les sous classes pourront y avoir accès, question1
	protected String nom;
	protected String prenom;
	protected String numSecu;
	protected int anneeNaissance;
	protected char sexe;
	protected int deptNaissance;
	protected String adresse;
	
	public Personne(String nom, String prenom) { //question2
		this.nom = nom;
		this.prenom = prenom;
		this.numSecu="0";
		this.anneeNaissance=0;
		this.sexe='N';
		this.deptNaissance=0;
	}
	public Personne(String nom, String prenom, String numSecu, String adresse) { //question4,8
		this.nom = nom;
		this.prenom = prenom;
		this.numSecu=numSecu;
		this.anneeNaissance=anneeNaissance(numSecu);
		this.sexe=sexe(numSecu);
		this.adresse=adresse;
		this.deptNaissance=deptNaissance(numSecu);
	}
	public void toString(Personne p) { //question3
		System.out.print("Le nom est "+p.nom+". Le prénom est "+p.prenom+".");
		if (p.sexe!='N')
			System.out.print(" Le sexe est "+p.sexe+".");
		if (p.numSecu!="0")
			System.out.print(" Le numéro de sécurité sociale est "+p.numSecu+".");
		if (p.anneeNaissance!=0)
			System.out.print(" L'année de naissance est "+p.anneeNaissance+".");
		if (p.deptNaissance!=0)
			System.out.print(" Le département de naissance est "+p.deptNaissance+".");
	}

	private int anneeNaissance(String numSecu){ //question5
        	int x=Integer.parseInt(numSecu.substring(1,3));
        	if(x>25){return(1900+x);}
        	else{return(2000+x);}
    	}
	
	// j'ai une autre méthode qui fait pas exactement la même chose
	//question6
	private char sexe(String numSecu) {
		if (numSecu.charAt(0)=='1')
			return('M');
		else if(numSecu.charAt(0)=='2')
			return('F');
		else {return("Erreur dans le numéro de sécurité, sexe ne correspond pas");}
	}
	// pas la même technique
	//question7
	private int deptNaissance(String numSecu) {
		String a = Character.toString(numSecu.charAt(5))+Character.toString(numSecu.charAt(6));
		int result = Integer.parseInt(a);
		return(result);
	}

	public int calculAge(Personne p){ //question10
		int age = 2019- p.anneeNaissance;
		System.out.print("L'âge est de "+age+".");
		return age;
	}

	// comment justifier quels getters et setters sont "utiles"?
	// est ce qu'il faut les utiliser dans les fonctions
	public String getNom() {
        return this.nom; }
	public String getPrenom() {
        return this.prenom;
    }
	public char getSexe() {
        return this.sexe;}
	public String getNumSecu() {
        return this.numSecu;
    }
	public int getAnneeNaissance() {
        return this.anneeNaissance;
    }
	public int getDeptNaissance() {
        return this.deptNaissance;
    }
	public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String prenom) {
        this.adresse=adresse;}

    public void setNumSecu(String numSecu) {
        this.numSecu=numSecu;
        this.anneeNaissance=anneeNaissance(numSecu);
        this.deptNaissance=deptNaissance(numSecu);}

	
}
