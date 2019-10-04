package projetjava;

public class Enfant { //protected car on a des sous classes d'Enfant
	protected String nom;
	protected String prenom;
	protected int anneeNaissance;
	protected char sexe;
	protected int deptNaissance;
	protected String adresse;

	public Enfant(String nom, String prenom, int anneeNaissance, char sexe, int deptNaissance, String adresse) {
		this.nom = nom;
		this.prenom = prenom;
		this.anneeNaissance=anneeNaissance;
		this.sexe=sexe;
		this.adresse=adresse;
		this.deptNaissance=deptNaissance;
	}

	public void toString(Personne p) {
		System.out.print("Le nom est "+p.nom+". Le prénom est "+p.prenom+".");
		if (p.sexe!='N')
			System.out.print(" Le sexe est "+p.sexe+".");
		if (p.anneeNaissance!=0)
			System.out.print(" L'année de naissance est "+p.anneeNaissance+".");
		if (p.deptNaissance!=0)
			System.out.print(" Le département de naissance est "+p.deptNaissance+".");
	}

	
	
	public String getNom() {return this.nom; }
	public String getPrenom() {return this.prenom;}
	public char getSexe() {return this.sexe;}
	public String getNumSecu() {return this.numSecu;}
	public int getAnneeNaissance() {return this.anneeNaissance;}
	public int getDeptNaissance() {return this.deptNaissance;}
	public String getAdresse() {return this.adresse;}
 
	public void setNom(String nom) {        this.nom=nom;}
    	public void setPrenom(String prenom) {this.prenom=prenom;}
    	public void setSexe(char sexe) {this.sexe=sexe;}
	public void setNumSecu(String numSecu) {
		this.numSecu=numSecu;
		this.anneeNaissance=anneeNaissance(numSecu);
		this.deptNaissance=deptNaissance(numSecu);
	}
}
