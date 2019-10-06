package com.company.Emplette;
import java.util.ArrayList;

public class Magasin{
	
	//--------- ATTRIBUTS -----------
	protected String nom;
	protected String adresse;
	private int nbVendeurs;
	private ArrayList<Article> articlesVendus; // la quantité en Stock est rentrée dans les attributs de l'article
	private float caisse;
	
	// --------CONSTRUCTEURS ----------
	
	//*** Constructeur avec sélection d'articles définie en entrée
	public Magasin(String nom, String adresse, int nbVendeurs, float caisse, ArrayList<Article> articlesMagasin ) {
		this.nom=nom;
		this.adresse=adresse;
		this.nbVendeurs=nbVendeurs;
		this.caisse=caisse;
		this.articlesVendus = articlesMagasin; 
		/*il s'agit de la sélection d'articles du Magasin. Un type d'article n'y apparait qu'une seule fois maximum et
		y reste même s'il n'est plus en stock.*/
	}
	
	//*** Constructeur plus simple avec sélection d'articles vide
	public Magasin(String nom, String adresse, int nbVendeurs, float caisse) {
		this.nom=nom;
		this.adresse=adresse;
		this.nbVendeurs=nbVendeurs;
		this.caisse=caisse;
		this.articlesVendus = new ArrayList<Article>();

	}

	//------------ METHODES --------------
	
	
	//*****Sous-méthodes/outils pour simplifier les méthodes de vente et d'achat 
	
	
	// booléen pour voir si article demandé est dans la sélection du magasin ou non, est utilisé dans le Main et dans les méthodes d'instance de Magasin
	public boolean enVente(Article art){
		boolean b;
		b=false;
		for(int i = 0 ; i < this.articlesVendus.size(); i++){
			if ((this.articlesVendus.get(i)).equals(art)) {
				b= true;
			}
		}
		return b;
	
	// méthode qui rend l'indice d'un article recherché dans la liste d'articles vendus par le magasin
	private int indexArticle(String nomArticle) { 
	    for(var i = 0; i < articlesVendus.size(); i += 1) {
	        if(articlesVendus.get(i).getNom().equals(nomArticle)) {return i;}
    		}
    		return -1;
		}
		
	
	// Methode qui rend un article du magasin
	public Article articleMagasin(Article art){ 
		int index = this.indexArticle(art.getNom());
		return this.articlesVendus.get(index);
	}
	
	//***** Corps du magasin  : Méthodes vente/achat/remboursement

	//ACHAT
	public void achat(Article art, float qteAchat){
		if (art.pieceKilo.equals("piece") && ((int)qteAchat!=qteAchat))	// on ne peut pas acheter des quantités non-entières d'articles type "pièce"
			{System.out.println("Erreur : le nombre de pièces demandé n'est pas entier.");}
		//on passe à la suite si les quantités achetées correspondent bien au type d'article demandé
		else if ((art.prixAchat*qteAchat<=this.caisse) && this.enVente(art))
			/* s'il y a suffisamment d'argent en caisse pour acheter la quantité voulue et que l'article fait
			bien partie de la sélection du magasin */
			{System.out.println("Suffisamment d'argent en caisse, achat de "+ art.getNom()+" effectué.");
			int index = this.indexArticle(art.getNom()); //une fois l'indice de liste correspondant obtenu
			articlesVendus.get(index).ajoutQteStock(qteAchat);// on récupère le bon élément de la liste articlesVendus (sélection magasin) et on augmente son stock
			articlesVendus.get(index).artEnStock(); // l'article est à présent indiqué en stock 
			
			this.caisse-=art.prixAchat*qteAchat;} // on décrémente la caisse du magasin suivant l'achat effectué

		else if (!this.enVente(art)){ // si l'article n'est pas dans la sélection
			System.out.println("L'article n'est pas vendu dans ce magasin");}
		else if (art.prixAchat*qteAchat>this.caisse){System.out.println("Pas assez d'argent en caisse pour cet achat");} //s'il n'y a pas assez d'argent en caisse pour financer un nouvel achat
		}

	//VENTE		 
	public void vendre(Article art, float qteVente){

		int index = this.indexArticle(art.getNom());
		if (index == -1) {System.out.println("L'article n'est pas à vendre");} // l'article n'est pas dans la sélection, ne peut pas être vendu
		// on sépare les cas selon le type d'article vendu : selon si c'est pièce ou kilo, les méthodes de vente ne seront pas les mêmes
		else if (art.pieceKilo.equals("kilo"))
			{articlesVendus.get(index).vendreKilo(qteVente);}// devrait gérer la quantité en stock si la vente a lieu
		else if (art.pieceKilo.equals("piece") && ((int)qteVente == qteVente)) // vérifie que la quantité rentrée est bien entière dans le cas d'un article pièce
			articlesVendus.get(index).vendrePiece((int)qteVente);	// convertit le float rentré en int
		else if (art.pieceKilo.equals("piece") && (! ((int)qteVente == qteVente)))
			System.out.println("Erreur : le nombre de pièces demandé n'est pas entier");
		if (art.vente)
		/*booléen retourné par les méthodes vendreKilo et vendrePiece
		si les quantités de stock permettent la vente, art.vente = true */
			this.caisse+=art.prixVente*qteVente; // on augmente la caisse si la vente a lieu
	}
	
	//RETOUR-REMBOURSEMENT
	
	/*On peut rendre tout article, mêmes ceux qui se vendent au kilo. L'article sera dans tous les cas remboursé.
	En revanche, si l'article est en bon état il pourra être revendu et réintégrera les stocks du magasin. Le
	booléen etatRetour permet d'en tenir compte. Si etatRetour=true, l'article rendu est en bon état.*/
		
	public void retourArticle(Article art, boolean etatRetour){
		if (!enVente(art)){System.out.println(("L'article n'est pas vendu dans le magasin"));}
		else if (art.pieceKilo.equals("piece") && etatRetour){ 
			// on ne peut remettre en vente qu'un article type "piece"
			int index = this.indexArticle(art.getNom());
			articlesVendus.get(index).ajoutQteStock(1);// on ne retourne qu'un article type "piece" à la fois
			articlesVendus.get(index).artEnStock();
			
			this.caisse-=art.prixVente;//on décrémente la caisse suite au remboursement
		}
		else {// si l'article rendu est un type kilo ou s'il est en mauvais état, on ne procède qu'au remboursement
			// les stocks restent inchangés
			this.caisse-=art.prixVente;
		}
	}
	
	//------------ SETTERS ET GETTERS --------------
	public float getCaisse(){return this.caisse;}


}
