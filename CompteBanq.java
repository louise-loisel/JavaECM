package projetjava;
/*
11)	Ecrire une classe CompteBanq avec les attributs :
private String num;
private Personne client;
private float solde;
private float decouvertAutorise;
private String code1;
private String code2;

12)	Ecrire un constructeur ne saisissant que le numéro, le client et  les codes ; initialisant les autres attributs à 0.
13)	Ecrire les setters et getters en sachant qu’on ne doit pouvoir modifier que le solde et le découvert autorisé
et ceci en donnant le code1 pour la première opération et le code 2 pour la deuxième. 
On ne doit pas pouvoir non plus modifier les codes.
14)	Ecrire une méthode versement pour laquelle il faudra bien sûr connaître le code 
15)	Ecrire une méthode retrait pour laquelle il faudra connaître le code 1 et si la somme à retirer est supérieure au solde il faut alors vérifier si l’opération peut être effectuée en regardant le découvert autorisé.
16)	Au niveau du main il faut arriver, après création de la personne et du compte, à donner un nom, afficher le solde, proposer une versement ou un retrait, l’effecteur et afficher le nouveau solde.
*/

public class CompteBanq {
	// en private car pas de sous classes
	
	//question11
	private String num;
	private Personne client;
	private float solde;
	private float decouvertAutorise;
	private String code1;
	private String code2;
	
	public CompteBanq(String num, Personne client, String code1, String code2){ //question12
		this.num=num;
		this.client=client;
		this.code1=code1;
		this.code2=code2;
		this.solde=0;
		this.decouvertAutorise=0;
	}

	// je comprends pas grand chose mais je fais confiance
	// moi j'ai seulement plus des messages d'erreurs
	public void versement(float montant,String code) //question14
		throws CodeIncorrectException {
			if (code.equals(code1)) {
				this.solde += montant;
			}
			else {
				throw new CodeIncorrectException();
			}

		}

	//idem
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

	// comment on justifie l'utilité de ces trucs là? Peut etre pas code1 code2 question13
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

	
	
    public void setNum(String num) {
        this.num=num;}
    public void setClient(Personne client) {
        this.client=client;}
    public void setSolde(String code, float solde) {
        if (code.equals(code1))
        	this.solde=solde;
        }
    public void setDecouvertAutorise(float decouvertAutorise,String code){
    	if (code.equals(code2))
    		this.decouvertAutorise=decouvertAutorise;
    }


	
}
