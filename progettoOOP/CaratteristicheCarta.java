
package progettoOOP;


public interface CaratteristicheCarta {
    
    enum TipologiaCarta {MISTICA, SERVITORE};
    
    enum Servitore {MAGO, GUERRIERO, BESTIA, SUPPORTO};
    
    enum TipologiaServitore {TERRA, ACQUA, FUOCO, ELETTRICITA};
    
    
    String DESCRIZIONE_MAGO = "\"Alla sua uccisione, -1 salute a un servitore nemico (casuale) schierato.\"";
    String DESCRIZIONE_GUERRIERO = "\"Potrebbe attaccare nel turno in cui viene schierato.\"";
    String DESCRIZIONE_BESTIA = "\"Potrebbe attaccare 2 volte per turno.\"";
    String DESCRIZIONE_SUPPORTO = "\"In ogni turno in cui e' schierato, +1 salute a un servitore schierato a scelta.\"";
    String DESCRIZIONE_MISTICA_MAGO = "\"Una volta giocata, +1 attacco e +1 salute di ogni MAGO schierato.\"";
    String DESCRIZIONE_MISTICA_GUERRIERO = "\"Una volta giocata, +1 attacco e +1 salute di ogni GUERRIERO schierato.\"";
    String DESCRIZIONE_MISTICA_BESTIA = "\"Una volta giocata, +1 attacco e +1 salute di ogni BESTIA schierato.\"";
    String DESCRIZIONE_MISTICA_SUPPORTO = "\"Una volta giocata, +1 attacco e +1 salute di ogni SUPPORTO schierato.\"";

        
}
