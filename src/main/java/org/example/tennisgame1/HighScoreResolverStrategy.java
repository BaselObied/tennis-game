package org.example.tennisgame1;

public class HighScoreResolverStrategy implements ScoreResolver {
    private final int player1Points;
    private final int player2Points;

    public HighScoreResolverStrategy(int player1Points, int player2Points) {
        this.player1Points = player1Points;
        this.player2Points = player2Points;
    }

    @Override
    public String resolve() {
        return determineScoreAbove();
    }

    private String determineScoreAbove() {
        Integer minusResult = this.player1Points - this.player2Points;
        return switch (minusResult) {
            case 1 -> "Advantage player1";
            case -1 -> "Advantage player2";
            case Integer result when result >= 2-> "Win for player1";
            default -> "Win for player2";
        };
    }
}
