public class MonstreAvecCasque extends MonstreDecorateur {
    public MonstreAvecCasque(Monstre inner) { super(inner); }

    @Override
    public void subirDegats(int degats) {
        int reduit = (int)Math.ceil(degats / 2.0);
        inner.subirDegats(reduit);
    }
}