public abstract class MonstreDecorateur implements Monstre {
    protected final Monstre inner;  

    public MonstreDecorateur(Monstre inner) {
        this.inner = inner;
    }
   
    @Override public int getPV() { return inner.getPV();  }
    @Override public int getDegats() { return inner.getDegats(); }
    @Override public void subirDegats(int degats) {  inner.subirDegats(degats); }
    @Override public void ajouteObservateur(Observateur o) { inner.ajouteObservateur(o) ; }
    @Override public int getId() { return inner.getId(); }
    @Override public String getNom() { return  inner.getNom(); }

    @Override
    public void attaque( Monstre cible) throws MortException 
    {
        inner.attaque(cible);
    }

}
