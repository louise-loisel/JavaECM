package com.company;


public class Personne {
	
	// -------------- ATTRIBUTS -------	
	protected String nom;
	protected String prenom;
	protected String numSecu;
	protected int anneeNaissance;
	protected char sexe;
	protected int deptNaissance;
	protected String adresse;
	
	// ------------ CONSTRUCTEUR
	
	// **** Valeurs par défaut
	public Personne(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
		this.numSecu="0";
		this.anneeNaissance=0;
		this.sexe='N';
		this.deptNaissance=0;
	}
	
	// **** Constructeur plus élaboré
 	public Personne(String nom, String prenom, String numSecu, String adresse) {
		this.nom = nom;
		this.prenom = prenom;
		this.numSecu=numSecu;
		this.anneeNaissance=anneeNaissance(numSecu);
		this.sexe=sexe(numSecu);
		this.adresse=adresse;
		this.deptNaissance=deptNaissance(numSecu);
	}
	
	// ----------------- METHODES 
	public void toString(Personne p) {
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

	private int anneeNaissance(String numSecu){
        	int x=Integer.parseInt(numSecu.substring(1,3));
        	if(x>25){return(1900+x);}
        	else{return(2000+x);}
    	}
	

	private char sexe(String numSecu) {
		if (numSecu.charAt(0)=='1')
			return('M');
		else if(numSecu.charAt(0)=='2')
			return('F');
		else {
			System.out.println("Erreur dans le numéro de sécurité, sexe ne correspond pas");
		    	return('N');
		}
	}

	private int deptNaissance(String numSecu) {
		String a = Character.toString(numSecu.charAt(5))+Character.toString(numSecu.charAt(6));
		int result = Integer.parseInt(a);
		return(result);
	}

	public static int calculAge(Personne p){
		int age = 2019- p.anneeNaissance;
		return age;
	}

	// --------------- SETTERS & GETTERS
	public String getNom() {return this.nom; }
	public String getPrenom() {return this.prenom;}
	public char getSexe() {return this.sexe;}
	public String getNumSecu() {return this.numSecu; }
	public int getAnneeNaissance() {return this.anneeNaissance;}
	public int getDeptNaissance() { return this.deptNaissance;}
	public String getAdresse() {return this.adresse;}

    	public void setAdresse(String prenom) {this.adresse=adresse;}
	public void setNumSecu(String numSecu) {
		this.numSecu=numSecu;
        	this.anneeNaissance=anneeNaissance(numSecu);
        	this.deptNaissance=deptNaissance(numSecu);
    		this.sexe=sexe(numSecu);}

	
}
