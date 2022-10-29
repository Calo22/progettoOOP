
package progettoOOP;


import java.security.SecureRandom;


public class Mazzo implements CaratteristicheCarta{
    
    private static final int MAX_CARTE = 80;
    private static final Carta[] carte = new Carta[MAX_CARTE];
    private static int indice = 0;
    
    
    
    public static int getMaxCarte(){
        return MAX_CARTE;
    }
    
    
    
    
    public static int getIndice(){
        return indice;
    }

    
    
    
    public static void inizializzaMazzo() {
            int i = 0;
            
            //creazione carte MAGO
            int j = 0;
            
            int mana = 2;
            int attacco = 1;
            int salute = 2;
            
            for (int s=0; s<4; s++){
               carte[i] = new CartaServitore("Mago" + (j+1), DESCRIZIONE_MAGO, TipologiaCarta.SERVITORE, mana, attacco, salute, Servitore.MAGO, TipologiaServitore.TERRA);
               i++;
               j++;
               mana +=2;
               attacco++;
               salute++;
  
            }
            
            mana = 2;
            attacco = 1;
            salute = 2;
            
            for (int s=0; s<4; s++){
               carte[i] = new CartaServitore("Mago" + (j+1), DESCRIZIONE_MAGO, TipologiaCarta.SERVITORE, mana, attacco, salute, Servitore.MAGO, TipologiaServitore.ACQUA);
               i++;
               j++;
               mana +=2;
               attacco++;
               salute++;
  
            }
            
            mana = 2;
            attacco = 1;
            salute = 2;
            
            for (int s=0; s<4; s++){
               carte[i] = new CartaServitore("Mago" + (j+1), DESCRIZIONE_MAGO, TipologiaCarta.SERVITORE, mana, attacco, salute, Servitore.MAGO, TipologiaServitore.FUOCO);
               i++;
               j++;
               mana +=2;
               attacco++;
               salute++;
  
            }
            
            mana = 2;
            attacco = 1;
            salute = 2;
            
            for (int s=0; s<4; s++){
               carte[i] = new CartaServitore("Mago" + (j+1), DESCRIZIONE_MAGO, TipologiaCarta.SERVITORE, mana, attacco, salute, Servitore.MAGO, TipologiaServitore.ELETTRICITA);
               i++;
               j++;
               mana +=2;
               attacco++;
               salute++;
  
            }
            
            //fine creazione carte MAGO
            
            //creazione carte GUERRIERO
            j = 0;
            
            mana = 2;
            attacco = 1;
            salute = 2;
            
            for (int s=0; s<4; s++){
               carte[i] = new CartaServitore("Guerriero" + (j+1), DESCRIZIONE_GUERRIERO, TipologiaCarta.SERVITORE, mana, attacco, salute, Servitore.GUERRIERO, TipologiaServitore.TERRA);
               i++;
               j++;
               mana +=2;
               attacco++;
               salute++;
  
            }
            
            
            mana = 2;
            attacco = 1;
            salute = 2;
            
            for (int s=0; s<4; s++){
               carte[i] = new CartaServitore("Guerriero" + (j+1), DESCRIZIONE_GUERRIERO, TipologiaCarta.SERVITORE, mana, attacco, salute, Servitore.GUERRIERO, TipologiaServitore.ACQUA);
               i++;
               j++;
               mana +=2;
               attacco++;
               salute++;
  
            }
            
            
            mana = 2;
            attacco = 1;
            salute = 2;
            
            for (int s=0; s<4; s++){
               carte[i] = new CartaServitore("Guerriero" + (j+1), DESCRIZIONE_GUERRIERO, TipologiaCarta.SERVITORE, mana, attacco, salute, Servitore.GUERRIERO, TipologiaServitore.FUOCO);
               i++;
               j++;
               mana +=2;
               attacco++;
               salute++;
  
            }
            
            
            mana = 2;
            attacco = 1;
            salute = 2;
            
            for (int s=0; s<4; s++){
               carte[i] = new CartaServitore("Guerriero" + (j+1), DESCRIZIONE_GUERRIERO, TipologiaCarta.SERVITORE, mana, attacco, salute, Servitore.GUERRIERO, TipologiaServitore.ELETTRICITA);
               i++;
               j++;
               mana +=2;
               attacco++;
               salute++;
  
            }
                        
            //fine creazione carte GUERRIERO

            //creazione carte BESTIA
            j = 0;
            
            mana = 2;
            attacco = 1;
            salute = 2;
            
            for (int s=0; s<4; s++){
               carte[i] = new CartaServitore("Bestia" + (j+1), DESCRIZIONE_BESTIA, TipologiaCarta.SERVITORE, mana, attacco, salute, Servitore.BESTIA, TipologiaServitore.TERRA);
               i++;
               j++;
               mana +=2;
               attacco++;
               salute++;
  
            }
            
            
            mana = 2;
            attacco = 1;
            salute = 2;
            
            for (int s=0; s<4; s++){
               carte[i] = new CartaServitore("Bestia" + (j+1), DESCRIZIONE_BESTIA, TipologiaCarta.SERVITORE, mana, attacco, salute, Servitore.BESTIA, TipologiaServitore.ACQUA);
               i++;
               j++;
               mana +=2;
               attacco++;
               salute++;
  
            }
            
            
            mana = 2;
            attacco = 1;
            salute = 2;
            
            for (int s=0; s<4; s++){
               carte[i] = new CartaServitore("Bestia" + (j+1), DESCRIZIONE_BESTIA, TipologiaCarta.SERVITORE, mana, attacco, salute, Servitore.BESTIA, TipologiaServitore.FUOCO);
               i++;
               j++;
               mana +=2;
               attacco++;
               salute++;
  
            }
            
            
            mana = 2;
            attacco = 1;
            salute = 2;
            
            for (int s=0; s<4; s++){
               carte[i] = new CartaServitore("Bestia" + (j+1), DESCRIZIONE_BESTIA, TipologiaCarta.SERVITORE, mana, attacco, salute, Servitore.BESTIA, TipologiaServitore.ELETTRICITA);
               i++;
               j++;
               mana +=2;
               attacco++;
               salute++;
  
            }
            
            //fine creazione carte BESTIA

            //creazione carte SUPPORTO
            j = 0;
            
            mana = 2;
            attacco = 1;
            salute = 2;
            
            for (int s=0; s<4; s++){
               carte[i] = new CartaServitore("Supporto" + (j+1), DESCRIZIONE_SUPPORTO, TipologiaCarta.SERVITORE, mana, attacco, salute, Servitore.SUPPORTO, TipologiaServitore.TERRA);
               i++;
               j++;
               mana +=2;
               attacco++;
               salute++;
  
            }       
            
            
            mana = 2;
            attacco = 1;
            salute = 2;
            
            for (int s=0; s<4; s++){
               carte[i] = new CartaServitore("Supporto" + (j+1), DESCRIZIONE_SUPPORTO, TipologiaCarta.SERVITORE, mana, attacco, salute, Servitore.SUPPORTO, TipologiaServitore.ACQUA);
               i++;
               j++;
               mana +=2;
               attacco++;
               salute++;
  
            }
            
            
            mana = 2;
            attacco = 1;
            salute = 2;
            
            for (int s=0; s<4; s++){
               carte[i] = new CartaServitore("Supporto" + (j+1), DESCRIZIONE_SUPPORTO, TipologiaCarta.SERVITORE, mana, attacco, salute, Servitore.SUPPORTO, TipologiaServitore.FUOCO);
               i++;
               j++;
               mana +=2;
               attacco++;
               salute++;
  
            }
            
            
            mana = 2;
            attacco = 1;
            salute = 2;
            
            for (int s=0; s<4; s++){
               carte[i] = new CartaServitore("Supporto" + (j+1), DESCRIZIONE_SUPPORTO, TipologiaCarta.SERVITORE, mana, attacco, salute, Servitore.SUPPORTO, TipologiaServitore.ELETTRICITA);
               i++;
               j++;
               mana +=2;
               attacco++;
               salute++;
  
            }
            
            //fine creazione carte SUPPORTO
            
            //creazione carte MISTICA_MAGO
            j = 0;
            
            mana = 3;
            
            for (int s=0; s<4; s++){
               carte[i] = new CartaMistica("MisticaMAGO" + (j+1), DESCRIZIONE_MISTICA_MAGO, TipologiaCarta.MISTICA, mana);
               i++;
               j++;
  
            }       
            
            
            //creazione carte MISTICA_GUERRIERO
            j = 0;
            
            for (int s=0; s<4; s++){
               carte[i] = new CartaMistica("MisticaGUERRIERO" + (j+1), DESCRIZIONE_MISTICA_GUERRIERO, TipologiaCarta.MISTICA, mana);
               i++;
               j++;
  
            }  
            
            
            //creazione carte MISTICA_BESTIA
            j = 0;
            
            for (int s=0; s<4; s++){
               carte[i] = new CartaMistica("MisticaBESTIA" + (j+1), DESCRIZIONE_MISTICA_BESTIA, TipologiaCarta.MISTICA, mana);
               i++;
               j++;
  
            }  


            //creazione carte MISTICA_SUPPORTO
            j = 0;
            
            for (int s=0; s<4; s++){
               carte[i] = new CartaMistica("MisticaSUPPORTO" + (j+1), DESCRIZIONE_MISTICA_SUPPORTO, TipologiaCarta.MISTICA, mana);
               i++;
               j++;
  
            }
            
            
            //FINE CREAZIONE MAZZO

            
    }
    
    
    
    
    public static void mischiaMazzo(){
        Carta app;
        int pos;
        SecureRandom s = new SecureRandom();
        for (int n = 0; n < MAX_CARTE; n++) {
           app = carte[n];
           pos = s.nextInt(MAX_CARTE);
           carte[n] = carte[pos];
           carte[pos] = app;
        }
    
    }
    
    
    
    
    public static Carta pescaCarta() {
		
		Carta cartaPescata = null;
		
		if (indice < MAX_CARTE) {
		
			cartaPescata = carte[indice];
			carte[indice] = null;
			indice++;
			
		}
		
		return cartaPescata;
	}
    
    
    
    
    
    public static void visualizzazioneMazzo(){
        
        System.out.println("Mazzo:\n");
        
        for (Carta c : carte){            
            System.out.print("[");
            c.disegnaCarta();
            System.out.print("]\n");
        }
        
        System.out.println("\n\n\n");

            
    }
    
}