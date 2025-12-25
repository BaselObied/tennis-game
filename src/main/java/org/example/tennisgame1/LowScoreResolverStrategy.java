package org.example.tennisgame1;

import static org.example.tennisgame1.TennisGame1.ADVANTAGE_THRESHOLD;

public class LowScoreResolverStrategy implements ScoreResolver {
    private final int player1Points;
    private final int player2Points;

    public LowScoreResolverStrategy(int player1Points, int player2Points) {
        this.player1Points = player1Points;
        this.player2Points = player2Points;
    }

    @Override
    public String resolve() {
        return determineScoreBelow();
    }

    private String determineScoreBelow() {
        int tempScore = this.player1Points;
        StringBuilder score = new StringBuilder();
        buildScoreDependOnPoints(score, tempScore);
        return score.toString();
    }

    private void buildScoreDependOnPoints(StringBuilder score, int tempScore) {
        for (int i = 1; i < ADVANTAGE_THRESHOLD; i++) {
            if (i != 1) {
                score.append("-");
                tempScore = this.player2Points;
            }
            appendToScore(score, tempScore);
        }
    }

    private static void appendToScore(StringBuilder score, int tempScore) {
        score.append(
                switch (tempScore) {
                    case 0 -> "Love";
                    case 1 -> "Fifteen";
                    case 2 -> "Thirty";
                    case 3 -> "Forty";
                    default -> "";
                }
        );
    }
}
