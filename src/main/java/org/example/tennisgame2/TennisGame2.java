package org.example.tennisgame2;

import org.example.TennisGame;

public class TennisGame2 implements TennisGame
{
    private static final int ADVANTAGE_THRESHOLD = 4;

    public int player1Points = 0;
    public int player2Points = 0;

    private final String player1Name;
    private final String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        if (isDraw()) {
            return resolveDrawScore();
        } else if(player1Points > player2Points) {
            return resolveScoreForP1PointsIsHigher();
        } else{
            return resolveScoreForP2PointsIsHigher();
        }
    }

    private String resolveScoreForP2PointsIsHigher() {
        if (player2Points < ADVANTAGE_THRESHOLD)
        {
            return getScoreLessThanAdvantageThreshold(player2Points, player1Points, player2Name);
        } else {
            return getScoreMoreThanAdvantageThreshold(player2Points, player1Points, player2Name);
        }
    }

    private String resolveScoreForP1PointsIsHigher() {
        if (player1Points < ADVANTAGE_THRESHOLD)
        {
            return getScoreLessThanAdvantageThreshold(player1Points, player2Points, player1Name);
        } else {
            return getScoreMoreThanAdvantageThreshold(player1Points, player2Points, player1Name);
        }
    }

    private String getScoreMoreThanAdvantageThreshold(int highPoint, int lowPoint, String playerName) {
        if (highPoint - lowPoint > 1) {
            return "Win for " + playerName;
        }
        return "Advantage " + playerName;
    }

    private String getScoreLessThanAdvantageThreshold(int highPoint, int lowPoint, String highPlayerName) {
        String high = switch (highPoint) {
            case 1 -> "Fifteen";
            case 2 -> "Thirty";
            case 3 -> "Forty";
            default -> "";
        };

        String low = switch (lowPoint) {
            case 0 -> "Love";
            case 1 -> "Fifteen";
            case 2 -> "Thirty";
            default -> "";
        };

        if (highPlayerName.equals("player1")) {
            return high + "-" + low;
        } else {
            return low + "-" + high;
        }
    }


    private String resolveDrawScore() {
        int drawPoints = this.player1Points;
        return switch (drawPoints) {
            case 0 -> "Love-All";
            case 1 -> "Fifteen-All";
            case 2 -> "Thirty-All";
            default -> "Deuce";
        };
    }

    private boolean isDraw() {
        return player1Points == player2Points;
    }

    public void P1Score(){
        player1Points++;
    }

    public void P2Score(){
        player2Points++;
    }

    public void wonPoint(String player) {
        if (player1Name.equals(player))
            P1Score();
        else
            P2Score();
    }
}
