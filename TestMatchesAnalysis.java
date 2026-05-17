package igrica;

public class TestMatchesAnalysis {

    public static void printTestAnalysis() throws Exception {

    	MatchDataset dataset = Factory.fromCsvFile("matches.csv");
    	
    	MatchSummary highestClickRate = dataset.getMatchWithHighestClickRate();    
    	double avgVictoryClicks = dataset.getAverageClicksByResult("VICTORY");
    	double avgDefeatClicks = dataset.getAverageClicksByResult("DEFEAT");
    
	    System.out.println("====================================");
	    System.out.println("      MATCHES ANALYSIS REPORT       ");
	    System.out.println("====================================\n");
	    
	    System.out.println("\n Match with highest click rate:");
	    System.out.println(highestClickRate);
	
	    System.out.println("\n Average clicks by VICTORY result:");
	    System.out.println(avgVictoryClicks);
	
	    System.out.println("\n Average clicks by DEFEAT result:");
	    System.out.println(avgDefeatClicks);
	
	    System.out.println("\n====================================");
	    System.out.println("            END REPORT              ");
	    System.out.println("====================================");
    }
}
