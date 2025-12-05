public interface Observateur {
    // Le deuxième paramètre peut être "attaque", "subit", "mort", ...
    void miseAJour(Monstre m, String evenement);
}