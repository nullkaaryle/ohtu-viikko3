package statistics;

import statistics.matcher.*;

public class Main {

    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));

        Matcher m = new Not(
                new HasFewerThan(0, "goals"),
                new HasAtLeast(100, "assists"),
                new PlaysIn("PHI"),
                new PlaysIn("BOS")
        );

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
    }
}
