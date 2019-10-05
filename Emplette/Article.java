package projetjava;

public class Article {
	protected String nom;
	protected float prixAchat;
	protected float prixVente;
	protected float tauxSoldes
	
	public Article(String nom, float prixAchat, float prixVente, float quantite) {
		this.nom=nom;
		this.prixAchat=prixAchat;
		this.prixVente=prixVente;
		this.tauxSoldes=0;
		this.quantite=quantite;
	}
}
