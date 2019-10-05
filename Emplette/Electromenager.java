package projetjava;

public class Electromenager extends Article implements IPublicite, IVendrePiece, ISolde {
  
  //constructeur
  public Electromenager(String nom, float prixAchat, float prixVente){
    super(nom, prixAchat, prixVente);
  }
  
  //slogan
  public void slogan(){
    System.out.println("Venez vous équipez pour la maison yes !");
  }
  
  //connaitre taux soldes
  public void tauxSoldes(){
    System.out.println("Le taux de soldes est de "+(tauxSoldes*100)+"%.");
  }
  
  //lancer soldes
  public void lancerSoldes(float taux){
    throws  PasEntre0et100ExceptionA
  {  
      if(0<taux<1)
      {
        this.tauxSoldes=taux;
      }
      else
      {
        throw new PasEntre0et100ExceptionA();
      }
  }
    
  //stopper soldes
  public void stopSoldes(){
    this.taux=0;
  }
}
