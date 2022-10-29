
package progettoOOP;


public class Giocatore {
    
    private final String user;
    private int vita;
    private int mana;
    private Mano mano;
    private Schieramento carteSchierate;
    
    public Giocatore(String user, int vita, int mana) {
        
        this.user = user;
        this.vita = vita;
        this.mana = mana;  
        this.mano = new Mano();
        this.carteSchierate = new Schieramento();
    }
    
    public String getUser() {   
        return user;                    
    }
    
    public int getVita() {
        return vita;
    }
    
    public int getMana() {
        return mana;
    }
    
    public Mano getMano(){
        return mano;
    }
    
    public Schieramento getCarteSchierate(){
        return carteSchierate;
    }
    
    
    public void setVita(int vita) {
        this.vita = vita;
    }
    
    public void setMana(int mana) {
        this.mana = mana;
    }
    
    
    
    
}
