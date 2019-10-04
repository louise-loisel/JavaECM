package projetjava;
//Créer une classe note, une note est décrite par deux attributs : l’intitulé de la matière, la note sur 20, nombre de crédits obtenus, un booléen validation.
public class Note {
	private String nomMatiere;
	private float note;
	private int credits;
	private boolean validation;
	
	public Note(String nomMatiere, float note, int credits, boolean validation){
		this.nomMatiere=nomMatiere;
		this.note=note;
		this.credits=credits;
		this.validation=validation;
	}

}
