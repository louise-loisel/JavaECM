package com.company;

public class Collegiens extends Enfant implements Scolaire {

	// -------------- ATTRIBUTS
	
	private static String niveaux[] = {"6eme", "5eme", "4eme" , "3eme"};
	private String niveau;
	private boolean examen;
	
	// ------------ CONSTRUCTEUR
	
	public Collegiens(String nom, String prenom, int anneeNaissance, char sexe, int deptNaissance, String adresse, int annee) {
		super(nom, prenom, anneeNaissance, sexe, deptNaissance, adresse);
		this.niveau=niveaux[annee];
		if (this.grand()==true)
			this.examen=true;
		else
			this.examen=false;
	}
	
	// ----------- IMPLEMENTATION INTERFACE SCOLAIRE

	public boolean petit() {
		 if (this.niveau.equals("6eme"))
			return true;
		else 
			return false;
	}
	
	public boolean moyen() {
		if (this.niveau.equals("6eme") || this.niveau.equals("3eme"))
			return false;
		else 
			return true;
	}
	public boolean grand() {
		if (this.niveau.equals("3eme"))
			return true;
		else 
			return false;
	}

	// ----------------- METHODES 
	
	public boolean isExamen() {
		return examen;
	}
}
