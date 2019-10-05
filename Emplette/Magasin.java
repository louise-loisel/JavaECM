package projetjava;
import java.util.ArrayList;

public class Magasin implements IVendrePiece, IVendreKilo{
	protected String nom;
	protected String adresse;
	protected int nbVendeurs;
	protected ArrayList<Article> articlesVendus; // la quantité en Stock est rentrée dans les attributs de l'article
	protected float caisse;
	
	public Magasin(String nom, String adresse, int nbVendeurs, float caisse, ArrayList<Article> articlesMagasin ) {
		this.nom=nom;
		this.adresse=adresse;
		this.nbVendeurs=nbVendeurs;
		this.caisse=caisse;
		this.articlesVendus = articlesMagasin;
	}
	
	public boolean enVente(Article art){ // booléen pour voir si article demandé dans la liste des articles du magasin
		for(Article a : this.articlesVendus){
			if (a instanceof art) 
				return true;
		}
	}
	
	public int indexArticle(String nomArticle) { // rend l'indice de l'article du nom recherché dans la liste articlesVendus
	    for(var i = 0; i < articlesVendus.length; i += 1) {
	        if(articlesVendus[i].getNom().equals(nomArticle)) {return i;}
    		}
    		return -1;
		}
	
	public void achat(Article art, float qteAchat){
		if art.prixAchat*qteAchat<=this.caisse && this.enVente(Article art); 
			{System.out.println("Achat possible, suffisamment d'argent en caisse");
			
			// trouver article correspondant (suivant le nom !) dans la liste et incrémenter sa quantité
			//+ update boolean enStock
			int index = this.indexArticle(String art.getNom());
			articlesVendus[index].ajoutQteStock(float qteAchat);
			articlesVendus[index].artEnStock();
			
			this.caisse-=art.prixAchat*qteAchat;}
		else if (!this.enVente( Article art)){
			System.out.println("L'article n'est pas vendu dans ce magasin");};
		else if (art.prixAchat*qteAchat>this.caisse){System.out.println("Pas assez d'argent en caisse pour cet achat");}
		}

			 
	public void vendre(Article art, float qteVente){
		/* on pourrait faire art.vendreKilo(), mais je ne sais pas si modifier le stock de quantité de l'instance art
		modifiera aussi sa valeur dans l'array articlesVendus. Je ne sais pas si la valeur des attributs est automatiquement
		mise-à-jour dans la liste d'articles. */
		int index = this.indexArticle(String art.getNom())
		if art.pieceKilo.equals("kilo");
			articlesVendus[index].vendreKilo(float qteVente);// devrait normalement gérer la quantité en stock si la vente a lieu
		else if art.pieceKilo.equals("piece") && ((int)qteVente == qteVente); // check que la quantité rentrée est bien entière
			articlesVendus[index].vendrePiece((int)qteVente);	// convertir le float rentré en int lorsqu'on l'intègre à l'argument de la fonction
		else if art.pieceKilo.equals("piece") && (!(int)qteVente == qteVente);
			System.out.println("Erreur : le nombre de pièces demandé n'est pas entier";);
		if art.vente();
			this.caisse+=art.prixVente*qteVente; 
	}


	public void retourArticle(Article art, boolean etatRetour){
		this.caisse-=art.prixVente;
		if (art.pieceKilo.equals("piece") && etatRetour;){ // dans le cas d'un article type "piece" on peut le remettre en vente
			
			int index = this.indexArticle(String art.getNom());
			articlesVendus[index].ajoutQteStock(1);// on ne retourne qu'un article type "piece" à la fois (vérification du bon état)
			articlesVendus[index].artEnStock();}
		}
	}
	
}
