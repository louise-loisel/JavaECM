package projetjava;

public class Collegiens extends Enfant implements Scolaire {
	//Pour un collégien les niveaux ne sont pas les mêmes et pour un lycéen non plus. Ces deux classes ont un booléen examen.
	public String niveaux[] = {"6eme", "5eme", "4eme" , "3eme"};
	protected String niveau;
	protected boolean examen;
	
	public Collegiens(String nom, String prenom, int anneeNaissance, char sexe, int deptNaissance, String adresse, int annee) {
		super(nom, prenom, anneeNaissance, sexe, deptNaissance, adresse);
		this.niveau=niveaux[annee];
		if (this.Grand()==true) // cf lycéens
			this.examen=true;
		else
			this.examen=false;
	}
	
	public boolean Petit() {
		 if (this.niveau.equals("6eme"))
			return true;
		else 
			return false;
	}
	
	public boolean Moyen() {
		if (this.niveau.equals("6eme") || this.niveau.equals("3eme"))
			return false;
		else 
			return true;
	}
	public boolean Grand() {
		if (this.niveau.equals("3eme"))
			return true;
		else 
			return false;
	}
	

}