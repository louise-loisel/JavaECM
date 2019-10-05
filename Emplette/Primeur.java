package projetjava;

public class Primeur extends Article implements IPublicite, IVendreKilo, ISolde  {
    
    private boolean remboursable;
    
    //constructeur
    public Primeur(String nom, float prixAchat, float prixVente){
       super(nom, prixAchat, prixVente);
       this.remboursable=false;
      }
    public void slogan(){
      System.out.println("Venez vous nourrir yes !");
        
        //connaitre taux soldes
    public void tauxSoldes(){
      System.out.println("Le taux de soldes est de "+(this.tauxSoldes*100)+"%.");
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
  
  public boolean getRemboursable(){return this.remboursable;}
}
