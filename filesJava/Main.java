
package progettoOOP;


public class Main{
    
    public static void main(String[] args) {
         
        Gioco.intro();

        
        Mazzo.inizializzaMazzo();
        Mazzo.visualizzazioneMazzo();
        Mazzo.mischiaMazzo();
        Mazzo.visualizzazioneMazzo();
               
        
        Gioco.inizializzaGioco();
        Gioco.avviaTurno();
        
        Gioco.fine();

        
    }
    
      
}
