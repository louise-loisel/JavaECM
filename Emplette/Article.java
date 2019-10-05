package projetjava;

public class Article implements IVendrePiece, IVendreKilo {
	protected String nom;
	protected float prixAchat;
	protected float prixVente;
	protected float tauxSoldes;
		protected boolean remboursable;
		protected float qteStock;
		protected String pieceKilo;
		protected boolean enStock;
	
	public Article(String nom, float prixAchat, float prixVente) {
		this.nom=nom;
		this.prixAchat=prixAchat;
		this.prixVente=prixVente;
		this.tauxSoldes=0;
		this.remboursable=false;
		this.quantiteStock=0;
		this.pieceKilo="default";
		if (quantiteStock>0;){this.enStock = true};
	}
	
	public boolean getRemboursable(){return this.remboursable;}
	public float getQteStock(){return this.qteStock;}
	
	// méthodes vente
	public boolean vente();
	public boolean remboursement();
	
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
			boolean vente=true;
			}
		else if (this.enStock && qteVente=this.qteStock;)
			{this.qteStock=0;
			this.enStock=false;
			System.out.println("Article vendu, il n'en reste plus en stock.");
			boolean vente=true;
			}
		else if (!this.enStock || qteVente>this.qteStock)
			{System.out.println("Pas assez d'articles en stock")
			boolean vente=false;}
	};
	
	
	// getters & setters
	
	public void setEnStock(boolean enStock){this.enStock=enStock;}
	public void ajoutQteStock(float ajout){this.qteStock+=ajout;}
	
	
	
}
