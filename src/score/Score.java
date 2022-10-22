package score;

/**
 * Class for Builder Score
 */
public final class Score {
    /**
     * Value of nice score
     */
    private Double niceScore;
    /**
     * Value of bonus score
     */
    private Integer niceScoreBonus;

    private Score(final ScoreBuilder builder) {
        this.niceScore = builder.niceScore;
        this.niceScoreBonus = builder.niceScoreBonus;
    }

    public Double getNiceScore() {
        return niceScore;
    }

    public void setNiceScore(final Double niceScore) {
        this.niceScore = niceScore;
    }

    public Integer getNiceScoreBonus() {
        return niceScoreBonus;
    }

    public void setNiceScoreBonus(final Integer niceScoreBonus) {
        this.niceScoreBonus = niceScoreBonus;
    }

    public static class ScoreBuilder {
        private Double niceScore;
        private Integer niceScoreBonus;

        /**
         * Constructor
         */
        public ScoreBuilder(final Double niceScore) {
            this.niceScore = niceScore;
        }
        /**
         * If it has, add bonus score
         */
        public ScoreBuilder addNiceScoreBonus(final Integer newNiceScoreBonus) {
            this.niceScoreBonus = newNiceScoreBonus;
            return this;
        }
        /**
         * Builder
         */
        public Score build() {
            return new Score(this);
        }
    }
}
