package projetjava;

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
