package com.company;

public class Note {
	/***************VARIABLES***********/
	private String nomMatiere;
	private float note;
	private int credits;
	private boolean validation;
	/***************CONSTRUCTEUR***********/
	public Note(String nomMatiere, float note, int credits, boolean validation){
		this.nomMatiere=nomMatiere;
		this.note=note;
		this.credits=credits;
		this.validation=validation;
	}

}
