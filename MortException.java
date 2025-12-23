
public class MortException extends Exception {
    public MortException() { super("Le monstre est mort et ne peut pas attaquer."); }
    
    public MortException(String msg) { 
        super(msg); }

}
