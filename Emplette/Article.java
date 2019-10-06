package projetjava;

public class Article implements IVendrePiece, IVendreKilo {

	// ----------- ATTRIBUTS -------------
	protected String nom;
	protected float prixAchat;
	protected float prixVente;
	protected float tauxSoldes;
		protected float qteStock;
		protected String pieceKilo;
		protected boolean enStock;
		public boolean vente;

	// ----------- CONSTRUCTEURS -------------

	//*** constructeur par défaut
	public Article(String nom, float prixAchat, float prixVente) {
		this.nom=nom;
		this.prixAchat=prixAchat;
		this.prixVente=prixVente;
		this.tauxSoldes=0;
		this.pieceKilo="défaut";
		this.qteStock=0;
		this.pieceKilo="default";
		this.enStock = false;
		this.vente=false;
	}

	//*** constructeur où on peut aussi préciser la quantité associée à l'article
			/* pratique si on veut directement initialiser le magasin, sans avoir recours à l'achat pour tous les
			 articles */
	public Article(String nom, float prixAchat, float prixVente, float qte) {
		this.nom=nom;
		this.prixAchat=prixAchat;
		this.prixVente=prixVente;
		this.tauxSoldes=0;
		this.pieceKilo="défaut";
		this.qteStock=qte;
		this.enStock = false;}

	//---------- GETTERS ET SETTERS ------------

	public float getQteStock(){return this.qteStock;}
	public String getNom(){return this.nom;}

	public void artEnStock(){this.enStock=true;}
	public void ajoutQteStock(float ajout){this.qteStock+=ajout;}

	//------------ METHODES

	//**** VENTE

	@Override
	public void vendrePiece(int qteVente){
		if (this.enStock && qteVente<this.qteStock)
			{this.qteStock-=qteVente;
			this.enStock=true;
			System.out.println("Article vendu, il reste " + this.qteStock + " en stock.");
			this.vente=true;
			}
		else if (this.enStock && qteVente==this.qteStock)
			{this.qteStock=0;
			this.enStock=false;
			System.out.println("Article vendu, il n'en reste plus en stock.");
			this.vente=true;
			}
		else if (!this.enStock || qteVente>this.qteStock)
			{System.out.println("Pas assez d'article en stock");
			this.vente=false;}
	};
	
	@Override
	public void vendreKilo(float qteVente){
		if (this.enStock && qteVente<this.qteStock)
			{this.qteStock-=qteVente;
			this.enStock=true;
			System.out.println("Article vendu, il reste " + this.qteStock + " en stock.");
			this.vente=true;
			}
		else if (this.enStock && qteVente==this.qteStock)
			{this.qteStock=0;
			this.enStock=false;
			System.out.println("Article vendu, il n'en reste plus en stock.");
			this.vente=true;
			}
		else if (!this.enStock || qteVente>this.qteStock)
			{System.out.println("Pas assez d'articles en stock");
			this.vente=false; }
	}
}
