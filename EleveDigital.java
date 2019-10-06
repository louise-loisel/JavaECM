package projetjava;
import java.util.*;

public class EleveDigital extends Eleve {
    
	// -------------- ATTRIBUTS -------
	private ArrayList<Note> listeNotes;
	
	// ------------ CONSTRUCTEUR
	public EleveDigital(String nom, String prenom, String numSecu, String adresse, String ine, int promo, int annee){
		super(nom, prenom, numSecu, ine, promo, annee, adresse);
		this.listeNotes= new ArrayList<Note>();
	}
	
	// ----------------- METHODES 
	public void ajouteNote(Note n) {
		this.listeNotes.add(n);
	}
	
    	public ArrayList<Note> getNotes() {
        	return this.listeNotes;
    	}
	

}
