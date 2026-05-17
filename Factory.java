package igrica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.SortedSet;
import java.util.TreeSet;

//Ucitava iz fajlova red po red i kreira matchSummary

public class Factory {

    public static MatchSummary fromCsvLine(String line) {
        String[] parts = line.split(",");
        System.out.println(line);

        return new MatchSummary(
                Integer.parseInt(parts[0]),
                parts[1],
                parts[2].trim(),
                Long.parseLong(parts[3]),
                Integer.parseInt(parts[4])
        );
    }

    public static MatchDataset fromCsvFile(String fileName) throws IOException {

        SortedSet<MatchSummary> set = new TreeSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;

            while ((line = br.readLine()) != null) {
                // ako ima header preskoči
                if (line.startsWith("MatchId")) continue;
                
                MatchSummary match = fromCsvLine(line);
                set.add(match);
                
            }
            
            System.out.println("RESULTS IN DATASET:");
            set.stream()
                .map(MatchSummary::result)
                .distinct()
                .forEach(System.out::println);
        }

        return new MatchDataset(set);
    }
}
