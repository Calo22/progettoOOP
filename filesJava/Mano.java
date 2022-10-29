
package progettoOOP;

import java.util.ArrayList;


public class Mano {
    
    
    private ArrayList<Carta> manoAttuale;
    
    
    
    public Mano(){
        this.manoAttuale = new ArrayList<>();
    } 
    
    
    public ArrayList<Carta> getManoAttuale(){
        return manoAttuale;
    }

    
    public void aggiungiCartaAllaMano(Carta carta){
        manoAttuale.add(carta);
    }
    
    
    public void rimuoviCartaDallaMano(Carta carta) {
        manoAttuale.remove(carta);
    }
    
    
    
    
            
}
