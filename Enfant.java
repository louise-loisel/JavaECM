package projetjava;
/*Soit la classe Enfant qui n’est pas sous-classe de Personne car un enfant n’a pas de numéro de sécurité sociale.
Il aura donc les mêmes autres champs que Personne.*/

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



	public String getNom() {return this.nom; }
	public String getPrenom() {return this.prenom;}
	public char getSexe() {return this.sexe;}
	public int getAnneeNaissance() {return this.anneeNaissance;}
	public int getDeptNaissance() {return this.deptNaissance;}
	public String getAdresse() {return this.adresse;}

	public void setAdresse(String adresse) {this.adresse=adresse;}
}
