
public interface Monstre {
    int getPV();   
    int getDegats() ;
    void subirDegats(int degats);   
    void attaque(Monstre cible) throws   MortException; 
    int getId(); 
    String getNom();
  
    void ajouteObservateur( Observateur o) ;

}
