package igrica;

import java.io.FileWriter;
import java.io.IOException;

public class GamesSimulator {

    public static Player createBot(Board tabla) {
        return new Player(tabla);
    }

    public static void main(String[] args) {
        String csvFajl = "matches.csv";
        
        try (FileWriter pisac = new FileWriter(csvFajl)) {
            
            pisac.write("MatchId,Bot Type,Result,TimeMs,TotalClicks\n");

            // Ovdje je sada ispravljeno u idMeca
            for (int idMeca = 1; idMeca <= 1000; idMeca++) {
                
                Board tabla = new Board(8, 6);
                Player bot = createBot(tabla);

                long pocetnoVrijeme = System.currentTimeMillis();
                
                GameOutcome ishod = GameOutcome.IN_PROGRESS;

                while (ishod == GameOutcome.IN_PROGRESS) {
                    ishod = bot.playTurn();
                }

                long krajnjeVrijeme = System.currentTimeMillis();
                long vrijemeMs = krajnjeVrijeme - pocetnoVrijeme;

                int ukupnoKlikova = 0;
                NodeMove tekuci = bot.getMoveHistory().getHead();
                while (tekuci != null) {
                    ukupnoKlikova++;
                    tekuci = tekuci.getSledeci();
                }

                String ishodString = (ishod == GameOutcome.VICTORY) ? "VICTORY" : "DEFEAT";
                String tipBota = "RandomBot"; 

                String csvLinija = String.format("%d,%s,%s,%d,%d\n", 
                        idMeca, tipBota, ishodString, vrijemeMs, ukupnoKlikova);
                
                pisac.write(csvLinija);
            }

            System.out.println("Simulacija je uspjesno zavrsena! Kreiran je fajl: " + csvFajl);

        } catch (IOException e) {
            System.err.println("Greska prilikom upisivanja u CSV fajl: " + e.getMessage());
        }
    }
}