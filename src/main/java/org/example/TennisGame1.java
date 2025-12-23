package org.example;


public class TennisGame1 implements TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;
    private final int ADVANTAGE_THRESHOLD = 3;
    private static final String PLAYER1 = "player1";

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (PLAYER1.equals(playerName))
            m_score1++;
        else
            m_score2++;
    }

    public String getScore() {
        String score = "";
        if (isDraw()) {
            score = determineDrawScore();
        } else if (hasAnyPointsAbove(ADVANTAGE_THRESHOLD))
        {
            score = determineScoreAbove();
        } else
        {
            score = determineScoreBelow();
        }
        return score;
    }

    private String determineScoreBelow() {
        int tempScore = this.m_score1;
        StringBuilder score = new StringBuilder();
        buildScoreDependOnPoints(score, tempScore);
        return score.toString();
    }

    private void buildScoreDependOnPoints(StringBuilder score, int tempScore) {
        for (int i = 1; i < ADVANTAGE_THRESHOLD; i++) {
            if (i != 1) {
                score.append("-");
                tempScore = this.m_score2;
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

    private String determineScoreAbove() {
        Integer minusResult = m_score1-m_score2;
        return switch (minusResult) {
            case 1 -> "Advantage player1";
            case -1 -> "Advantage player2";
            case Integer result when result >= 2-> "Win for player1";
            default -> "Win for player2";
        };
    }

    private String determineDrawScore() {
        final int drawPoints = this.m_score1;
        return switch (drawPoints) {
            case 0 -> "Love-All";
            case 1 -> "Fifteen-All";
            case 2 -> "Thirty-All";
            default -> "Deuce";
        };
    }

    private boolean hasAnyPointsAbove(int points) {
        return this.m_score1 > points || this.m_score2 > points;
    }

    private boolean isDraw() {
        return this.m_score1 == this.m_score2;
    }
}

