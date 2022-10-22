package delivery;

public final class DeliveryStrategyFactory {
    private DeliveryStrategyFactory() {
    }
    /**
     * Method that creates a strategy using Factory Pattern to
     * establish the strategy for delivering gifts
     */
    public static DeliveryStrategy createDeliveryStrategy(final String annualStrategy) {
        if (annualStrategy.equals("id")) {
            return new IdStrategy();
        } else if (annualStrategy.equals("niceScore")) {
            return new NiceScoreStrategy();
        } else if (annualStrategy.equals("niceScoreCity")) {
            return new NiceScoreCityStrategy();
        }
        return null;
    }
}
