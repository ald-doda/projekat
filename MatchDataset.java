package igrica;

import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.stream.Collectors;

public class MatchDataset {

	private final SortedSet<MatchSummary> matches;
	
    public MatchDataset(SortedSet<MatchSummary> matches) {
        this.matches = matches;
    }

    public SortedSet<MatchSummary> getMatches() {
        return matches;
    }
	
    public Double getAverageClicksByResult(String result) {
    	Set<MatchSummary> filtered = matches
    			.stream()
    			.filter(x -> x.result().equals(result))
    			.collect(Collectors.toSet());
    	
    	double average = filtered
    	        .stream()
    	        .mapToInt(m -> m.totalClicks())
    	        .average()
    	        .orElse(0.0);
    	
    	return average;
    }
    
    public MatchSummary getMatchWithHighestClickRate() {
    MatchSummary maxClicksMatch = matches
            .stream()
            .max(Comparator.comparingDouble(m -> 
                (double) m.totalClicks() / (m.timeMs() == 0 ? 1 : m.timeMs())))
            .orElse(null);
    
    return maxClicksMatch;
}
}
