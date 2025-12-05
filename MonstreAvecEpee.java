public class MonstreAvecEpee extends MonstreDecorateur {
    public MonstreAvecEpee(Monstre inner) { super(inner); }

    @Override
    public int getDegats() { return inner.getDegats() * 2; }

    // attaque() délègue mais utilise getDegats() de ce décorateur via cible.subirDegats(...)
    @Override
    public void attaque(Monstre cible) throws MortException {
        if (inner.getPV() <= 0) throw new MortException("Attaque impossible: mort.");
        // on notifie via inner (on garde cohérence des observateurs)
        if (inner instanceof MonstreBase) ((MonstreBase) inner).notifie("attaque"); 
        cible.subirDegats(this.getDegats());
    }
}