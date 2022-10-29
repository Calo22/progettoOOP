
package progettoOOP;


public class CartaMistica extends Carta {
    
    public CartaMistica(String nome, String descrizioneCarta, TipologiaCarta tipologiaCarta, int manaCarta) {
        
        super(nome, descrizioneCarta, tipologiaCarta, manaCarta);
        
    }    
    
    @Override
    public void disegnaCarta(){
        System.out.print(getNome() + "  " + getDescrizioneCarta() + "  " + getTipologia() + "\nMana: " + getManaCarta());

    }
    
}
