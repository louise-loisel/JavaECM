package projetjava;

public class Habit extends Article implements IPublicite, ISolde  {
    
    //---- Constructeur
    public Habit(String nom, float prixAchat, float prixVente){
       super(nom, prixAchat, prixVente);
       this.pieceKilo="piece";
      }
  
  
    //---- Méthodes pub
    public void slogan(){
      System.out.println("Venez vous rhabiller yes !");
    }

    
    //---- Méthodes soldes
    
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
    this.tauxSoldes=0;
  }
}
