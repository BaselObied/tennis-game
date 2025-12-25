package org.example.tennisgame2;

import org.example.TennisGame;

public class TennisGame2 implements TennisGame {

    public int player1Points = 0;
    public int player2Points = 0;

    private final String player1Name;
    private final String player2Name;
    private final ScoreResolver scoreResolver;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.scoreResolver = new ScoreResolverImpl();
    }

    public String getScore() {
        if (isDraw()) {
            return scoreResolver.resolveScoreForDraw(player1Points);
        }
        return scoreResolver.resolveScoreForNonDraw(createPlayer(player1Name, player1Points), createPlayer(player2Name, player2Points));
    }

    private Player createPlayer(String name, int points) {
        return new Player(name, points);
    }

    private boolean isDraw() {
        return player1Points == player2Points;
    }

    public void P1Score() {
        player1Points++;
    }

    public void P2Score() {
        player2Points++;
    }

    public void wonPoint(String player) {
        if (player1Name.equals(player))
            P1Score();
        else
            P2Score();
    }
}
