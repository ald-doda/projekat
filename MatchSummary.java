package igrica;

public record MatchSummary(
        int matchId,
        String botType,
        String result,
        long timeMs,
        int totalClicks
) implements Comparable<MatchSummary> {

    @Override
//    public int compareTo(MatchSummary other) {
//        return Long.compare(this.timeMs, other.timeMs);
//    }
    public int compareTo(MatchSummary other) {
        int cmp = Long.compare(this.timeMs, other.timeMs);

        if (cmp != 0) return cmp;

        return Integer.compare(this.matchId, other.matchId);
    }
}