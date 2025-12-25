package org.example.tennisgame2;

public interface ScoreResolver {
    String resolveScoreForDraw(int drawPoints);
    String resolveScoreForNonDraw(Player player1, Player player2);
}
