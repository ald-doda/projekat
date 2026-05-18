# Strukture podataka - Minesweeper projekat💣 
 
Java projekat koji kombinuje OOP, custom data strukture i Streams API za automatsku simulaciju i analizu Minesweeper mečeva.
 
---
 
## Struktura projekta
 
```
igrica/
├── Cell.java               # Reprezentacija jedne ćelije
├── CellState.java          # Enum: HIDDEN, REVEALED, FLAGGED
├── GameOutcome.java        # Enum: IN_PROGRESS, VICTORY, DEFEAT
├── CoordinateQueue.java    # Custom FIFO queue za BFS
├── Board.java              # Tabla igre, BFS cascade reveal
├── Move.java               # Jedan potez bota
├── NodeMove.java           # Čvor linked liste
├── MyLinkedList.java       # Custom linked lista za historiju poteza
├── Player.java             # Bot koji igra nasumično
├── GamesSimulator.java     # Simulira 1000 mečeva → matches.csv
├── MatchSummary.java       # Record: jedan red iz CSV-a
├── MatchDataset.java       # SortedSet + Stream analize
├── Factory.java            # Parsiranje CSV fajla
└── TestMatchesAnalysis.java # Glavni entry point za report
```
 
---
 
## Pokretanje
 
### Korak 1 — Generišite dataset
 
Pokrenite `GamesSimulator.java`. Ovo simulira 1000 mečeva i kreira `matches.csv` u root direktoriju projekta.
 
```
GamesSimulator.main()
```
 
CSV format:
```
MatchId,BotType,Result,TimeMs,TotalClicks
1,RandomBot,VICTORY,12,47
2,RandomBot,DEFEAT,3,9
...
```
 
### Korak 2 — Analizirajte rezultate
 
Pokrenitr `TestMatchesAnalysis.java`:
 
```
TestMatchesAnalysis.main()
```
 
Ispisuje:
- Meč s najvišim click rate-om
- Prosječan broj klikova za VICTORY
- Prosječan broj klikova za DEFEAT
---
## Razvoj projekta:
 
### Milestone 1 — Board & BFS
 
`Board` čuva dvodimenzionalni niz (matrice) `Cell` objekata. Pri pozivu `revealCell()` na ćeliji s 0 susjednih mina, pokreće se iterativni BFS koristeći `CoordinateQueue` koji automatski otkriva sve susjedne sigurne ćelije (cascade efekat).
 
`CoordinateQueue` je potpuno enkapsulirana implementacija — `CoordinateNode` je private static inner class, bez ikakve upotrebe `java.util`.
 
### Milestone 2 — Player & Telemetrija
 
`Player` nasumično bira neotkrivenu ćeliju svaki turn i bilježi svaki potez u `MyLinkedList` (custom singly linked lista). `GamesSimulator` pokreće game loop dok ishod nije `VICTORY` ili `DEFEAT`, zatim zapisuje summary u CSV.
 
### Milestone 3 — Streams & Analiza
 
`MatchSummary` je Java record koji implementira `Comparable` — sortirani po `timeMs` (brži mečevi prvi), s `matchId` kao tiebreakerom. `MatchDataset` koristi `SortedSet` i Java Streams API za statističke upite nad datasetom.
 
---
 
## Konfiguracija simulacije
 
U `GamesSimulator.java` možete mijenjati parametre:
 
```java
Board tabla = new Board(8, 6);  // 8x8 tabla, 6 mina
for (int idMeca = 1; idMeca <= 1000; idMeca++) { ... }  // broj mečeva
```
 
Manji broj mina → više pobjeda u datasetu.
 
---
 








 
