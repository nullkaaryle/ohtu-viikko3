package statistics;

import statistics.matcher.*;

public class Main {

    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));

        QueryBuilder query = new QueryBuilder();

        System.out.println("---------------------------------");

        Matcher mTesti0 = query.build();

        for (Player player : stats.matches(mTesti0)) {
            System.out.println(player);
        }

        System.out.println("---------------------------------");

        Matcher mTesti1 = query.playsIn("NYR").playsIn("NSH").build();

        for (Player player : stats.matches(mTesti1)) {
            System.out.println(player);
        }

        System.out.println("---------------------------------");

        Matcher mTesti2 = query.playsIn("VAN").hasFewerThan(10, "goals").build();

        for (Player player : stats.matches(mTesti2)) {
            System.out.println(player);
        }

        System.out.println("---------------------------------");

        Matcher mTesti3 = query.playsIn("VAN").hasFewerThan(10, "goals").hasAtLeast(20, "assists").build();

        for (Player player : stats.matches(mTesti3)) {
            System.out.println(player);
        }

        System.out.println("---------------------------------");

        Matcher m1 = query.playsIn("NYR")
                .hasAtLeast(10, "goals")
                .hasFewerThan(25, "assists").build();

        for (Player player : stats.matches(m1)) {
            System.out.println(player);
        }

        System.out.println("---------------------------------");

        Matcher m2 = query.playsIn("PHI")
                .hasAtLeast(10, "goals")
                .hasFewerThan(20, "assists").build();

        Matcher m3 = query.playsIn("EDM")
                .hasAtLeast(60, "points").build();

        Matcher m4 = query.oneOf(m1, m2).build();

        for (Player player : stats.matches(m4)) {
            System.out.println(player);
        }

        System.out.println("---------------------------------");

        Matcher m5 = query.oneOf(
                query.playsIn("PHI")
                .hasAtLeast(10, "goals")
                .hasFewerThan(20, "assists").build(),
                query.playsIn("EDM")
                .hasAtLeast(60, "points").build()
        ).build();

        for (Player player : stats.matches(m5)) {
            System.out.println(player);
        }
    }
}
