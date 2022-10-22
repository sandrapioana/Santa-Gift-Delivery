package child;

import common.Constants;

public class BabyStrategy implements ScoreStrategy {
    /**
     * Method that calculate baby's score
     */
    @Override
    public void calculateScore(final Child child) {
        // add score to history if it has a new one
        if (!child.getNiceScore().equals(Constants.INVALID_SCORE)) {
            child.addToHistory(child.getNiceScore());
        }
        child.setNiceScoreCalculated(Constants.MAX_SCORE);
        // for the case that it has no new score
        child.setNiceScore(Constants.INVALID_SCORE);
    }
}
