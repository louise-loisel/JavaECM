package projetjava;

public class Enfant {
	protected String nom;
	protected String prenom;
	protected int anneeNaissance;
	protected char sexe;
	protected int deptNaissance;
	protected String adresse;// adresse

	public Enfant(String nom, String prenom, int anneeNaissance, char sexe, int deptNaissance, String adresse) {
		this.nom = nom;
		this.prenom = prenom;
		this.anneeNaissance=anneeNaissance;
		this.sexe=sexe;
		this.adresse=adresse;
		this.deptNaissance=deptNaissance;
	}

	// mêmes méthodes qu'avec Personne?
}
