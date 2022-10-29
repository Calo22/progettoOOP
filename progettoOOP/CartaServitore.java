
package progettoOOP;


public class CartaServitore extends Carta {
    
    private int attacco;
    private int salute;
    private final Servitore servitore;
    private final TipologiaServitore tipologiaServitore;
    
    public CartaServitore(String nome, String descrizioneCarta, TipologiaCarta tipologiaCarta, int manaCarta,
            int attacco, int salute, Servitore servitore, TipologiaServitore tipologiaServitore) {
        
        super(nome, descrizioneCarta, tipologiaCarta, manaCarta);
        this.attacco = attacco;
        this.salute = salute;
        this.servitore = servitore;
        this.tipologiaServitore = tipologiaServitore;
        
    }
    
    public int getAttacco() {
        return attacco;
    }
    
    public int getSalute() {
        return salute;
    }
    
    public Servitore getServitore() {
        return servitore;
    }
    
    public TipologiaServitore getTipologiaServitore(){
        return tipologiaServitore;
    } 
    
    public void setAttacco(int attacco) {
        this.attacco = attacco;
    }
    
    public void setSalute(int salute) {
        this.salute = salute;
    }
    
  
    
    @Override
    public void disegnaCarta(){
        System.out.print(getNome() + "  " + getDescrizioneCarta() + "  " + getTipologia() + "\nMana: " + getManaCarta());
        System.out.print("  Att: " + getAttacco() + "  Sal: " + getSalute() + "  " + getServitore());
    }
    
}
