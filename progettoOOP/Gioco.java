
package progettoOOP;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;



public class Gioco implements Costanti, CaratteristicheCarta{
    
    
    private static Giocatore[] giocatore = new Giocatore[2];
    private static ArrayList<CartaServitore> carteAbilitate1 = new ArrayList<>();  //indica le carte schierate che possono essere utilizzate nel turno
    private static int manaMaxAttuale;
    private static ArrayList<String> bestiaAttacco1 = new ArrayList<>(); //indica se la carta BESTIA ha attaccato solo una volta nel turno
    private static ArrayList<String> saluteGiaIncrementata = new ArrayList<>();  //indica se nel turno, la carta SUPPORTO ha già incrementato la salute di qualcuno
    
    
    
    public static Giocatore getGiocatore(int num){
        return giocatore[num];
    }
    
    
    
    
    public static void intro(){
        Scanner input = new Scanner(System.in);
        
        System.out.println("Benvenuto al tuo gioco di carte fantasy! Buon divertimento.\n\n");
        
        System.out.print("Immettere il nome del giocatore 1: ");  
        giocatore[0] = new Giocatore(input.nextLine(), VITA_INIZIALE, MANA_INIZIALI);

              
        System.out.print("Immettere il nome del giocatore 2: ");
        giocatore[1] = new Giocatore(input.nextLine(), VITA_INIZIALE, MANA_INIZIALI);

    }
    
    
    
    
    
    
    
    public static void inizializzaGioco() {
        
        for(int i = 0; i < 3; i++) //prime 3 carte in mano per ogni giocatore
        {
            int j = 0;
            
            giocatore[j].getMano().aggiungiCartaAllaMano(Mazzo.pescaCarta());
            giocatore[j+1].getMano().aggiungiCartaAllaMano(Mazzo.pescaCarta());
        }
        

    }
    
    
    
    
    
    public static void avviaTurno(){
            
        SecureRandom rand = new SecureRandom();
        
        int numAtt = rand.nextInt(2);  //si decide fra i due giocatori chi comincia il gioco
        int numDif;
        
        
        
        if (numAtt == 0)
            numDif = numAtt + 1;  
        else
            numDif = numAtt - 1;
        
        
        Scanner in = new Scanner(System.in);

        
        while (giocatore[0].getVita() > 0 && giocatore[1].getVita() > 0)
        {
            Grafica.cambiaSchermata();
            Grafica.disegnaTavolo(numAtt, numDif);
            
            //inizializzazioni di inizio turno
            carteAbilitate1.clear();
            bestiaAttacco1.clear();
            saluteGiaIncrementata.clear();
            
            //vengono indicate, all'inizio del turno, tutte le carte schierate che potranno essere utilizzate subito
            for (int i = 0; i < giocatore[numAtt].getCarteSchierate().getCarteSchierate().size(); i++) 
                carteAbilitate1.add(giocatore[numAtt].getCarteSchierate().getCarteSchierate().get(i));

            manaMaxAttuale = giocatore[numAtt].getMana();
            if (Mazzo.getIndice() < Mazzo.getMaxCarte())  //verifica se il mazzo ha almeno una carta da poter pescare
                giocatore[numAtt].getMano().aggiungiCartaAllaMano(Mazzo.pescaCarta()); //carta pescata per ogni turno
            Grafica.cambiaSchermata();
            System.out.println("Il giocatore " + giocatore[numAtt].getUser() + " ha pescato una carta.\n\n\n\n");
            Grafica.disegnaTavolo(numAtt, numDif);
            System.out.println("\n\n\n\n\n");
            
            
            
            boolean continua = true;
            
            int scelta;
            
            
            while (continua){
                
                boolean continuaLoop = true;
                
                do {
                    
                    System.out.print("Cosa vuoi fare? \nVoglio schierare le mie carte: 1 \nVoglio utilizzare le mie carte schierate: 2 \nHo finito il mio turno: 0\n\nScelta: ");
                                       

                    try{
                        
                        scelta = in.nextInt();
                        
                        if (scelta == 1){
                            schieraCarte(numAtt);

                            Grafica.cambiaSchermata();
                            Grafica.disegnaTavolo(numAtt, numDif);
                            System.out.println("\n\n\n\n\n");

                        }
                        else if (scelta == 2){
                            if (numAtt == 0)
                                numDif = numAtt + 1;
                            else
                                numDif = numAtt - 1;

                            
                            if (!carteAbilitate1.isEmpty())
                                utilizzaCarteSchierate(numAtt,numDif);
                            else
                                System.out.println("\nNon hai carte schierate da utilizzare!\n");

                            Grafica.cambiaSchermata();
                            Grafica.disegnaTavolo(numAtt, numDif);
                            System.out.println("\n\n\n\n\n");

                            //verifica se entrambi i giocatori hanno il valore di vita maggiore di 0, in caso contrario esce dal ciclo while 
                            if (giocatore[0].getVita() <= 0 || giocatore[1].getVita() <= 0) {
                                continuaLoop = false;
                                continua = false;                                
                            }
                        }
                        else if (scelta == 0){
                            continuaLoop = false;
                            continua = false;
                        }
                        else if (scelta < 0 || scelta > 2)
                            throw new Exception();                           

                    }
                    catch (InputMismatchException e){
                                                
                        System.out.println("\nInserimento non compatibile. Riprova.\n");
                        System.out.println("Fai la tua scelta inserendo un numero intero.\n\n");         
                        in.nextLine();
                    }
                    catch (Exception e){
                        System.out.println("Non hai inserito un numero intero valido. Riprova.\n\n");
                    }
                }
                while(continuaLoop);
                
                

            }
            
            //verifiche e aggiornamenti di fine turno
            if (manaMaxAttuale < 10)
                giocatore[numAtt].setMana( manaMaxAttuale + 1);
            else
                giocatore[numAtt].setMana(MANA_MAX); 
            
            //il giocatore in attacco e il giocatore in difesa si invertono per il turno successivo
            int temp;
            temp = numAtt;
            numAtt = numDif;
            numDif = temp;
            
            
          
           
        }
       
    
    }
    
    
    
    
    
    private static void schieraCarte(int num) {
        
        Scanner in = new Scanner(System.in);
        
        boolean continuaLoop = true;

        int scelta;
   
        do {
            
            System.out.println("\n\nQuale carta vuoi schierare? \n");
            for (int i = 0; i < giocatore[num].getMano().getManoAttuale().size(); i++){
                System.out.print("[" + (i+1) + ") ");
                giocatore[num].getMano().getManoAttuale().get(i).disegnaCarta();
                System.out.print("]\n");
            }
            System.out.print("\nDigita 0 per tornare al menu' precedente.");
            System.out.print("\n\nScelta: ");
            
            
            
            
            try {
                
                scelta = in.nextInt();                
                
                if (scelta < 0 || scelta > giocatore[num].getMano().getManoAttuale().size())
                    throw new Exception();     
                else if (scelta == 0){
                    continuaLoop = false;
                }
                
                else {
                
                    Carta carta = giocatore[num].getMano().getManoAttuale().get(scelta - 1);
                    //verifica se i mana disponibili del giocatore sono sufficienti per giocare la carta, scelta da quelle in mano
                    if (carta.getManaCarta() <= giocatore[num].getMana()) {
                        giocatore[num].getMano().rimuoviCartaDallaMano(carta);

                        //aggiornamento mana disponibili
                        giocatore[num].setMana(giocatore[num].getMana() - carta.getManaCarta());
                        if (carta.getTipologia() == TipologiaCarta.MISTICA)
                            azione(carta, num);
                        else {
                            giocatore[num].getCarteSchierate().schieraCarta((CartaServitore) carta);
                            verificaCartaGuerriero((CartaServitore) carta);  //verifica perchè la carta GUERRIERO può attaccare nel turno in cui viene giocata, diversamente dalle altre carte
                        }
                        
                        continuaLoop = false;


                    }
                    else
                        System.out.println("\nMi dispiace, mana insufficienti.");
                }
                    
                
                

            }
            catch (InputMismatchException e){
                System.out.println("Inserimento non compatibile. Riprova.");
                System.out.println("Fai la tua scelta inserendo un numero intero."); 
                in.nextLine();

            }
            catch (Exception e){
                System.out.println("Non hai inserito un numero intero valido. Riprova.");
            }
            
        }
        while(continuaLoop);
                    
    }
    
    
    
    
    
    
    private static void utilizzaCarteSchierate(int att, int dif){
        
        Scanner in = new Scanner(System.in);
        
        boolean continuaLoop = true;
        
        int scelta;

        do {
            System.out.println("Quale carta vuoi utilizzare? \n");

            //scorre tutta carteAbilitate1 per scegliere la carta che dovrà essere utilizzata tra quelle schierate
            for (int i = 0; i < carteAbilitate1.size(); i++)
                System.out.println("Carta " + (i+1) + "\n");
            
            System.out.print("\nDigita 0 per tornare al menu' precedente.");
            System.out.print("\n\nScelta: ");
            
            
            
            try {
                
                scelta = in.nextInt();
                
                if (scelta < 0 || scelta > carteAbilitate1.size())
                    throw new Exception();
                else if (scelta == 0){
                    continuaLoop = false;
                }
                else {
                    CartaServitore cartaUtilizzata = carteAbilitate1.get(scelta-1);
                    for (int i = 0; i < giocatore[att].getCarteSchierate().getCarteSchierate().size(); i++){

                        //cerca la corrispondenza tra la carta scelta in carteAbilitate1 e le carte schierate appartenenti al giocatore del turno (i due nomi ovviamente dovranno coincidere, dato che indicano la medesima carta)
                        if (giocatore[att].getCarteSchierate().getCarteSchierate().get(i).getNome() == cartaUtilizzata.getNome()){
                            cartaUtilizzata = giocatore[att].getCarteSchierate().getCarteSchierate().get(i);
                            verificaCartaDaUtilizzare(cartaUtilizzata, att, dif);
                        }

                    }
                    continuaLoop = false;

                }
                
                              
            }
            catch (InputMismatchException e){
                System.out.println("Inserimento non compatibile. Riprova.\n");
                System.out.println("Fai la tua scelta inserendo un numero intero.\n\n");    
                in.nextLine();
            }
            catch (Exception e){
                System.out.println("Non hai inserito un numero intero valido. Riprova.\n\n");
            }
            
        }
        while(continuaLoop);

    }
    
    
    
    
    
    private static void verificaCartaDaUtilizzare(CartaServitore carta, int att, int dif) {
        
        Scanner in2 = new Scanner(System.in);
        
        boolean continuaLoop = true;
        
        int scelta;
        
        //la carta SUPPORTO ha una duplice modalità
        if (carta.getServitore() == Servitore.SUPPORTO && !saluteGiaIncrementata.contains(carta.getNome())){
            do {
                    System.out.println("Cosa vuoi fare?\nAttaccare: 1\nIncrementare la salute di un servitore schierato: 2\n");
                    
                    
                    
                try {            
                    
                    scelta = in2.nextInt();
                    
                    if (scelta == 1){
                        attacco(carta, att, dif);
                        continuaLoop = false;
                    }
                    else if (scelta == 2){
                        incrementaSalute(att);
                        saluteGiaIncrementata.add(carta.getNome());
                        continuaLoop = false;
                    }
        
                    else if (scelta < 1 || scelta > 2)
                            throw new Exception();   
                }
                catch(InputMismatchException e){
                    System.out.println("Inserimento non compatibile. Riprova.\n");
                    System.out.println("Fai la tua scelta inserendo un numero intero.\n\n");   
                    in2.nextLine();
                }
                catch (Exception e){
                System.out.println("Non hai inserito un numero intero valido. Riprova.\n\n");
                }
                
            }
            while(continuaLoop);
        }        
                
        else
            attacco(carta, att, dif);
    
    }

    
    
    
    
    private static void verificaCartaGuerriero(CartaServitore carta){
        if (carta.getServitore() == Servitore.GUERRIERO)
            carteAbilitate1.add(carta);

    }
    
    
    
    
    
    private static void azione(CartaServitore carta1, CartaServitore carta2, int giocatore1, int giocatore2){
            
        confrontoTipoCarte(carta1, carta2); //confronta la tipologia della carta che attacca e di quella che subisce dato che i danni subiti potrebbero variare in base proprio alla tipologia
        
        //verifica che la salute della carta che subisce l'attacco sia maggiore di 0
        if (carta2.getSalute() <= 0)
            giocatore[giocatore2].getCarteSchierate().rimuoviCartaSchierata(carta2);
        
        //verifica oltre la salute, che il servitore che ha attaccato sia un MAGO, dato che alla sua morte danneggia di 1 la salute di un servitore nemico schierato casuale
        if (carta1.getSalute() <= 0 && carta1.getServitore() == Servitore.MAGO){
            
            SecureRandom rand = new SecureRandom();
           
            int num = rand.nextInt(giocatore[giocatore2].getCarteSchierate().getCarteSchierate().size());
            
            giocatore[giocatore2].getCarteSchierate().getCarteSchierate().get(num).setSalute(giocatore[giocatore2].getCarteSchierate().getCarteSchierate().get(num).getSalute() - 1);
            if (giocatore[giocatore2].getCarteSchierate().getCarteSchierate().get(num).getSalute() <= 0)
                giocatore[giocatore2].getCarteSchierate().rimuoviCartaSchierata(giocatore[giocatore2].getCarteSchierate().getCarteSchierate().get(num));
        }
        
        //verifica che la salute della carta che ha attaccato sia maggiore di 0
        if (carta1.getSalute() <= 0){
            giocatore[giocatore1].getCarteSchierate().rimuoviCartaSchierata(carta1);
            carteAbilitate1.remove(carta1);
        }
        else if (carta1.getServitore() == Servitore.BESTIA) {  //verifica che il servitore rimasto in vita sia una BESTIA, per verificare quante volte può ancora attaccare nel turno
            if (bestiaAttacco1.contains(carta1.getNome())) {
                bestiaAttacco1.remove(carta1.getNome());
                carteAbilitate1.remove(carta1);
                
            }
            else
                bestiaAttacco1.add(carta1.getNome());
        }
        else
            carteAbilitate1.remove(carta1);
        
    }
    
    
    
    
    
    //metodo utilizzato quando viene giocata una carta MISTICA e verifica della sua tipologia 
    private static void azione(Carta carta, int num){
        
        if (carta.getDescrizioneCarta() == DESCRIZIONE_MISTICA_MAGO){
            for (int i = 0; i < giocatore[num].getCarteSchierate().getCarteSchierate().size(); i++)
                if (giocatore[num].getCarteSchierate().getCarteSchierate().get(i).getServitore() == Servitore.MAGO){
                    giocatore[num].getCarteSchierate().getCarteSchierate().get(i).setAttacco(giocatore[num].getCarteSchierate().getCarteSchierate().get(i).getAttacco() + 1);
                    giocatore[num].getCarteSchierate().getCarteSchierate().get(i).setSalute(giocatore[num].getCarteSchierate().getCarteSchierate().get(i).getSalute() + 1);
                }
        }
        
        if (carta.getDescrizioneCarta() == DESCRIZIONE_MISTICA_GUERRIERO){
            for (int i = 0; i < giocatore[num].getCarteSchierate().getCarteSchierate().size(); i++)
                if (giocatore[num].getCarteSchierate().getCarteSchierate().get(i).getServitore() == Servitore.GUERRIERO){
                    giocatore[num].getCarteSchierate().getCarteSchierate().get(i).setAttacco(giocatore[num].getCarteSchierate().getCarteSchierate().get(i).getAttacco() + 1);
                    giocatore[num].getCarteSchierate().getCarteSchierate().get(i).setSalute(giocatore[num].getCarteSchierate().getCarteSchierate().get(i).getSalute() + 1);
                }
        }
        
        if (carta.getDescrizioneCarta() == DESCRIZIONE_MISTICA_BESTIA){
            for (int i = 0; i < giocatore[num].getCarteSchierate().getCarteSchierate().size(); i++)
                if (giocatore[num].getCarteSchierate().getCarteSchierate().get(i).getServitore() == Servitore.BESTIA){
                    giocatore[num].getCarteSchierate().getCarteSchierate().get(i).setAttacco(giocatore[num].getCarteSchierate().getCarteSchierate().get(i).getAttacco() + 1);
                    giocatore[num].getCarteSchierate().getCarteSchierate().get(i).setSalute(giocatore[num].getCarteSchierate().getCarteSchierate().get(i).getSalute() + 1);
                }
        }
        
        if (carta.getDescrizioneCarta() == DESCRIZIONE_MISTICA_SUPPORTO){
            for (int i = 0; i < giocatore[num].getCarteSchierate().getCarteSchierate().size(); i++)
                if (giocatore[num].getCarteSchierate().getCarteSchierate().get(i).getServitore() == Servitore.SUPPORTO){
                    giocatore[num].getCarteSchierate().getCarteSchierate().get(i).setAttacco(giocatore[num].getCarteSchierate().getCarteSchierate().get(i).getAttacco() + 1);
                    giocatore[num].getCarteSchierate().getCarteSchierate().get(i).setSalute(giocatore[num].getCarteSchierate().getCarteSchierate().get(i).getSalute() + 1);
                }
        }
        
    }
    
    
    
    
    private static void confrontoTipoCarte(CartaServitore cartaAtt, CartaServitore cartaDif){
        
        if (cartaAtt.getTipologiaServitore() == TipologiaServitore.TERRA && cartaDif.getTipologiaServitore() == TipologiaServitore.ELETTRICITA)
            cartaDif.setSalute(cartaDif.getSalute() - (cartaAtt.getAttacco() + 1));
        else if (cartaAtt.getTipologiaServitore() == TipologiaServitore.ACQUA && (cartaDif.getTipologiaServitore() == TipologiaServitore.TERRA || cartaDif.getTipologiaServitore() == TipologiaServitore.FUOCO))
            cartaDif.setSalute(cartaDif.getSalute() - (cartaAtt.getAttacco() + 1));
        else if (cartaAtt.getTipologiaServitore() == TipologiaServitore.FUOCO && cartaDif.getTipologiaServitore() == TipologiaServitore.TERRA)
            cartaDif.setSalute(cartaDif.getSalute() - (cartaAtt.getAttacco() + 1));
        else if (cartaAtt.getTipologiaServitore() == TipologiaServitore.ELETTRICITA && (cartaDif.getTipologiaServitore() == TipologiaServitore.ACQUA || cartaDif.getTipologiaServitore() == TipologiaServitore.FUOCO))
            cartaDif.setSalute(cartaDif.getSalute() - (cartaAtt.getAttacco() + 1));
        else 
            cartaDif.setSalute(cartaDif.getSalute() - cartaAtt.getAttacco());
        
        cartaAtt.setSalute(cartaAtt.getSalute() - cartaDif.getAttacco());
        
    }
    
    
    
    
    
    private static void incrementaSalute(int num){
        Scanner in2 = new Scanner(System.in);
        
        boolean continuaLoop = true;
        
        int scelta;
    
        do {
            System.out.println("A quale servitore schierato vuoi incrementare la salute?\n\n");
            
            for (int i = 0; i < giocatore[num].getCarteSchierate().getCarteSchierate().size(); i++)
                System.out.println(giocatore[num].getCarteSchierate().getCarteSchierate().get(i).getNome() + " di salute " + giocatore[num].getCarteSchierate().getCarteSchierate().get(i).getSalute() + ". Digita: " + (i+1) + "\n");
            try {
            
                scelta = in2.nextInt();
                
                if (scelta < 1 || scelta > giocatore[num].getCarteSchierate().getCarteSchierate().size())
                    throw new Exception();
            
                giocatore[num].getCarteSchierate().getCarteSchierate().get(scelta - 1).setSalute(giocatore[num].getCarteSchierate().getCarteSchierate().get(scelta - 1).getSalute() + 1);
                continuaLoop = false;
                   
            }
            catch(InputMismatchException e){
                    System.out.println("Inserimento non compatibile. Riprova.\n");
                    System.out.println("Fai la tua scelta inserendo un numero intero.\n\n");   
                    in2.nextLine();
            }
            catch (Exception e){
                System.out.println("Non hai inserito un numero intero valido. Riprova.\n\n");
            }
                
        }
        while(continuaLoop);
    }
    
    
    
    
    private static void attacco(CartaServitore cartaUtilizzata, int att, int dif){
        Scanner in2 = new Scanner(System.in);
        
        boolean continuaLoop = true;
        
        int scelta;
        
        do {
            System.out.println("Chi vuoi attaccare? \nGiocatore avversario: 13\n");
            for (int i = 0; i < giocatore[dif].getCarteSchierate().getCarteSchierate().size(); i++)
                System.out.println("Carta " + (i+1) + "\n");
        
            try {
                
                scelta = in2.nextInt();
            
                if ((scelta < 1 || scelta > giocatore[dif].getCarteSchierate().getCarteSchierate().size()) && scelta != 13)
                    throw new Exception();
        
                if (scelta == 13){
                    giocatore[dif].setVita(giocatore[dif].getVita() - cartaUtilizzata.getAttacco());  //attacco direttamente alla vita del giocatore avversario

                    if (cartaUtilizzata.getServitore() == Servitore.BESTIA) {  //verifica che il servitore rimasto in vita sia una BESTIA, per verificare quante volte può ancora attaccare nel turno
                        if (bestiaAttacco1.contains(cartaUtilizzata.getNome())) {
                            bestiaAttacco1.remove(cartaUtilizzata.getNome());
                            carteAbilitate1.remove(cartaUtilizzata);

                        }
                        else
                            bestiaAttacco1.add(cartaUtilizzata.getNome());
                    }
                    else
                        carteAbilitate1.remove(cartaUtilizzata);
                }
                else {            
                    CartaServitore cartaAttaccata = giocatore[dif].getCarteSchierate().getCarteSchierate().get(scelta - 1);
                    azione(cartaUtilizzata, cartaAttaccata, att, dif);  //attacco di un servitore schierato verso un servitore avversario
                }
                
                continuaLoop = false;
                
            }
            catch(InputMismatchException e){
                    System.out.println("Inserimento non compatibile. Riprova.\n");
                    System.out.println("Fai la tua scelta inserendo un numero intero.\n\n");   
                    in2.nextLine();
            }
            catch (Exception e){
                System.out.println("Non hai inserito un numero intero valido. Riprova.\n\n");
            }
                
        }
        while(continuaLoop);
            
    }
    
    
    
    
    
    public static void fine(){
        for (int i = 0; i < giocatore.length; i++)
            if(giocatore[i].getVita() > 0)
                System.out.println("Complimenti " + giocatore[i].getUser() + ", hai vinto!\n\n");       
            else
                System.out.println(giocatore[i].getUser() + ", mi dispiace, hai perso...\n\n\n");
    }
    
}
