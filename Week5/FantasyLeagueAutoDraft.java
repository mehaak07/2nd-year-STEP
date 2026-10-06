import java.util.Arrays;

public class FantasyLeagueAutoDraft {

    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    // Constructor
    public FantasyLeagueAutoDraft(String name, int matchesPlayed,
                                   double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    // Rule 1: Experienced players
    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    // Rule 2: Less experienced players must be fit
    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    // Sort by batting average in descending order
    public int compareTo(FantasyLeagueAutoDraft other) {
        return Double.compare(other.battingAverage, this.battingAverage);
    }

    static String draftAndRank(FantasyLeagueAutoDraft[] players) {

        int count = 0;

        // Count draftable players
        for (int i = 0; i < players.length; i++) {

            if (isDraftable(players[i].matchesPlayed) ||
                isDraftable(players[i].matchesPlayed, players[i].injured)) {
                count++;
            }
        }

        // Create array of only draftable players
        FantasyLeagueAutoDraft[] draftable =
                new FantasyLeagueAutoDraft[count];

        int index = 0;

        for (int i = 0; i < players.length; i++) {

            if (isDraftable(players[i].matchesPlayed) ||
                isDraftable(players[i].matchesPlayed, players[i].injured)) {

                draftable[index] = players[i];
                index++;
            }
        }

        // Sort using compareTo()
        Arrays.sort(draftable);

        // Create final output
        String result = "";

        for (int i = 0; i < draftable.length; i++) {

            result = result + (i + 1) + ". " + draftable[i].name;

            if (i < draftable.length - 1) {
                result = result + " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        FantasyLeagueAutoDraft[] players = {
            new FantasyLeagueAutoDraft("Virat", 15, 48.0, false),
            new FantasyLeagueAutoDraft("Rahul", 7, 55.0, false),
            new FantasyLeagueAutoDraft("Sameer", 3, 60.0, false),
            new FantasyLeagueAutoDraft("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(players));
    }
}
