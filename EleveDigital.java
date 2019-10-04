package projetjava;
import java.util.*;

public class EleveDigital extends Eleve {
    
	private ArrayList<Note> listeNotes;
	public EleveDigital(String nom, String prenom, String numSecu, int anneeNaissance, char sexe, int deptNaissance, String adresse, int ine, int promo, int annee){
		super(nom, prenom, numSecu, ine, promo, annee, adresse);
		this.listeNotes= new ArrayList<Note>();
	}
	
	public void ajouteNote(Note n) {
		this.listeNotes.add(n);
	}
	

}
