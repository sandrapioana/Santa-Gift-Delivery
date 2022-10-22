package child;

import enums.Ages;

public final class ScoreStrategyFactory {

    private ScoreStrategyFactory() {
    }
    /**
     * Method that creates a strategy using Factory Pattern to
     * calculate child's score
     */
    public static ScoreStrategy createStrategy(final Child child) {

        if (child.getAge() < Ages.BABY_STRATEGY) {
            return new BabyStrategy();
        } else if (child.getAge() < Ages.KID_STRATEGY) {
            return new KidStrategy();
        } else if (child.getAge() <= Ages.TEEN_STRATEGY) {
            return new TeenStrategy();
        }
        return null;
    }
}
