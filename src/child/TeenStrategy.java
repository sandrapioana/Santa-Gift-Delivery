package child;

import common.Constants;

public class TeenStrategy implements ScoreStrategy {
    /**
     * Method that calculate teen's score
     */
    @Override
    public void calculateScore(final Child child) {
        double sumScores = 0;
        int sumWeight = 0;
        // add score to history if it has a new one
        if (!child.getNiceScore().equals(Constants.INVALID_SCORE)) {
            child.addToHistory(child.getNiceScore());
        }
        for (int i = 1; i < child.getNiceScoreHistory().size() + 1; ++i) {
            sumScores = sumScores + (child.getNiceScoreHistory().get(i - 1) * i);
            sumWeight = sumWeight + i;
        }
        // calculate average score with or without bonus
        if (child.getNiceScoreHistory().size() != 0) {
            double averageWithoutBonus = sumScores / sumWeight;
            double averageWithBonus = averageWithoutBonus
                    + averageWithoutBonus * child.getNiceScoreBonus() / Constants.PERCENT;
            if (averageWithBonus > Constants.MAX_SCORE) {
                child.setNiceScoreCalculated(Constants.MAX_SCORE);
            } else {
                child.setNiceScoreCalculated(averageWithBonus);
            }
        } else {
            child.setNiceScoreCalculated(0.0);
        }
        // for the case that it has no new score
        child.setNiceScore(Constants.INVALID_SCORE);

    }
}
