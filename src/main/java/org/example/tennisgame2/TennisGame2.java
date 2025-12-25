package org.example.tennisgame2;

import org.example.TennisGame;

public class TennisGame2 implements TennisGame
{
    public int P1point = 0;
    public int P2point = 0;

    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        String score = "";
        if (isDraw()) {
            int drawPoints = P1point;
            return resolveDrawScore(drawPoints);
        } else if(P1point > P2point) {
            score = resolveScoreForP1PointsIsHigher();
        } else{
            score = resolveScoreForP2PointsIsHigher();
        }

        return score;
    }

    private String resolveScoreForP2PointsIsHigher() {
        if (P2point < 4)
        {
            return getScoreLessThanAdvantageThreshold(P2point, P1point, "player2");
        } else {
            return getScoreMoreThanAdvantageThreshold(P2point, P1point, "player2");
        }
    }

    private String resolveScoreForP1PointsIsHigher() {
        if (P1point < 4)
        {
            return getScoreLessThanAdvantageThreshold(P1point, P2point, "player1");
        } else {
            return getScoreMoreThanAdvantageThreshold(P1point, P2point, "player1");
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


    private static String resolveDrawScore(int drawPoints) {
        return switch (drawPoints) {
            case 0 -> "Love-All";
            case 1 -> "Fifteen-All";
            case 2 -> "Thirty-All";
            default -> "Deuce";
        };
    }

    private boolean isDraw() {
        return P1point == P2point;
    }

    public void P1Score(){
        P1point++;
    }

    public void P2Score(){
        P2point++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}
