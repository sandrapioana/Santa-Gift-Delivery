package gift;

public class Gift {
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
    /**
     * Gift's quantity
     */
    private Integer quantity;

    // Class constructor
    public Gift(final String productName, final Double price,
                final String category, final Integer quantity) {
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    /**
     * Method that returns gift's name
     */
    public String getProductName() {
        return productName;
    }
    /**
     * Method that returns gift's price
     */
    public Double getPrice() {
        return price;
    }
    /**
     * Method that returns gift's category that it belongs
     */
    public String getCategory() {
        return category;
    }
    /**
     * Method that returns gift's quantity
     */
    public Integer getQuantity() {
        return quantity;
    }
    /**
     * Method that sets gift's quantity
     */
    public void setQuantity(final Integer quantity) {
        this.quantity = quantity;
    }
}
