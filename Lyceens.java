package com.company;

public class Lyceens extends Enfant implements Scolaire{

	//Pour un collégien les niveaux ne sont pas les mêmes et pour un lycéen non plus. Ces deux classes ont un booléen examen.
	private static String niveaux[] = {"Seconde","Premiere","Terminale"};
	private String niveau;
	private boolean examen;
	
	public Lyceens(String nom, String prenom, int anneeNaissance, char sexe, int deptNaissance, String adresse, int annee) {
		super(nom, prenom, anneeNaissance, sexe, deptNaissance, adresse);
		this.niveau=niveaux[annee];
		if (this.grand()) 
			this.examen=true;
		else
			this.examen=false;
	}

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
	public boolean isExamen() {
		return examen;
	}
}
