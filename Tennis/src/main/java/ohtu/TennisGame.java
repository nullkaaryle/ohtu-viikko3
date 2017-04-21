package ohtu;

public class TennisGame {

    private int player1Points;
    private int player2Points;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.player1Points = 0;
        this.player2Points = 0;
    }

    public void wonPoint(String playerName) {

        if (playerName.equals(player1Name)) {
            player1Points += 1;
        }

        if (playerName.equals(player2Name)) {
            player2Points += 1;
        }
    }

    public String getScore() {

        if (player1Points == player2Points) {
            return pointsAreEqual();

        } else if (player1Points >= 4 || player2Points >= 4) {
            return onePlayerHasAtLeastFourPointsAndPointsAreNotEqual();

        } else {
            return playersHaveUnderFourPoints();
        }

    }

    private String pointsAreEqual() {
        switch (player1Points) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            case 3:
                return "Forty-All";
            default:
                return "Deuce";
        }
    }

    private String onePlayerHasAtLeastFourPointsAndPointsAreNotEqual() {
        int subtraction = player1Points - player2Points;

        if (subtraction == 1) {
            return "Advantage " + player1Name;

        } else if (subtraction == -1) {
            return "Advantage " + player2Name;

        } else if (subtraction >= 2) {
            return "Win for " + player1Name;

        } else {
            return "Win for " + player2Name;
        }

    }

    private String playersHaveUnderFourPoints() {
        return getPlayerScore(player1Points) + "-" + getPlayerScore(player2Points);
    }

    private String getPlayerScore(int points) {

        switch (points) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                return "";
        }

    }

}
