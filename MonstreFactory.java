public class MonstreFactory {

    public Monstre creerMonstre(String description, int pv, int degats) {

               
        String desc = description.toLowerCase();

        Monstre base;
        if (desc.contains("dragon")) {
            base = new Dragon(pv, degats);
            
        } else if (desc.contains("professeur")) {
            base = new Professeur(pv, degats);
        } else {

                    base = new Professeur(pv, degats);   }

        if (desc.contains("épée") || desc.contains("epee")) {
            base = new MonstreAvecEpee(base);
        }   
        if (desc.contains("casque")) {
            base = new MonstreAvecCasque(base);
        }  

        return base;

        
    }
}

