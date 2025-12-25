package org.example.tennisgame2;

public class ScoreResolverImpl implements ScoreResolver{

    @Override
    public String resolveScoreForDraw(int drawPoints) {
        return switch (drawPoints) {
            case 0 -> "Love-All";
            case 1 -> "Fifteen-All";
            case 2 -> "Thirty-All";
            default -> "Deuce";
        };
    }

    @Override
    public String resolveScoreForNonDraw(int player1Points, int player2Points) {
        return "";
    }
}
