package org.example.tennisgame2;

public interface ScoreResolver {
    String resolveScoreForDraw(int drawPoints);
    String resolveScoreForNonDraw(int player1Points, int player2Points);
}
