package projetjava;

public class Article implements IVendrePiece, IVendreKilo {
	protected String nom;
	protected float prixAchat;
	protected float prixVente;
	protected float tauxSoldes;
		protected float qteStock;
		protected String pieceKilo;
		protected boolean enStock;
	
	public Article(String nom, float prixAchat, float prixVente) {
		this.nom=nom;
		this.prixAchat=prixAchat;
		this.prixVente=prixVente;
		this.tauxSoldes=0;
		this.pieceKilo="défaut";
		this.qteStock=0;
		this.pieceKilo="default";
		this.enStock = false};
	}
	
	// deuxième constructeur où on peut aussi préciser la quantité
	public Article(String nom, float prixAchat, float prixVente, float qte) {
		this.nom=nom;
		this.prixAchat=prixAchat;
		this.prixVente=prixVente;
		this.tauxSoldes=0;
		this.pieceKilo="défaut";
		this.qteStock=qte;
		this.enStock = false};
	}
	
	public float getQteStock(){return this.qteStock;}
	public void enStock(){if this.qteStock>0;this.enStock=true}
	
	//---- Méthodes vente

	public boolean vente();
	
	public void vendrePiece(int qteVente){
		if (this.enStock && qteVente<this.qte Stock;)
			{this.qteStock-=qteVente;
			System.out.println("Article vendu, il reste " + this.qteStock + " en stock.");
			boolean vente=true;
			}
		else if (this.enStock && qteVente=this.qteStock;)
			{this.qteStock=0;
			this.enStock=false;
			System.out.println("Article vendu, il n'en reste plus en stock.");
			boolean vente=true;
			}
		else if (!this.enStock || qteVente>this.qteStock)
			{System.out.println("Pas assez d'article en stock")
			boolean vente=false;}
	};
	
	
	public void vendreKilo(float qteVente){
		if (this.enStock && qteVente<this.qte Stock;)
			{this.qteStock-=qteVente;
			System.out.println("Article vendu, il reste " + this.qteStock + " en stock.");
			this.vente=true;
			}
		else if (this.enStock && qteVente=this.qteStock;)
			{this.qteStock=0;
			this.enStock=false;
			System.out.println("Article vendu, il n'en reste plus en stock.");
			this.vente=true;
			}
		else if (!this.enStock || qteVente>this.qteStock)
			{System.out.println("Pas assez d'articles en stock")
			this.vente=false;}
	};
	
	
	// getters & setters
	
	public String getNom(){return this.nom;}
	
	public void artEnStock(){this.enStock=true;}
	public void ajoutQteStock(float ajout){this.qteStock+=ajout;}
	
	
	
}
