
package progettoOOP;


public class Grafica {
    
    
    
    public static void disegnaTavolo(int g1, int g2){
        
        int almenoUnaCartaInMano1 = 0;
        int almenoUnaCartaInMano2 = 0;
        
        if (g1 == 0){       
            for (int i = 0; i < Gioco.getGiocatore(0).getMano().getManoAttuale().size(); i++)
                if (Gioco.getGiocatore(0).getMano().getManoAttuale().get(i) != null)
                    almenoUnaCartaInMano1++;
            if (almenoUnaCartaInMano1 != 0)
                for (int i = 0, j = 0; i < Gioco.getGiocatore(0).getMano().getManoAttuale().size() && Gioco.getGiocatore(0).getMano().getManoAttuale().get(i) != null; i++){
                    System.out.print("[" + (j+1) + ") ");
                    Gioco.getGiocatore(0).getMano().getManoAttuale().get(i).disegnaCarta();
                    System.out.print("]\n");
                    j++;
                }
            
            System.out.println("---------------------------------------------------------------------");
            System.out.println("---------------------------------------------------------------------");
            
            carteSchierate(0, 1);
            
            System.out.println("---------------------------------------------------------------------");
            System.out.println("---------------------------------------------------------------------");
            
            for (int i = 0; i < Gioco.getGiocatore(1).getMano().getManoAttuale().size(); i++)
                if (Gioco.getGiocatore(1).getMano().getManoAttuale().get(i) != null)
                    almenoUnaCartaInMano2++;
            if (almenoUnaCartaInMano2 != 0)
                for (int i = 0, j = 0; i < Gioco.getGiocatore(1).getMano().getManoAttuale().size() && Gioco.getGiocatore(1).getMano().getManoAttuale().get(i) != null; i++){
                    System.out.print("[" + (j+1) + ") ");
                    System.out.print("||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
                    System.out.print("]\n");
                    j++;
                }

        }
        else {
            for (int i = 0; i < Gioco.getGiocatore(0).getMano().getManoAttuale().size(); i++)
                if (Gioco.getGiocatore(0).getMano().getManoAttuale().get(i) != null)
                    almenoUnaCartaInMano1++;
            if (almenoUnaCartaInMano1 != 0)
                for (int i = 0, j = 0; i < Gioco.getGiocatore(0).getMano().getManoAttuale().size() && Gioco.getGiocatore(0).getMano().getManoAttuale().get(i) != null; i++){
                    System.out.print("[" + (j+1) + ") ");
                    System.out.print("||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
                    System.out.print("]\n");
                    j++;
                }
            
            System.out.println("---------------------------------------------------------------------");
            System.out.println("---------------------------------------------------------------------");
            
            carteSchierate(0, 1);
            
            System.out.println("---------------------------------------------------------------------");
            System.out.println("---------------------------------------------------------------------");
            
            for (int i = 0; i < Gioco.getGiocatore(1).getMano().getManoAttuale().size(); i++)
                if (Gioco.getGiocatore(1).getMano().getManoAttuale().get(i) != null)
                    almenoUnaCartaInMano2++;
            if (almenoUnaCartaInMano2 != 0)
                for (int i = 0, j = 0; i < Gioco.getGiocatore(1).getMano().getManoAttuale().size() && Gioco.getGiocatore(1).getMano().getManoAttuale().get(i) != null; i++){
                    System.out.print("[" + (j+1) + ") ");
                    Gioco.getGiocatore(1).getMano().getManoAttuale().get(i).disegnaCarta();
                    System.out.print("]\n");
                    j++;
                }
                   
        }
        
        System.out.println("\n\nVita di " + Gioco.getGiocatore(0).getUser() + " = " + Gioco.getGiocatore(0).getVita());
        System.out.println("Vita di " + Gioco.getGiocatore(1).getUser() + " = " + Gioco.getGiocatore(1).getVita());
        
        
        System.out.println("\nMana disponibili di " + Gioco.getGiocatore(0).getUser() + " = " + Gioco.getGiocatore(0).getMana());
        System.out.println("Mana disponibili di " + Gioco.getGiocatore(1).getUser() + " = " + Gioco.getGiocatore(1).getMana());
        
        System.out.print("\nMazzo: ");
        if(Mazzo.getIndice() < Mazzo.getMaxCarte())
            System.out.println("Disponibile\t Carte restanti: " + (Mazzo.getMaxCarte() - Mazzo.getIndice()));
        else
            System.out.println("Vuoto\n");
        
    }
    
    
    
    
    public static void cambiaSchermata(){
        for (int i = 0; i < 20; i++)
            System.out.print("\n");
    }
    
    
    
    
    private static void carteSchierate(int g1, int g2){
        if (!Gioco.getGiocatore(g1).getCarteSchierate().getCarteSchierate().isEmpty())
                for (int i = 0; i < Gioco.getGiocatore(g1).getCarteSchierate().getCarteSchierate().size(); i++){
                    System.out.print("[" + (i+1) + ") ");
                    Gioco.getGiocatore(g1).getCarteSchierate().getCarteSchierate().get(i).disegnaCarta();
                    System.out.print("]\n");

                }
            
            System.out.println("\n\n\n");
            
            if (!Gioco.getGiocatore(g2).getCarteSchierate().getCarteSchierate().isEmpty())
                for (int i = 0; i < Gioco.getGiocatore(g2).getCarteSchierate().getCarteSchierate().size(); i++){
                    System.out.print("[" + (i+1) + ") ");
                    Gioco.getGiocatore(g2).getCarteSchierate().getCarteSchierate().get(i).disegnaCarta();
                    System.out.print("]\n");

                }
    }
    
}
