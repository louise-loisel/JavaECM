package com.company;

public class Lyceens extends Enfant implements Scolaire{

	// -------------- ATTRIBUTS -------
	private static String niveaux[] = {"Seconde","Premiere","Terminale"};
	private String niveau;
	private boolean examen;

	// ------------ CONSTRUCTEUR
	public Lyceens(String nom, String prenom, int anneeNaissance, char sexe, int deptNaissance, String adresse, int annee) {
		super(nom, prenom, anneeNaissance, sexe, deptNaissance, adresse);
		this.niveau=niveaux[annee];
		if (this.grand()) 
			this.examen=true;
		else
			this.examen=false;
	}

	// ----------- IMPLEMENTATION INTERFACE SCOLAIRE
	public boolean petit() {
		 if (this.niveau.equals("Seconde"))
			return true;
		else 
			return false;
	}

	public boolean moyen() {
		if (this.niveau.equals("Premiere"))
			return true;
		else 
			return false;
	}
	public boolean grand() {
		if (this.niveau.equals("Terminale"))
			return true;
		else 
			return false;
	}

	// ----------------- METHODES 
	public boolean isExamen() {
		return examen;
	}
}
