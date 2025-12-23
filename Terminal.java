public class Terminal implements Observateur {
    
    @Override
    public void miseAJour(Monstre m, String evenement) {

        
        if (evenement.startsWith("subit:")) {
            
            String dmg = evenement.substring("subit:".length()) ;
            System.out.println(m.getNom() + " (id " + m.getId() + ") subit "+ dmg +" dégâts. PV restants: " + m.getPV());
        } else if (evenement.equals("attaque")) {
            System.out.println(m.getNom() + " (id " + m.getId() + ") attaque.");
            
        } else if  (evenement.equals("mort")) {
            System.out.println(m.getNom() + " (id " + m.getId() + ") est mort.");
        } else {
            
            System.out.println("[" + m.getNom() + " id " + m.getId() + "] " +  evenement );
        }
    }

}

