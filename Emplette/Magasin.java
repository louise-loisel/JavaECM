package projetjava;
import java.util.ArrayList;

public class Magasin {
	protected String nom;
	protected String adresse;
	protected int nbVendeurs;
	protected ArrayList<Article> articlesEnStock;
	protected ArrayList<Integer> qteArticlesEnStock;
	protected float caisse;
	
	public Magasin(String nom, String adresse, int nbVendeurs, float caisse) {
		this.nom=nom;
		this.adresse=adresse;
		this.nbVendeurs=nbVendeurs;
		this.caisse=caisse;
		this.articlesEnStock = new ArrayList<Article>();
		this.qteArticlesEnStock = new ArrayList<Integer>();
	}
	
	public void achatArticles(Article art, float qte){
		if art.prixAchat*qte<this.caisse{
			articlesEnStock.add(art);
			qteArticlesEnStock(qte);
			this.caisse-=art.prixAchat*qte;
		}
		else{
			System.out.println("Fonds du magasin insuffisants");
		}
	
		
	}
	
}
