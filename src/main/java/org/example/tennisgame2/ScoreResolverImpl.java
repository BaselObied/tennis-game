package org.example.tennisgame2;

public class ScoreResolverImpl implements ScoreResolver {

    private static final int ADVANTAGE_THRESHOLD = 4;

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
    public String resolveScoreForNonDraw(Player player1, Player player2) {
        if (player1.points() > player2.points()) {
            return resolveScoreForNonDraw(player1, player2, true);
        } else {
            return resolveScoreForNonDraw(player2, player1, false);
        }
    }

    private String resolveScoreForNonDraw(Player highPointPlayer, Player lowPointPlayer, boolean highPlayerIsPlayer1) {
        if (highPointPlayer.points() < ADVANTAGE_THRESHOLD) {
            String high = getHighScore(highPointPlayer.points());
            String low = getLowScore(lowPointPlayer.points());
            return highPlayerIsPlayer1 ? high + "-" + low : low + "-" + high;
        } else {
            return getScoreMoreThanAdvantageThreshold(highPointPlayer.points(), lowPointPlayer.points(), highPointPlayer.name());
        }

    }

    private String getScoreMoreThanAdvantageThreshold(int highPoint, int lowPoint, String playerName) {
        if (highPoint - lowPoint > 1) {
            return "Win for " + playerName;
        }
        return "Advantage " + playerName;
    }

    private static String getLowScore(int lowPoint) {
        return switch (lowPoint) {
            case 0 -> "Love";
            case 1 -> "Fifteen";
            case 2 -> "Thirty";
            default -> "";
        };
    }

    private static String getHighScore(int highPoint) {
        return switch (highPoint) {
            case 1 -> "Fifteen";
            case 2 -> "Thirty";
            case 3 -> "Forty";
            default -> "";
        };
    }


}
