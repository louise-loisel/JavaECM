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

	public float getCaisse(){return this.caisse;}

	public boolean enVente(Article art){ // booléen pour voir si article demandé dans la liste des articles du magasin
		boolean b=false;
		for(Article a : this.articlesVendus){
			if (a.getNom().equals(art.getNom())) {b= true;}
		}
		return b;
	}
	
	public int indexArticle(String nomArticle) { // rend l'indice de l'article du nom recherché dans la liste articlesVendus
	    for(var i = 0; i < articlesVendus.size(); i += 1) {
	        if(articlesVendus.get(i).getNom().equals(nomArticle)) {return i;}
    		}
    		return -1;
		}
	
	public void achat(Article art, float qteAchat){
		if (art.pieceKilo.equals("piece") && ((int)qteAchat!=qteAchat))
			{System.out.println("Erreur : le nombre de pièces demandé n'est pas entier");
			}
		else if (art.prixAchat*qteAchat<=this.caisse && this.enVente(art))
			{System.out.println("Suffisamment d'argent en caisse, achat effectué");
			
			// trouver article correspondant (suivant le nom !) dans la liste et incrémenter sa quantité
			//+ update boolean enStock
			int index = this.indexArticle(art.getNom());
			articlesVendus.get(index).ajoutQteStock(qteAchat);
			articlesVendus.get(index).artEnStock();
			
			this.caisse-=art.prixAchat*qteAchat;}

		else if (!this.enVente(art)){
			System.out.println("L'article n'est pas vendu dans ce magasin");}
		else if (art.prixAchat*qteAchat>this.caisse){System.out.println("Pas assez d'argent en caisse pour cet achat");}
		}

			 
	public void vendre(Article art, float qteVente){

		int index = this.indexArticle(art.getNom());
		if (index == -1) {System.out.println("L'article n'est pas à vendre");}
		else if (art.pieceKilo.equals("kilo"))
			{articlesVendus.get(index).vendreKilo(qteVente);}// devrait normalement gérer la quantité en stock si la vente a lieu
		else if (art.pieceKilo.equals("piece") && ((int)qteVente == qteVente)) // check que la quantité rentrée est bien entière
			articlesVendus.get(index).vendrePiece((int)qteVente);	// convertir le float rentré en int lorsqu'on l'intègre à l'argument de la fonction
		else if (art.pieceKilo.equals("piece") && (! ((int)qteVente == qteVente)))
			System.out.println("Erreur : le nombre de pièces demandé n'est pas entier");
		if (art.vente)
			this.caisse+=art.prixVente*qteVente; 
	}

	public Article articleMagasin(Article art){ // pour pouvoir faire magasin.article sans avoir à le chercher chaque fois dans la liste
		int index = this.indexArticle(art.getNom());
		return this.articlesVendus.get(index);
	}

	public ArrayList<Article> getArticlesVendus(){return this.articlesVendus;}

	public void retourArticle(Article art, boolean etatRetour){
		if (!enVente(art)){System.out.println(("L'article n'est pas vendu dans le magasin"));}
		else if (art.pieceKilo.equals("piece") && etatRetour){ // dans le cas d'un article type "piece" on peut le remettre en vente
			
			int index = this.indexArticle(art.getNom());
			articlesVendus.get(index).ajoutQteStock(1);// on ne retourne qu'un article type "piece" à la fois (vérification du bon état)
			articlesVendus.get(index).artEnStock();
			this.caisse-=art.prixVente;
		}
		else {this.caisse-=art.prixVente;}

		}
}
