
package progettoOOP;

import java.util.ArrayList;


public class Schieramento {
    
    private ArrayList<CartaServitore> carteSchierate;
    
    public Schieramento(){
        this.carteSchierate = new ArrayList<>();
    } 
    
    public ArrayList<CartaServitore> getCarteSchierate(){
        return carteSchierate;
    }
   
    public void schieraCarta(CartaServitore carta){
        carteSchierate.add(carta);
    }
    
    
    public void rimuoviCartaSchierata(CartaServitore carta) {
        carteSchierate.remove(carta);
    }
    
}
