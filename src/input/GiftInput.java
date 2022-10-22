package input;

public class GiftInput {
    /**
     * Input gift's name
     */
    private String productName;
    /**
     * Input gift's name
     */
    private Double price;
    /**
     * Input gift's name
     */
    private String category;
    /**
     * Input gift's quantity
     */
    private Integer quantity;

    public GiftInput(final String productName, final Double price,
                     final String category, final Integer quantity) {
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }
    /**
     * Method that returns input gift's name
     */
    public String getProductName() {
        return productName;
    }
    /**
     * Method that sets input gift's name
     */
    public void setProductName(final String productName) {
        this.productName = productName;
    }
    /**
     * Method that returns input gift's price
     */
    public Double getPrice() {
        return price;
    }
    /**
     * Method that sets input gift's price
     */
    public void setPrice(final Double price) {
        this.price = price;
    }
    /**
     * Method that returns input gift's category that it belongs
     */
    public String getCategory() {
        return category;
    }
    /**
     * Method that sets input gift's category that it belongs
     */
    public void setCategory(final String category) {
        this.category = category;
    }
    /**
     * Method that returns input gift's quantity
     */
    public Integer getQuantity() {
        return quantity;
    }
    /**
     * Method that sets input gift's quantity
     */
    public void setQuantity(final Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * Method toString
     */
    @Override
    public String toString() {
        return "GiftInput{"
                + "productName='" + productName + '\''
                + ", price=" + price
                + ", category=" + category
                + '}';
    }
}
