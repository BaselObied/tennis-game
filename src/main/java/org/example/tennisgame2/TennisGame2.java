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
            return resolveScoreForDraw();
        } else if(player1Points > player2Points) {
            return resolveScoreForNonDraw(player1Points, player2Points, player1Name);
        } else{
            return resolveScoreForNonDraw(player2Points, player1Points, player2Name);
        }
    }

    private String resolveScoreForNonDraw(int highPoint, int lowPoint, String highPlayerName) {
        if (highPoint < ADVANTAGE_THRESHOLD)
        {
            return getScoreLessThanAdvantageThreshold(highPoint, lowPoint, highPlayerName);
        } else {
            return getScoreMoreThanAdvantageThreshold(highPoint, lowPoint, highPlayerName);
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

        if (highPlayerName.equals(player1Name)) {
            return high + "-" + low;
        } else {
            return low + "-" + high;
        }
    }


    private String resolveScoreForDraw() {
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
