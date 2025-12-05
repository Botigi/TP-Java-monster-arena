public class Main {
    public static void main(String[] args) {
        Arene arene = Arene.getInstance();
        MonstreFactory f = new MonstreFactory();
        Observateur terminal = new Terminal();

        Monstre m1 = f.creerMonstre("Dragon avec une épée", 100, 10);
        Monstre m2 = f.creerMonstre("Professeur avec un casque", 200, 20);
        arene.ajouteMonstre(m1);
        arene.ajouteMonstre(m2);

        arene.ajouteObservateurs(terminal);
        arene.combat();
    }
}