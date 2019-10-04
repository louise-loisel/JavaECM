package projetjava;
// import java.util.Calendar;

public class Personne {
	protected String nom;
	protected String prenom;
	protected String numSecu;
	protected int anneeNaissance;
	protected char sexe;
	protected int deptNaissance;
	protected String adresse;
	
	public Personne(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
		this.numSecu="0";
		this.anneeNaissance=0;
		this.sexe='N';
		this.deptNaissance=0;
	}
	public Personne(String nom, String prenom, String numSecu, String adresse) {
		this.nom = nom;
		this.prenom = prenom;
		this.numSecu=numSecu;
		this.anneeNaissance=anneeNaissance(numSecu);
		this.sexe=sexe(numSecu);
		this.adresse=adresse;
		this.deptNaissance=deptNaissance(numSecu);
	}
	// HELP je sais pas à quoi ça sert
	public void toString(Personne p) {
		System.out.print("Le nom est "+p.nom+". Le prénom est "+p.prenom+".");
		if (p.sexe!='N')
			System.out.print(" Le sexe est "+p.sexe+".");
		if (p.numSecu!="0")
			System.out.print(" Le numéro de sécurité sociale est "+p.numSecu+".");
		if (p.anneeNaissance!=0)
			System.out.print(" L'année de naissance est "+p.numSecu+".");
		if (p.deptNaissance!=0)
			System.out.print(" Le département de naissance est "+p.deptNaissance+".");
	}
	// moi j'ai pas la même technique mais si ça marche aussi, tant mieux
	private int anneeNaissance(String numSecu) {
		String a = Character.toString(numSecu.charAt(1))+Character.toString(numSecu.charAt(2));
		int result = Integer.parseInt(a);
		return(result);
	}
	// j'ai une autre méthode qui fait pas exactement la même chose
	private char sexe(String numSecu) {
		if (numSecu.charAt(0)=='1')
			return('M');
		else
			return('F');
	}
	// pas la même technique
	private int deptNaissance(String numSecu) {
		String a = Character.toString(numSecu.charAt(5))+Character.toString(numSecu.charAt(6));
		int result = Integer.parseInt(a);
		return(result);
	}

	// prendre en compte les gens nés depuis 2000 ? voir méthode en commentaire
	public int calculAge(Personne p){
		int age = 2019- p.anneeNaissance;
		System.out.print("L'âge est de "+age+".");
		return age;
	}

//	public int calculAge(){
//      int year = Calendar.getInstance().get(Calendar.YEAR);
//		int age= year-this.getAnneeNaissance();
//		return(age);
//	}



	// comment justifier quels getters et setters sont "utiles"?
	// est ce qu'il faut les utiliser dans les fonctions
	public String getNom() {
        return this.nom; }
	public String getPrenom() {
        return this.prenom;
    }
	public char getSexe() {
        return this.sexe;}
	public String getNumSecu() {
        return this.numSecu;
    }
	public int getAnneeNaissance() {
        return this.anneeNaissance;
    }
	public int getDeptNaissance() {
        return this.deptNaissance;
    }
	public String getAdresse() {
        return this.adresse;
    }
 
    public void setNom(String nom) {
        this.nom=nom;}
    public void setPrenom(String prenom) {
        this.prenom=prenom;}
    public void setSexe(char sexe) {
        this.sexe=sexe;}
    public void setNumSecu(String numSecu) {
        this.numSecu=numSecu;
        this.anneeNaissance=anneeNaissance(numSecu);
        this.deptNaissance=deptNaissance(numSecu);}

	
}
