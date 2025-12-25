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
        }


        if (P1point > 0 && P2point==0)
        {
            if (P1point==1)
                P1res = "Fifteen";
            if (P1point==2)
                P1res = "Thirty";
            if (P1point==3)
                P1res = "Forty";

            P2res = "Love";
            score = P1res + "-" + P2res;
        }

        if (P2point > 0 && P1point==0)
        {
            if (P2point==1)
                P2res = "Fifteen";
            if (P2point==2)
                P2res = "Thirty";
            if (P2point==3)
                P2res = "Forty";

            P1res = "Love";
            score = P1res + "-" + P2res;
        }

        if (P1point>P2point && P1point < 4)
        {
            if (P1point==2)
                P1res="Thirty";
            if (P1point==3)
                P1res="Forty";
            if (P2point==1)
                P2res="Fifteen";
            if (P2point==2)
                P2res="Thirty";
            score = P1res + "-" + P2res;
        }
        if (P2point>P1point && P2point < 4)
        {
            if (P2point==2)
                P2res="Thirty";
            if (P2point==3)
                P2res="Forty";
            if (P1point==1)
                P1res="Fifteen";
            if (P1point==2)
                P1res="Thirty";
            score = P1res + "-" + P2res;
        }

        if (P1point > P2point && P2point > 2)
        {
            score = "Advantage player1";
        }

        if (P2point > P1point && P1point > 2)
        {
            score = "Advantage player2";
        }

        if (P1point>3 && P2point>=0 && (P1point-P2point)>1)
        {
            score = "Win for player1";
        }
        if (P2point>3 && P1point>=0 && (P2point-P1point)>1)
        {
            score = "Win for player2";
        }
        return score;
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
