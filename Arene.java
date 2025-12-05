
import java.util.ArrayList;
import java.util.List;

public class Arene {
    private static Arene instance;
    private final List<Monstre> monstres = new ArrayList<>(2);
    private final List<Observateur> observateursGlobaux = new ArrayList<>();

    private Arene() { }

    public static Arene getInstance() {
        if (instance == null) instance = new Arene();
        return instance;
    }

    public void ajouteMonstre(Monstre m) {
        if (monstres.size() >= 2) {
            System.err.println("Arene pleine (max 2).");
            return;
        }
        monstres.add(m);
        // ajouter les observateurs globaux à ce monstre
        for (Observateur o : observateursGlobaux) m.ajouteObservateur(o);
    }

    public void ajouteObservateurs(Observateur o) {
        this.observateursGlobaux.add(o);
        // ajouter à tous les monstres déjà présents
        for (Monstre m : monstres) m.ajouteObservateur(o);
    }

    public void combat() {
        if (monstres.size() != 2) {
            System.err.println("Un combat nécessite exactement 2 monstres dans l'arene.");
            return;
        }
        Monstre m1 = monstres.get(0);
        Monstre m2 = monstres.get(1);

        // boucle simple : les monstres attaquent alternativement jusqu'à la mort d'un
        boolean tourDeM1 = true;
        while (m1.getPV() > 0 && m2.getPV() > 0) {
            try {
                if (tourDeM1) {
                    m1.attaque(m2);
                } else {
                    m2.attaque(m1);
                }
            } catch (MortException e) {
                // si le monstre mort essaye d'attaquer
                System.err.println(e.getMessage());
            }
            tourDeM1 = !tourDeM1;

            // petit délai possible (non-blockant), ou simplement boucle
        }

        // affichage du gagnant
        if (m1.getPV() > 0) {
            System.out.println(m1.getNom() + " (id " + m1.getId() + ") gagne");
        } else if (m2.getPV() > 0) {
            System.out.println(m2.getNom() + " (id " + m2.getId() + ") gagne");
        } else {
            System.out.println("Match nul (les deux sont morts)");
        }
    }
}