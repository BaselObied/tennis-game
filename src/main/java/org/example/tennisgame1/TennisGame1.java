package org.example.tennisgame1;


public class TennisGame1 implements TennisGame {

    protected final static int ADVANTAGE_THRESHOLD = 3;

    private int player1Points = 0;
    private int player2Points = 0;
    private String player1Name;
    private String player2Name;
    private ScoreResolver scoreResolver;


    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (player1Name.equals(playerName))
            player1Points++;
        else
            player2Points++;
    }

    public String getScore() {
        if (isDraw()) {
            scoreResolver = new DrawScoreResolverStrategy(this.player1Points);
        } else if (hasAnyPointsAbove(ADVANTAGE_THRESHOLD)) {
            scoreResolver = new HighScoreResolverStrategy(this.player1Points, this.player2Points);
        } else {
            scoreResolver = new LowScoreResolverStrategy(this.player1Points, this.player2Points);
        }
        return scoreResolver.resolve();
    }

    private boolean hasAnyPointsAbove(int points) {
        return this.player1Points > points || this.player2Points > points;
    }

    private boolean isDraw() {
        return this.player1Points == this.player2Points;
    }
}

