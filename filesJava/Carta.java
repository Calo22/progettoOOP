
package progettoOOP;


public abstract class Carta implements CaratteristicheCarta {
    
    private final String nome;
    private final TipologiaCarta tipologiaCarta;
    private final String descrizioneCarta;
    private final int manaCarta;
    
    public Carta(String nome, String descrizioneCarta, TipologiaCarta tipologiaCarta, int manaCarta) {
        
        this.nome = nome;
        this.tipologiaCarta = tipologiaCarta;
        this.descrizioneCarta = descrizioneCarta;
        this.manaCarta = manaCarta;
        
    }
    
    public String getNome(){
        return nome;
    }
    
    public TipologiaCarta getTipologia(){
        return tipologiaCarta;
    }
    
    public String getDescrizioneCarta(){
        return descrizioneCarta;
    }
    
    public int getManaCarta(){
        return manaCarta;
    }
    
    public abstract void disegnaCarta();
    

}
