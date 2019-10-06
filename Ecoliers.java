package projetjava;

public class Ecoliers extends Enfant implements Scolaire {// ai rajouté le "implements Scolaire"
	private static String niveaux[] = {"CP", "CE1", "CE2" , "CM1", "CM2"};
	private String niveau;
	
	/*La classe écolier a un tableau commun à toute la classe et qui ne peut pas être modifié qui donne les cinq niveaux possibles
	 * 
	 *  et chaque écolier a une variable d’instance qui donne son niveau.
	 */
	
	public Ecoliers(String nom, String prenom, int anneeNaissance, char sexe, int deptNaissance, String adresse, int annee) {
		super(nom, prenom, anneeNaissance, sexe, deptNaissance, adresse);
		this.niveau=niveaux[annee];
	}

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
