package projetjava;
import java.util.ArrayList;

public class Magasin implements IVendrePiece, IVendreKilo{
	protected String nom;
	protected String adresse;
	protected int nbVendeurs;
	protected ArrayList<Article> articlesEnStock;
//	protected ArrayList<Float> qteArticlesEnStock; 
// la quantité en stock est rentrée comme attribut de l'article
	protected float caisse;
	
	public Magasin(String nom, String adresse, int nbVendeurs, float caisse) {
		this.nom=nom;
		this.adresse=adresse;
		this.nbVendeurs=nbVendeurs;
		this.caisse=caisse;
		this.articlesEnStock = new ArrayList<Article>();
//		this.qteArticlesEnStock = new ArrayList<Float>();
	}
	
/*	public void achatArticles(Article art, float qte){
		if art.prixAchat*qte<this.caisse{
			articlesEnStock.add(art);
			qteArticlesEnStock(qte);
			this.caisse-=art.prixAchat*qte;
		}
		else{
			System.out.println("Fonds du magasin insuffisants");
		}
*/
		
	}

	
	public void vendreArticle(Article art) // argument = item de la liste d'articlesEnStock
		if art.kiloPiece="kilo";
			art.vendrekilo(); // devrait normalement gérer la quantité en stock si la vente a lieu
		if art.kiloPiece="piece";
			art.vendrePiece();
		if art.vente; 
			this.caisse+=art.prixVente; 
	
	public void retourArticle(Article art, boolean etatRetour){
		if (art.remboursable && etatRetour;){
			this.caisse-=art.prixVente;
			art.ajoutQteStock(1); // on ne retourne qu'un article à la fois (vérification du bon état)
			art.setEnStock(true);
		}
		else if (art.remboursable && !etatRetour){
			this.caisse-=art.prixVente;
		}
		else if (!art.remboursable){
			System.out.println("Pas de retour possible");
		}
	};
	
}
