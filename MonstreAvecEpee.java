public class MonstreAvecEpee extends MonstreDecorateur {
    public MonstreAvecEpee(Monstre inner) { super(inner); }

    @Override
    public int getDegats() { return inner.getDegats() * 2; }

    @Override
    public void attaque(Monstre cible) throws MortException {
        if (inner.getPV() <= 0) throw new MortException("Attaque impossible: mort.");
        if (inner instanceof MonstreBase) ((MonstreBase) inner).notifie("attaque");
        cible.subirDegats(this.getDegats());
    }
}