package projetjava;

public class Enfant {
	
	// -------------- ATTRIBUTS -------
	protected String nom;
	protected String prenom;
	protected int anneeNaissance;
	protected char sexe;
	protected int deptNaissance;
	protected String adresse;

	// ------------ CONSTRUCTEUR
	public Enfant(String nom, String prenom, int anneeNaissance, char sexe, int deptNaissance, String adresse) {
		this.nom = nom;
		this.prenom = prenom;
		this.anneeNaissance=anneeNaissance;
		this.sexe=sexe;
		this.adresse=adresse;
		this.deptNaissance=deptNaissance;
	}

	// --------------- SETTERS & GETTERS
	public String getNom() {return this.nom; }
	public String getPrenom() {return this.prenom;}
	public char getSexe() {return this.sexe;}
	public int getAnneeNaissance() {return this.anneeNaissance;}
	public int getDeptNaissance() {return this.deptNaissance;}
	public String getAdresse() {return this.adresse;}

	public void setAdresse(String adresse) {this.adresse=adresse;}
}
