package org.example.tennisgame1;

public class DrawScoreResolverStrategy implements ScoreResolver {
    private final int drawPoints;

    public DrawScoreResolverStrategy(int drawPoints) {
        this.drawPoints = drawPoints;
    }

    @Override
    public String resolve() {
        return switch (drawPoints) {
            case 0 -> "Love-All";
            case 1 -> "Fifteen-All";
            case 2 -> "Thirty-All";
            default -> "Deuce";
        };
    }
}
