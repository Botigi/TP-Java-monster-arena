public class MonstreFactory {

    public Monstre creerMonstre(String description, int pv, int degats) {
        // description attendue : "Dragon", "Professeur", ou "Dragon avec une épée", etc.
        String desc = description.toLowerCase();

        Monstre base;
        if (desc.contains("dragon")) {
            base = new Dragon(pv, degats);
        } else if (desc.contains("professeur")) {
            base = new Professeur(pv, degats);
        } else {
            // Par défaut, un professeur
            base = new Professeur(pv, degats);
        }

        // parse décorateurs simples
        if (desc.contains("épée") || desc.contains("epee")) {
            base = new MonstreAvecEpee(base);
        }
        if (desc.contains("casque")) {
            base = new MonstreAvecCasque(base);
        }

        return base;
    }
}