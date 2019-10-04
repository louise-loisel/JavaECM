package projetjava;

public class CompteBanq {
	// pourquoi protégé? on les réutilise après?
	protected String num;
	protected Personne client;
	protected float solde;
	protected float decouvertAutorise;
	protected String code1;
	protected String code2;
	
	public CompteBanq(String num, Personne client, String code1, String code2){
		this.num=num;
		this.client=client;
		this.code1=code1;
		this.code2=code2;
		this.solde=0;
		this.decouvertAutorise=0;
	}

	// je comprends pas grand chose mais je fais confiance
	// moi j'ai seulement plus des messages d'erreurs
	public void versement(float montant,String code)
		throws CodeIncorrectException{
			if (code==this.code1)
				this.solde=this.solde+montant;
			else
				throw new CodeIncorrectException();
	}

	//idem
	public void retrait(float montant,String code)
	throws CodeIncorrectException{
		if (code==this.code1) {
			if (this.solde-montant>=(-this.decouvertAutorise))
				this.solde=this.solde-montant;}
		else
			throw new CodeIncorrectException();
	}

	// comment on justifie l'utilité de ces trucs là?
	public String getNum() {
        return this.num; 
        }
	public Personne getPersonne() {
        return this.client;
    }
	public float getSolde() {
        return this.solde;
        }
	public float getDecouvertAutorise() {
        return this.decouvertAutorise;
    }
	public String getCode1() {
        return this.code1;
    }
	public String getCode2() {
        return this.code2;
    }

	
	
    public void setNum(String num) {
        this.num=num;}
    public void setClient(Personne client) {
        this.client=client;}
    public void setSolde(String code, float solde) {
        if (code==code1)
        	this.solde=solde;
        }
    public void setDecouvertAutorise(float decouvertAutorise,String code){
    	if (code==code2)
    		this.decouvertAutorise=decouvertAutorise;
    }


	
}
