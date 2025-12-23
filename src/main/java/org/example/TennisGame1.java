package org.example;


public class TennisGame1 implements TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        String score = "";
        if (isDraw())
        {
            score = determineDrawScore();
        }
        else if (hasAnyPointsAbove(3))
        {
            score = determineScoreAbove();
        }
        else
        {
            score = determineScoreBelow();
        }
        return score;
    }

    private String determineScoreBelow() {
        int tempScore;
        String score = "";
        for (int i = 1; i<3; i++)
        {
            if (i==1) tempScore = m_score1;
            else { score +="-"; tempScore = m_score2;}
            switch(tempScore)
            {
                case 0:
                    score +="Love";
                    break;
                case 1:
                    score +="Fifteen";
                    break;
                case 2:
                    score +="Thirty";
                    break;
                case 3:
                    score +="Forty";
                    break;
            }
        }
        return score;
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

