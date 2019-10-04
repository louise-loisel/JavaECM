package projetjava;
import java.util.*;
//Créer la classe EleveDigital qui a en plus un ArrayList pour gérer ses notes.Donner les constructeurs et les méthodes pour gérer ceci correctement.


public class EleveDigital extends Eleve {
    
	private ArrayList<Note> listeNotes;
	public EleveDigital(String nom, String prenom, String numSecu, String adresse, int ine, int promo, int annee){
		super(nom, prenom, numSecu, ine, promo, annee, adresse);
		this.listeNotes= new ArrayList<Note>();//a-t-on besoin du this?
	}
	
	public void ajouteNote(Note n) {
		this.listeNotes.add(n); //a-t-on besoin du this?
	}
	
    	public ArrayList<Note> getNotes() {
        	return this.listeNotes; // avant : "return notes", sauf que je savais pas ce que c'était que notes
    	}


	

}
