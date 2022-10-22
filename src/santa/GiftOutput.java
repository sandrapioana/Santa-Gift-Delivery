package santa;

public class GiftOutput {
    /**
     * Gift's name
     */
    private final String productName;
    /**
     * Gift's price
     */
    private final Double price;
    /**
     * Gift's category that it belongs
     */
    private final String category;


    // Class constructor
    public GiftOutput(final String productName, final Double price,
                final String category) {
        this.productName = productName;
        this.price = price;
        this.category = category;
    }

    /**
     * Method that returns output gift's name
     */
    public String getProductName() {
        return productName;
    }
    /**
     * Method that returns output gift's price
     */
    public Double getPrice() {
        return price;
    }
    /**
     * Method that returns output gift's category that it belongs
     */
    public String getCategory() {
        return category;
    }

}
