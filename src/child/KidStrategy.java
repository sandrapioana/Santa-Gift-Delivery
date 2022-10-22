package child;

import common.Constants;

public class KidStrategy implements ScoreStrategy {
    /**
     * Method that calculate kid's score
     */
    @Override
    public void calculateScore(final Child child) {
        double sum = 0;
        // add score to history if it has a new one
        if (!child.getNiceScore().equals(Constants.INVALID_SCORE)) {
            child.addToHistory(child.getNiceScore());
        }
        for (int i = 0; i < child.getNiceScoreHistory().size(); ++i) {
            sum = sum + child.getNiceScoreHistory().get(i);
        }
        // calculate average score with or without bonus
        if (child.getNiceScoreHistory().size() != 0) {
            double averageWithoutBonus = sum / child.getNiceScoreHistory().size();
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
