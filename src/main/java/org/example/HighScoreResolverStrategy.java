package org.example;

public class HighScoreResolverStrategy implements ScoreResolver {
    private int player1Points;
    private int player2Points;

    public HighScoreResolverStrategy(int player1Points, int player2Points) {
        this.player1Points = player1Points;
        this.player2Points = player2Points;
    }

    @Override
    public String resolve() {
        return "";
    }
}
