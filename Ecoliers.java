package projetjava;

public class Ecoliers extends Enfant implements Scolaire {
	
	
	// -------------- ATTRIBUTS -------
	
	private static final String niveaux[] = {"CP", "CE1", "CE2" , "CM1", "CM2"};
	private String niveau;

	// ------------ CONSTRUCTEUR

	public Ecoliers(String nom, String prenom, int anneeNaissance, char sexe, int deptNaissance, String adresse, int annee) {
		super(nom, prenom, anneeNaissance, sexe, deptNaissance, adresse);
		this.niveau=niveaux[annee];
	}

	// ----------- IMPLEMENTATION INTERFACE SCOLAIRE

	public boolean petit() {
		if (this.niveau.equals("CP"))
			return true;
		else
			return false;
	}

	public boolean moyen() {
		if (this.niveau.equals("CP")  || this.niveau.equals("CM2"))
			return false;
		else
			return true;
	}
	public boolean grand() {
		if (this.niveau.equals("CM2"))
			return true;
		else
			return false;
	}

}
