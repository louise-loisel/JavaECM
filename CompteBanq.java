package projetjava;

public class CompteBanq {
	
	// -------------- ATTRIBUTS -------
	// ------------ CONSTRUCTEUR
	// ----------- IMPLEMENTATION INTERFACE SCOLAIRE
	// ----------------- METHODES 
	// --------------- SETTERS & GETTERS
	private String num;
	private Personne client;
	private float solde;
	private float decouvertAutorise;
	private String code1;
	private String code2;
	
	
	// ------------ CONSTRUCTEUR

	public CompteBanq(String num, Personne client, String code1, String code2){
		this.num=num;
		this.client=client;
		this.code1=code1;
		this.code2=code2;
		this.solde=0;
		this.decouvertAutorise=0;
	}

	// ----------------- METHODES 

	public void versement(float montant,String code) //question14
		throws CodeIncorrectException {
			if (code.equals(code1)) {
				this.solde += montant;
			}
			else {
				throw new CodeIncorrectException();
			}

		}

	public void retrait(float montant,String code) throws CodeIncorrectException{  //question15
		if (!code.equals(this.code1))
			throw new CodeIncorrectException();
		else
		{
			if (this.solde-montant>=(-this.decouvertAutorise))
				{this.solde=this.solde-montant;}
			else
				{System.out.println("Découvert insuffisant");}
		}

	}

	
	// --------------- SETTERS & GETTERS
	
	public String getNum() {return this.num;}
	public Personne getPersonne() {return this.client;}
	public float getSolde() {return this.solde;}
	public float getDecouvertAutorise() {return this.decouvertAutorise;}
	
    	public void setNum(String num) {this.num=num;}
    	public void setClient(Personne client) {this.client=client;}
   	public void setSolde(String code, float solde) {
		if (code.equals(code1))
        		this.solde=solde
				else System.out.println("Mauvais code, insérez code 2");

	}
	
    	public void setDecouvertAutorise(float decouvertAutorise,String code){
    		if (code.equals(code2))
    			this.decouvertAutorise=decouvertAutorise
				else System.out.println("Mauvais code, insérez code 2");
	}


	
}
