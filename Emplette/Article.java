package com.company.Emplette;
import java.util.*;

public class Article implements IVendrePiece, IVendreKilo{

	// ----------- ATTRIBUTS -------------
	protected String nom;
	protected float prixAchat;
	protected float prixVente;
	protected float tauxSoldes;
	protected float qteStock;
	protected String pieceKilo; // String qui permet de distinguer les articles de type pièce (Electroménager,Habit) et kilo (Primeur)
	protected boolean enStock;
	public boolean vente; // permettra de modifier la caisse du magasin selon si un article a un stock suffisant ou non
	protected boolean enSoldes;

	// ----------- CONSTRUCTEURS -------------

	//*** constructeur par défaut
	public Article(String nom, float prixAchat, float prixVente) {
		this.nom = nom;
		this.prixAchat = prixAchat;
		this.prixVente = prixVente;
		this.tauxSoldes = 0;
		this.pieceKilo = "défaut"; // sera modifié par les sous-classes d'articles
		this.qteStock = 0;
		this.enStock = false;
		this.vente = false;
		this.enSoldes = false;
	}

	//*** constructeur où on peut aussi préciser la quantité associée à l'article
			/* pratique si on veut directement initialiser le magasin, sans avoir recours à l'achat pour tous les
			 articles */
	public Article(String nom, float prixAchat, float prixVente, float qte) {
		this.nom = nom;
		this.prixAchat = prixAchat;
		this.prixVente = prixVente;
		this.tauxSoldes = 0;
		this.pieceKilo = "défaut";
		this.qteStock = qte;
		this.enStock = false;
		this.enSoldes = false;
	}

	//---------- GETTERS ET SETTERS ------------

	public float getQteStock() {
		return this.qteStock;
	}

	public String getNom() {
		return this.nom;
	}

	public boolean isEnSoldes() {
		return enSoldes;
	}

	public float getPrixVente() {
		return prixVente;
	}

	public void artEnStock() {
		this.enStock = true;
	}

	public void ajoutQteStock(float ajout) {
		this.qteStock += ajout;
	}

	//------------ METHODES

	//**** VENTE
	//**VENTE A LA PIECE
	@Override
	public void vendrePiece(int qteVente) {				//Vente à la pièce, quantité entière
		if (this.enStock && qteVente < this.qteStock) {		//L'article est en stock et le sera encore après la vente
			this.qteStock -= qteVente;			//On décrémente le stock
			this.enStock = true;				//On a toujours du stock
			System.out.println("Article vendu, il reste " + this.qteStock + " en stock.");
			this.vente = true;				//La vente a bien eu lieu
		} else if (this.enStock && qteVente == this.qteStock) { //Ici on vend tout le stock
			this.qteStock = 0;				//On modifie le stock à 0
			this.enStock = false;				//On a plus de stock
			System.out.println("Article vendu, il n'en reste plus en stock.");	//On avertit, la vente a eu lieu mais plus de stock
			this.vente = true;				//La vente a bien eu lieu
		} else if (!this.enStock || qteVente > this.qteStock) { //Pas assez de stock
			System.out.println("Pas assez d'article en stock");
			this.vente = false;				//La vente n'a pas eu lieu
		}	
	}

	
	//**VENTE AU KILO
	@Override
	public void vendreKilo(float qteVente) {			//Vente au kilo
		if (this.enStock && qteVente < this.qteStock) {		//L'article est en stock et le sera encore après la vente
			this.qteStock -= qteVente;			//On décrémente le stock
			this.enStock = true;				//On a toujours du stock
			System.out.println("Article vendu, il reste " + this.qteStock + " en stock.");
			this.vente = true;				//La vente a bien eu lieu
		} else if (this.enStock && qteVente == this.qteStock) {	//Ici on vend tout le stock
			this.qteStock = 0;				//On modifie le stock à 0
			this.enStock = false;				//On a plus de stock
			System.out.println("Article vendu, il n'en reste plus en stock.");	//On avertit, la vente a eu lieu mais plus de stock
			this.vente = true;				//La vente a bien eu lieu
		} else if (!this.enStock || qteVente > this.qteStock) {	//Pas assez de stock
			System.out.println("Pas assez d'articles en stock");
			this.vente = false;				//La vente n'a pas eu lieu
		}
	}



}

