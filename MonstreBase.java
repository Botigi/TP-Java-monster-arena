
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class MonstreBase implements Monstre {
    private static final AtomicInteger NEXT_ID = new AtomicInteger(1);

    protected final int id;
    protected final String nom;
    protected int pv;
    protected int degats;
    private final List<Observateur> observateurs = new ArrayList<>();

    public MonstreBase(String nom, int pv, int degats) {
        this.id = NEXT_ID.getAndIncrement();
        this.nom = nom;
        this.pv = pv;
        this.degats = degats;
    }

    @Override
    public int getPV() { return this.pv; }

    
    @Override
    public int getDegats() { return this.degats; }

    @Override
    public int getId() { return this.id; }

    @Override
    public String getNom() { return this.nom; }

    
    @Override
    public void ajouteObservateur(Observateur o) {
        if (o != null && !this.observateurs.contains(o)) this.observateurs.add(o);
    }

    protected void notifie(String evenement) {
        for (Observateur o : observateurs) {
            
            o.miseAJour(this, evenement);
        }
    }

    @Override
    public void subirDegats(int deg) {
        if (this.pv <= 0) {
            return; }

        
        this.pv = Math.max(0, this.pv - deg);
        notifie("subit:" + deg);
        if (this.pv == 0) 
        {
            notifie("mort");
        }
    }

    @Override
    public void attaque(Monstre cible) throws MortException {
        if (this.pv <= 0){
            throw new MortException(this.nom + " (id " +this.id + ") est mort et ne peut attaquer." );
        }
        notifie("attaque");
        if (cible != null) {
            cible.subirDegats(this.getDegats());
        }
        
    }

}
